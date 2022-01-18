import java.util.ArrayList;

public class Course {
    private String courseName;
    private int basePoints;
    private int totalPoints;
    private int studentPoints; 
    private ArrayList<Assignment> courseAssignments = new ArrayList<Assignment>();
    private ArrayList<Category> courseCategories = new ArrayList<Category>();

    public Course(String name, int points, int score) { //Takes the name of the course, the total # of points at the time of creation, and the percent the student has in the course
        courseName = name;
        basePoints = points;
        studentPoints = points/(int)((double)(score)/100);
    }
    
}