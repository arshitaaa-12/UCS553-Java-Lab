import java.util.Scanner;

class InvalidMarksException extends Exception {
    InvalidMarksException(String message) {
        super(message);
    }
}

public class ques4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter marks of Subject 1: ");
            int m1 = sc.nextInt();

            System.out.print("Enter marks of Subject 2: ");
            int m2 = sc.nextInt();

            System.out.print("Enter marks of Subject 3: ");
            int m3 = sc.nextInt();

            if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {

                throw new InvalidMarksException("Marks must be between 0 and 100");
            }

            int total = m1 + m2 + m3;
            double percentage = total / 3.0;

            System.out.println("Total = " + total);
            System.out.println("Percentage = " + percentage);

            if (percentage >= 90)
                System.out.println("Grade = A");
            else if (percentage >= 80)
                System.out.println("Grade = B");
            else if (percentage >= 60)
                System.out.println("Grade = C");
            else
                System.out.println("Grade = F");
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}