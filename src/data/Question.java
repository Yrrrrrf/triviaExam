package data;

import java.io.Serializable;

public class Question implements Serializable {

    private String question;
    private String correctAnswer;
    private String cathegory;
    private String topic;


    public Question(String question, String correctAnswer, String cathegory, String topic) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.cathegory = cathegory;
        this.topic = topic;
    }


    @Override
    public String toString() {
        return getQuestion() + "\n"
             + getCorrectAnswer() + "\n"
             + getCathegory() + "\n"
             + getTopic();
    }


    //* Setters
    public void setQuestion(String question) {this.question = question;}

    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}

    public void setCathegory(String cathegory) {this.cathegory = cathegory;}

    public void setTopic(String topic) {this.topic = topic;}


    //* Getters
    public String getQuestion() {return this.question;}

    public String getCorrectAnswer() {return this.correctAnswer;}
    
    public String getCathegory() {return this.cathegory;}

    public String getTopic() {return this.topic;}
}