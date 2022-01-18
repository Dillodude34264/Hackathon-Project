import java.util.ArrayList;
import java.io.Scanner;

////// Garrett can you make mock-ups or a plan for a potential UI - Michael ////////////

public class App {
    Scanner getInput = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        String input = "";
        // Continues to ask user what they want to do until the choose student or teacher mode
        while(input.equals("")){
            // Gets input from user
            System.out.println("Choose student or teacher mode(s/t): ");
            input = getInput.nextLine();
            if(input == "s"){
                studentMode();
            }else if(input == "t"){
                teacherMode();
            }else{
                // Invalid statement
                System.out.println("Invalid input. Please try again.");
                input = "";

            }
        }

    }
    public static void studentMode(){

    }
    public static void teacherMode(){
        System.out.println("Enter the grade percentages of students on the test as integer numbers; enter -1 to end");
        int grade = 0;
        while()
    }
}
