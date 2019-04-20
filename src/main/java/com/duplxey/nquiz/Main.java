package com.duplxey.nquiz;

import com.duplxey.nquiz.commander.Commander;
import com.duplxey.nquiz.quiz.QuizManager;

public class Main {

    public static void main(String[] args) {
        QuizManager quizManager = new QuizManager();

        Commander commander = new Commander();
        commander.start();
    }
}
