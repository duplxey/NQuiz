import com.duplxey.nquiz.quiz.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class QuizTest {

    @Test
    public void dummyExam() {
        Quiz quiz = new Quiz(
                "about-me",
                "Some basic questions about me.",
                QuizCategory.FUN,
                QuizDifficulty.MEDIUM,
                new LinkedList<>(Arrays.asList(
                        new Question("What is my name?",
                                new Answer[] {
                                        new Answer("Jim"),
                                        new Answer("Peter"),
                                        new Answer("Tom"),
                                        new Answer("Jim"),
                                }, 2),
                                new Question("How old am I?",
                                        new Answer[] {
                                                new Answer("1"),
                                                new Answer("3"),
                                                new Answer("15"),
                                                new Answer("3"),
                                        }, 3)
                ))
        );
        QuizManager.registerQuiz("about-me", quiz);
        quiz.print();
    }
}
