import com.duplxey.nquiz.quiz.*;
import com.duplxey.nquiz.util.GsonUtil;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

class QuizTest {

    @Test
    void dummyQuiz() {
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
        System.out.println(quiz.info());
        System.out.println(GsonUtil.getInstance().getGson().toJson(quiz));
    }

    @Test
    void complexQuiz() {
        Quiz quiz = new Quiz(
                "random",
                "Some random questions.",
                QuizCategory.TRIVIA,
                QuizDifficulty.HARD,
                new LinkedList<>(Arrays.asList(
                        new Question("What is the world's longest river?",
                                new Answer[]{
                                        new Answer("Amazon"),
                                        new Answer("Nile"),
                                        new Answer("Drava"),
                                }, 0),
                        new Question("What are the three primary colors?",
                                new Answer[]{
                                        new Answer("Red, green, blue"),
                                        new Answer("Red, yellow, blue"),
                                        new Answer("Red, orange, purple"),
                                        new Answer("Red, white, black"),
                                }, 1),
                        new Question("What is the capital of Spain?",
                                new Answer[]{
                                        new Answer("Paris"),
                                        new Answer("Prague"),
                                        new Answer("Ljubljana"),
                                        new Answer("London"),
                                        new Answer("Madrid"),
                                }, 4),
                        new Question("What does roman numeral C represent?",
                                new Answer[]{
                                        new Answer("1"),
                                        new Answer("100"),
                                        new Answer("500"),
                                        new Answer("1000"),
                                        new Answer("1000000"),
                                }, 1),
                        new Question("What color is blue panda?",
                                new Answer[]{
                                        new Answer("black & white"),
                                        new Answer("blue"),
                                }, 1)
                ))
        );
        QuizManager.registerQuiz(quiz);
        System.out.println(quiz.info());
        System.out.println(GsonUtil.getInstance().getGson().toJson(quiz));
    }

    @Test
    void webQuiz() {
        String json = null;
        try {
            json = Jsoup.connect("https://pastebin.com/raw/dhLGhypw").get().body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }

    @Test
    void webQuizParse() {
        Quiz webQuiz = QuizManager.getWebQuiz("https://pastebin.com/raw/dhLGhypw");
        if (webQuiz != null) {
            System.out.println(webQuiz.info());
        } else {
            System.out.println("WebQuiz was null.");
        }
    }
}
