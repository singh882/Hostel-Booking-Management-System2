
import java.util.Stack;

public class BookingHistory {

    private final Stack<String> history;

    public BookingHistory() {

        history = new Stack<>();

    }

    public void addHistory(String message) {

        history.push(message);

    }

    public void showHistory() {

        if (history.isEmpty()) {

            System.out.println("\nNo Booking History Found.");

            return;

        }

        System.out.println("\n======= BOOKING HISTORY =======");

        while (!history.isEmpty()) {

            System.out.println(history.pop());

        }

        System.out.println("===============================");

    }

}