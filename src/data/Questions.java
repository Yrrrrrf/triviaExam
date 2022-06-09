package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Questions {

    static ArrayList<Question> questionsList = loadQuestion();
    // static ArrayList<Question> questionsList = new ArrayList<Question>();

    /**
     * Saves the actual Questions class to be persistant in time.
     */
    public static void saveQuestions() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/data/Questions.ser"); // file path
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // file Out
            objectOut.writeObject(questionsList); // Write object's data in the file
            objectOut.close();
            fileOut.close();
            System.out.println("Successfully Object Saved");
        } catch (IOException e) {System.out.println(e);}
    }


    /**
     * Load the data saved. Built the questions using the 
     */
    public static ArrayList<Question> loadQuestion()  {
        try {
            FileInputStream fileInput = new FileInputStream("src/data/Questions.ser"); // file path
            ObjectInputStream objectInput = new ObjectInputStream(fileInput); // data File
            questionsList = (ArrayList<Question>) objectInput.readObject(); // Instantiate the Object, casting the objetcInput
            fileInput.close();
            objectInput.close();
            System.out.println("Questions Loaded Succesfully");
        } catch (IOException | ClassNotFoundException e) {System.out.println(e);}
        return questionsList;
    }


    public static void addQuestion(Question question) {
        questionsList.add(question);
    }


    public static void removeQuestion(Question question) {
        questionsList.remove(question);
    }
    
    
    public static Question getuestionAt(int index) {
        return questionsList.get(index);
    }

    // In terminal
    public static void showQuestions() {
        System.out.println(questionsList.size());
        for (int i = 0; i < questionsList.size(); i++) 
            System.out.println(Questions.getuestionAt(i).toString());
    }


    // Return all the questions form the same cathegory
    public ArrayList<Question> getByCathegory(String cathegory) {
        ArrayList<Question> questionsByCathegory = new ArrayList<Question>();
        for (int i = 0; i < questionsList.size(); i++) {
            if (cathegory.equals(questionsList.get(i).getCathegory())) {
                questionsByCathegory.add(questionsList.get(i));
            }
        }
        return questionsByCathegory;
    }


    public static void main(String[] args) {
        // saveLeaderboard();
        // loadLeaderboard();
    }
}       