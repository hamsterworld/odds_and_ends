package inflearn.section3._03_long_function._13_replace_conditional_with_polymorphism;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public abstract class StudyPrinter {

//    private int totalNumberOfEvents;
//
//    private List<Participant> participants;

    // 아래처럼 protected 로하니까 field 도 공유가 되네!?
    protected int totalNumberOfEvents;

    protected List<Participant> participants;

    public StudyPrinter(int totalNumberOfEvents, List<Participant> participants) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        this.participants = participants;
        this.participants.sort(Comparator.comparing(Participant::username));
    }

    public abstract void execute() throws IOException;

    // 아래를 리펙토링할것이다.
//    public void execute() throws IOException {
//        switch (printerMode) {
//            case CVS -> {
//                try (FileWriter fileWriter = new FileWriter("participants.cvs");
//                     PrintWriter writer = new PrintWriter(fileWriter)) {
//                    writer.println(cvsHeader(this.participants.size()));
//                    this.participants.forEach(p -> {
//                        writer.println(getCvsForParticipant(p));
//                    });
//                }
//            }
//            case CONSOLE -> {
//                this.participants.forEach(p -> {
//                    System.out.printf("%s %s:%s\n", p.username(), checkMark(p), p.getRate(this.totalNumberOfEvents));
//                });
//            }
//            case MARKDOWN -> {
//                try (FileWriter fileWriter = new FileWriter("participants.md");
//                     PrintWriter writer = new PrintWriter(fileWriter)) {
//
//                    writer.print(header(this.participants.size()));
//
//                    this.participants.forEach(p -> {
//                        String markdownForHomework = getMarkdownForParticipant(p);
//                        writer.print(markdownForHomework);
//                    });
//                }
//            }
//        }
//    }

    /**
     * |:white_check_mark:|:white_check_mark:|:white_check_mark:|:x:|
     */
    protected String checkMark(Participant p) {
        StringBuilder line = new StringBuilder();
        for (int i = 1 ; i <= this.totalNumberOfEvents ; i++) {
            if(p.homework().containsKey(i) && p.homework().get(i)) {
                line.append("|:white_check_mark:");
            } else {
                line.append("|:x:");
            }
        }
        return line.toString();
    }
}
