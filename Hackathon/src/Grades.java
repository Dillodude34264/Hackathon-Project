import java.util.ArrayList<>();
// For teacher mode, gets grades of all the students in the class
public class Grades(){
    private ArrayList<Assignment> gradePercs = new ArrayList<Assignment>();
    private int mean;
    private double stanDev;

    public void Grades(ArrayList<Assignment> gP){
        gradePercs = gP;
    }

    public static void findMean(ArrayList<Assignment> gradePercs){
        int sum = 0;
        int numGrades = gradePercs.size();
        for(int i = 0; i < numGrades; i++){
            int grade = gradePercs.get(i).getScore();
            sum += grade;
        }
        mean = (int)((sum/numGrades)+0.5);
    }

}
