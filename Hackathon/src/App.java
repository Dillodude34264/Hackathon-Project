import java.util.ArrayList;
import java.util.Scanner;

////// Garrett can you make mock-ups or a plan for a potential UI - Michael ////////////

public class App {
    public static void main(String[] args) throws Exception {
        Scanner getInput = new Scanner(System.in);

        String input = "";
        // Continues to ask user what they want to do until the choose student or teacher mode
        while(input.equals("")){
            // Gets input from user
            System.out.println("Choose student or teacher mode(s/t) or 'q' to quit: ");
            input = getInput.nextLine();
            if(input.toLowerCase().equals("s")){
                studentMode();
            }else if(input.toLowerCase().equals("t")){
                teacherMode();
            }else if(input.toLowerCase().equals("q")){
                break;
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
        //while()
    }
}
