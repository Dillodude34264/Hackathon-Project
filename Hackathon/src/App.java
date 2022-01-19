import java.util.ArrayList;
import java.util.Scanner;

////// Garrett can you make mock-ups or a plan for a potential UI - Michael ////////////

public class App {
    static ArrayList<Course> courses = new ArrayList<Course>();
    static Scanner getInput = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String input = "";

        // Continues to ask user what they want to do until the choose student or teacher mode
        while(true){
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

    //Student mode driver
    public static void studentMode(){
        String input;
        int selectedCourse;
        while (true) {
            //Ask what student wants to do
            input = "";
            if (courses.size() != 0) {
                System.out.println("Enter 'v' to view an existing course, 'c' to create a new course, or 'q' to quit:");
                input = getInput.nextLine().toLowerCase();
            } else {
                input = "c";
            }

            if (input.equals("v")) { //User is selecting a previously created course
                System.out.println("Courses: ");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println("#" + i + " Name: " + courses.get(i).courseName + " Grade: " + courses.get(i).getScoreString() + "%");
                }

                System.out.println("Enter the # of the desired course or '-1' to cancel ");
                selectedCourse = Integer.parseInt(getInput.nextLine());

                if (selectedCourse >= 0 && selectedCourse < courses.size()) {}
            }

            else if (input.equals("c")) { //User is adding a new course to their list of courses
                String tempName;
                int tempTotalPoints;
                int tempStudentPoints;

                System.out.println("Please Enter a Name: ");
                tempName = getInput.nextLine();

                System.out.println("Enter 'c' to continue to enter grades or 's' to skip and create empty course or hit 'q' to quit: ");
                input = getInput.nextLine().toLowerCase();

                if (input.equals("c")) {

                } else if (input.equals("s")) {
                    courses.add(new Course(tempName));
                }
            }
            
            else { //If the User entered anything other than 'c' or 'v' it quits
                break;
            }
        }
    }

    //Teacher mode driver
    public static void teacherMode(){
        System.out.println("Enter the grade percentages of students on the test as integer numbers; enter -1 to quit");
        int grade = 0;
        //while()
    }
}
