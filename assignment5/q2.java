package assignment5;

import java.util.Optional;

class q2 {
    public static void main(String[] args) {

        Optional<String> email = Optional.of("student@gmail.com");

        Optional<String> emptyEmail = Optional.empty();

        System.out.print("Email: ");
        email.ifPresent(System.out::println);

        String defaultEmail = emptyEmail.orElse("default@gmail.com");

        System.out.println("Default email: " + defaultEmail);

        try {
            String value = emptyEmail.orElseThrow(
                    () -> new RuntimeException("Email is missing"));
            System.out.println(value);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
