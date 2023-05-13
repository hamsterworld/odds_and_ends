package inflearn.section2._02_duplicated_code._04_extract_function;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 함수 추출하기
 *
 * 의도와 구현 분리하기
 * 의도와 구현이 무슨말이냐?
 * 의도 => 코드(method,function)가 무슨일을 하는지를 잘표현
 * 구현 => 의도가 파악이 안되서 우리가 하나하나 내부구현까지 들여다보고있다면, 그것은 구현이다.
 *
 * 한줄짜리 매서드는 괜찮은가?
 * => 취향에 따라서..
 */
public class StudyDashboard {

    private void printParticipants(int eventId) throws IOException {

        // 아래는 구현에 가깝다. 보면 아 먼저 gitHub Connect 하고 repository 를 읽어오고.
        // list 를 돌고
        // sout 하고
        // 이렇게 다읽어야된다 시간이 상당히 걸린다.

        // Get github issue to check homework
//        GitHub gitHub = GitHub.connect();
//        GHRepository repository = gitHub.getRepository("whiteship/live-study");
//        GHIssue issue = repository.getIssue(eventId);

        // 아래처럼 구현을 의도로 변경할것
        GHIssue issue = getGhIssue(eventId);


        // Get participants
        Set<String> participants = getUsernames(issue);

        // Print participants
        print(participants);
    }


    private void printReviewers() throws IOException {
        // Get github issue to check reviews
        GHIssue issue = getGhIssue(30);

        // Get reviewers
        Set<String> reviewers = getUsernames(issue);

        // Print reviewers
        print(reviewers);
    }

    private GHIssue getGhIssue(int eventId) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);
        return issue;
    }

    private Set<String> getUsernames(GHIssue issue) throws IOException {
        Set<String> participants = new HashSet<>();
        issue.getComments().forEach(c -> participants.add(c.getUserName()));
        return participants;
    }

    private void print(Set<String> participants) {
        participants.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.printReviewers();
        studyDashboard.printParticipants(15);
    }

}
