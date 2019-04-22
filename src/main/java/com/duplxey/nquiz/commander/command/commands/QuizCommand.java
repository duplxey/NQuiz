package com.duplxey.nquiz.commander.command.commands;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.constants.Message;
import com.duplxey.nquiz.quiz.Quiz;
import com.duplxey.nquiz.quiz.QuizManager;

public class QuizCommand extends Command {

    public QuizCommand() {
        super("quiz", "Quiz management command.", "quiz <name|list|create|remove|play> | <name>");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println(Message.WRONG_SYNTAX.getText() + getSyntax());
            return;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("list")) {
                if (QuizManager.getQuizzes().size() == 0) {
                    System.out.println("There are currently no quizzes registered. Create or download some!");
                    return;
                }
                System.out.println("The following quizzes are registered: ");
                for (Quiz quiz : QuizManager.getQuizzes()) {
                    System.out.println(quiz.info());
                }
                return;
            }
            Quiz quiz = QuizManager.getQuiz(args[0]);
            if (quiz == null) {
                System.out.println("The quiz named '" + args[0] + "' does not exist.");
                return;
            }
            quiz.print();
            return;
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("register")) {
                if (QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' already exists.");
                    return;
                }
                QuizManager.registerQuiz(args[1], new Quiz(args[1]));
                System.out.println("Quiz named '" + args[1] + "' has been registered.");
                return;
            }
            if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("unregister")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                QuizManager.unregisterQuiz(args[1]);
                System.out.println("Quiz named '" + args[1] + "' has been removed.");
                return;
            }
            System.out.println(Message.WRONG_SYNTAX.getText() + getSyntax());
            return;
        }
    }
}
