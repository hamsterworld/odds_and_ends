package inflearn.section3._03_long_function._10_replace_function_with_command;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 조건문 분해하기
 * -> 조건문 내부구현을 함수로 빼기 (이것도 사실상 함수 추출하기다.)
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

    private Participant findParticipant(String username, List<Participant> participants) {
        Participant participant = null;
        if (participants.stream().noneMatch(p -> p.username().equals(username))) {
            participant = new Participant(username);
            participants.add(participant);
        } else {
            participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
        }
        return participant;
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

        // 이부분을 적용해볼것이다.
//        try (FileWriter fileWriter = new FileWriter("participants.md");
//            PrintWriter writer = new PrintWriter(fileWriter)) {
//            participants.sort(Comparator.comparing(Participant::username));
//
//            writer.print(header(participants.size()));
//
//            participants.forEach(p -> {
//                String markdownForHomework = getMarkdownForParticipant(p);
//                writer.print(markdownForHomework);
//            });
//        }

        // 이렇게하면 이 객체는 완전히 하나의 command 처럼 실행되는 독립적인 command 가 된다.
        new StudyPrinter(this.totalNumberOfEvents,participants).execute();
    }

    // 아래코드전부다 StudyPrinter 로 옮겨주자
//    private void execute(List<Participant> participants) throws IOException {
//        try (FileWriter fileWriter = new FileWriter("participants.md");
//             PrintWriter writer = new PrintWriter(fileWriter)) {
//            participants.sort(Comparator.comparing(Participant::username));
//
//            writer.print(header(participants.size()));
//
//            participants.forEach(p -> {
//                String markdownForHomework = getMarkdownForParticipant(p);
//                writer.print(markdownForHomework);
//            });
//        }
//    }

//    private String getMarkdownForParticipant(Participant p) {
//        return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p, this.totalNumberOfEvents),
//                p.getRate(this.totalNumberOfEvents));
//    }

    /**
     * | 참여자 (420) | 1주차 | 2주차 | 3주차 | 참석율 |
     * | --- | --- | --- | --- | --- |
     */
//    private String header(int totalNumberOfParticipants) {
//        StringBuilder header = new StringBuilder(String.format("| 참여자 (%d) |", totalNumberOfParticipants));
//
//        for (int index = 1; index <= this.totalNumberOfEvents; index++) {
//            header.append(String.format(" %d주차 |", index));
//        }
//        header.append(" 참석율 |\n");
//
//        header.append("| --- ".repeat(Math.max(0, this.totalNumberOfEvents + 2)));
//        header.append("|\n");
//
//        return header.toString();
//    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     */
//    private String checkMark(Participant p, int totalEvents) {
//        StringBuilder line = new StringBuilder();
//        for (int i = 1 ; i <= totalEvents ; i++) {
//            if(p.homework().containsKey(i) && p.homework().get(i)) {
//                line.append("|:white_check_mark:");
//            } else {
//                line.append("|:x:");
//            }
//        }
//        return line.toString();
//    }

}
