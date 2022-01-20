public class Assignment {
    private String name; //Name of the assignment
    private int pointValue; //How many points the assignment is worth
    private boolean completed; //Wether or not it has been completed
    private int score; //What percent the student got on the assignment
    private Category category; //What Category it is in

    public Assignment(int s){
        score = s;
    }

    public int getScore(){
        return score;
    }


}
