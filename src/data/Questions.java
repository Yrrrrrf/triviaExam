package data;

import java.io.IOException;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Questions {

    static List<Question> questionsList;

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
    public static List<Question> loadQuestion()  {
        try {
            FileInputStream fileInput = new FileInputStream("D:\\UAEMex\\3° Semestre\\Paradigmas de Programación\\TriviaGameExam\\src\\data\\Questions.ser"); // file path
            ObjectInputStream objectInput = new ObjectInputStream(fileInput); // data File
            questionsList = (List<Question>) objectInput.readObject(); // Instantiate the Object, casting the objetcInput
            fileInput.close();
            objectInput.close();
            System.out.println("Questions Loaded Succesfully");
        } catch (IOException | ClassNotFoundException e) {System.out.println(e);}
        return questionsList;
    }

    public static void main(String[] args) {
        // saveLeaderboard();
        // loadLeaderboard();
    }
}