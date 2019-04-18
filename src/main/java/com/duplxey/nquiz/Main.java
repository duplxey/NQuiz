package com.duplxey.nquiz;

import com.duplxey.nquiz.commander.Commander;
import com.duplxey.nquiz.quiz.Answer;
import com.duplxey.nquiz.quiz.Question;
import com.duplxey.nquiz.quiz.Quiz;
import com.duplxey.nquiz.quiz.QuizCategory;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Commander commander = new Commander();
        commander.start();

        Quiz quiz = new Quiz("About me", "A few questions about me.", QuizCategory.FUN, new LinkedList<>(Arrays.asList(
                new Question("What is my name?", new Answer[] {new Answer("Joze"), new Answer("Mirko")})
        )));
    }
}
