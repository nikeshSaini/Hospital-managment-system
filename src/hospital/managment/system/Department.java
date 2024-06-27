package hospital.managment.system;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    JTable table;

    Department() {
        // Create and configure the panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 620, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Create table and fetch data from database
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 600, 400);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String query = "select * from Department";
            ResultSet resultSet = c.statement.executeQuery(query);

            // Use DbUtils to populate the table with result set data
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add a title label
        JLabel titleLabel = new JLabel("Department Information");
        titleLabel.setBounds(140, 20, 400, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        panel.add(titleLabel);

        // Add cancel button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(240, 500, 120, 30);
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
        setSize(630, 550);
        setLayout(null);
        setLocation(280, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To close the application on exit
    }

    public static void main(String[] args) {
        new Department();
    }
}
