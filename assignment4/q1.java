package assignment4;

import java.util.*;

class Course {
    String code;
    int capacity;
    HashSet<String> enrolled = new HashSet<>();
    ArrayList<String> prerequisites = new ArrayList<>();
    LinkedList<String> waitlist = new LinkedList<>();

    Course(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
    }
}

public class q1 {
    HashMap<String, Course> courses = new HashMap<>();

    void addCourse(String code, int capacity, String... prereqs) {
        Course c = new Course(code, capacity);
        c.prerequisites.addAll(Arrays.asList(prereqs));
        courses.put(code, c);
    }

    void register(String code, String student) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found!");
            return;
        }

        for (String p : c.prerequisites) {
            Course pre = courses.get(p);
            if (pre == null || !pre.enrolled.contains(student)) {
                System.out.println("Prerequisite not completed!");
                return;
            }
        }

        if (c.enrolled.contains(student) || c.waitlist.contains(student)) {
            System.out.println("Already registered or waitlisted!");
        } else if (c.enrolled.size() < c.capacity) {
            c.enrolled.add(student);
            System.out.println(student + " enrolled in " + code);
        } else {
            c.waitlist.addLast(student);
            System.out.println(student + " added to waitlist");
        }
    }

    void drop(String code, String student) {
        Course c = courses.get(code);

        if (c == null) {
            System.out.println("Course not found!");
            return;
        }

        if (c.enrolled.remove(student)) {
            System.out.println(student + " dropped " + code);

            if (!c.waitlist.isEmpty()) {
                String next = c.waitlist.removeFirst();
                c.enrolled.add(next);
                System.out.println(next + " promoted from waitlist");
            }
        } else if (c.waitlist.remove(student)) {
            System.out.println(student + " removed from waitlist");
        } else {
            System.out.println("Student not registered!");
        }
    }

    void display(String code) {
        Course c = courses.get(code);

        if (c != null) {
            System.out.println("Course: " + c.code);
            System.out.println("Enrolled: " + c.enrolled);
            System.out.println("Waitlist: " + c.waitlist);
            System.out.println("Prerequisites: " + c.prerequisites);
        }
    }

    public static void main(String[] args) {
        q1 portal = new q1();

        portal.addCourse("C101", 2);
        portal.addCourse("C102", 2, "C101");

        portal.register("C101", "S1");
        portal.register("C101", "S2");
        portal.register("C101", "S3");

        portal.register("C102", "S1");
        portal.drop("C101", "S1");

        portal.display("C101");
    }
}
