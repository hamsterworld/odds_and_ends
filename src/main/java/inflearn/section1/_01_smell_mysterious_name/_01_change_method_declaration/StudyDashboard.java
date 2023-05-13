package inflearn.section1._01_smell_mysterious_name._01_change_method_declaration;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * - 좋은 이름을 가진 함수는 함수가 어떻게 구현되었는지 코드를 보지않아도 이름만 보고도 이해할수있다.
 *
 * - 좋은 이름 찾아내는법?
 *   함수에 주석을 작성한다음, 주석을 함수 이름으로 만들어 본다.
 *
 * - 함수의 매개변수?
 *   함수 내부 문액을 결정한다. (전화번호 포매팅 함수)
 *   의존성을 결정한다. (Payment 만기일 계산 함수)
 */
public class StudyDashboard {

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    /**
     * 스터디 리뷰 이슈에 작성되어있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * (Loads the list of reviewers and their reviews written in the study review issue.)
     *
     * @param issue
     * @throws IOException
     */
    private void loadReviews(GHIssue issue) throws IOException {
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
        studyDashboard.loadReviews(issue);
        studyDashboard.getUsernames().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
