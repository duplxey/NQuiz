package com.duplxey.nquiz.quiz.data;

import java.io.File;
import java.io.IOException;

public class DataManager {

    private File quizDirectory;

    public DataManager() {
        setup();
        loadLocalQuizzes();
    }

    private void setup() {
        quizDirectory = new File("quizzes");
        if (!quizDirectory.exists()) {
            try {
                quizDirectory.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadLocalQuizzes() {
//        for (File file : quizDirectory.listFiles()) {
//            QuizManager.registerQuiz(file.getName(), GsonUtil.getInstance().getGson().fromJson(FileUtil.getFileContent(file), Quiz.class));
//        }
    }

    public File getQuizDirectory() {
        return quizDirectory;
    }
}
