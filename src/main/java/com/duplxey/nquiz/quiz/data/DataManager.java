package com.duplxey.nquiz.quiz.data;

import com.duplxey.nquiz.quiz.Quiz;
import com.duplxey.nquiz.quiz.QuizManager;
import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;

import java.io.File;

public class DataManager {

    private static File quizDirectory;

    public DataManager() {
        setup();
        loadSavedQuizzes();
    }

    private void setup() {
        quizDirectory = new File("quizzes");
        if (!quizDirectory.exists()) {
            quizDirectory.mkdir();
        }
    }

    private void loadSavedQuizzes() {
        for (File file : quizDirectory.listFiles()) {
            QuizManager.registerQuiz(GsonUtil.getInstance().getGson().fromJson(FileUtil.getFileContent(file.getPath()), Quiz.class));
        }
    }

    public static void save(Quiz quiz) {
        FileUtil.writeToFile(quizDirectory.getPath() + File.separator + quiz.getName() + ".json", GsonUtil.getInstance().getGson().toJson(quiz));
    }

    public static void delete(String name) {
        File quizFile = new File(quizDirectory, name + ".json");
        quizFile.delete();
    }

    public File getQuizDirectory() {
        return quizDirectory;
    }
}
