package data;

import java.io.IOException;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Questions {

    static ArrayList<Question> questionsList = loadQuestion();


    /**
     * Saves the actual Questions class to be persistant in time.
     */
    public static void saveQuestions() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/data/Questions.bin"); // file path
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
            FileInputStream fileInput = new FileInputStream("src/data/Questions.bin"); // file path
            ObjectInputStream objectInput = new ObjectInputStream(fileInput); // data File
            questionsList = (ArrayList<Question>) objectInput.readObject(); // Instantiate the Object, casting the objetcInput
            fileInput.close();
            objectInput.close();
            // System.out.println("Questions Loaded Succesfully");
        } catch (IOException | ClassNotFoundException e) {System.out.println(e);}
        return questionsList;
    }

    /**
     * 
     * @param question
     */
    public static void addQuestion(Question question) {
        questionsList.add(question);
        System.out.println("Appropriately Added");
    }


    public static void removeQuestion(String question) {
        for (int i = 0; i < questionsList.size(); i++)
            if (questionsList.get(i).getQuestion().equals(question)) {
                questionsList.remove(questionsList.get(i));
                break;
            }
    }


    public static void replaceQuestion(int index, Question question) {
        questionsList.remove(index);
        questionsList.add(index, question);
    }

    
    public static int getCuestionIndex(String questionText) {
        for (int i = 0; i < questionsList.size(); i++)
            if (questionsList.get(i).getQuestion().equals(questionText))
                return i;
          return (Integer) null;
    }


    public static ArrayList<String> getArrayListStrings() {
        ArrayList<String> questionsTexts = new ArrayList<String>();
        for (int i = 0; i < questionsList.size(); i++)
            questionsTexts.add(questionsList.get(i).getQuestion());
        return questionsTexts;
    }


    // In terminal
    public static String[][] showQuestions() {
        String[][] questionsArray = new String[questionsList.size()][2];
        for (int i = 0; i < questionsList.size(); i++){
            questionsArray[i][0] = questionsList.get(i).getQuestion();
            questionsArray[i][1] = questionsList.get(i).getCorrectAnswer();
        }
        return questionsArray;
    }


    // Return all the questions form the same cathegory
    public ArrayList<Question> getByCathegory(String cathegory) {
        ArrayList<Question> questionsByCathegory = new ArrayList<Question>();
        for (int i = 0; i < questionsList.size(); i++)
            if (cathegory.equals(questionsList.get(i).getCathegory()))
                questionsByCathegory.add(questionsList.get(i));
        return questionsByCathegory;
    }


    // Return all the questions form the same cathegory
    public static ArrayList<String> getCathegories() {
        ArrayList<String> cathegories = new ArrayList<String>();
        for (int i = 0; i < questionsList.size(); i++)
            if (cathegories.contains(questionsList.get(i).getCathegory())) continue;
                else cathegories.add(questionsList.get(i).getCathegory());
        return cathegories;
    }


    public static ArrayList<String> getTopics() {
        ArrayList<String> topics = new ArrayList<String>();
        for (int i = 0; i < questionsList.size(); i++)
            if (topics.contains(questionsList.get(i).getTopic())) continue;
            else topics.add(questionsList.get(i).getTopic());
        return topics;
    }
}       