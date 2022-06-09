package ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import data.Question;
import data.Questions;
import test.ButtonColumn;
import util.AuxiliarMethods;


public class MainMenu {

    
    ArrayList<String> arrayTopics = Questions.getTopics();
    ArrayList<String> arrayCategory = Questions.getCathegories();
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

        deleteButton.setBounds(560, 320, 120, 60);

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
        
        JComboBox comboBoxTopic = AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 140,false, arrayTopics);
        JComboBox comboBoxCategory =AuxiliarMethods.createComboBox(workSpace,"Category", 80, 180,false, arrayCategory);
        JTextField textQuestion = AuxiliarMethods.createAskField(workSpace, "Question:", 80, 220, false);
        JTextField textCategory = AuxiliarMethods.createAskField(workSpace, "Correct Answer:", 80, 260, false);
 

        JButton addCategoryTopicButton = new JButton("Add categories");
        addCategoryTopicButton.setBounds(400, 35, 120, 30);
        addCategoryTopicButton.addActionListener(e -> {
            addCategoriasMenu();     
            workSpace.repaint();
        });


        JButton saveButton = new JButton("Add");
        saveButton.setBounds(160, 340, 120, 40);
        saveButton.addActionListener(e -> {
            Question q = new Question(textQuestion.getText(), textCategory.getText(), comboBoxTopic.getSelectedItem().toString(), comboBoxCategory.getSelectedItem().toString());
            Questions.addQuestion(q);
            Questions.saveQuestions();
         });


        
        workSpace.add(addCategoryTopicButton);
        workSpace.add(saveButton);
    }
    
    private void addCategoriasMenu() {   
        
        JTextField textTopic=  AuxiliarMethods.createAskField(workSpace, "Topic", 40, 10, false);
        JTextField textCategory = AuxiliarMethods.createAskField(workSpace, "Category", 40, 60, false);

        JButton addTopicButton = new JButton("Add");
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
        String[] Arrayquestion = {"Question", "Answer"};
        JTable questionsTable = new JTable (Questions.showQuestions(),Arrayquestion); 
        System.out.println(Questions.getCathegories());
       // System.out.println(Questions.getCathegories().size());
        questionsTable.setRowHeight(32);
        JScrollPane questiScrollPane = new JScrollPane(questionsTable);
        questiScrollPane.setBounds(20, 20, 400, 400);
        workSpace.add(questiScrollPane);

    }

    private void updateMenu() {
        
        JComboBox arrayquestions = AuxiliarMethods.createComboBox(workSpace, "Questions", 40, 120, false, Questions.getArrayListStrings());
        arrayquestions.setBounds(80, 120,300,32);
        workSpace.add(arrayquestions);
        
        JButton addEditButton = new JButton("Edit");
        addEditButton.setBounds(390, 120,60, 30);
        addEditButton.addActionListener(e -> {
            workSpace.removeAll();
            JComboBox comboBoxQuestion = AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 50,false, arrayTopics);
            JComboBox comboBoxAnswer =AuxiliarMethods.createComboBox(workSpace,"Category", 80, 100,false, arrayCategory);
           
            Integer index = Questions.getCuestionIndex((String)arrayquestions.getSelectedItem());
            JTextField textfiedQuestion = AuxiliarMethods.createAskField(workSpace, "Question", 50, 150, false);
            JTextField textfieldAnswer = AuxiliarMethods.createAskField(workSpace, "Answer", 50, 200, false);
            comboBoxAnswer.setSelectedItem(Questions.loadQuestion().get(index).getCorrectAnswer());
            comboBoxQuestion.setSelectedItem(Questions.loadQuestion().get(index).getQuestion());
            
            textfiedQuestion.setText(Questions.loadQuestion().get(index).getQuestion());
            textfieldAnswer.setText(Questions.loadQuestion().get(index).getCorrectAnswer());
            
            JButton saveButton = new JButton("Save");
            saveButton.setBounds(160, 340, 120, 40);
            saveButton.addActionListener(i -> {
            Question q = new Question(textfiedQuestion.getText(), textfieldAnswer.getText(), comboBoxAnswer.getSelectedItem().toString(), comboBoxQuestion.getSelectedItem().toString());
            Questions.replaceQuestion(index, q);
            Questions.saveQuestions();
         });

            workSpace.add(textfiedQuestion);
            workSpace.add(textfieldAnswer);
            workSpace.add(comboBoxQuestion);
            workSpace.add(comboBoxAnswer);
            workSpace.add(saveButton);
            workSpace.repaint();
        });

        
        workSpace.add(addEditButton);


        
        /* 
        AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 80,false, arrayCategory);
        AuxiliarMethods.createAskField(workSpace, "New Topic", 80, 120, false);
        AuxiliarMethods.createComboBox(workSpace,"Category", 80, 200,false, arrayTopics);
        AuxiliarMethods.createAskField(workSpace, "New Category", 80, 240, false);
        JButton updateTopicButton = new JButton("Update");
        updateTopicButton.setBounds(362, 240,100, 30);
        updateTopicButton.addActionListener(e -> {
            // arrayCategory.add(textCategory.getText());
            // workSpace.removeAll();
            workSpace.repaint();
        });

        JButton updateCategorysButton = new JButton("Update");
        updateCategorysButton.setBounds(362, 120,100, 30);
        updateCategorysButton.addActionListener(e -> {
            // arrayCategory.add(textCategory.getText());
            // workSpace.removeAll();
            workSpace.repaint();
        });

        workSpace.add(updateTopicButton);
        workSpace.add(updateCategorysButton);
        */
    }

    private void deleteMenu() {

        String[] Arrayquestion = {"Question", "Answer"};
        JTable questionsTable = new JTable (Questions.showQuestions(),Arrayquestion); 
        System.out.println(Questions.getCathegories());
       // System.out.println(Questions.getCathegories().size());
        questionsTable.setRowHeight(32);
        


      
        questionsTable.addColumn(new TableColumn());
        //inventoryTable.getColumnModel().getColumn(6).setPreferredWidth(32); // Table Button
        // Table action Performed method (used below in the ButtonColumn)
        Action tableButtonAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                Questions.removeQuestion((String)table.getValueAt(table.getSelectedRow(), 2));
                workSpace.removeAll();
                deleteMenu();
                workSpace.repaint();
                Questions.saveQuestions();
                // table.getValueAt(table.getSelectedRow(), 0);
            }
        };
        // Add the Button Column to the table
        new ButtonColumn(questionsTable, tableButtonAction, 2);
       // questionsTable.getColumnModel().getColumn(2).setHeaderValue("Delete");
        JScrollPane questiScrollPane = new JScrollPane(questionsTable);
        questiScrollPane.setBounds(20, 20, 400, 400);
        workSpace.add(questiScrollPane);

    }



}