package stream.toMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class BookTest {

    private static ArrayList<Book> bookList;

    @BeforeAll
    static void init(){
        bookList = new ArrayList<>();
        bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
        bookList.add(new Book("The Two Towers", 1954, "0345339711"));
        bookList.add(new Book("The Return of the King", 1955, "0618129111"));
    }

    @Test
    void ListToMap(){

        Map<String, String> bookMap = bookList.stream().
                collect(Collectors.toMap(Book::getIsbn, Book::getName));
        System.out.println(bookMap);

    }

    @Test
    @DisplayName("만약에 중복 키로 인한 예외발생")
    void ListToMap2(){

        Map<Integer, Book> bookMap = bookList.stream()
                .collect(Collectors.toMap(Book::getReleaseYear, Function.identity()));

        System.out.println("예외가 터진다. IllegalStateException.");

    }

    @Test
    @DisplayName("만약에 중복 키로 인한 예외발생")
    void ListToMap3(){


        Map<Integer, Book> bookMap = bookList.stream()                               //Merge Function 기존에 있는것으로 대체. existing
                .collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),(existing,replacement) -> replacement));

        System.out.println(bookMap.get(1954).getName());

    }

    @Test
    @DisplayName("List를 ConcurrentMap으로 변경")
    void ListToMap4(){

        bookList.stream().                                                        //mapSupplier 이용
                collect(Collectors.toMap(Book::getReleaseYear,Function.identity(),(o1,o2) -> o1, ConcurrentHashMap::new));

    }

    @Test
    @DisplayName("Map 정렬 방법")
    void ListToMap5(){

        //treeMap 을 더 알아보자
        TreeMap<Integer, Book> collect = bookList.stream()                           //mapSupplier 이용
                .collect(Collectors.toMap(Book::getReleaseYear, Function.identity(), (o1, o2) -> o1, TreeMap::new));

        System.out.println(collect);


    }



}