package Graphics;

import SuperClasses.SuperCustomerData;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssignRoomGUI extends JFrame {
    private JPanel panel1;
    private JPanel subpanel1;
    private JPanel subpanel2;
    private JPanel subpanel3;
    private JTable table1;
    private JTextField UpdateIndexField1;
    private JTextField UpdateRoomIDField2;
    private JTextField UpdatePriceField3;
    private JButton UpdateButton;
    private DatePicker UpdateStartDate;
    private DatePicker UpdateEndDate;
    private JTextField PriceField1;
    private JTextField IDField2;
    private JTextField IndexField3;
    private JButton AssignButton;
    private DatePicker StartDate;
    private DatePicker EndDate;
    private JButton backButton;

    public AssignRoomGUI()
    {
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel1);

        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperCustomerData.setCustomerRoomID(UpdateRoomIDField2.getText(),Integer.parseInt(UpdateIndexField1.getText()));
                SuperCustomerData.setCustomerRoomPrice(UpdatePriceField3.getText(),Integer.parseInt(UpdateIndexField1.getText()));
                SuperCustomerData.setCustomerRoomStartDate(UpdateStartDate.getText(),Integer.parseInt(UpdateIndexField1.getText()));
                SuperCustomerData.setCustomerRoomEndDate(UpdateEndDate.getText(),Integer.parseInt(UpdateIndexField1.getText()));
                SuperCustomerData.UpdateRoom(Integer.parseInt(UpdateIndexField1.getText()),UpdateRoomIDField2.getText(),UpdateStartDate.getText(),UpdateEndDate.getText(),UpdatePriceField3.getText());
                dispose();
                new AssignRoomGUI().setVisible(true);

            }
        });
        AssignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperCustomerData.setCustomerRoomID(IDField2.getText(),Integer.parseInt(IndexField3.getText()));
                SuperCustomerData.setCustomerRoomPrice(PriceField1.getText(),Integer.parseInt(IndexField3.getText()));
                SuperCustomerData.setCustomerRoomStartDate(StartDate.getText(),Integer.parseInt(IndexField3.getText()));
                SuperCustomerData.setCustomerRoomEndDate(EndDate.getText(),Integer.parseInt(IndexField3.getText()));
                SuperCustomerData.UpdateRoom(Integer.parseInt(IndexField3.getText()),IDField2.getText(),StartDate.getText(),EndDate.getText(),PriceField1.getText());
                dispose();
                new AssignRoomGUI().setVisible(true);

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesGUI().setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel model1=new DefaultTableModel();

        model1.addColumn("Index");
        model1.addColumn("Name");
        model1.addColumn("Mobile No");
        model1.addColumn("Room ID");
        model1.addColumn("Price");
        model1.addColumn("Start Date");
        model1.addColumn("End Date");



        if(SuperCustomerData.getcounter()!=0) {
            for (int i = 0; i < SuperCustomerData.getcounter(); i++) {
                String s0, s1, s2, s3, s4, s5, s6;
                s0 = String.valueOf(i);
                s1 = SuperCustomerData.getCustomerName(i);
                s2 = SuperCustomerData.getCustomerMobileNo(i);
                s3 = SuperCustomerData.getCustomerRoomID(i);
                s4 = SuperCustomerData.getCustomerRoomPrice(i);
                s5 = SuperCustomerData.getCustomerRoomStartDate(i);
                s6 = SuperCustomerData.getCustomerRoomEndDate(i);

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
        table1.getColumnModel().getColumn(2).setMinWidth(120);
        table1.getColumnModel().getColumn(2).setMaxWidth(140);
        table1.getColumnModel().getColumn(2).setCellRenderer(rightrendere);
        //CNIC No
        table1.getColumnModel().getColumn(3).setMinWidth(80);
        table1.getColumnModel().getColumn(3).setMaxWidth(80);
        table1.getColumnModel().getColumn(3).setCellRenderer(Centerrendere);
        //Mobile No
        table1.getColumnModel().getColumn(4).setMinWidth(80);
        table1.getColumnModel().getColumn(4).setMaxWidth(80);
        table1.getColumnModel().getColumn(4).setCellRenderer(Centerrendere);
        //Email Address
        table1.getColumnModel().getColumn(5).setMinWidth(120);
        table1.getColumnModel().getColumn(5).setMaxWidth(120);
        table1.getColumnModel().getColumn(5).setCellRenderer(Centerrendere);
        //Address
        table1.getColumnModel().getColumn(6).setMinWidth(120);
        table1.getColumnModel().getColumn(6).setMaxWidth(120);
        table1.getColumnModel().getColumn(6).setCellRenderer(Centerrendere);

        // TODO: place custom component creation code here
    }


}
