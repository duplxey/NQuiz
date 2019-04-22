package com.duplxey.nquiz.commander.command.commands;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.constants.Message;
import com.duplxey.nquiz.quiz.*;
import com.duplxey.nquiz.quiz.data.DataManager;

import java.util.Scanner;

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
                Quiz created = new Quiz(args[1]);
                QuizManager.registerQuiz(created);
                System.out.println("Quiz named '" + args[1] + "' has been registered.");
                DataManager.save(created);
                return;
            }
            if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("unregister")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                QuizManager.unregisterQuiz(args[1]);
                System.out.println("Quiz named '" + args[1] + "' has been removed.");
                DataManager.delete(args[1]);
                return;
            }
            if (args[0].equalsIgnoreCase("addquestion")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = QuizManager.getQuiz(args[1]);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Question?");
                String question = scanner.nextLine();
                System.out.println("How many answers?");
                Answer[] answers = new Answer[scanner.nextInt() + 1];
                for (int i = 0; i < answers.length; i++) {
                    answers[i] = new Answer(scanner.nextLine());
                }
                System.out.println("Correct answer?");
                int correct = scanner.nextInt();
                quiz.addQuestion(new Question(question, answers, correct-1));
                System.out.println("Successfully added a question.");
                DataManager.save(quiz);
                return;
            }
            System.out.println(Message.WRONG_SYNTAX.getText() + getSyntax());
            return;
        }
        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("setdifficulty")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = QuizManager.getQuiz(args[1]);
                String difficulty = args[2];
                // TODO: verify if enum exists
                quiz.setDifficulty(QuizDifficulty.valueOf(difficulty.toUpperCase()));
                DataManager.save(quiz);
                return;
            }
            if (args[0].equalsIgnoreCase("setcategory")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = QuizManager.getQuiz(args[1]);
                String category = args[2];
                // TODO: verify if enum exists
                quiz.setCategory(QuizCategory.valueOf(category.toUpperCase()));
                DataManager.save(quiz);
                return;
            }
            if (args[0].equalsIgnoreCase("removequestion")) {
                if (!QuizManager.existsQuiz(args[1])) {
                    System.out.println("Quiz named '" + args[1] + "' doesn't exist.");
                    return;
                }
                Quiz quiz = QuizManager.getQuiz(args[1]);
                quiz.removeQuestion(new Scanner(System.in).nextInt()-1);
                DataManager.save(quiz);
                return;
            }
        }
    }
}
