package assignment5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

class q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = sc.nextLine();

        System.out.print("Enter event date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.print("Enter start time (HH:mm): ");
        LocalTime start = LocalTime.parse(sc.nextLine());

        System.out.print("Enter venue (leave blank if absent): ");
        String venueInput = sc.nextLine();

        Optional<String> venue = venueInput.isBlank()
                ? Optional.empty()
                : Optional.of(venueInput);

        LocalDate today = LocalDate.now();

        System.out.println("\n--- Event Details ---");
        System.out.println("Event: " + name);
        System.out.println("Date: " + date);
        System.out.println("Start time: " + start);
        System.out.println("End time: " + start.plusHours(2));

        venue.ifPresentOrElse(
                v -> System.out.println("Venue: " + v),
                () -> System.out.println("Venue not specified"));

        if (date.isAfter(today)) {
            System.out.println("Status: Future event");
        } else if (date.isEqual(today)) {
            System.out.println("Status: Event is today");
        } else {
            System.out.println("Status: Past event");
        }

        long days = ChronoUnit.DAYS.between(today, date);

        if (days > 0) {
            System.out.println("Days remaining: " + days);
        } else if (days == 0) {
            System.out.println("Event is today!");
        } else {
            System.out.println("Days since event: " + (-days));
        }

        sc.close();
    }
}
