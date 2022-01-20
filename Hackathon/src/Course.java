import java.util.ArrayList;

public class Course {
    public String courseName; //Name of the course
    public int basePoints; //# of points at the time the Course was created
    public int totalPoints; //Total # of points calculated to include added Assignments
    public int baseStudentPoints;
    public int studentPoints; //Total # of points the student has calculated to include added
    public ArrayList<Assignment> courseAssignments = new ArrayList<Assignment>();
    public ArrayList<Category> courseCategories = new ArrayList<Category>();

    public Course(String name, int points, int score) { //Takes the name of the course, the total # of points at the time of creation, and the percent the student has in the course
        courseName = name;
        basePoints = points;
        baseStudentPoints = (int)(points*((double)(score)/100.0));
    }

    public Course(String name) { //Constructor for when the student is making a new course that they have no points in yet
        courseName = name;
        basePoints = 0;
        baseStudentPoints = 0;
    }

    public void addAssingment(String n, int points, int s) {
        if (s == 0) {
            courseAssignments.add(new Assignment(n, points));
        } else {
            courseAssignments.add(new Assignment(n, points, s));
        }
    }

    public void updatePoints() { //Updates the point count for the course counting the base points and adding points from completed assignments
        int tempAssignmentPoints = 0;
        int tempGainedPoints = 0;
        for (Assignment a : courseAssignments) {
            if (a.getCompleted()) {
                tempAssignmentPoints += a.getPoints();
                tempGainedPoints += (int)(a.getPoints()*((double)(a.getScore())/100));
            }
        }

        totalPoints = basePoints + tempAssignmentPoints;
        studentPoints = baseStudentPoints + tempGainedPoints;
    }

    public String getScoreString() {
        updatePoints();
        if (totalPoints != 0) {
            return "" + (int)(((double)(studentPoints)/totalPoints)*100);
        } else {
            return "N/A";
        }
    }

    public ArrayList<Assignment> getAssignments() {
        return courseAssignments;
    } 

    public void testAssignment(String n, int points) {
        updatePoints();
        Assignment test = new Assignment(n, points);
        System.out.println("If you get an A on " + test.getName() + " then your overall grade in " + courseName + " will be " + (int)((test.getPoints()*.95+studentPoints)/(totalPoints+test.getPoints())*100) + "%");
        System.out.println("If you get a  B on " + test.getName() + " then your overall grade in " + courseName + " will be " + (int)((test.getPoints()*.85+studentPoints)/(totalPoints+test.getPoints())*100) + "%");
        System.out.println("If you get a  C on " + test.getName() + " then your overall grade in " + courseName + " will be " + (int)((test.getPoints()*.75+studentPoints)/(totalPoints+test.getPoints())*100) + "%");
        System.out.println("If you get a  D on " + test.getName() + " then your overall grade in " + courseName + " will be " + (int)((test.getPoints()*.65+studentPoints)/(totalPoints+test.getPoints())*100) + "%");
        System.out.println("If you get an F on " + test.getName() + " then your overall grade in " + courseName + " will be " + (int)((test.getPoints()*.50+studentPoints)/(totalPoints+test.getPoints())*100) + "%");
    }
}
