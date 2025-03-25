package yovel.danil;

import java.util.Scanner;

public class InnitMain {

    // Daniel And Yovel
    private static final String menu =
            "here are the functions:" +
                    "\n0 - Exit " +
                    "\n1 - Add a lecturer " +
                    "\n2 - Add a committee " +
                    "\n3 - Add Course " +
                    "\n4 - Assign a lecturer to a committee " +
                    "\n5 - Show college lecturer average salary " +
                    "\n6 - Show specific course's lecturers average salary " +
                    "\n7 - Show all lecturers info " +
                    "\n8 - Show all committees info\n";

    private static boolean isInArray(String[] arr, String str) {
        for (String s : arr) {
            if (s.equals(str)) return true;
        }
        return false;
    }

    private static String[] addNewValue(String[] arr, String value){
        String[] newArr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = value;
        return newArr;
    }

    private static void printInfo(String... arr){
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter college name: ");

        String college = scanner.nextLine();
        String[] lecturers = new String[0];
        String[] committees = new String[0];
        String[] courses = new String[0];
        System.out.println("College created successfully!");
        System.out.println("Welcome to " + college + " college!");




        A: while (true) {
            System.out.print("\n"+menu);
            String func = scanner.nextLine();

            switch (func) {
                case "0":
                    System.out.println("Goodbye!");
                    break A;

                case "1":
                    while (true) {
                        System.out.print("Enter lecturer name: ");
                        String lecturer = scanner.nextLine();
                        if (lecturer.isEmpty()) continue;
                        if (isInArray(lecturers, lecturer)) {
                            System.out.println("Lecturer already exists!");
                            break;
                        }
                        lecturers = addNewValue(lecturers, lecturer);
                        System.out.println("Lecturer added successfully!");
                        break;

                    }
                    break;
                case "2":
                    while (true) {
                        System.out.print("Enter committee name: ");
                        String committee = scanner.nextLine();
                        if (committee.isEmpty()) continue;
                        if (isInArray(committees, committee)) {
                            System.out.println("Committee already exists!");
                            break;
                        }

                        committees = addNewValue(committees, committee);
                        System.out.println("Committee added successfully!");
                        break;
                    }
                    break;

                case "3":
                    while (true) {
                        System.out.print("Enter course name: ");
                        String course = scanner.nextLine();
                        if (course.isEmpty()) continue;
                        if (isInArray(courses, course)) {
                            System.out.println("Course already exists!");
                            break;
                        }

                        courses = addNewValue(courses, course);
                        System.out.println("Course added successfully!");
                        break;
                    }
                    break;

                case "4":
                    while (true) {
                        System.out.print("Enter lecturer name: ");
                        String lecturer = scanner.nextLine();
                        if (!isInArray(lecturers, lecturer)) {
                            System.out.println("Lecturer doesn't exist!");
                            break;
                        }

                        System.out.print("Enter committee name: ");
                        String committee = scanner.nextLine();
                        if (!isInArray(committees, committee)) {
                            System.out.println("Committee doesn't exist!");
                            break;
                        }
                    }
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.print(college + "'s Lecturers:\n");
                    printInfo(lecturers);
                    break;
                case "8":
                    System.out.print(college + "'s Committees:\n");
                    printInfo(committees);
                    break;

                default:
                    System.out.println("Invalid function!");
                    break;
            }

            System.out.println(" ");
        }

    }
}
