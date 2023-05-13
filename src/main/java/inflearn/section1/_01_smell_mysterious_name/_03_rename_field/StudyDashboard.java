package inflearn.section1._01_smell_mysterious_name._03_rename_field;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Record 자료 구조의 필드 이름은 프로그램 전반에 걸쳐 참조될수있기때문에 매우 종요하다.
 *
 * Recode 자료 구조란?
 * 특정 데이터와 관련있는 필드를 묶어놓은 자료구조
 * 자바는 14부터 지원 (record 키워드)
 * 자바에서는 Getter,Setter 메소드 이름도 필드이름과 비슷하게 간주할수있다.
 */
public class StudyDashboard {

    // it would be better to use userNames instead of reviewName
    private Set<String> reviewers = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    /**
     * 스터디 리뷰 이슈에 작성되어 있는 리뷰어 목록과 리뷰를 읽어옵니다.
     * @throws IOException
     */
    private void loadReviews() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        List<GHIssueComment> reviews = issue.getComments();
        for (GHIssueComment review : reviews) {
            reviewers.add(review.getUserName());
            this.reviews.add(review.getBody());
        }
    }

    public Set<String> getReviewers() {
        return reviewers;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
        studyDashboard.getReviewers().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
