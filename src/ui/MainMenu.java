package ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import data.Question;
import data.Questions;
import test.ButtonColumn;
import util.AuxiliarMethods;

/**
 * 
 */
public class MainMenu {

    ArrayList<String> arrayTopics = Questions.getTopics();
    ArrayList<String> arrayCategory = Questions.getCathegories();
    JPanel workSpace = new JPanel();


    /**
     * Create all the components of the Main Menu & add it to the frame
     * @param frame JPanel in which the elements will be painted
     */
    public MainMenu(JPanel frame) {
        System.out.println("Hola");
        UserInterface.frame.setJMenuBar(null);
        // frame.setLayout(null);
        frame.setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        frame.add(layeredPane);
        workSpace.setLayout(null);
        workSpace.setBounds(20, 20, 520, 420);
        frame.add(workSpace);

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
        deleteButton.addActionListener(e -> {
            workSpace.removeAll();
            deleteMenu();
            workSpace.repaint();
        });
        frame.add(deleteButton);
    }

    /**
     * Load create menu in 
     */
    private void createMenu() {
        JComboBox comboBoxTopic = AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 140,false, arrayTopics);
        JComboBox comboBoxCategory =AuxiliarMethods.createComboBox(workSpace,"Category", 80, 180,false, arrayCategory);
        JTextField textQuestion = AuxiliarMethods.createAskField(workSpace, "Question:", 80, 220, false);
        JTextField textCategory = AuxiliarMethods.createAskField(workSpace, "Correct Answer:", 80, 260, false);
 
        JButton addCategoryTopicButton = new JButton("Add categories");
        addCategoryTopicButton.setBounds(400, 35, 120, 30);
        addCategoryTopicButton.addActionListener(e -> {
            addCategoriesMenu();     
            workSpace.repaint();
        });
        workSpace.add(addCategoryTopicButton);

        JButton saveButton = new JButton("Add");
        saveButton.setBounds(160, 340, 120, 40);
        saveButton.addActionListener(e -> {
            String question = textCategory.getText();
            String correct = textCategory.getText();
            if(question.isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Is not posible create a empty question");
            }if(correct.isEmpty()== true){
                JOptionPane.showMessageDialog(null, "Is not posible create a empty empty correct answer");
            }else{
                Question q = new Question(textQuestion.getText(), textCategory.getText(), comboBoxTopic.getSelectedItem().toString(), comboBoxCategory.getSelectedItem().toString());
                Questions.addQuestion(q);
                Questions.saveQuestions();
                JOptionPane.showMessageDialog(null, "Question successfully saved");
                workSpace.removeAll();
                workSpace.repaint();
            }
            
          
         });        
        workSpace.add(saveButton);
    }
    
    /**
     * Add categories to add topics and categories
     */
    private void addCategoriesMenu() {
        JTextField textTopic=  AuxiliarMethods.createAskField(workSpace, "Topic", 40, 10, false);
        JTextField textCategory = AuxiliarMethods.createAskField(workSpace, "Category", 40, 60, false);

        JButton addTopicButton = new JButton("Add");
        addTopicButton.setBounds(320, 10, 60, 30);
        addTopicButton.addActionListener(e -> {   
            String a =textTopic.getText();
            if (a.isEmpty()== true){
                JOptionPane.showMessageDialog(null, "Is not posible sabe a empty topic");
            }else{
                arrayTopics.add(textTopic.getText());
                workSpace.removeAll();
                createMenu();
                workSpace.repaint();
            }
        });
        workSpace.add(addTopicButton);

        JButton addCategorysButton = new JButton("add");
        addCategorysButton.setBounds(320, 60,60, 30);
        addCategorysButton.addActionListener(e -> {
            String a =textCategory.getText();
            if (a.isEmpty()== true){
                JOptionPane.showMessageDialog(null, "Is not posible sabe a empty category");
            }else{
                arrayCategory.add(textCategory.getText());
                workSpace.removeAll();
                createMenu();
                workSpace.repaint();
            }
        });
        workSpace.add(addCategorysButton);
    }

    /**
     * Read data from question table in read menu 
     */
    private void readMenu() {
        String[] Arrayquestion = {"Question", "Answer"};
        JTable questionsTable = new JTable (Questions.showQuestions(),Arrayquestion); 
        questionsTable.setRowHeight(32);
        JScrollPane questiScrollPane = new JScrollPane(questionsTable);
        questiScrollPane.setBounds(20, 20, 400, 400);
        workSpace.add(questiScrollPane);
    }

    /**
     * Update menu to replace topic, category, question and answer (old to new)  
     */
    private void updateMenu() {
        JComboBox arrayQuestions = AuxiliarMethods.createComboBox(workSpace, "Questions", 40, 120, false, Questions.getArrayListStrings());
        arrayQuestions.setBounds(80, 120,300,32);
        workSpace.add(arrayQuestions);
        JButton addEditButton = new JButton("Edit");
        addEditButton.setBounds(390, 120,60, 30);
       
            
        
        addEditButton.addActionListener(e -> {
            try {
                workSpace.removeAll();
                 workSpace.repaint();
                JComboBox comboBoxQuestion = AuxiliarMethods.createComboBox(workSpace,"Topic", 80, 50,false, arrayTopics);
                JComboBox comboBoxAnswer =AuxiliarMethods.createComboBox(workSpace,"Category", 80, 100,false, arrayCategory);
                Integer index = Questions.getCuestionIndex((String)arrayQuestions.getSelectedItem());
                JTextField textFieldQuestion = AuxiliarMethods.createAskField(workSpace, "Question", 50, 150, false);
                JTextField textFieldAnswer = AuxiliarMethods.createAskField(workSpace, "Answer", 50, 200, false);
                comboBoxAnswer.setSelectedItem(Questions.loadQuestion().get(index).getCorrectAnswer());
                comboBoxQuestion.setSelectedItem(Questions.loadQuestion().get(index).getQuestion());
    
                textFieldQuestion.setText(Questions.loadQuestion().get(index).getQuestion());
                textFieldAnswer.setText(Questions.loadQuestion().get(index).getCorrectAnswer());
                
                JButton saveButton = new JButton("Save");
                saveButton.setBounds(160, 340, 120, 40);
                saveButton.addActionListener(i -> {
                    
                Question q = new Question(textFieldQuestion.getText(), textFieldAnswer.getText(), comboBoxAnswer.getSelectedItem().toString(), comboBoxQuestion.getSelectedItem().toString());
                Questions.replaceQuestion(index, q);
                Questions.saveQuestions();
                workSpace.add(textFieldQuestion);
                workSpace.add(textFieldAnswer);
                workSpace.add(comboBoxQuestion);
                workSpace.add(comboBoxAnswer);
                workSpace.add(saveButton);
                
             }); 
            } catch (Exception i) {
               JOptionPane.showMessageDialog(null, "At least one question needs to be added");
               workSpace.removeAll();
               createMenu();
            }
    });

        workSpace.add(addEditButton);
    }


    /**
     * Table action Performed method (used below in the ButtonColumn)
     * Add the Button Column to the table
     * Remove questions and answers from table 
     */
    private void deleteMenu() {
        String[] Arrayquestion = {"Question", "Answer"};
        JTable questionsTable = new JTable (Questions.showQuestions(),Arrayquestion); 
        // System.out.println(Questions.getCathegories());
        questionsTable.setRowHeight(32);

        questionsTable.addColumn(new TableColumn());
        Action tableButtonAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                Questions.removeQuestion((String)table.getValueAt(table.getSelectedRow(), 2));
                workSpace.removeAll();
                deleteMenu();
                workSpace.repaint();
                Questions.saveQuestions();
            }
        };
        new ButtonColumn(questionsTable, tableButtonAction, 2);
        questionsTable.getColumnModel().getColumn(2).setHeaderValue("Delete");
        JScrollPane questiScrollPane = new JScrollPane(questionsTable);
        questiScrollPane.setBounds(20, 20, 400, 400);
        workSpace.add(questiScrollPane);
    }
}
