import java.util.*;

public class QuizApplication {

    static class Question {
        String questionText;
        String[] options;
        int correctOption;

        public Question(String questionText, String[] options, int correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> quizQuestions = new ArrayList<>();
        quizQuestions.add(new Question("What is the capital of France?",
                new String[]{"1. Paris", "2. London", "3. Rome", "4. Berlin"}, 0));
        quizQuestions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"1. Venus", "2. Mars", "3. Jupiter", "4. Saturn"}, 1));
        quizQuestions.add(new Question("What is 5 + 3?",
                new String[]{"1. 6", "2. 7", "3. 8", "4. 9"}, 2));

        int score = 0;
        int timeLimit = 10;

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + timeLimit + " seconds to answer each question.\n");

        for (Question question : quizQuestions) {
            System.out.println(question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");

            long startTime = System.currentTimeMillis();
            String answer = null;

            while ((System.currentTimeMillis() - startTime) < timeLimit * 1000) {
                if (scanner.hasNextLine()) {
                    answer = scanner.nextLine();
                    break;
                }
            }

            if (answer == null) {
                System.out.println("Time's up! Moving to the next question.\n");
                continue;
            }

            int selectedOption;
            try {
                selectedOption = Integer.parseInt(answer) - 1;
                if (selectedOption == question.correctOption) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong answer. The correct answer was: " + (question.correctOption + 1) + "\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Moving to the next question.\n");
            }
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your final score: " + score + "/" + quizQuestions.size());

        scanner.close();
    }
}
