
package assignment6;

import java.io.*;

class Q1 {
    public static void main(String[] args) {

        // Writing student details
        try (FileWriter fw = new FileWriter("students.txt")) {
            fw.write("Student ID: 101\n");
            fw.write("Name: Arshita\n");
            fw.write("Course: Computer Engineering\n");
            fw.write("Marks: 85\n");

            System.out.println("Student details written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Reading student details
        try (FileReader fr = new FileReader("students.txt")) {
            int ch;

            System.out.println("\nStudent Details:");

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Copying binary file
        try (
                FileInputStream fis = new FileInputStream("input.jpg");
                FileOutputStream fos = new FileOutputStream("copy.jpg")) {
            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("\nBinary file copied successfully.");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
