package Graphics;

import SuperClasses.SuperComplainData;
import SuperClasses.SuperCustomerData;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplainGUI extends JFrame {
    private JPanel panel1;
    private JPanel Tablepanel;
    private JPanel Registerpanel;
    private JPanel Updatepanel;
    private JPanel Deletepanel;
    private JPanel mainButtonpanel;
    private JButton registerButton;
    private JButton UpdateButton;
    private JButton DeleteButton;
    private JTable table1;
    private JTextField RegisterNameField1;
    private JButton RegisterButton1;
    private JTextField UpdateIndexField2;
    private JComboBox RegistercomboBox;
    private JComboBox UpdatecomboBox;
    private JButton UpdateButton1;
    private JButton DeleteButton1;
    private JTextField DeleteIndexField3;
    private DatePicker RegisterDate;
    private DatePicker CloseDate;
    private JButton BackButton;
    private JTextArea DetailsArea1;
    private JPanel DetailPanel;
    private JButton DetailsButton;
    private JTextField DetailIndexField1;
    private JTextField DetailIndexField2;
    private JTextField DetailRegistrationdateField4;
    private JTextField DetailStatusField5;
    private JTextField DetailsClosedateField6;
    private JTextArea DetailDetailArea1;
    private JButton DetailBackButton;
    private JButton UpdateBackButton;
    private JButton DeleteBackButton;
    private JButton RegisterBackButton;
    private JPanel Detailpanel2;
    private JTextField DetailsNameField;
    private JButton DetailButton;
    private JButton DetailpanelButton;

    public ComplainGUI()
    {
        setSize(1024,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add((panel1));

        mainButtonpanel.setVisible(true);
        Tablepanel.setVisible(true);
        Deletepanel.setVisible(false);
        Updatepanel.setVisible(false);

        Registerpanel.setVisible(false);
        Detailpanel2.setVisible(false);
        DetailPanel.setVisible(false);

        RegistercomboBox.addItem("Pending");
        RegistercomboBox.addItem("Working");


        UpdatecomboBox.addItem("Working");
        UpdatecomboBox.addItem("Close");



        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainButtonpanel.setVisible(false);
                Registerpanel.setVisible(true);
            }
        });
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Updatepanel.setVisible(true);
                mainButtonpanel.setVisible(false);
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deletepanel.setVisible(true);
                mainButtonpanel.setVisible(false);
            }
        });


        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesGUI().setVisible(true);
                dispose();
            }
        });
        RegisterButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperComplainData.setComplainName(RegisterNameField1.getText(),SuperComplainData.getComplainCounter());
                SuperComplainData.setComplainStatus(String.valueOf(RegistercomboBox.getSelectedItem()),SuperComplainData.getComplainCounter());
                SuperComplainData.setComplainRegistrationDate(RegisterDate.getText(),SuperComplainData.getComplainCounter());
                SuperComplainData.setComplainDetails(DetailsArea1.getText(),SuperComplainData.getComplainCounter());
                SuperComplainData.AddComplain();
                dispose();
                new ComplainGUI().setVisible(true);
            }
        });
        UpdateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperComplainData.setComplainStatus(String.valueOf(UpdatecomboBox.getSelectedItem()),Integer.parseInt(UpdateIndexField2.getText()));
                SuperComplainData.setComplainCloseDate(CloseDate.getText(),Integer.parseInt(UpdateIndexField2.getText()));
                new ComplainGUI().setVisible(true);
                dispose();


            }
        });
        DeleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperComplainData.DeleteComplainData(Integer.parseInt(DeleteIndexField3.getText()));
                new ComplainGUI().setVisible(true);
                dispose();

            }
        });
        DetailBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Detailpanel2.setVisible(false);
                mainButtonpanel.setVisible(true);

                DetailIndexField2.setText("");
                DetailsNameField.setText("");
                DetailRegistrationdateField4.setText("");
                DetailStatusField5.setText("");
                DetailsClosedateField6.setText("");
                DetailDetailArea1.setText("");
            }
        });
        DeleteBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deletepanel.setVisible(false);
                mainButtonpanel.setVisible(true);
            }
        });
        UpdateBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Updatepanel.setVisible(false);
                mainButtonpanel.setVisible(true);
            }
        });
        DetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Detailpanel2.setVisible(true);
                DetailPanel.setVisible(false);

                DetailIndexField2.setText(DetailIndexField1.getText());
                DetailsNameField.setText(SuperComplainData.getComplainName(Integer.parseInt(DetailIndexField1.getText())));
                DetailRegistrationdateField4.setText(SuperComplainData.getComplainRegistrationDate(Integer.parseInt(DetailIndexField1.getText())));
                DetailStatusField5.setText(SuperComplainData.getComplainStatus(Integer.parseInt(DetailIndexField1.getText())));
                DetailsClosedateField6.setText(SuperComplainData.getComplainCloseDate(Integer.parseInt(DetailIndexField1.getText())));
                DetailDetailArea1.setText(SuperComplainData.getComplainDetails(Integer.parseInt(DetailIndexField1.getText())));
            }
        });
        DetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailPanel.setVisible(true);
                mainButtonpanel.setVisible(false);
            }
        });
        DetailpanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainButtonpanel.setVisible(true);
                DetailPanel.setVisible(false);
            }
        });
        RegisterBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registerpanel.setVisible(false);
                mainButtonpanel.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel model1=new DefaultTableModel();

        model1.addColumn("Index");//0
        model1.addColumn("Name");//1
        model1.addColumn("Registration Date");//2
        model1.addColumn("Status");//3
        model1.addColumn("Close Date");//4


        if(SuperComplainData.getComplainCounter()!=0) {
            for (int i = 0; i < SuperComplainData.getComplainCounter(); i++) {
                String s0, s1, s2, s3, s4;
                s0 = String.valueOf(i);
                s1 = SuperComplainData.getComplainName(i);
                s2 = SuperComplainData.getComplainRegistrationDate(i);
                s3 = SuperComplainData.getComplainStatus(i);
                s4 = SuperComplainData.getComplainCloseDate(i);


                String[] data = {s0, s1, s2, s3, s4};

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
        //Registration Date
        table1.getColumnModel().getColumn(2).setMinWidth(150);
        table1.getColumnModel().getColumn(2).setMaxWidth(150);
        table1.getColumnModel().getColumn(2).setCellRenderer(rightrendere);
        //Status
        table1.getColumnModel().getColumn(3).setMinWidth(100);
        table1.getColumnModel().getColumn(3).setMaxWidth(100);
        table1.getColumnModel().getColumn(3).setCellRenderer(Centerrendere);
        //Close Date
        table1.getColumnModel().getColumn(4).setMinWidth(150);
        table1.getColumnModel().getColumn(4).setMaxWidth(150);
        table1.getColumnModel().getColumn(4).setCellRenderer(Centerrendere);

        // TODO: place custom component creation code here
    }
}
