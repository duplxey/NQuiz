package com.duplxey.nquiz.quiz;

import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class QuizManager {

    private File quizDirectory;
    private HashMap<String, Quiz> quizzes = new HashMap<>();

    public QuizManager() {
        setup();
    }

    private void setup() {
        quizDirectory = new File("quizzes");
        if (!quizDirectory.mkdir()) {
            File[] files = quizDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    registerQuiz(GsonUtil.getInstance().getGson().fromJson(FileUtil.getFileContent(file.getPath()), Quiz.class));
                }
            }
        }
    }

    public void registerQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);
    }

    public void unregisterQuiz(String name) {
        quizzes.remove(name);
    }

    public Quiz getQuiz(String name) {
        return quizzes.get(name);
    }

    public Quiz getWebQuiz(String url) throws IOException {
        return GsonUtil.getInstance().getGson().fromJson(Jsoup.connect(url).get().body().text(), Quiz.class);
    }

    public boolean existsQuiz(String name) {
        return quizzes.containsKey(name);
    }

    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }

    public File getQuizDirectory() {
        return quizDirectory;
    }
}
