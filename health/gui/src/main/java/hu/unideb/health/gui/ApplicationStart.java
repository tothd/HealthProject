package hu.unideb.health.gui;

/**
 * Az alkalmazás elindítására szolgáló osztály.
 */
public class ApplicationStart {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            //TODO Log
        }

        FrameContainer.showSignIn();
    }

}
