import java.util.ArrayList<>();
// For teacher mode, gets grades of all the students in the class
public class Grades(){
    private ArrayList<Assignment> gradePercs = new ArrayList<Assignment>();
    private int mean;
    private double stanDev;

    // Constructor to get ArrayList of grades
    public void Grades(ArrayList<Assignment> gP){
        gradePercs = gP;
    }

    // Finds mean of grades from the inputted grades
    public static void findMean(ArrayList<Assignment> gradePercs){
        int sum = 0;
        int numGrades = gradePercs.size();
        // Loops through grades, adds to sum
        for(int i = 0; i < numGrades; i++){
            int grade = gradePercs.get(i).getScore();
            sum += grade;
        }
        mean = (int)((sum/numGrades)+0.5);  // Divides sum by number of grades
    }

}
