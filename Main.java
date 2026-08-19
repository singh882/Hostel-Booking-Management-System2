import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hostel hostel = new Hostel();
        hostel.createHostel();

        while (true) {

            System.out.println("\n========== HOSTEL BOOKING MANAGEMENT SYSTEM ==========");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Search Student");
            System.out.println("4. Display Hostel");
            System.out.println("5. Display Statistics");
            System.out.println("6. Show Booking History");
            System.out.println("7. Add Complaint");
            System.out.println("8. Display Complaints");
            System.out.println("9. Display Waiting List");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1 -> {

                    System.out.print("Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    System.out.print("Year(1-4): ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(id, name, age, gender, course, year);

                    hostel.bookRoom(student);

                }

                case 2 -> {

                    System.out.print("Enter Student ID: ");
                    hostel.cancelBooking(sc.nextLine());

                }

                case 3 -> {

                    System.out.print("Enter Student ID: ");
                    hostel.searchStudent(sc.nextLine());

                }

                case 4 -> {

                    hostel.displayHostel();

                }

                case 5 -> {

                    hostel.displayStatistics();

                }

                case 6 -> {

                    hostel.showBookingHistory();

                }

                case 7 -> {

                    System.out.print("Enter Complaint: ");
                    hostel.addComplaint(sc.nextLine());

                }

                case 8 -> {

                    hostel.displayComplaints();

                }

                case 9 -> {

                    hostel.getWaitingQueue().displayWaitingList();

                }

                case 10 -> {

                    System.out.println("\nThank You!");
                    sc.close();
                    return;
                }

                default -> {

                    System.out.println("Invalid Choice.");
                }
            }
        }
    }
}
