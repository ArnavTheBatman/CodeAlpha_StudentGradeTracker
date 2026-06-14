import java.util.Scanner;

public class Menu {

    private StudentService studentService;
    private FileService fileService;
    private Scanner scanner;

    public Menu() {
        studentService = new StudentService();
        fileService = new FileService();
        scanner = new Scanner(System.in);

        studentService.setStudents(fileService.loadStudents());
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n==============================");
            System.out.println("    STUDENT GRADE TRACKER");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Student");
            System.out.println("4. View All Students");
            System.out.println("5. Generate Report");
            System.out.println("6. Delete Student");
            System.out.println("7. Save Data");
            System.out.println("8. Show Rankings");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    addGrade();
                    break;

                case 3:
                    viewStudent();
                    break;

                case 4:
                    studentService.displayAllStudents();
                    break;

                case 5:
                    studentService.generateReport();
                    break;

                case 6:
                    deleteStudent();
                    break;

                case 7:
                    fileService.saveStudents(studentService.getStudents());
                    System.out.println("Data saved successfully.");
                    break;

                case 8:
                    studentService.showRankings();
                    break;

                case 9:
                    fileService.saveStudents(studentService.getStudents());
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }

    private void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);

        studentService.addStudent(student);
    }

    private void addGrade() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Grade: ");
        int grade = scanner.nextInt();

        if (grade < 0 || grade > 100) {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }

        studentService.addGradeToStudent(id, grade);
    }

    private void viewStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        studentService.displayStudent(id);
    }

    private void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        studentService.deleteStudent(id);
    }
}