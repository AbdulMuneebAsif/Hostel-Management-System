package Graphics;

import SuperClasses.SuperCustomerData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditCustomerGUI2 extends JFrame{
    private JPanel panel1;
    private JTextField NameField;
    private JTextField FatherNameField;
    private JTextField CNICNoField;
    private JTextField MobileNoField;
    private JTextField EmailAddressField;
    private JTextField AddressField;
    private JButton UpdateButton;
    private JButton BackButton;

    public EditCustomerGUI2() {

        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel1);

        int Index=SuperCustomerData.getEditeNo();
        NameField.setText(SuperCustomerData.getCustomerName(Index));
        FatherNameField.setText(SuperCustomerData.getCustomerFatherName(Index));
        CNICNoField.setText(SuperCustomerData.getCustomerCNICNo(Index));
        MobileNoField.setText(SuperCustomerData.getCustomerMobileNo(Index));
        EmailAddressField.setText(SuperCustomerData.getCustomerEmailAddress(Index));
        AddressField.setText(SuperCustomerData.getCustomerAddress(Index));

        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperCustomerData.setCustomerName(NameField.getText(),Index);
                SuperCustomerData.setCustomerFatherName(FatherNameField.getText(),Index);
                SuperCustomerData.setCustomerCNICNo(CNICNoField.getText(),Index);
                SuperCustomerData.setCustomerMobileNo(MobileNoField.getText(),Index);
                SuperCustomerData.setCustomerEmailAddress(EmailAddressField.getText(),Index);
                SuperCustomerData.setCustomerAddress(AddressField.getText(),Index);

                dispose();
                new EditCustomerGUI().setVisible(true);



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
