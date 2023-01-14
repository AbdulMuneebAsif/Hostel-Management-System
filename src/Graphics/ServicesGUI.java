package Graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicesGUI extends JFrame {
    private JButton FoodItemsButton;
    private JPanel panel1;
    private JButton BackButton;
    private JButton AssignRoomButton;
    private JButton complainsButton;

    public ServicesGUI()
    {
        setSize(1026,720);
        add(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminGUI().setVisible(true);
            }
        });
        FoodItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FoodItemsGUI().setVisible(true);
                dispose();
            }
        });
        AssignRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssignRoomGUI().setVisible(true);
                dispose();
            }
        });
        complainsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ComplainGUI().setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
