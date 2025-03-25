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

    private static String[] lecturers = new String[1];
    private static int lecturersCount = 0;
    private static String[] committees = new String[1];
    private static int committeesCount = 0;
    private static String[] courses = new String[1];
    private static int coursesCount = 0;


    private static boolean isInArray(String[] arr, String str) {
        for (String s : arr) {
            if (s != null && s.equals(str)) return true;
        }
        return false;
    }

    private static String[] addNewValue(String[] arr,int count, String value){
        if (count < arr.length) {
            arr[count] = value;
            return arr;
        }

        String[] newArr = new String[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[count] = value;
        return newArr;
    }

    private static void printInfo(String... arr){
        for (int i = 0; i < arr.length; i++){
            if ((i + 1 < arr.length && arr[i + 1] == null) || i == arr.length - 1){ // Checks if i last or before nulls (last not null value)
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
                            continue;
                        }
                        lecturers = addNewValue(lecturers,lecturersCount, lecturer);
                        lecturersCount++;
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
                            continue;
                        }

                        committees = addNewValue(committees, committeesCount,committee);
                        committeesCount++;
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
                            continue;
                        }

                        courses = addNewValue(courses, coursesCount,course);
                        coursesCount++;
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
