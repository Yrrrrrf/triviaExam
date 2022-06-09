package data;

import java.io.IOException;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Questions {

    //static ArrayList<Question> questionsList = loadQuestion();
   static ArrayList<Question> questionsList = new ArrayList<Question>();

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
            System.out.println("Questions Loaded Succesfully");
        } catch (IOException | ClassNotFoundException e) {System.out.println(e);}
        return questionsList;
    }




    public static void addQuestion(Question question) {
        questionsList.add(question);
        System.out.println("Agregado correctamente");
    }


    public static void removeQuestion(String question) {
        //  System.out.println(questionsList.size());
          for (int i = 0; i < questionsList.size(); i++){
            //  System.out.println(i);
             if (questionsList.get(i).getQuestion().equals(question)){
             questionsList.remove(questionsList.get(i));
             break;
             }
          }
    }

    public static void replaceQuestion(int index, Question question) {
        questionsList.remove(index);
        questionsList.add(index, question);
        
    }
    
    public static int getCuestionIndex(String questionText) {
        
        for (int i = 0; i < questionsList.size(); i++){
            //  System.out.println(i);
             if (questionsList.get(i).getQuestion().equals(questionText)){
             return i;
             }
          }
          return (Integer) null;
    }


    public static ArrayList<String> getArrayListStrings() {
        ArrayList<String> questionsTexts = new ArrayList<String>();
        for (int i = 0; i < questionsList.size(); i++){
            //  System.out.println(i);
              questionsTexts.add(questionsList.get(i).getQuestion());
          }   
          return questionsTexts;
    }

    // In terminal
    public static String[][] showQuestions() {
        String[][] questionsArray = new String[questionsList.size()][2];
        
        //System.out.println(questionsList.size());
        
        //System.out.println(questionsList[0].);
        //System.out.println(questionsList.size());
        for (int i = 0; i < questionsList.size(); i++){
          //  System.out.println(i);
            questionsArray[i][0] = questionsList.get(i).getQuestion();
            questionsArray[i][1] = questionsList.get(i).getCorrectAnswer();
        //   System.out.println(questionsList.get(i).getQuestion());
        //    System.out.println(questionsList.get(i).getCorrectAnswer());
        //    System.out.println(Questions.getuestionAt(i).toString());
        }
        return questionsArray;
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


    // Return all the questions form the same cathegory
    public static ArrayList<String> getCathegories() {
        ArrayList<String> cathegories = new ArrayList<String>();
      //  System.out.println(questionsList.size());
        for (int i = 0; i < questionsList.size(); i++){
          //  System.out.println(i);
           if (cathegories.contains(questionsList.get(i).getCathegory())) continue;
            else cathegories.add(questionsList.get(i).getCathegory());
            //    System.out.println(questionsList.get(i).getCathegory());
        }
        return cathegories;
    }

    public static ArrayList<String> getTopics() {
        ArrayList<String> topics = new ArrayList<String>();
      //  System.out.println(questionsList.size());
        for (int i = 0; i < questionsList.size(); i++){
          //  System.out.println(i);
           if (topics.contains(questionsList.get(i).getTopic())) continue;
            else topics.add(questionsList.get(i).getTopic());
            //    System.out.println(questionsList.get(i).getCathegory());
        }
        return topics;
    }

    

    public static void main(String[] args) {
       // Questions.getCathegories();
        //Questions.showQuestions();
        // saveLeaderboard();
        // loadLeaderboard();
        // comparateQuestion();
    }
}       