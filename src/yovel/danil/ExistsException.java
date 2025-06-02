package yovel.danil;

public class ExistsException extends Exception {
    public ExistsException(String objectName, String objectClass) {
        super("College already has " + objectClass + " with name " + objectName + ".");
    }
}
