abstract class LibraryResource {

    private int resourceId;
    private String title;
    private String author;

    static String libraryName = "Central University Library";
    static int count = 0;

    LibraryResource(int id, String title, String author) {
        this.resourceId = id;
        this.title = title;
        this.author = author;
        count++;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract double calculateFine(int overdueDays);

    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + count);
    }
}

interface Printable {

    void printDetails();
}

class Book extends LibraryResource implements Printable {

    Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }

    @Override
    public void printDetails() {
        System.out.println("Resource Type : Book");
        System.out.println("Resource ID   : " + getResourceId());
        System.out.println("Title         : " + getTitle());
        System.out.println("Author        : " + getAuthor());
    }
}

class DigitalResource extends LibraryResource implements Printable {

    DigitalResource(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }

    @Override
    public void printDetails() {
        System.out.println("Resource Type : Digital Resource");
        System.out.println("Resource ID   : " + getResourceId());
        System.out.println("Title         : " + getTitle());
        System.out.println("Author        : " + getAuthor());
    }
}

class InputValidator {

    public static boolean validateResourceId(int id) {
        return id > 0;
    }

    public static boolean validateFineDays(int days) {
        return days >= 0;
    }
}

public class LibraryMain {

    public static void main(String[] args) {

        LibraryResource[] resources = {

                new Book(101, "Java Programming", "James Gosling"),

                new DigitalResource(102, "Database Systems",
                        "Raghu Ramakrishnan"),

                new Book(103, "Data Structures",
                        "Mark Allen"),

                new DigitalResource(104, "Computer Networks",
                        "Andrew Tanenbaum"),

                new Book(105, "Operating Systems",
                        "Abraham Silberschatz")
        };

        int[] overdueDays = { 5, 10, 3, 7, 2 };

        double totalFine = 0;

        System.out.println("======================================");
        System.out.println("     " + LibraryResource.libraryName);
        System.out.println("======================================");

        for (int i = 0; i < resources.length; i++) {

            if (InputValidator.validateResourceId(
                    resources[i].getResourceId())
                    &&
                    InputValidator.validateFineDays(
                            overdueDays[i])) {

                ((Printable) resources[i]).printDetails();

                double fine = resources[i].calculateFine(overdueDays[i]);

                System.out.println("Overdue Days  : " + overdueDays[i]);
                System.out.println("Fine          : Rs." + fine);

                System.out.println("--------------------------------------");

                totalFine = totalFine + fine;
            }
        }

        System.out.println("Total Fine: Rs." + totalFine);

        LibraryResource.displayTotalResources();
    }
}