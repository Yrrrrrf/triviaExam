package data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Question implements Serializable {
 
    private HashMap<String, List<String>> answers;
    private String cathegory;
    private String topic;


    public Question(HashMap<String, List<String>> answers, String cathegory, String topic) {
        this.answers = answers;
        this.cathegory = cathegory;
        this.topic = topic;
    }



}