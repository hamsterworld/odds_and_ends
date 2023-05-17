package inflearn.section2._02_duplicated_code._06_pull_up_method;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 메소드 올리기
 *
 * 중복 코드는 당장은 잘 동작하더라도 미래에 버그를 만들어낼 빌미를 제공한다.
 * ex) A에서 코드를 고치고, B에는 반영하지 않는경우
 *
 * 여러 하위 클래스에 동일한 코드가 있다면, 손쉽게 이 방법을 적용할수있다.
 *
 * 비슷하지만 일부값만 다른경우라면, 함수 매개변수화하기 리팩토링 적용후 이방법 적용가능
 *
 * 하위 클래스에 있는 코드가 상위 클래스가 아닌 하위 클래스기능에 의존하고있다면
 * 필드 올리기를 적용한후에 이방법을 적용할수있다.
 *
 * 두메소드가 비슷한 절차를 따르고있다면, 템플릿 메소드 패턴 적용을 고려해볼수있다.
 *
 * 자주사용되는 리펙토링 기술은 아니지만
 * 하위클래스에 중복되는 코드를 발견햇다면 상위클래스로 이렇게 쳐올릴수있다.
 */
public class Dashboard {

    public static void main(String[] args) throws IOException {
        ReviewerDashboard reviewerDashboard = new ReviewerDashboard();
        reviewerDashboard.printReviewers();

        ParticipantDashboard participantDashboard = new ParticipantDashboard();
        participantDashboard.printParticipants(15);
    }

    protected void printUsernames(int eventId) throws IOException {
        // Get github issue to check homework
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(eventId);

        // Get usernames
        Set<String> reviewers = new HashSet<>();
        issue.getComments().forEach(c -> reviewers.add(c.getBody()));

        // Print participants
        reviewers.forEach(System.out::println);
    }

}
