import java.util.ArrayList;

public class Room {

    private final int roomNumber;
    private final int floorNumber;
    private final int totalCapacity;
    private int availableBeds;
    private final ArrayList<Student> students;

    public Room(int roomNumber, int floorNumber, int totalCapacity) {

        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.totalCapacity = totalCapacity;
        this.availableBeds = totalCapacity;
        this.students = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean isAvailable(int people) {
        return availableBeds >= people;
    }

    public boolean addStudent(Student student) {

        if (availableBeds == 0) {
            return false;
        }

        students.add(student);
        availableBeds--;

        return true;
    }

    public boolean removeStudent(String studentId) {

        for (Student student : students) {

            if (student.getStudentId().equals(studentId)) {

                students.remove(student);
                availableBeds++;

                return true;
            }
        }

        return false;
    }

    public void displayRoom() {

        System.out.println("------------------------------------");
        System.out.println("Room Number    : " + roomNumber);
        System.out.println("Floor Number   : " + floorNumber);
        System.out.println("Total Capacity : " + totalCapacity);
        System.out.println("Available Beds : " + availableBeds);

        if (students.isEmpty()) {

            System.out.println("Students : None");

        } else {

            System.out.println("Students:");

            for (Student student : students) {

                System.out.println(student.getStudentId()
                        + " - "
                        + student.getName());

            }

        }

        System.out.println("------------------------------------");
    }
}