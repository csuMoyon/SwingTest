package Mon_Test.Test;

import Mon_Test.Funcs.LoginPage.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setVisible(true);
    }
}
