package inflearn.section13._13_loop._33_replace_loop_with_pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 반복문을 파이프라인으로 바꾸기
 *
 * 즉, 자바의 stream 을 이용해보자.
 */
public class Author {

    private String company;

    private String twitterHandle;

    public Author(String company, String twitterHandle) {
        this.company = company;
        this.twitterHandle = twitterHandle;
    }

    static public List<String> TwitterHandles(List<Author> authors, String company) {

        return authors.stream()
                .filter(a -> a.company.equals(company))
                .map(a -> a.twitterHandle)
                .filter(t -> t != null)
                .collect(Collectors.toList());

    }

}
