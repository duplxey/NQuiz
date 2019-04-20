package com.duplxey.nquiz.quiz;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import sun.security.jgss.GSSCaller;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

public class QuizManager {

    private static HashMap<String, Quiz> quizzes = new HashMap<>();

    public QuizManager() {
        // Let's register a dummy quiz for now
        registerQuiz("math", getWebQuiz("https://pastebin.com/raw/dhLGhypw"));
        // TODO: remove me
    }

    public static void registerQuiz(String name, Quiz quiz) {
        quizzes.put(name, quiz);
    }

    public static void unregisterQuiz(String name) {
        quizzes.remove(name);
    }

    public static Quiz getQuiz(String name) {
        return quizzes.get(name);
    }

    public static Quiz getWebQuiz(String url) {
        try {
            return new Gson().fromJson(Jsoup.connect(url).get().body().text(), Quiz.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }
}
