import java.util.*;

public class Question {
    private String questionText;
    private String correctAnswer;
    private List<String> options;
    
    public Question(String questionText, String correctAnswer, List<String> incorrectAnswers) {
        this.questionText = htmlDecode(questionText);
        this.correctAnswer = htmlDecode(correctAnswer);
        this.options = new ArrayList<>();
        for (String ans : incorrectAnswers) this.options.add(htmlDecode(ans));
        this.options.add(this.correctAnswer);
        Collections.shuffle(this.options);
    }

    public String getQuestionText() { return questionText; }
    public List<String> getOptions() { return options; }
    public boolean isCorrect(String answer) { return answer.equalsIgnoreCase(correctAnswer); }

    private String htmlDecode(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&#039;", "'")
                .replaceAll("&amp;", "&")
                .replaceAll("&eacute;", "é");
    }
}