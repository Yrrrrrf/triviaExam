package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTest implements Serializable {
    public static void main(String[] args) {
        // SERIALIZARION
        // Instance a new Object (a neddle class in this case)
        SerializationTest.User user = (new SerializationTest()).new User("Fer", "I<3Pizza");
        // SerializationTest.User user = new User("Fer", "I<3Pizza");
        try {
            FileOutputStream fileOut = new FileOutputStream("NewUserTest.ser"); // file path
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut); // file Out
            objectOut.writeObject(user); // Write object's data in the file
            objectOut.close();
            fileOut.close();
            System.out.println("Successfully Object Saved");
        } catch (IOException e) {System.out.println(e);}        


        // DESERIALIZARION
        SerializationTest.User user2 = null;
        try {
            FileInputStream fileInput = new FileInputStream("D:\\Programming\\Java\\JavaBasics\\NewUserTest.ser"); // file path
            ObjectInputStream objectInput = new ObjectInputStream(fileInput); // data File
            user2 = (SerializationTest.User) objectInput.readObject(); // Instantiate the Object, casting the objetcInput
            fileInput.close();
            objectInput.close();
            System.out.println("Object Rebuilted Successfully");
        } catch (IOException e) {System.out.println(e);
        } catch (ClassNotFoundException e) {System.out.println(e);}

        // TESTING PART:
        // user2.name = "NewName";
        // user2.password = "NewPassword";
        System.out.println(user.toString()); 
        System.out.println(user2.toString()); 
    }


    //? NESTED CLASS
    public class User implements Serializable {
        String name, password;
        
        User (String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "\nName:     " + this.name + "\nPassword: " + this.password;
        }
    }
}