package Graphics;

import SuperClasses.SuperEmployeeData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame  {
    private JLabel Welcome;
    private JButton Customers_Button;
    private JButton Services_Button;
    private JButton Logout_Button;
    private JButton Change_Login_Details_Button;
    private JPanel Admin_Panel;
    private JButton employeeButton;
    private JButton CheckIn;
    private LoginGUI login_Panel;
//JFrame Object

    public AdminGUI() {
        setTitle("AdminMenu");
        add(Admin_Panel);
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        if(SuperEmployeeData.isEmployeeLogin()==true)
        {
            employeeButton.setVisible(false);
            Change_Login_Details_Button.setVisible(false);
        }



        Logout_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperEmployeeData.setEmployeeLogin(false);
                new LoginGUI().setVisible(true);
                dispose();
            }
        });

        Change_Login_Details_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SetAdminDetailsGUI().setVisible(true);
                dispose();
            }
        });

        Customers_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new CustomerGUI().setVisible(true);
                dispose();
            }
        });
        Services_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesGUI().setVisible(true);
                dispose();
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeGUI().setVisible(true);
                dispose();
            }
        });
        CheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Checkin().setVisible(true);
                dispose();
            }
        });
    }

}
