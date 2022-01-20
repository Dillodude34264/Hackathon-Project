public class Assignment {
    private String name; //Name of the assignment
    private int pointValue; //How many points the assignment is worth
    private boolean completed; //Wether or not it has been completed
    private int score; //What percent the student got on the assignment
    private Category category; //What Category it is in

    public Assignment(String n, int points) {
        name = n;
        pointValue = points;
        completed = false;
    }
    
    public Assignment(String n, int points, int s) {
        name = n;
        pointValue = points;
        score =s;
        completed = true;
    }

    public Assignment(int s) { //For Teacher Use Only
        score = s;
    }

    public int getScore(){
        return score;
    }


}
