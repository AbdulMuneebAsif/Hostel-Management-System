package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {
    JFrame adminFrame = new JFrame("About");

    JLabel userLabel1 = new JLabel("About ");
    JLabel successfulLogin = new JLabel(" ");

    JTextField userTextField = new JTextField(25);
    JPasswordField userPasswordField = new JPasswordField();
    JButton adminLoginButton = new JButton("Login");
    JButton BackButton = new JButton("< BACK");


    public About() {

        userLabel1.setBounds(15, 55, 85, 30);
        userLabel1.setFont(new Font(null, Font.BOLD, 16));

        userLabel1.setFont(new Font(null, Font.PLAIN, 16));

        userTextField.setBounds(105, 55, 170, 30);

        userPasswordField.setBounds(105, 95, 170, 30);

        adminLoginButton.setBounds(105, 160, 85, 30);
        adminLoginButton.setFocusable(false);
        adminLoginButton.addActionListener(this);

        BackButton.setBounds(0,0,100,20);
        BackButton.setFocusable(false);
        BackButton.addActionListener(this);

        successfulLogin.setBounds(105, 200, 305, 30);

        adminFrame.add(userLabel1);
        adminFrame.add(userTextField);
        adminFrame.add(userPasswordField);
        adminFrame.add(adminLoginButton);
        adminFrame.add(BackButton);
        adminFrame.add(successfulLogin);

        adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        adminFrame.setSize(380, 300);
        adminFrame.setLayout(null);
        adminFrame.setVisible(true);
    }


    public void actionPerformed(ActionEvent actionEvent)
    {
        if (userTextField.getText().equals("Muneeb") && userPasswordField.getText().equals("admin"))
        {
            if (actionEvent.getSource() == adminLoginButton)
            {
                adminFrame.dispose();
            }
        }
        else if (actionEvent.getSource() == BackButton)
        {
            adminFrame.dispose();
        }
        else
        {
            successfulLogin.setText("Invalid Login!");
        }
    }
}
