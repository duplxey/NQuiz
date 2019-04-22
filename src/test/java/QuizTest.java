import com.duplxey.nquiz.quiz.*;
import com.duplxey.nquiz.util.GsonUtil;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

class QuizTest {

    @Test
    void dummyExam() {
        Quiz quiz = new Quiz(
                "about-me",
                "Some general questions about me.",
                QuizCategory.FUN,
                QuizDifficulty.MEDIUM,
                new LinkedList<>(Arrays.asList(
                        new Question("What is my name?",
                                new Answer[]{
                                        new Answer("Jim"),
                                        new Answer("Peter"),
                                        new Answer("Tom"),
                                        new Answer("Jim"),
                                }, 2),
                        new Question("How old am I?",
                                new Answer[]{
                                        new Answer("1"),
                                        new Answer("3"),
                                        new Answer("15"),
                                        new Answer("3"),
                                }, 3)
                ))
        );
        QuizManager.registerQuiz(quiz);
        quiz.print();

        System.out.println(GsonUtil.getInstance().getGson().toJson(quiz));
    }

    @Test
    void webExam() {
        String json = null;
        try {
            json = Jsoup.connect("https://pastebin.com/raw/dhLGhypw").get().body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    void webExamParse() {
        Quiz webQuiz = QuizManager.getWebQuiz("https://pastebin.com/raw/dhLGhypw");
        if (webQuiz != null) {
            webQuiz.print();
        } else {
            System.out.println("WebQuiz was null.");
        }
    }
}
