package yovel.danil;

import yovel.danil.lecturers.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    private static final Path path = Paths.get("./data.secret");

    public static Lecturer[] expandStrArr(Lecturer[] arr) {
        Lecturer[] newArr = new Lecturer[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static Committee[] expandStrArr(Committee[] arr) {
        Committee[] newArr = new Committee[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static Department[] expandStrArr(Department[] arr) {
        Department[] newArr = new Department[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void printArr(Object[] arr) {
        for (Object s : arr) {
            System.out.print(s + ", ");
        }
    }


    public static Lecturer createLecturer(String name, int id, Degree degree, String major, float salary, Department department) {
        switch (degree){
            case FIRST -> {
                return new FirstDegLecturer(name,id,major,salary,department);
            }

            case SECOND -> {
                return new SecDegLecturer(name,id,major,salary,department);
            }

            case DOCTOR -> {
                return new DocDegLecturer(name, id, major,salary,department);
            }

            case PROFESSOR -> {
                return new ProfDegLecturer(name,id, major, salary, department);
            }

        }
        return null;
    }

    public static boolean hasPreviousData() {
        return Files.exists(path);
    }

    public static void saveData(College college) throws IOException {
        if (!hasPreviousData()) {
            Files.createFile(path);
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data.secret"))) {
            out.writeObject(college);
            System.out.println("Saved College Data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static College loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./data.secret"))) {
            return (College) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
