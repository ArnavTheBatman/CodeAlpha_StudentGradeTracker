import java.io.*;
import java.util.ArrayList;

public class FileService {

    private final String FILE_NAME = "data/students.txt";

    // Save students to file
    public void saveStudents(ArrayList<Student> students) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(FILE_NAME));

            for (Student student : students) {

                StringBuilder grades = new StringBuilder();

                for (int grade : student.getGrades()) {
                    grades.append(grade).append("|");
                }

                if (grades.length() > 0) {
                    grades.deleteCharAt(grades.length() - 1);
                }

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                grades
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file.");
            e.printStackTrace();
        }
    }

    // Load students from file
    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                Student student = new Student(id, name);

                if (parts.length > 2 && !parts[2].isEmpty()) {

                    String[] grades = parts[2].split("\\|");

                    for (String grade : grades) {
                        student.addGrade(
                                Integer.parseInt(grade)
                        );
                    }
                }

                students.add(student);
            }

            reader.close();

            System.out.println("Data loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading file.");
            e.printStackTrace();
        }

        return students;
    }
}