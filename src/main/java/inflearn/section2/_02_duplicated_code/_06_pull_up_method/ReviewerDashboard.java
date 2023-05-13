package inflearn.section2._02_duplicated_code._06_pull_up_method;

import java.io.IOException;

public class ReviewerDashboard extends Dashboard {

    public void printReviewers() throws IOException {
//        // Get github issue to check homework
//        Set<String> reviewers = new HashSet<>();
//        GitHub gitHub = GitHub.connect();
//        GHRepository repository = gitHub.getRepository("whiteship/live-study");
//        GHIssue issue = repository.getIssue(30);
//
//        // Get usernames
//        issue.getComments().forEach(c -> reviewers.add(c.getUserName()));
//
//        // Print reviewers
//        reviewers.forEach(System.out::println);

        super.printUsernames(30);
    }

}
