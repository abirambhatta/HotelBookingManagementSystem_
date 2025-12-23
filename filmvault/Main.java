package filmvault;

import filmvault.view.LoginView;
import filmvault.controller.LoginController;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                new LoginController(view);
                view.setVisible(true);
            }
        });
    }
}
