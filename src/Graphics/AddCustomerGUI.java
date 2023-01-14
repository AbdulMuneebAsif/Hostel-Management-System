package Graphics;

import SuperClasses.SuperCustomerData;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerGUI extends JFrame {
    private JTextField NameField;
    private JTextField FatherNameField;
    private JTextField EmailAddressField;
    private JTextField CNICNoField;
    private JTextField MobileNoField;
    private JTextField AddressField;
    private JLabel Name;
    private JLabel FatherName;
    private JLabel EmailAddress;
    private JLabel CNICNo;
    private JLabel MobileNo;
    private JLabel Address;
    private JButton AddButton;
    private JButton BackButton;
    private JPanel Panel1;
    private JLabel WarrningLabel;

    public AddCustomerGUI()
    {
        add(Panel1);
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Add Customer");


        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerGUI().setVisible(true);
                dispose();
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean Missing=false;
                if(NameField.getText()==""||NameField.getText()==null)
                {
                    Missing=true;
                }
                else if (FatherNameField.getText()==""||FatherNameField.getText()==null)
                {
                    Missing=true;
                }
                else if (CNICNoField.getText()==""||CNICNoField.getText()==null)
                {
                    Missing=true;
                }
                else if (MobileNoField.getText()==""||MobileNoField.getText()==null)
                {
                    Missing=true;
                }
                else if (EmailAddressField.getText()==""||EmailAddressField.getText()==null)
                {
                    Missing=true;
                }
                else if (AddressField.getText()==""||AddressField.getText()==null)
                {
                    Missing=true;
                }
                else {
                    Missing=false;
                }



                if(Missing==false) {
                    SuperCustomerData.setCustomerName(NameField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.setCustomerFatherName(FatherNameField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.setCustomerCNICNo(CNICNoField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.setCustomerMobileNo(MobileNoField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.setCustomerEmailAddress(EmailAddressField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.setCustomerAddress(AddressField.getText(),SuperCustomerData.getcounter());
                    SuperCustomerData.RegisterCustomer(NameField.getText(),FatherNameField.getText(),CNICNoField.getText(),MobileNoField.getText(),EmailAddressField.getText(),AddressField.getText());
                    SuperCustomerData.AddCustomer();

                    NameField.setText("");
                    FatherNameField.setText("");
                    CNICNoField.setText("");
                    MobileNoField.setText("");
                    EmailAddressField.setText("");
                    AddressField.setText("");
                }

                else
                {
                    WarrningLabel.setText("Pls Check the Details and Try Again");
                }

            }
        });
    }
}
