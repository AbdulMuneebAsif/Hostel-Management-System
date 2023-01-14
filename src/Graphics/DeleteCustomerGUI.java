package Graphics;


import SuperClasses.SuperCustomerData;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomerGUI extends JFrame {

    private JTable table1;
    private JButton BackButton;
    private JButton DeleteButton;
    private JPanel Panel1;
    private JTextField IndexField;


    public DeleteCustomerGUI()
    {
        add(Panel1);
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerGUI().setVisible(true);
                dispose();
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Index = Integer.parseInt(IndexField.getText());
                SuperCustomerData.DeleteCustomer(Index);
                dispose();
                new DeleteCustomerGUI().setVisible(true);
            }
        });
    }


    private void createUIComponents() {
        DefaultTableModel model1=new DefaultTableModel();

            model1.addColumn("Index");
            model1.addColumn("Name");
            model1.addColumn("Father Name");
            model1.addColumn("CNIC No");
            model1.addColumn("Mobile No");
            model1.addColumn("Email Address");
            model1.addColumn("Address");

//            String s0, s1, s2, s3, s4, s5, s6;
//
//            s0 = "0";
//            s1 = "Osama Khalid";
//            s2 = "Khalid Pervez";
//            s3 = "14302 4711256 9";
//            s4 = "0343 3433630";
//            s5 = "gamingworkstationpak@gmail.com";
//            s6 = "s/4, guhrui road okara cantt,okara";
//            String[] data = {s0, s1, s2, s3, s4, s5, s6};
//
//            model1.addRow(data);
//

        if(SuperCustomerData.getcounter()!=0) {
            for (int i = 0; i < SuperCustomerData.getcounter(); i++) {
                String s0, s1, s2, s3, s4, s5, s6;
                s0 = String.valueOf(i);
                s1 = SuperCustomerData.getCustomerName(i);
                s2 = SuperCustomerData.getCustomerFatherName(i);
                s3 = SuperCustomerData.getCustomerCNICNo(i);
                s4 = SuperCustomerData.getCustomerMobileNo(i);
                s5 = SuperCustomerData.getCustomerEmailAddress(i);
                s6 = SuperCustomerData.getCustomerAddress(i);

                String[] data = {s0, s1, s2, s3, s4, s5, s6};

                model1.addRow(data);
            }
        }

        //Right Side
        DefaultTableCellRenderer rightrendere=new DefaultTableCellRenderer();
        rightrendere.setHorizontalAlignment(JLabel.RIGHT);
        //Center Side
        DefaultTableCellRenderer Centerrendere=new DefaultTableCellRenderer();
        Centerrendere.setHorizontalAlignment(JLabel.CENTER);

        table1=new JTable(model1);
        //Index
        table1.getColumnModel().getColumn(0).setMaxWidth(40);
        table1.getColumnModel().getColumn(0).setMinWidth(40);
        table1.getColumnModel().getColumn(0).setCellRenderer(rightrendere);
        //Name
        table1.getColumnModel().getColumn(1).setMinWidth(150);
        table1.getColumnModel().getColumn(1).setMaxWidth(150);
        //Father Name
        table1.getColumnModel().getColumn(2).setMinWidth(150);
        table1.getColumnModel().getColumn(2).setMaxWidth(150);
        //CNIC No
        table1.getColumnModel().getColumn(3).setMinWidth(120);
        table1.getColumnModel().getColumn(3).setMaxWidth(120);
        table1.getColumnModel().getColumn(3).setCellRenderer(rightrendere);
        //Mobile No
        table1.getColumnModel().getColumn(4).setMinWidth(120);
        table1.getColumnModel().getColumn(4).setMaxWidth(140);
        table1.getColumnModel().getColumn(4).setCellRenderer(rightrendere);
        //Email Address
        table1.getColumnModel().getColumn(5).setMinWidth(200);
        table1.getColumnModel().getColumn(5).setMaxWidth(250);
        table1.getColumnModel().getColumn(5).setCellRenderer(Centerrendere);
        //Address
        table1.getColumnModel().getColumn(6).setMinWidth(200);
        table1.getColumnModel().getColumn(6).setMaxWidth(300);



        // TODO: place custom component creation code here
    }
}
