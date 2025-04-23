package yovel.danil;

public enum Degree {
    FIRST,
    SECOND,
    DOCTOR,
    PROFESSOR;


    static boolean isValidDegree(String degree) {
        degree = degree.toUpperCase();
        for (Degree d : Degree.values()) {
            if (d.name().equals(degree)) return true;
        }
        return false;
    }
}
