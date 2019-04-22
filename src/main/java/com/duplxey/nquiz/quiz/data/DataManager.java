package com.duplxey.nquiz.quiz.data;

import com.duplxey.nquiz.quiz.Quiz;
import com.duplxey.nquiz.quiz.QuizManager;
import com.duplxey.nquiz.util.FileUtil;
import com.duplxey.nquiz.util.GsonUtil;

import java.io.File;

public class DataManager {

    private File quizDirectory;

    public DataManager() {
        setup();
        loadLocalQuizzes();
    }

    private void setup() {
        quizDirectory = new File("quizzes");
        if (!quizDirectory.exists()) {
            quizDirectory.mkdir();
        }
    }

    private void loadLocalQuizzes() {
        for (File file : quizDirectory.listFiles()) {
            QuizManager.registerQuiz(file.getName(), GsonUtil.getInstance().getGson().fromJson(FileUtil.getFileContent(file.getPath()), Quiz.class));
        }
    }

    public File getQuizDirectory() {
        return quizDirectory;
    }
}
