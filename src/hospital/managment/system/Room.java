package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class Room extends JFrame {
    private JTable table;

    public Room() {
        // Create and configure the panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Create and add the image label
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(600, 200, 200, 200); // Adjusted image position
        panel.add(label);

        // Create table and fetch data from database
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 500, 400);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String query = "select * from Room";
            ResultSet resultSet = c.statement.executeQuery(query);

            // Use DbUtils to populate the table with result set data
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add a title label
        JLabel titleLabel = new JLabel("Room Information");
        titleLabel.setBounds(180, 20, 260, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);


        JButton cancel = new JButton("cancel");
        cancel.setBounds(200,500,120,30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        panel.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        // Frame settings
        setUndecorated(true);
        setSize(900, 600);
        setLocation(300, 250);// Center the frame on screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To close the application on exit
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Room()); // Create and display the Room frame on the Event Dispatch Thread
    }
}
