import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentPortal {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Add student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, email, course);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Display students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search student using Streams
    public static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();

        List<Student> result = students.stream()
                .filter(student -> student.getId() == id)
                .toList();

        if (result.isEmpty()) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            result.forEach(Student::displayStudent);
        }
    }

    // Edit student
    public static void editStudent() {

        System.out.print("Enter Student ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        System.out.print("Enter new course: ");
        String course = scanner.nextLine();

        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        System.out.println("Student updated successfully!");
    }

    // Delete student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        boolean deleted = students.removeIf(
                student -> student.getId() == id
        );

        if (deleted) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Main method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   INTERACTIVE STUDENT PORTAL");
            System.out.println("==============================");

            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
