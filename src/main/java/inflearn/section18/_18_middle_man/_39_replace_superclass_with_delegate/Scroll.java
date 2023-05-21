package inflearn.section18._18_middle_man._39_replace_superclass_with_delegate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

// 위임으로 만드는 방법은 매우 간단하다.
// compose 방법과 굉장히 유사하다.
public class Scroll{

    private LocalDate dateLastCleaned;

    private CategoryItem categoryItem;

//    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
//        super(id, title, tags);
//        this.dateLastCleaned = dateLastCleaned;
//    }


    public Scroll(Integer id, String title, List<String> tags, LocalDate dateLastCleaned) {
        this.dateLastCleaned = dateLastCleaned;
        this.categoryItem = new CategoryItem(id, title, tags);
    }

    public long daysSinceLastCleaning(LocalDate targetDate) {
        return this.dateLastCleaned.until(targetDate, ChronoUnit.DAYS);
    }
}
