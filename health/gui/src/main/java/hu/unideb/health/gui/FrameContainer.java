package hu.unideb.health.gui;

import hu.unideb.health.shared.vo.UserVO;

/**
 * Frame-eket tároló osztály.
 */
public class FrameContainer {

    public static UserVO signedUser = null;
    public static SignIn signIn;

    public static void showSignIn() {
        if (signIn == null) {
            signIn = new SignIn();
        }
        signIn.setVisible(true);
    }

    public static void hideSignIn() {
        signIn.setVisible(false);
    }

    public static Registration registration;

    public static void showRegistration() {
        if (registration == null) {
            registration = new Registration();
        }
        registration.setVisible(true);
    }

    public static void hideRegistration() {
        registration.setVisible(false);
    }

    public static Functions functions;

    public static void showFunctions() {
        if (functions == null) {
            functions = new Functions();
        }
        functions.setVisible(true);
    }

    public static void hideFunctions() {
        functions.setVisible(false);
    }

    public static Report report;

    public static void showReport() {
        if (report == null) {
            report = new Report();
        }
        report.setVisible(true);
    }

    public static void hideReport() {
        report.setVisible(false);
    }

    public static Result result;

    public static void showResult(String index) {

        result = new Result(index);
        result.setVisible(true);
    }

    public static void hideResult() {
        result.setVisible(false);
        result.dispose();
    }

    public static UserVO getSignedUser() {
        return signedUser;
    }

    public static void setSignedUser(UserVO signedUser) {
        FrameContainer.signedUser = signedUser;
    }

}
