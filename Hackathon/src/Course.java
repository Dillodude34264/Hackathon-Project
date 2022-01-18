import java.util.ArrayList;

public class Course {
    private String courseName; //Name of the course
    private int basePoints; //# of points at the time the Course was created
    private int totalPoints; //Total # of points calculated to include added Assignments
    private int studentPoints; //Total # of points the student has calculated to include added 
    private ArrayList<Assignment> courseAssignments = new ArrayList<Assignment>();
    private ArrayList<Category> courseCategories = new ArrayList<Category>();

    public Course(String name, int points, int score) { //Takes the name of the course, the total # of points at the time of creation, and the percent the student has in the course
        courseName = name;
        basePoints = points;
        studentPoints = (int)(points/((double)(score)/100));
    }

    public Course(String name) { //Constructor for when the student is making a new course that they have no points in yet
        courseName = name;
    }
    
}