package com.duplxey.nquiz;

import com.duplxey.nquiz.commander.Commander;
import com.duplxey.nquiz.quiz.QuizManager;
import com.duplxey.nquiz.util.FileUtil;

public class Main {

    // TODO: fix that stupid static abuse
    public static void main(String[] args) {
        System.out.println(FileUtil.getResourceContent("about.txt"));

        QuizManager quizManager = new QuizManager();

        Commander commander = new Commander();
        commander.start();
    }
}
