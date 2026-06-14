import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        grades = new ArrayList<>();
    }


    public double getAverage() {
        if (grades.size() == 0) {
            return 0;
        }

        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.size() == 0) {
            return 0;
        }

        int highest = grades.get(0);

        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    public int getLowest() {
        if (grades.size() == 0) {
            return 0;
        }

        int lowest = grades.get(0);

        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }
    public void setName(String name) {
        this.name = name;
    }
        public void addGrade(int grade) {

        if (grade < 0 || grade > 100) {

            System.out.println(
                    "Invalid Grade!"
            );

            return;
        }

        grades.add(grade);
    }
    public int getTotalMarks() {

        int total = 0;

        for (int grade : grades) {
            total += grade;
        }

        return total;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nName: " + name +
                "\nGrades: " + grades +
                "\nTotal Marks: " + getTotalMarks() +
                "\nAverage: " + String.format("%.2f", getAverage()) +
                "\nHighest: " + getHighest() +
                "\nLowest: " + getLowest();
    }
}