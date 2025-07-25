\# Java Quiz Game 🎮



A simple Java console application that fetches multiple-choice quiz questions from the Open Trivia API and displays them in the terminal.



\## 📌 Features

\- Fetches 5 quiz questions from an online API

\- Multiple-choice format

\- Score tracking

\- Console interface

\- Structured using 3 Java classes



\## 🛠️ Tech Stack

\- Java (JDK 8+)

\- JSON-simple 1.1.1 library

\- Open Trivia DB API



\## 📁 Files

\- `QuizGame.java` – Main runner

\- `QuizService.java` – API + JSON logic

\- `Question.java` – Holds question data

\- `json-simple-1.1.1.jar` – JSON parser



\## ▶️ How to Run

1\. Compile:

&nbsp;  ```bash

&nbsp;  javac -cp .;json-simple-1.1.1.jar \*.java

2\, Run;

java -cp .;json-simple-1.1.1.jar QuizGame


