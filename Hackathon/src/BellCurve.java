public class BellCurve{
  private Grades allGrades;
  private int mean;
  private double stanDev;

  public BellCurve(Grades g){
    allGrades = g;
    mean = allGrades.getMean();
    stanDev = allGrades.getStanDev();
  }


  public double getStanDev(){
    return stanDev;
  }

}
