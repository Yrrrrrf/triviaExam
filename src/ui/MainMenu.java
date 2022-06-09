package ui;

import javax.swing.*;

import data.Question;
import data.Questions;
import util.AuxiliarMethods;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MainMenu {
    
    ArrayList<String> arrayTopics = new ArrayList<String>();
    ArrayList<String> arrayCategory = new ArrayList<String>();

    JPanel workSpace = new JPanel();
 
    /**
     * Create all the components of the Main Menu & add it to the frame
     * @param frame JPanel in which the elements will be painted
     */
    public MainMenu(JPanel frame) {

      

        UserInterface.frame.setJMenuBar(null);
        // frame.setLayout(null);
        frame.setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        workSpace.setLayout(null);
        workSpace.setBounds(20, 20, 520, 420);
        frame.add(workSpace);

        

        // JButton createButton = AuxiliarMethods.createImageButton("Create", "", 40, 20, "Arial", 14);
        JButton createButton = AuxiliarMethods.createImageButton("Create", "src/img/Create.png", 40, 40, "Arial", 14);
        createButton.setBounds(560, 80, 120, 60);
        createButton.addActionListener(e -> {
            workSpace.removeAll();
            createMenu();       
            workSpace.repaint();
        });

        frame.add(createButton); 

        
        

        JButton readButton = AuxiliarMethods.createImageButton("Read", "src/img/Read.png", 40, 40, "Arial", 14);
        readButton.setBounds(560, 160, 120, 60);
        readButton.addActionListener(e -> {
            workSpace.removeAll();
            readMenu();
            workSpace.repaint();
        });
        frame.add(readButton);

        JButton updateButton = AuxiliarMethods.createImageButton("Update", "src/img/Update.png", 40, 40, "Arial", 14);
        updateButton.setBounds(560, 240, 120, 60);
        updateButton.addActionListener(e -> {
            workSpace.removeAll();
            updateMenu();
            workSpace.repaint();
        });
        frame.add(updateButton);

        JButton deleteButton = AuxiliarMethods.createImageButton("Delete", "src/img/Delete.png", 40, 40, "Arial", 14);
        deleteButton.setBounds(560, 340, 120, 60);
        deleteButton.addActionListener(e -> {
            workSpace.removeAll();
            deleteMenu();
            workSpace.repaint();
        });
        frame.add(deleteButton);

    }




    private void createMenu() {
        

        // AuxiliarMethods.createComboBox(workSpace,"Topic" , 120, 140, arrayTopics);
        AuxiliarMethods.createComboBox(workSpace,"Category", 80, 140,false, arrayTopics);
        AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 180,false, arrayCategory);
        AuxiliarMethods.createAskField(workSpace, "Question:", 80, 220, false);
        AuxiliarMethods.createAskField(workSpace, "Correct Answer:", 80, 260, false);
 

        JButton addCategoryorTopicButton = new JButton("Add categories");
        addCategoryorTopicButton.setBounds(400, 35, 120, 30);
        addCategoryorTopicButton.addActionListener(e -> {
            addCategoriasMenu();     
            workSpace.repaint();
        });


        JButton saveButton = new JButton("Save");
        saveButton.setBounds(160, 340, 120, 40);
        saveButton.addActionListener(e -> {
            Questions.saveQuestions();
        });
        
        workSpace.add(addCategoryorTopicButton);
        workSpace.add(saveButton);
    }
    
    private void addCategoriasMenu() {   
        
        JTextField textTopic=  AuxiliarMethods.createAskField(workSpace, "Topic", 40, 10, false);
        JTextField textCategory = AuxiliarMethods.createAskField(workSpace, "Category", 40, 60, false);

        JButton addTopicButton = new JButton("add");
        addTopicButton.setBounds(320, 10, 60, 30);
        addTopicButton.addActionListener(e -> {   
            arrayTopics.add(textTopic.getText());
            workSpace.removeAll();
            createMenu();
            workSpace.repaint();

        });
        JButton addCategorysButton = new JButton("add");
        addCategorysButton.setBounds(320, 60,60, 30);
        addCategorysButton.addActionListener(e -> {
            arrayCategory.add(textCategory.getText());
            workSpace.removeAll();
            createMenu();
            workSpace.repaint();
        });
        workSpace.add(addTopicButton);
        workSpace.add(addCategorysButton);
    }

    private void readMenu() {


    }

    private void updateMenu() {


    }

    private void deleteMenu() {


    }



}