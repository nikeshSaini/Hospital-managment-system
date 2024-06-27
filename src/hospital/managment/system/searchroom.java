package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class searchroom extends JFrame {

    private Choice choice;
    private JTable table;

    public searchroom() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(50, 70, 120, 31);
        statusLabel.setForeground(Color.white);
        statusLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(statusLabel);

        choice = new Choice();
        choice.setBounds(170, 73, 120, 20);
        choice.add("Availabil");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 120, 650, 350);
        panel.add(scrollPane);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(320, 70, 80, 20);
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.black);
        searchButton.addActionListener(e -> searchRooms());
        panel.add(searchButton);


        JButton cancel = new JButton("Cancel");
        cancel.setBounds(401, 70, 100, 20);
        cancel.setForeground(Color.black);
        cancel.setBackground(Color.white);
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700, 500);
        setLocationRelativeTo(null); // Centers the frame on the screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void searchRooms() {
        String selectedStatus = choice.getSelectedItem();
        try {
            conn c = new conn();
            String q = "SELECT * FROM room WHERE avalibility = '" + selectedStatus + "'";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new searchroom();
    }
}
