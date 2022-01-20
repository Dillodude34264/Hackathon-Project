import java.util.ArrayList;
// For teacher mode, gets grades of all the students in the class
public class Grades {
    private ArrayList<Assignment> gradePercs = new ArrayList<Assignment>();
    private int mean;
    private double stanDev;
    private int numGrades;

    // Constructor to get ArrayList of grades
    public Grades(ArrayList<Assignment> gP){
        gradePercs = gP;
        numGrades = gradePercs.size();
        findMean();
        findStanDev();
    }

    // Finds mean of grades from the inputted grades
    public void findMean(){
        int sum = 0;
        // Loops through grades, adds to sum
        for(int i = 0; i < numGrades; i++){
            int grade = gradePercs.get(i).getScore();
            sum += grade;
        }
        mean = (int)((sum/numGrades)+0.5);  // Divides sum by number of grades
    }

    public void findStanDev(){
      double sumDiffs = 0;
      for(int i = 0; i < numGrades; i++){
        Assignment grade = gradePercs.get(i);
        sumDiffs += Math.pow(grade.getScore() - mean,2);
      }
      stanDev = Math.sqrt(sumDiffs/numGrades);
    }

    public int getMean(){
      return mean;
    }

    public double getStanDev(){
      return stanDev;
    }

    public int getSize(){
        return numGrades;
    }

    public Assignment getGrade(int i){
        return gradePercs.get(i);
    }

}
