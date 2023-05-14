package inflearn.section3._03_long_function._11_decompose_conditional;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 조건문 분해하기
 * -> 조건문 내부구현을 함수로 빼기
 * -> 근데 이렇게 함수로 빼면 삼항연산이 보이기도하는것처럼 좀더 간편하게 만들수있다.
 */
public class StudyDashboard {

    private final int totalNumberOfEvents;

    public StudyDashboard(int totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashboard studyDashboard = new StudyDashboard(15);
        studyDashboard.print();
    }

    private void print() throws IOException, InterruptedException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        List<Participant> participants = new CopyOnWriteArrayList<>();

        ExecutorService service = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        for (int index = 1 ; index <= totalNumberOfEvents ; index++) {
            int eventId = index;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GHIssue issue = repository.getIssue(eventId);
                        List<GHIssueComment> comments = issue.getComments();

                        for (GHIssueComment comment : comments) {
                            Participant participant = findParticipant(comment.getUserName(), participants);
                            participant.setHomeworkDone(eventId);
                        }

                        latch.countDown();
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
        }

        latch.await();
        service.shutdown();

        new StudyPrinter(this.totalNumberOfEvents, participants).execute();
    }

    // 더 간추리기도 가능
    // 이게바로 조건문 분해하기의 힘이다.
    // 아래 삼항연산자까지보면 내공이 상당한 개발자이다.
    // 또 아래도 반복적인 매개변수가 있다.
        private Participant findParticipant(String username, List<Participant> participants) {
        return isNewParticipants(username, participants) ? createNewParticipant(username, participants) : findExistingParticipant(username, participants);
    }

    // 아래 얘네들도 원래 저기위에 조건문에 들어가있던 애들을
    // 이렇게 함수로 따로떼서 넣어줬다.
    private static Participant findExistingParticipant(String username, List<Participant> participants) {
        return participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
    }

    private Participant createNewParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = new Participant(username);
        participants.add(participant);
        return participant;
    }


    private boolean isNewParticipants(String username,List<Participant> participants){
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

    // 원래 for 문
//    private Participant findParticipant(String username, List<Participant> participants) {
//        Participant participant;
//        if (participants.stream().noneMatch(p -> p.username().equals(username))) {
//            participant = new Participant(username);
//            participants.add(participant);
//        } else {
//            participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
//        }
//
//        return participant;
//    }

}
