package ui;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import data.Question;
import data.Questions;
import java.awt.Dimension;
import java.util.List;
import java.awt.CardLayout;

public class UserInterface {

    // Load Question
    static List<Question> questions = Questions.loadQuestion();
    // Init JFrame
    public static JFrame frame = new JFrame();
    // USERS LOGIN MENU & declaration
    static JPanel mainPanel = new JPanel();
    static MainMenu mainMenu = new MainMenu(mainPanel);
    // The principal panel that will altern between the others
    public static JPanel framePanel = new JPanel();
    public static CardLayout cardLayout = new CardLayout();


    /**
     * Init the User Interface with the gived Name & Dimension
     * @param windowName
     * @param width
     * @param height
     */
    public static void setUserInterface(String windowName, int width, int height) {
        frame.setTitle(windowName);
        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // New design for JFrame
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);// vanishing the default title bar
        frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set Icon
        frame.setIconImage(new ImageIcon("src/img/quiz_dude.jpg").getImage());
        // Set framePanel as the Original Card
        framePanel.setLayout(cardLayout);
        framePanel.setPreferredSize(new Dimension(width, height));
        // Add new Panels to the Original Card
        framePanel.add(mainPanel, "MainMenu");
        // Set the initial panel that appears
        cardLayout.show(framePanel, "MainMenu");
        // Add the Original Panel (that will altern) into the frame
        frame.add(framePanel);
    }


    public static void newTrivia() {
        // Just implement this
    }

    public static void main(String[] args) {
        setUserInterface("Trivia Game", 720, 480);
        frame.setVisible(true);
    }
}
