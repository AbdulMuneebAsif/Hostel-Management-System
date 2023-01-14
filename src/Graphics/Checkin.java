package Graphics;

import SuperClasses.SuperCheckIn;
import SuperClasses.SuperCustomerData;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkin extends JFrame {
    private JTable table1;
    private JButton CheckOut;
    private JButton CheckIn;
    private JTextField IndexField;
    private JPanel Jpanel1;
    private JButton backButton;

    public Checkin()
    {
        setSize(1024,720);
        add(Jpanel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperCheckIn.setName(SuperCustomerData.getCustomerName(Integer.parseInt(IndexField.getText())),Integer.parseInt(IndexField.getText()));
                SuperCheckIn.setStatus("CheckIn",Integer.parseInt(IndexField.getText()));

                SuperCheckIn.CheckInsert(Integer.parseInt(IndexField.getText()),
                        SuperCustomerData.getCustomerName(Integer.parseInt(IndexField.getText())),
                        SuperCheckIn.getStatusl(Integer.parseInt(IndexField.getText())));
                SuperCheckIn.CheckinCountADD();
                new Checkin().setVisible(true);
                dispose();
            }
        });
        CheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperCheckIn.setName(SuperCustomerData.getCustomerName(Integer.parseInt(IndexField.getText())),Integer.parseInt(IndexField.getText()));
                SuperCheckIn.setStatus("CheckOut",Integer.parseInt(IndexField.getText()));
                SuperCheckIn.CheckInsert(Integer.parseInt(IndexField.getText()),
                        SuperCustomerData.getCustomerName(Integer.parseInt(IndexField.getText())),
                        SuperCheckIn.getStatusl(Integer.parseInt(IndexField.getText())));
                SuperCheckIn.CheckinCountADD();
                new Checkin().setVisible(true);
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminGUI().setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel model1=new DefaultTableModel();

        model1.addColumn("Index");
        model1.addColumn("Name");
        model1.addColumn("Status");


        if(SuperCustomerData.getcounter()!=0) {
            for (int i = 0; i < SuperCustomerData.getcounter(); i++) {
                String s0, s1, s2;
                s0 = String.valueOf(i);
                s1 = SuperCustomerData.getCustomerName(i);
                s2 = SuperCheckIn.getStatusl(i);
                String[] data = {s0, s1, s2};

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
        table1.getColumnModel().getColumn(1).setMinWidth(180);
        table1.getColumnModel().getColumn(1).setMaxWidth(180);
        //Status
        table1.getColumnModel().getColumn(2).setMinWidth(90);
        table1.getColumnModel().getColumn(2).setMaxWidth(90);
        table1.getColumnModel().getColumn(2).setCellRenderer(Centerrendere);

        // TODO: place custom component creation code here
    }
}
