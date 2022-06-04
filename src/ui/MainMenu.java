package ui;

import javax.swing.*;

import data.Question;
import data.Questions;
import util.AuxiliarMethods;

import java.awt.*;
import javax.swing.*;

public class MainMenu {

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
        workSpace.setBounds(20, 20, 400, 400);
        frame.add(workSpace);

        JButton createButton = AuxiliarMethods.createImageButton("Create", "", 40, 40);
        createButton.setBounds(560, 40, 120, 60);
        createButton.addActionListener(e -> {
            workSpace.removeAll();
            createMenu();
            workSpace.repaint();
        });
        frame.add(createButton);

        JButton readButton = AuxiliarMethods.createImageButton("Read", "", 40, 40);
        readButton.setBounds(560, 140, 120, 60);
        readButton.addActionListener(e -> {
            workSpace.removeAll();
            readMenu();
            workSpace.repaint();
        });
        frame.add(readButton);

        JButton updateButton = AuxiliarMethods.createImageButton("Update", "", 40, 40);
        updateButton.setBounds(560, 240, 120, 60);
        updateButton.addActionListener(e -> {
            workSpace.removeAll();
            updateMenu();
            workSpace.repaint();
        });
        frame.add(updateButton);

        JButton deleteButton = AuxiliarMethods.createImageButton("Delete", "", 40, 40);
        deleteButton.setBounds(560, 340, 120, 60);
        deleteButton.addActionListener(e -> {
            workSpace.removeAll();
            deleteMenu();
            workSpace.repaint();
        });
        frame.add(deleteButton);

    }


    private void createMenu() {
        AuxiliarMethods.createAskField(workSpace, "Question", 80, 100, false);
        AuxiliarMethods.createAskField(workSpace, "Correct Answer", 80, 160, false);
        AuxiliarMethods.createAskField(workSpace, "Possible Answer:", 80, 200, false);
        AuxiliarMethods.createAskField(workSpace, "Possible Answer:", 80, 240, false);
        AuxiliarMethods.createAskField(workSpace, "Possible Answer:", 80, 280, false);


        JButton saveButton = new JButton("Save");
        saveButton.setBounds(160, 340, 120, 40);
        saveButton.addActionListener(e -> {
            // TODO Save properlly the new question
            // UserInterface.questions.add(new Question());
            Questions.saveQuestions();
        });
        workSpace.add(saveButton);
    }

    private void readMenu() {


    }

    private void updateMenu() {


    }

    private void deleteMenu() {


    }



}