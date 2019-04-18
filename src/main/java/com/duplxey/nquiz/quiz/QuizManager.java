package com.duplxey.nquiz.quiz;

import java.util.Collection;
import java.util.HashMap;

public class QuizManager {

    private static HashMap<String, Quiz> quizzes = new HashMap<>();

    public static void registerQuiz(String name, Quiz quiz) {
        quizzes.put(name, quiz);
    }

    public static void unregisterQuiz(String name) {
        quizzes.remove(name);
    }

    public Quiz getQuiz(String name) {
        return quizzes.get(name);
    }

    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }
}
