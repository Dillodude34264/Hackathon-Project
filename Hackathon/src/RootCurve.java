import java.util.ArrayList;
public class RootCurve{
  private Grades normGrades;
  private Grades newGrades;
  private int numGrades;
  private int newMean;
  private int currMean;
  private double root;
  private ArrayList<Assignment> newGradesList = new ArrayList<Assignment>();

  public RootCurve(Grades nG, int nM){
    normGrades = nG;
    numGrades = normGrades.getSize();
    newMean = nM;
    currMean = normGrades.getMean();
  }

  public void curveThem(){
    root = Math.log(newMean/100.0)/Math.log(currMean/100.0);
    for(int i = 0; i < numGrades; i++){
      double origScore = normGrades.getGrade(i).getScore()/100.0;
      int newScore = (int)(Math.pow(origScore,root)*100);
      newGradesList.add(new Assignment(newScore));
    }
    newGrades = new Grades(newGradesList);
  }

  public Grades getCurve(){
    return newGrades;
  }




}
