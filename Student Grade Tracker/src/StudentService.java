import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {

        if (findStudentById(student.getId()) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    public Student findStudentById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void addGradeToStudent(int id, int grade) {

        Student student = findStudentById(id);

        if (student != null) {
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudent(int id) {

        Student student = findStudentById(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            System.out.println("---------------------");
            System.out.println(student);
        }
    }

    public void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        double totalAverage = 0;

        Student topStudent = students.get(0);
        Student lowStudent = students.get(0);

        for (Student student : students) {

            totalAverage += student.getAverage();

            if (student.getAverage() > topStudent.getAverage()) {
                topStudent = student;
            }

            if (student.getAverage() < lowStudent.getAverage()) {
                lowStudent = student;
            }
        }

        System.out.println("\n========== CLASS REPORT ==========");
        System.out.println("Total Students : " + students.size());

        System.out.printf("Class Average : %.2f%n",
                totalAverage / students.size());

        System.out.println("\nHighest Scorer : "
                + topStudent.getName());

        System.out.printf("Average Marks : %.2f%n",
                topStudent.getAverage());

        System.out.println("\nLowest Scorer : "
                + lowStudent.getName());

        System.out.printf("Average Marks : %.2f%n",
                lowStudent.getAverage());

        System.out.println("==================================");
    }
    public void showRankings() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        ArrayList<Student> ranking =
                new ArrayList<>(students);

        ranking.sort((s1, s2) ->
                Double.compare(
                        s2.getAverage(),
                        s1.getAverage()));

        System.out.println("\n===== STUDENT RANKINGS =====");

        int rank = 1;

        for (Student student : ranking) {

            System.out.printf(
                    "%d. %s - %.2f%n",
                    rank++,
                    student.getName(),
                    student.getAverage()
            );
        }
    }
    public void searchStudentByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName()
                    .equalsIgnoreCase(name)) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
    public void updateStudentName(int id,
                                  String newName) {

        Student student =
                findStudentById(id);

        if (student != null) {

            student.setName(newName);

            System.out.println(
                    "Name updated successfully."
            );

        } else {
            System.out.println(
                    "Student not found."
            );
        }
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}