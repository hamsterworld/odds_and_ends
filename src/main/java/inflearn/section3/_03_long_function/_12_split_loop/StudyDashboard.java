package inflearn.section3._03_long_function._12_split_loop;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 반복문 쪼개기
 *
 * 하나의 반복문을 돌때
 * 안에서 여러가지작업을 하면
 * 내가 코딩을 할때 그것을 전부다 고려해야된다는 단점이 있다.
 *
 * 반복문을 여러개로 쪼개면 좀더 쉽게 이해하고 수정할수있다.
 * O(n)은 O(n)이다.
 *
 * 그래서 refactoring 할때는 성능최적화를 뒤로미루자.
 *
 */
public class StudyDashboard {

    private final int totalNumberOfEvents;
    /**
     * class 내에서 자주쓰이는 local var 들은 field 로 올려놓자.
     */
    private final List<Participant> participants;
    private final Participant[] firstParticipantsForEachEvent;

    public StudyDashboard(int totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        participants = new CopyOnWriteArrayList<>();
        firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashboard studyDashboard = new StudyDashboard(15);
        studyDashboard.print();
    }

    // 이제 어느정도 읽을수있는 코드가 되었다.
    // 구현으로 꽉차 있던 코드가 의도를 파악할수있는 코드로 변화하였다.
    private void print() throws IOException, InterruptedException {
        GHRepository ghRepository = getGhRepository();
        checkGithubIssues(ghRepository);
        new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();
        printFirstParticipants();
    }

    private void checkGithubIssues(GHRepository ghRepository) throws InterruptedException {

        // 시간이 오래걸려서 쓰레드 8개로 동시에 아래작업을 처리하게하는중이다.
        ExecutorService service = Executors.newFixedThreadPool(8);
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        for (int index = 1 ; index <= totalNumberOfEvents ; index++) {
            int eventId = index;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GHIssue issue = ghRepository.getIssue(eventId);
                        List<GHIssueComment> comments = issue.getComments();

                        // 이 loop 를 쪼개보자.
//                        for (GHIssueComment comment : comments) {
//                            Participant participant = findParticipant(comment.getUserName(), participants);
//                            participant.setHomeworkDone(eventId);
//
//                            if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
//                                firstCreatedAt = comment.getCreatedAt();
//                                first = participant;
//                            }
//                        }

                        // 아래가 그결과
                        checkHomework(comments, eventId);
                        firstParticipantsForEachEvent[eventId - 1] = findFirst(comments, eventId);
                        latch.countDown();
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
        }

        latch.await();
        service.shutdown();
    }

    private Participant findFirst(List<GHIssueComment> comments, int eventId) throws IOException {
        Date firstCreatedAt = null;
        Participant first = null;

        for (GHIssueComment comment : comments) {
            Participant participant = findParticipant(comment.getUserName(), participants);

            if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
                firstCreatedAt = comment.getCreatedAt();
                first = participant;
            }
        }
        return first;
    }

    private void checkHomework(List<GHIssueComment> comments, int eventId) {
        for (GHIssueComment comment : comments) {
            Participant participant = findParticipant(comment.getUserName(), participants);
            participant.setHomeworkDone(eventId);
        }
    }

    private void printFirstParticipants() {
        Arrays.stream(this.firstParticipantsForEachEvent).forEach(p -> System.out.println(p.username()));
    }

    private GHRepository getGhRepository() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository;
    }

    private Participant findParticipant(String username, List<Participant> participants) {
        return isNewParticipant(username, participants) ?
                createNewParticipant(username, participants) :
                findExistingParticipant(username, participants);
    }

    private Participant findExistingParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
        return participant;
    }

    private Participant createNewParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = new Participant(username);
        participants.add(participant);
        return participant;
    }

    private boolean isNewParticipant(String username, List<Participant> participants) {
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

}
