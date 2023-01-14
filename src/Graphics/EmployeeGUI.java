package Graphics;

import SuperClasses.SuperEmployeeData;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeGUI extends JFrame {
    private JPanel MainPanel;
    private JButton registerEmployeeButton;
    private JButton salaryButton;
    private JButton editEmplyeeDetailsButton;
    private JButton backButton;
    private JTextField NameField1;
    private JTextField CNICNoField2;
    private JTextField MobileNoField3;
    private JTextField EmailAddressField4;
    private JTextField AddressField5;
    private JTextField AgeField6;
    private JTextField PostField7;
    private JButton registerButton;
    private JButton backButton1;
    private JButton updateButton;
    private JTable table1;
    private JPanel buttonspanel;
    private JPanel registerpanel;
    private JPanel tablepanel1;
    private JButton updateButton1;
    private JTextField IndexField1;
    private JTextField SalaryField2;
    private JButton backbutton1;
    private JPanel Salarypanel;
    private JButton backButton2;
    private JTextField IndexUpdateField1;
    private JButton selectButton;
    private JButton backButton3;
    private JPanel EditeIndexPanel;
    private JTextField FatherNamefield;
    private JTable table2;
    private JButton userAndPasswordButton;
    private JPanel UsernamePanel;
    private JTable table3;
    private JTextField UsernameandPassIndexField1;
    private JTextField UsernameField1;
    private JTextField PasswardField2;
    private JButton updateButton2;
    private JButton backButton4;

    public EmployeeGUI()
    {
        setSize(1200,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(MainPanel);

        buttonspanel.setVisible(true);
        tablepanel1.setVisible(false);
        registerpanel.setVisible(false);
        Salarypanel.setVisible(false);
        EditeIndexPanel.setVisible(false);
        UsernamePanel.setVisible(false);



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminGUI().setVisible(true);
                dispose();
            }
        });
        registerEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerpanel.setVisible(true);

                updateButton.setVisible(false);
                backButton2.setVisible(false);

                backButton1.setVisible(true);
                registerButton.setVisible(true);

                buttonspanel.setVisible(false);

            }
        });
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonspanel.setVisible(true);

                registerButton.setVisible(false);
                backButton1.setVisible(false);

                registerpanel.setVisible(false);

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperEmployeeData.setEmployeeName(NameField1.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeCNICNo(CNICNoField2.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeMobileNo(MobileNoField3.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeEmailAddress(EmailAddressField4.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeAddress(AddressField5.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeAge(AgeField6.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeePost(PostField7.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeSalary(SalaryField2.getText(),SuperEmployeeData.getcounter());
                SuperEmployeeData.setEmployeeFatherName(FatherNamefield.getText(),SuperEmployeeData.getcounter());
                //Insert into Database
                SuperEmployeeData.RegisterEmployee(NameField1.getText(),CNICNoField2.getText(),MobileNoField3.getText(),EmailAddressField4.getText(),AddressField5.getText(),AgeField6.getText(),PostField7.getText(),SalaryField2.getText(),FatherNamefield.getText());

                SuperEmployeeData.addCounter();

                NameField1.setText("");
                CNICNoField2.setText("");
                MobileNoField3.setText("");
                EmailAddressField4.setText("");
                AddressField5.setText("");
                AgeField6.setText("");
                PostField7.setText("");
                SalaryField2.setText("");
                FatherNamefield.setText("");

                dispose();
                new EmployeeGUI().setVisible(true);



            }
        });


        editEmplyeeDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tablepanel1.setVisible(true);
                EditeIndexPanel.setVisible(true);
                buttonspanel.setVisible(false);
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperEmployeeData.setEditindex(Integer.parseInt(IndexUpdateField1.getText()));
                tablepanel1.setVisible(false);
                EditeIndexPanel.setVisible(false);
                registerpanel.setVisible(true);

                updateButton.setVisible(true);
                backButton2.setVisible(true);

                backButton1.setVisible(false);
                registerButton.setVisible(false);

                NameField1.setText(SuperEmployeeData.getEmployeeName(SuperEmployeeData.getEditindex()));
                CNICNoField2.setText(SuperEmployeeData.getEmployeeCNICNo(SuperEmployeeData.getEditindex()));
                MobileNoField3.setText(SuperEmployeeData.getEmployeeMobileNo(SuperEmployeeData.getEditindex()));
                EmailAddressField4.setText(SuperEmployeeData.getEmployeeEmailAddress(SuperEmployeeData.getEditindex()));
                AddressField5.setText(SuperEmployeeData.getEmployeeAddress(SuperEmployeeData.getEditindex()));
                AgeField6.setText(SuperEmployeeData.getEmployeeAge(SuperEmployeeData.getEditindex()));
                PostField7.setText(SuperEmployeeData.getEmployeePost(SuperEmployeeData.getEditindex()));
                SalaryField2.setText(SuperEmployeeData.getEmployeeSalary(SuperEmployeeData.getEditindex()));
                FatherNamefield.setText(SuperEmployeeData.getEmployeeFatherName(SuperEmployeeData.getEditindex()));





            }
        });
        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablepanel1.setVisible(false);
                buttonspanel.setVisible(true);
                EditeIndexPanel.setVisible(false);
            }
        });
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablepanel1.setVisible(true);
                registerpanel.setVisible(false);
                EditeIndexPanel.setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SuperEmployeeData.setEmployeeName(NameField1.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeCNICNo(CNICNoField2.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeMobileNo(MobileNoField3.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeEmailAddress(EmailAddressField4.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeAddress(AddressField5.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeAge(AgeField6.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeePost(PostField7.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeSalary(SalaryField2.getText(),SuperEmployeeData.getEditindex());
                SuperEmployeeData.setEmployeeFatherName(FatherNamefield.getText(),SuperEmployeeData.getEditindex());

                SuperEmployeeData.UpdateEmployee(SuperEmployeeData.getEditindex(),NameField1.getText(),CNICNoField2.getText(),MobileNoField3.getText(),EmailAddressField4.getText(),AddressField5.getText(),AgeField6.getText(),PostField7.getText(),SalaryField2.getText(),FatherNamefield.getText());
                NameField1.setText("");
                CNICNoField2.setText("");
                MobileNoField3.setText("");
                EmailAddressField4.setText("");
                AddressField5.setText("");
                AgeField6.setText("");
                PostField7.setText("");
                SalaryField2.setText("");
                FatherNamefield.setText("");

                registerpanel.setVisible(false);
                tablepanel1.setVisible(true);
                EditeIndexPanel.setVisible(true);
                IndexUpdateField1.setText("");

                dispose();
                new EmployeeGUI().setVisible(true);


            }
        });
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperEmployeeData.setEmployeeSalary(SalaryField2.getText(),Integer.parseInt(IndexField1.getText()));

                SuperEmployeeData.UpdateEmployeeSalary(Integer.parseInt(IndexField1.getText()),SalaryField2.getText());
                IndexField1.setText("");
                SalaryField2.setText("");
                dispose();
                new EmployeeGUI().setVisible(true);

            }
        });
        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Salarypanel.setVisible(true);
                buttonspanel.setVisible(false);

            }
        });
        backbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonspanel.setVisible(true);
               Salarypanel.setVisible(false);

                IndexField1.setText("");
                SalaryField2.setText("");

            }
        });
        backbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonspanel.setVisible(true);
                Salarypanel.setVisible(false);

            }
        });
        userAndPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsernamePanel.setVisible(true);
                buttonspanel.setVisible(false);
            }
        });
        backButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonspanel.setVisible(true);
                UsernamePanel.setVisible(false);
            }
        });
        updateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperEmployeeData.setEmployeeUserName(UsernameField1.getText(),Integer.parseInt(UsernameandPassIndexField1.getText()));
                SuperEmployeeData.setEmployeePassward(PasswardField2.getText(),Integer.parseInt(UsernameandPassIndexField1.getText()));

                dispose();
                new EmployeeGUI().setVisible(true);
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
        model1.addColumn("age");
        model1.addColumn("Post");

        if(SuperEmployeeData.getcounter()!=0) {
            for (int i = 0; i < SuperEmployeeData.getcounter(); i++) {
                String s0, s1, s2, s3, s4, s5, s6, s7, s8;
                s0 = String.valueOf(i);
                s1 = SuperEmployeeData.getEmployeeName(i);
                s2 = SuperEmployeeData.getEmployeeFatherName(i);
                s3 = SuperEmployeeData.getEmployeeCNICNo(i);
                s4 = SuperEmployeeData.getEmployeeMobileNo(i);
                s5 = SuperEmployeeData.getEmployeeEmailAddress(i);
                s6 = SuperEmployeeData.getEmployeeAddress(i);
                s7 = SuperEmployeeData.getEmployeeAge(i);
                s8 = SuperEmployeeData.getEmployeePost(i);

                String[] data = {s0, s1, s2, s3, s4, s5, s6, s7, s8};

                model1.addRow(data);
            }
        }

        //Right Side
        DefaultTableCellRenderer rightrendere=new DefaultTableCellRenderer();
        rightrendere.setHorizontalAlignment(JLabel.RIGHT);
        //Center Side
        DefaultTableCellRenderer Centerrendere=new DefaultTableCellRenderer();
        Centerrendere.setHorizontalAlignment(JLabel.CENTER);

        table1 =new JTable(model1);
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
        //age
        table1.getColumnModel().getColumn(7).setMinWidth(60);
        table1.getColumnModel().getColumn(7).setMaxWidth(60);
        table1.getColumnModel().getColumn(7).setCellRenderer(Centerrendere);
        //Post
        table1.getColumnModel().getColumn(8).setMinWidth(120);
        table1.getColumnModel().getColumn(8).setMaxWidth(120);
        table1.getColumnModel().getColumn(8).setCellRenderer(Centerrendere);



        DefaultTableModel model2=new DefaultTableModel();
        model2.addColumn("Index");
        model2.addColumn("Name");
        model2.addColumn("Mobile No");
        model2.addColumn("Post");
        model2.addColumn("Salary");

        if(SuperEmployeeData.getcounter()!=0) {
            for (int i = 0; i < SuperEmployeeData.getcounter(); i++) {
                String s0, s1, s2, s3,s4;
                s0 = String.valueOf(i);
                s1 = SuperEmployeeData.getEmployeeName(i);
                s2 = SuperEmployeeData.getEmployeeMobileNo(i);
                s3 = SuperEmployeeData.getEmployeePost(i);
                s4 = SuperEmployeeData.getEmployeeSalary(i);

                String[] data = {s0, s1, s2, s3,s4};

                model2.addRow(data);
            }
        }

        //Right Side
        DefaultTableCellRenderer rightrendere2=new DefaultTableCellRenderer();
        rightrendere2.setHorizontalAlignment(JLabel.RIGHT);
        //Center Side
        DefaultTableCellRenderer Centerrendere2=new DefaultTableCellRenderer();
        Centerrendere2.setHorizontalAlignment(JLabel.CENTER);

        table2 =new JTable(model2);
        //Index
        table2.getColumnModel().getColumn(0).setMaxWidth(40);
        table2.getColumnModel().getColumn(0).setMinWidth(40);
        table2.getColumnModel().getColumn(0).setCellRenderer(rightrendere2);
        //Name
        table2.getColumnModel().getColumn(1).setMinWidth(150);
        table2.getColumnModel().getColumn(1).setMaxWidth(150);

        //Mobile No
        table2.getColumnModel().getColumn(2).setMinWidth(120);
        table2.getColumnModel().getColumn(2).setMaxWidth(140);
        table2.getColumnModel().getColumn(2).setCellRenderer(rightrendere2);
        //Post
        table2.getColumnModel().getColumn(3).setMinWidth(120);
        table2.getColumnModel().getColumn(3).setMaxWidth(120);
        table2.getColumnModel().getColumn(3).setCellRenderer(Centerrendere2);

        //Salary

        table2.getColumnModel().getColumn(4).setMinWidth(100);
        table2.getColumnModel().getColumn(4).setMaxWidth(100);
        table2.getColumnModel().getColumn(4).setCellRenderer(Centerrendere2);


        DefaultTableModel model3=new DefaultTableModel();
        model3.addColumn("Index");
        model3.addColumn("Name");
        model3.addColumn("Mobile No");
        model3.addColumn("Post");
        model3.addColumn("UserName");
        model3.addColumn("Password");

        if(SuperEmployeeData.getcounter()!=0) {
            for (int i = 0; i < SuperEmployeeData.getcounter(); i++) {
                String s0, s1, s2, s3,s4,s5;
                s0 = String.valueOf(i);
                s1 = SuperEmployeeData.getEmployeeName(i);
                s2 = SuperEmployeeData.getEmployeeMobileNo(i);
                s3 = SuperEmployeeData.getEmployeePost(i);
                s4 = SuperEmployeeData.getEmployeePassward(i);
                s5 = SuperEmployeeData.getEmployeePassward(i);

                String[] data = {s0, s1, s2, s3,s4,s5};

                model3.addRow(data);
            }
        }

        //Right Side
        DefaultTableCellRenderer rightrendere3=new DefaultTableCellRenderer();
        rightrendere3.setHorizontalAlignment(JLabel.RIGHT);
        //Center Side
        DefaultTableCellRenderer Centerrendere3=new DefaultTableCellRenderer();
        Centerrendere2.setHorizontalAlignment(JLabel.CENTER);

        table3 =new JTable(model3);
        //Index
        table3.getColumnModel().getColumn(0).setMaxWidth(40);
        table3.getColumnModel().getColumn(0).setMinWidth(40);
        table3.getColumnModel().getColumn(0).setCellRenderer(rightrendere3);
        //Name
        table3.getColumnModel().getColumn(1).setMinWidth(150);
        table3.getColumnModel().getColumn(1).setMaxWidth(150);

        //Mobile No
        table3.getColumnModel().getColumn(2).setMinWidth(120);
        table3.getColumnModel().getColumn(2).setMaxWidth(140);
        table3.getColumnModel().getColumn(2).setCellRenderer(rightrendere3);
        //Post
        table3.getColumnModel().getColumn(3).setMinWidth(120);
        table3.getColumnModel().getColumn(3).setMaxWidth(120);
        table3.getColumnModel().getColumn(3).setCellRenderer(Centerrendere3);

        //Username
        table3.getColumnModel().getColumn(4).setMinWidth(180);
        table3.getColumnModel().getColumn(4).setMaxWidth(180);
        table3.getColumnModel().getColumn(4).setCellRenderer(Centerrendere3);
        //Password
        table3.getColumnModel().getColumn(5).setMinWidth(180);
        table3.getColumnModel().getColumn(5).setMaxWidth(180);
        table3.getColumnModel().getColumn(5).setCellRenderer(Centerrendere3);


        // TODO: place custom component creation code here
    }



}
