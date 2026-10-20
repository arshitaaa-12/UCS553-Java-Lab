package assignment5;

import java.util.Optional;
import java.util.Objects;

class Result<T extends Number> {

    private T marks;
    private double threshold;

    public Result(T marks, double threshold) {
        this.marks = Objects.requireNonNull(
                marks, "Marks cannot be null");
        this.threshold = threshold;
    }

    public double getPercentage() {
        return marks.doubleValue();
    }

    public boolean hasPassed() {
        return getPercentage() >= threshold;
    }

    public Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

class q3 {
    public static void main(String[] args) {

        Result<Integer> student = new Result<>(85, 40);

        student.getMarks().ifPresent(m -> System.out.println("Marks: " + m));

        System.out.println(
                "Percentage: " + student.getPercentage() + "%");

        System.out.println(
                "Result: " + (student.hasPassed() ? "Pass" : "Fail"));
    }
}
