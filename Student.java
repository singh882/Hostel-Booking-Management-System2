public class Student {

    private final String studentId;
    private final String name;
    private final int age;
    private final String gender;
    private final String course;
    private final int year;

    public Student(String studentId, String name, int age, String gender, String course, int year) {

        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {

        return "Student ID : " + studentId +
                "\nName       : " + name +
                "\nAge        : " + age +
                "\nGender     : " + gender +
                "\nCourse     : " + course +
                "\nYear       : " + year;
    }
}