/*
 * Created by JFormDesigner on Sun Sep 05 14:38:35 CST 2021
 */

package Mon_Test.Funcs.LoginPage;

import java.beans.*;
import Mon_Test.Tools.LoginTool;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author unknown
 */
public class Login extends JFrame {
    public Login() {
        initComponents();
    }

    int statusId = 0;

    private void loginBtMouseClicked(MouseEvent e) {
        String user = userText.getText();
        String password = new String(passText.getPassword());
        if(LoginTool.isLogin(panel1,user,password,statusId)){
            System.out.println("登录成功！");
        }
    }
    
    private void statusTextItemStateChanged(ItemEvent e) {
        statusId = statusText.getSelectedIndex();
    }

    private void statusTextPropertyChange(PropertyChangeEvent e) {
        statusId = statusText.getSelectedIndex();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        centralText = new JLabel();
        passText = new JPasswordField();
        loginBt = new JButton();
        findBt = new JButton();
        status = new JLabel();
        password = new JLabel();
        userText = new JTextField();
        user = new JLabel();
        statusText = new JComboBox<>();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- centralText ----
            centralText.setText("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf");
            panel1.add(centralText);
            centralText.setBounds(140, 35, 100, 28);
            panel1.add(passText);
            passText.setBounds(150, 120, 130, passText.getPreferredSize().height);

            //---- loginBt ----
            loginBt.setText("\u767b\u5f55");
            loginBt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginBtMouseClicked(e);
                }
            });
            panel1.add(loginBt);
            loginBt.setBounds(205, 205, 80, 30);

            //---- findBt ----
            findBt.setText("\u5fd8\u8bb0\u5bc6\u7801");
            panel1.add(findBt);
            findBt.setBounds(95, 205, 80, findBt.getPreferredSize().height);

            //---- status ----
            status.setText("\u8eab\u4efd");
            panel1.add(status);
            status.setBounds(100, 165, 35, 25);

            //---- password ----
            password.setText("\u5bc6\u7801");
            panel1.add(password);
            password.setBounds(100, 120, 35, 25);
            panel1.add(userText);
            userText.setBounds(150, 80, 130, userText.getPreferredSize().height);

            //---- user ----
            user.setText("\u8d26\u53f7");
            panel1.add(user);
            user.setBounds(100, 80, 35, 25);

            //---- statusText ----
            statusText.setSelectedIndex(-1);
            statusText.setMaximumRowCount(3);
            statusText.setModel(new DefaultComboBoxModel<>(new String[] {
                "\u5b66\u751f",
                "\u6559\u5e08",
                "\u540e\u53f0\u4eba\u5458"
            }));
            statusText.addPropertyChangeListener(e -> statusTextPropertyChange(e));
            panel1.add(statusText);
            statusText.setBounds(150, 165, 130, statusText.getPreferredSize().height);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 5, 385, 255);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JLabel centralText;
    private JPasswordField passText;
    private JButton loginBt;
    private JButton findBt;
    private JLabel status;
    private JLabel password;
    private JTextField userText;
    private JLabel user;
    private JComboBox<String> statusText;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
