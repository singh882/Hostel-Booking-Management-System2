public class Hostel {

    private Node head;
    private final WaitingQueue waitingQueue;
    private final BookingHistory bookingHistory;
    private final Complaint complaint;

    public Hostel() {

        head = null;
        waitingQueue = new WaitingQueue();
        bookingHistory = new BookingHistory();
        complaint = new Complaint();

    }

    public void createHostel() {

        int roomNumber = 101;

        for (int floor = 1; floor <= 3; floor++) {

            for (int i = 1; i <= 10; i++) {

                int capacity;

                if (i <= 3) {
                    capacity = 1;
                }
                else if (i <= 7) {
                    capacity = 2;
                }
                else {
                    capacity = 3;
                }

                Room room = new Room(roomNumber, floor, capacity);

                Node newNode = new Node(room);

                if (head == null) {

                    head = newNode;

                } else {

                    Node temp = head;

                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }

                    temp.setNext(newNode);
                    newNode.setPrevious(temp);

                }

                roomNumber++;

            }

            roomNumber = (floor + 1) * 100 + 1;

        }

        System.out.println("\n====================================");
        System.out.println(" Hostel Created Successfully");
        System.out.println(" Total Rooms : 30");
        System.out.println(" Floors      : 3");
        System.out.println("====================================");

    }

    public Node getHead() {
        return head;
    }

    public WaitingQueue getWaitingQueue() {
        return waitingQueue;
    }

    public BookingHistory getBookingHistory() {
        return bookingHistory;
    }

    public Complaint getComplaint() {
        return complaint;
    }


public void bookRoom(Student student) {

    Node temp = head;

    while (temp != null) {

        Room room = temp.getRoom();

        if (room.getAvailableBeds() > 0) {

            room.addStudent(student);

            String bookingId = "BK" + System.currentTimeMillis();

            System.out.println("\n====================================");
            System.out.println("      HOSTEL BOOKING RECEIPT");
            System.out.println("====================================");
            System.out.println("Booking ID : " + bookingId);
            System.out.println("Student ID : " + student.getStudentId());
            System.out.println("Name       : " + student.getName());
            System.out.println("Room No.   : " + room.getRoomNumber());
            System.out.println("Floor      : " + room.getFloorNumber());
            System.out.println("Status     : SUCCESS");
            System.out.println("====================================");

            bookingHistory.addHistory(
                    "Booked : " +
                    student.getStudentId() +
                    " -> Room " +
                    room.getRoomNumber());

            return;
        }

        temp = temp.getNext();
    }

    System.out.println("\nHostel Full!");
    System.out.println("Adding student to Waiting Queue...");

    waitingQueue.addStudent(student);

    bookingHistory.addHistory(
            "Waiting Queue : " + student.getStudentId());

}
 public void allocateWaitingStudent() {

        if (waitingQueue.isEmpty()) {
            return;
        }

        Student student = waitingQueue.getNextStudent();

        if (student != null) {
            bookRoom(student);
        }
    }

    public Room findRoom(int roomNumber) {

        Node temp = head;

        while (temp != null) {

            if (temp.getRoom().getRoomNumber() == roomNumber) {
                return temp.getRoom();
            }

            temp = temp.getNext();
        }

        return null;
    }
    public void cancelBooking(String studentId) {

    Node temp = head;

    while (temp != null) {

        Room room = temp.getRoom();

        if (room.removeStudent(studentId)) {

            System.out.println("\n====================================");
            System.out.println("Booking Cancelled Successfully");
            System.out.println("Student ID : " + studentId);
            System.out.println("Room No.   : " + room.getRoomNumber());
            System.out.println("====================================");

            bookingHistory.addHistory(
                    "Cancelled : " +
                    studentId +
                    " -> Room " +
                    room.getRoomNumber());

            allocateWaitingStudent();

            return;
        }

        temp = temp.getNext();
    }

    System.out.println("\nStudent not found.");
}
public void searchStudent(String studentId) {

    Node temp = head;

    while (temp != null) {

        Room room = temp.getRoom();

        for (Object studentObject : room.getStudents()) {

            Student student = (Student) studentObject;

            if (student.getStudentId().equals(studentId)) {

                System.out.println("\n========== STUDENT FOUND ==========");
                System.out.println(student);
                System.out.println("Room Number : " + room.getRoomNumber());
                System.out.println("Floor       : " + room.getFloorNumber());
                System.out.println("===================================");

                return;
            }
        }

        temp = temp.getNext();
    }

    System.out.println("\nStudent not found.");
}
public void displayHostel() {

    if (head == null) {

        System.out.println("Hostel not created.");
        return;

    }

    Node temp = head;

    while (temp != null) {

        temp.getRoom().displayRoom();

        temp = temp.getNext();
    }
}
public void displayStatistics() {

    int totalRooms = 0;
    int totalStudents = 0;
    int totalAvailableBeds = 0;

    Node temp = head;

    while (temp != null) {

        Room room = temp.getRoom();

        totalRooms++;

        totalStudents += room.getStudents().size();

        totalAvailableBeds += room.getAvailableBeds();

        temp = temp.getNext();
    }

    System.out.println("\n========== HOSTEL STATISTICS ==========");
    System.out.println("Total Rooms      : " + totalRooms);
    System.out.println("Students Staying : " + totalStudents);
    System.out.println("Available Beds   : " + totalAvailableBeds);
    System.out.println("Waiting Students : " + waitingQueue.size());
    System.out.println("=======================================");
}

public void addComplaint(String complaintText) {

    complaint.addComplaint(complaintText);

}

public void displayComplaints() {

    complaint.displayComplaints();

}
public void showBookingHistory() {

    bookingHistory.showHistory();

}
}