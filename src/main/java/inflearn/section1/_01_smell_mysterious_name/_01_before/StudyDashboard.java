package inflearn.section1._01_smell_mysterious_name._01_before;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 냄새1. 이해하기 힘든 이름
 * 깔끔하 코드에서 제일 중요한것은 좋은 이름이다.
 * 함수,변수,클래스,모듈의 이름등 모두 어떤 역할을 하는지 어떻게 쓰이는지 직관적이여야한다.
 *
 * 사용가능한 리팩토링 기술
 * 1. 함수 선언 변경하기
 * 2. 변수이름 변경하기
 * 3. 필드이름 바꾸기
 */
public class StudyDashboard {

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    private void studyReviews(GHIssue issue) throws IOException {
        List<GHIssueComment> comments = issue.getComments();
        for (GHIssueComment comment : comments) {
            usernames.add(comment.getUserName());
            reviews.add(comment.getBody());
        }
    }

    public Set<String> getUsernames() {
        return usernames;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.studyReviews(issue);
        studyDashboard.getUsernames().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
