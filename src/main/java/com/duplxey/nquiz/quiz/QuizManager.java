package com.duplxey.nquiz.quiz;

import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class QuizManager {

    private static File quizDirectory;
    private static HashMap<String, Quiz> quizzes = new HashMap<>();

    public QuizManager() {
        setup();
    }

    private void setup() {
        quizDirectory = new File("quizzes");
        if (!quizDirectory.mkdir()) {
            File[] files = quizDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    QuizManager.registerQuiz(GsonUtil.getInstance().getGson().fromJson(FileUtil.getFileContent(file.getPath()), Quiz.class));
                }
            }
        }
    }

    public static void registerQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);
    }

    public static void unregisterQuiz(String name) {
        quizzes.remove(name);
    }

    public static Quiz getQuiz(String name) {
        return quizzes.get(name);
    }

    public static Quiz getWebQuiz(String url) {
        try {
            return GsonUtil.getInstance().getGson().fromJson(Jsoup.connect(url).get().body().text(), Quiz.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean existsQuiz(String name) {
        return quizzes.containsKey(name);
    }

    public static Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }

    public static File getQuizDirectory() {
        return quizDirectory;
    }
}
