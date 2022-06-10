package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

  
public class AuxiliarMethods {
    

    /**
     * Create a JTextField with the given text
     * @param text String
     * @param posX int 
     * @param posY int
     * @return JLabel
     */
    public static JLabel createLabel(String text, int posX, int posY) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(120, 40));
        label.setBounds(posX, posY, 320, 120 );
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        return label;
    }

    /**
     * 
     * Create a JTextField with text parameter as the default text inside
     * @param text String
     * @return JTextFiel
     */
    public static JTextField createTextField(String text) {
        JTextField textField = new JTextField();
        textField.setText(text);
        textField.setPreferredSize(new Dimension(240, 32));
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setFont(new Font("Consolas", Font.ITALIC, 16));
        textField.setHorizontalAlignment(0);
        textField.setAlignmentY(100);
        return textField;
    }

    /**
     * Rezise an Image to the given size
     * @param path String
     * @param width int 
     * @param height int 
     * @return ImagenIcon
     */
    public static ImageIcon resizedImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }

    /**
     * Create a JLabel with an image(with given width & height)
     * @param text String
     * @param path String 
     * @param imageWidth int 
     * @param imageHeight int
     * @return JLabel
     */
    public static JLabel createImageLabel(String text, String path, int imageWidth, int imageHeight) {
        JLabel imageLabel = createLabel(text, imageHeight, imageHeight);
        ImageIcon image = resizedImage(path, imageWidth, imageHeight);
        imageLabel.setHorizontalTextPosition(JLabel.CENTER);
        imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
        imageLabel.setIcon(image);
        return imageLabel;
    }

    /**
     * Creates a button with image 
     * @param text String
     * @param path String
     * @param imageWidth int 
     * @param imageHeight int 
     * @param font String 
     * @param sizefont int 
     * @return JButton
     */
    public static JButton createImageButton(String text, String path, int imageWidth, int imageHeight, String font, int sizefont) {
        JButton button = new JButton();
        button.add(createImageLabel(text,path, imageWidth, imageHeight));
        button.setFont(new Font(font, Font.PLAIN,sizefont));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.white);
        button.setLayout(new GridLayout(1,1));
        button.setBorder(null);
        return button;
    }

    /**
     * Creates a complete Ask Field. Can be Horizontal or Vertical
     * <p>
     * Just if is necessary to get the written data
     * @param panel JPanel
     * @param askedValue String
     * @param posX int 
     * @param posY int 
     * @param isVertical boolean
     * @return JTextField
     */
    public static JTextField createAskField(JPanel panel, String askedValue, int posX, int posY, boolean isVertical) {
        JLabel label = createLabel(askedValue, posY, posY);
        JTextField textField = createTextField("");
        if (isVertical) {
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setBounds(posX, posY, 100, 20);
            textField.setBounds(posX - 70, posY + 20, 240, 32);
        } else {
            label.setHorizontalAlignment(JLabel.RIGHT);
            label.setBounds(posX - 80, posY + 4, 100, 20);
            textField.setBounds(posX + 40, posY, 240, 32);
        }
        panel.add(label);
        panel.add(textField);
        return textField; 
    }

    /**
     * Create a complete combo Box,  
     * @param frame JPanel
     * @param askedValue String 
     * @param posX int 
     * @param posY int 
     * @param isVertical boolean 
     * @param arrayList ArrayList<String>
     * @return JComboBox<String>
     */
    public static JComboBox<String> createComboBox(JPanel frame,String askedValue ,int posX, int posY, boolean isVertical, ArrayList <String> arrayList) {
        JComboBox<String> comboBox = new JComboBox<String>();
        JLabel label = new JLabel(askedValue);
        String[] values = new String[arrayList.size()];
        for (int i = 0; i < values.length; i++) values[i] = arrayList.get(i);
        for (int i = 0; i < values.length; i++) comboBox.addItem(values[i]);
        comboBox.setBounds(posX, posY, 128, 32);
        comboBox.setBackground(Color.DARK_GRAY);
        comboBox.setForeground(Color.WHITE);
        comboBox.addActionListener(e -> comboBox.getSelectedItem());
        if(isVertical){
            label.setHorizontalAlignment(JLabel.CENTER); 
            label.setBounds(posX, posY, 200, 100);
            comboBox.setBounds(posX - 70, posY + 20, 240, 32);
        }else{
            label.setHorizontalAlignment(JLabel.RIGHT);
            label.setBounds(posX - 80, posY + 4, 100, 20);
            comboBox.setBounds(posX + 40, posY, 240, 32);
        }
        frame.add(label);
        frame.add(comboBox);
        
        return comboBox;
    }
}