package Graphics;

import SuperClasses.SuperAdmin;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SetAdminDetailsGUI extends JFrame{
    private JPanel Panel;

    private JLabel NewUserNameLabel;
    private JTextField NewUserNameField;

    private JLabel ConfirmedPasswordLabel;
    private JPasswordField CurrentPasswordField;

    private JLabel NewPasswordLabel;
    private JPasswordField NewPasswordField;

    private JLabel CurrentPasswordLable;
    private JPasswordField ConfirmedPasswordField;

    private JLabel Warning;

    private JButton UpdateButton;

    private JButton BackButton;


    public SetAdminDetailsGUI() {
        add(Panel);
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Administrator Details");

        NewUserNameField.setText(SuperAdmin.getAdminUser());

        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(ConfirmedPasswordField.getText(),NewPasswordField.getText()) && Objects.equals(CurrentPasswordField.getText(), SuperAdmin.getAdminPass()))
                {
                    SuperAdmin.setAdminUser(NewUserNameField.getText());
                    SuperAdmin.setAdminPass( NewPasswordField.getText());

                    new AdminGUI().setVisible(true);
                    dispose();

                }
                else
                {
                    Warning.setText("You Entered Wrong Details Pls ReCheck");
                }

            }
        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AdminGUI().setVisible(true);
                dispose();
            }
        });
    }
}
