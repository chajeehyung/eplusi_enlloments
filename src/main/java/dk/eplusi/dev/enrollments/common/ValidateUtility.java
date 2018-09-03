package dk.eplusi.dev.enrollments.common;

public class ValidateUtility {

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
