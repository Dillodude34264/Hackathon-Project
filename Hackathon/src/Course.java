import java.util.ArrayList;

public class Course {
    public String courseName; //Name of the course
    public int basePoints; //# of points at the time the Course was created
    public int totalPoints; //Total # of points calculated to include added Assignments
    public int studentPoints; //Total # of points the student has calculated to include added
    public ArrayList<Assignment> courseAssignments = new ArrayList<Assignment>();
    public ArrayList<Category> courseCategories = new ArrayList<Category>();

    public Course(String name, int points, int score) { //Takes the name of the course, the total # of points at the time of creation, and the percent the student has in the course
        courseName = name;
        basePoints = points;
        studentPoints = (int)(points*((double)(score)/100));
    }

    public Course(String name) { //Constructor for when the student is making a new course that they have no points in yet
        courseName = name;
        basePoints = 0;
        studentPoints = 0;
    }

    public void addAssingment(String n, int points, int s) {
        if (s == 0) {
            courseAssignments.add(new Assignment(n, points));
        } else {
            courseAssignments.add(new Assignment(n, points, s));
        }
    }

    public String getScoreString() {
        if (basePoints + totalPoints != 0) {
            return "" + (studentPoints/(basePoints + totalPoints)*100);
        } else {
            return "N/A";
        }
    }
}
