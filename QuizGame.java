import java.util.*;

public class QuizGame {
    public static void main(String[] args) {
        QuizService service = new QuizService();
        int score = 0;

        try {
            List<Question> questions = service.fetchQuestions();
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                System.out.println("\nQ" + (i+1) + ": " + q.getQuestionText());
                List<String> opts = q.getOptions();
                for (int j = 0; j < opts.size(); j++) {
                    System.out.println((j + 1) + ". " + opts.get(j));
                }
                System.out.print("Your answer (1-4): ");
                int choice = sc.nextInt();
                String selected = opts.get(choice - 1);

                if (q.isCorrect(selected)) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong! Correct: " + q.getOptions().get(q.getOptions().indexOf(q.getOptions().stream().filter(opt -> q.isCorrect(opt)).findFirst().orElse(""))));
                }
            }
            sc.close();

            System.out.println("\n🎉 Quiz Completed! You scored: " + score + "/5");
        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }
}