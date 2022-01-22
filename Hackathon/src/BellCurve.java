import java.util.ArrayList;
public class BellCurve{
  private Grades origGrades;
  private int mean;
  private double stanDev;
  private Grades curvedGrades;
  private ArrayList<Assignment> curvAssns = new ArrayList<Assignment>();
  private int numGrades;
  private int newAveGrade;

  public BellCurve(Grades g, int nAG){
    origGrades = g;
    mean = origGrades.getMean();
    stanDev = origGrades.getStanDev();
    numGrades = origGrades.getSize();
    newAveGrade = nAG;
  }

  public void curveThem(){
      for(int i = 0; i < numGrades; i++){
          Assignment tempGrade = origGrades.getGrade(i);
          int diff = tempGrade.getScore() - mean;
          Assignment curvedAssn = new Assignment((int)((diff/(stanDev*0.1))+0.5) + newAveGrade);
          curvAssns.add(curvedAssn);
      }
      curvedGrades = new Grades(curvAssns);
  }

  public double getStanDev(){
    return stanDev;
  }

  public Grades getCurve(){
      return curvedGrades;
  }

}
