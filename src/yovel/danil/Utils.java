package yovel.danil;

public class Utils {


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
}
