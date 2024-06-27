package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_info extends JFrame {

    update_patient_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        // Label setup
        JLabel label1 = new JLabel("Update Patient Info");
        label1.setBounds(124, 11, 222, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name: ");
        label2.setBounds(25, 88, 106, 24);
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 100, 25);
        panel.add(choice);
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room No: ");
        label3.setBounds(25, 129, 106, 24);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248, 129, 140, 24);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time: ");
        label4.setBounds(25, 174, 106, 24);
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248, 174, 140, 24);
        panel.add(textField1);

        JLabel label5 = new JLabel("Amount Paid: ");
        label5.setBounds(25, 216, 156, 24);
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248, 216, 140, 24);
        panel.add(textField2);

        JLabel label6 = new JLabel("Amount Pending: ");
        label6.setBounds(25, 256, 206, 24);
        label6.setFont(new Font("Tahoma", Font.BOLD, 20));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 256, 140, 24);
        panel.add(textField3);

        JButton check = new JButton("CHECK");
        check.setBounds(251, 331, 100, 20);
        check.setForeground(Color.black);
        check.setBackground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info WHERE Name = '" + id + "'";

                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        textField.setText(resultSet.getString("Room_number"));
                        textField1.setText(resultSet.getString("Time"));
                        textField2.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("SELECT * FROM room WHERE Room_number = '" + textField.getText() + "'");
                    if (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField2.getText());
                        textField3.setText(String.valueOf(amountPaid));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(51, 331, 100, 20);
        update.setForeground(Color.black);
        update.setBackground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String name = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textField1.getText();
                    String deposit = textField2.getText();
                    c.statement.executeUpdate("UPDATE patient_info SET Room_number = '" + room + "', Time = '" + time + "', Deposit = '" + deposit + "' WHERE Name = '" + name + "'");
                    JOptionPane.showMessageDialog(null, "Patient info updated successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(151, 331, 100, 20);
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
        setSize(950, 500);
        setLayout(null);
        setLocation(350, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new update_patient_info();
    }
}
