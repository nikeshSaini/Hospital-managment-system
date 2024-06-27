package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Patient_info extends JFrame {
    JTable table;
    Patient_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        // Create table and fetch data from database
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 970, 450);
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String query = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(query);

            // Use DbUtils to populate the table with result set data
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add a title label
        JLabel titleLabel = new JLabel("Patient Information");
        titleLabel.setBounds(350, 20, 400, 30);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        panel.add(titleLabel);

        // Add cancel button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(420, 550, 120, 30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        panel.add(cancel);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(280, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Patient_info();
    }
}
