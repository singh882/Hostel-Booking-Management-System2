import java.util.LinkedList;
import java.util.Queue;

public class WaitingQueue {

    private final Queue<Student> queue;

    public WaitingQueue() {
        queue = new LinkedList<>();
    }

    public void addStudent(Student student) {

        queue.offer(student);

        System.out.println("\nStudent added to Waiting List successfully.");
    }

    public Student getNextStudent() {

        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void displayWaitingList() {

        if (queue.isEmpty()) {

            System.out.println("\nWaiting List is Empty.");
            return;

        }

        System.out.println("\n========== WAITING LIST ==========");

        for (Student student : queue) {

            System.out.println(student.getStudentId()
                    + " - "
                    + student.getName());

        }

        System.out.println("==================================");
    }
}