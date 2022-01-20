import java.util.ArrayList;
import java.util.Scanner;


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
                    System.out.println("#" + (i+1) + " Name: " + courses.get(i).courseName + " Grade: " + courses.get(i).getScoreString() + "%");
                }

                System.out.println("Enter the # of the desired course or '-1' to cancel ");
                selectedCourse = getInput.nextInt()-1;
                getInput.nextLine();

                if (selectedCourse >= 0 && selectedCourse < courses.size()) {
                    while (true) {
                        System.out.println("Enter 'a' to add an assignment, 't' to test an assignment, 'l' to list assignments, or 'q' to quit: ");
                        input = getInput.nextLine().toLowerCase();

                        if (input.equals("t")) {
                            String n;
                            int points;

                            System.out.println("What is the name of the Assignment: ");
                            n = getInput.nextLine();

                            System.out.println("How many points is the assignment worth: ");
                            points = getInput.nextInt();
                            getInput.nextLine();

                            courses.get(selectedCourse).testAssignment(n, points);

                        } else if (input.equals("a")) {
                            String n;
                            int points;
                            int s;

                            System.out.println("What is the name of the Assignment: ");
                            n = getInput.nextLine();

                            System.out.println("How many points is the assignment worth: ");
                            points = getInput.nextInt();
                            getInput.nextLine();

                            System.out.println("Is the assignment turned in and Grade (y/n): ");
                            input = getInput.nextLine().toLowerCase();

                            if (input.equals("y")) {
                                System.out.println("What percent grade did you get: ");
                                s = getInput.nextInt();
                                getInput.nextLine();

                                courses.get(selectedCourse).addAssingment(n, points, s);
                            } else {
                                courses.get(selectedCourse).addAssingment(n, points, 0);
                            }

                        } else if (input.equals("l")) {
                            ArrayList<Assignment> tempUnfinished = new ArrayList<Assignment>();
                            int counter = 1;

                            System.out.println("Completed Assignments: ");
                            for (Assignment a : courses.get(selectedCourse).getAssignments()) {
                                if (a.getCompleted()) {
                                    System.out.println("#" + counter + " Name: " + a.getName() + " Point Value: " + a.getPoints() + " Score: " + a.getScore());
                                    counter++;
                                } else {
                                    tempUnfinished.add(a);
                                }
                            }

                            counter = 1;
                            System.out.println("Unfinished Assignments: ");
                            for (Assignment a : tempUnfinished) {
                                System.out.println("#" + counter + " Name: " + a.getName() + " Point Value: " + a.getPoints() + " Score: " + a.getScore());
                                counter++;
                            }

                        } else {
                            break;
                        }
                    }
                }
            }
            else if (input.equals("c")) { //User is adding a new course to their list of courses
                String tempName;
                int tempTotalPoints;
                int tempScore;

                System.out.println("Please Enter a Name: ");
                tempName = getInput.nextLine();

                System.out.println("Enter 'c' to continue to enter grades or 's' to skip and create empty course or hit 'q' to quit: "); //Let the User choose bewtween creating the new course with just a name or adding preexisting data to it
                input = getInput.nextLine().toLowerCase();

                if (input.equals("c")) {
                    System.out.println("How many points is the course worth: ");
                    tempTotalPoints = getInput.nextInt();
                    getInput.nextLine();

                    System.out.println("What is your score in this course: ");
                    tempScore = getInput.nextInt();
                    getInput.nextLine();

                    System.out.println("Enter 'c' to confirm or 'q' to cancel: ");
                    input = getInput.nextLine();
                    if (input.equals("c")) courses.add(new Course(tempName, tempTotalPoints, tempScore));

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
        System.out.println("Enter the grade percentages of students on the test as integer numbers, click enter after each one; enter -1 to quit");
        int input = 0;
        Assignment grade;
        ArrayList<Assignment> gradesList = new ArrayList<Assignment>();
        while(true){
            input = getInput.nextInt();
            getInput.nextLine();
            if(input == -1){
                break;
            }else{
                grade = new Assignment(input);
                gradesList.add(grade);
            }
        }
        Grades allGrades = new Grades(gradesList);
        BellCurve thisCurve = new BellCurve(allGrades);
        thisCurve.curveThem();
        Grades curved = thisCurve.getCurve();

        for(int i = 0; i < curved.getSize(); i++){
            System.out.println(curved.getGrade(i).getScore());
        }

    }
}
