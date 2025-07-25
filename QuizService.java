import java.io.*;
import java.net.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class QuizService {
    private static final String API_URL = "https://opentdb.com/api.php?amount=5&type=multiple";

    public List<Question> fetchQuestions() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) sb.append(line);
        in.close();

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(sb.toString());
        JSONArray results = (JSONArray) root.get("results");

        List<Question> questions = new ArrayList<>();
        for (Object obj : results) {
            JSONObject item = (JSONObject) obj;
            String question = (String) item.get("question");
            String correct = (String) item.get("correct_answer");
            JSONArray incorrectArr = (JSONArray) item.get("incorrect_answers");
            List<String> incorrect = new ArrayList<>();
            for (Object wrong : incorrectArr) incorrect.add((String) wrong);
            questions.add(new Question(question, correct, incorrect));
        }
        return questions;
    }
}