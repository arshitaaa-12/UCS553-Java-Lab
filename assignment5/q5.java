package assignment5;

import java.util.Objects;
import java.util.Optional;

class Utility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(
            Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

class q5 {
    public static void main(String[] args) {

        System.out.println(
                "Strings equal: " +
                        Utility.isEqual("Java", "Java"));

        System.out.println(
                "Integers equal: " +
                        Utility.isEqual(10, 20));

        System.out.println(
                "Default value: " +
                        Utility.getDefault(Optional.empty(), "Hello"));

        System.out.println(
                "Maximum integer: " +
                        Utility.max(25, 40));

        System.out.println(
                "Maximum string: " +
                        Utility.max("Apple", "Banana"));

        System.out.println(
                "Is null: " + Utility.isNull(null));

        System.out.println(
                "Is null: " + Utility.isNull("Java"));
    }
}
