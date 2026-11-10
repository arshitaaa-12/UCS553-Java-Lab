package assignment6;
import java.io.*;

class Q2 {
    public static void main(String[] args) {

        int total = 0;
        int errors = 0;
        int warnings = 0;

        try (
            BufferedReader br = new BufferedReader(
                new FileReader("log.txt"));
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("filtered.txt"))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                total++;

                if (line.contains("ERROR")) {
                    errors++;
                    bw.write(line);
                    bw.newLine();
                }
                else if (line.contains("WARNING")) {
                    warnings++;
                    bw.write(line);
                    bw.newLine();
                }
            }

            System.out.println("Total log entries: " + total);
            System.out.println("ERROR entries: " + errors);
            System.out.println("WARNING entries: " + warnings);

            System.out.println("Filtered logs saved successfully.");
        }
        catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
