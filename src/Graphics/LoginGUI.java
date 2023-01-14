package Graphics;

import SuperClasses.SuperAdmin;
import SuperClasses.SuperEmployeeData;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class LoginGUI extends JFrame {
    private JPanel LoginPanel;
    private JTextField UserNameField;
    private JPasswordField PasswardField;
    private JButton LoginButton;
    private JLabel UserNameLabel;
    private JLabel PasswardLabel;
    private JLabel WrongPasswardLabel;
    public static boolean a=true;



    public LoginGUI()
    {

        //Frames Objects
        AdminGUI Admin_Panel=new AdminGUI();
        setVisible(a);

        setTitle("Welcome To DPDL Hostel");
        setVisible(true);
        setSize(1024,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       add(LoginPanel);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Objects.equals(SuperAdmin.getAdminUser(),UserNameField.getText()) && Objects.equals(SuperAdmin.getAdminPass(),PasswardField.getText()))
                {
                    new AdminGUI().setVisible(true);
                    setVisible(false);


                }
                else
               {
                    for(int i=0;i< SuperEmployeeData.getcounter();i++)
                    {
                        if(Objects.equals(SuperEmployeeData.getEmployeeUserName(i),UserNameField.getText()) &&Objects.equals(SuperEmployeeData.getEmployeePassward(i),PasswardField.getText()))
                        {
                            SuperEmployeeData.setEmployeeLogin(true);
                            new AdminGUI().setVisible(true);
                            break;
                        }
                    }
               }

            }


        });
    }


}
