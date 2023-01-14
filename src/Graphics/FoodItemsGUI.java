package Graphics;

import SuperClasses.SuperCustomerData;
import SuperClasses.SuperFoodItems;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodItemsGUI extends JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton AddButton;
    private JButton backButton;
    private JTextField ItemPriceField;
    private JTextField ItemNameField;
    private DatePicker DateField;

    public FoodItemsGUI()
    {
        setSize(1024,720);
        add(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DateField.setDateToToday();

        


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ServicesGUI().setVisible(true);
                dispose();
            }
        });
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuperFoodItems.setFoodItemsName(ItemNameField.getText(),SuperFoodItems.getFoodItemCount());
                SuperFoodItems.setFoodItemsPrice(ItemPriceField.getText(),SuperFoodItems.getFoodItemCount());
                SuperFoodItems.setFoodItemsDate(DateField.getText(),SuperFoodItems.getFoodItemCount());
                SuperFoodItems.InsertMon(ItemNameField.getText(),ItemPriceField.getText(),DateField.getText());
                SuperFoodItems.AddFoodItemCount();
                dispose();
                new FoodItemsGUI().setVisible(true);
            }
        });
    }

    private void createUIComponents() {

        DefaultTableModel model1=new DefaultTableModel();

        model1.addColumn("Index");
        model1.addColumn("Item Name");
        model1.addColumn("Price");
        model1.addColumn("Date");




        if(SuperFoodItems.getFoodItemCount()!=0) {
            for (int i = 0; i < SuperFoodItems.getFoodItemCount(); i++) {
                String s0, s1, s2,s3;
                s0 = String.valueOf(i);
                s1 = SuperFoodItems.getFoodItemsName(i);
                s2 = SuperFoodItems.getFoodItemsPrice(i);
                s3=SuperFoodItems.getFoodItemsDate(i);


                String[] data = {s0, s1, s2,s3};

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
        //Item Name
        table1.getColumnModel().getColumn(1).setMinWidth(180);
        table1.getColumnModel().getColumn(1).setMaxWidth(180);
        //Price
        table1.getColumnModel().getColumn(2).setMinWidth(90);
        table1.getColumnModel().getColumn(2).setMaxWidth(90);
        table1.getColumnModel().getColumn(2).setCellRenderer(Centerrendere);
        //date
        table1.getColumnModel().getColumn(3).setMinWidth(130);
        table1.getColumnModel().getColumn(3).setMaxWidth(130);



        // TODO: place custom component creation code here
    }
}
