package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class new_patient extends JFrame implements ActionListener {
    JComboBox<String> comboBox;
    JTextField textfieldNumber, textfieldName, textfieldDisease, textfieldDeposit, textfieldPrice;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    new_patient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Load and scale the image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);

        // Create a JLabel with the scaled image
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        // Form heading
        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20)); // Corrected "Tohoma" to "Tahoma"
        panel.add(labelName);

        // Form ID
        JLabel labelID = new JLabel("ID Type:");
        labelID.setBounds(35, 74, 200, 20);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"Aadhar No.", "Voter ID", "Driving Licence"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.black);
        panel.add(comboBox);

        // Number
        JLabel labelNumber = new JLabel("ID Number:");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textfieldNumber = new JTextField();
        textfieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textfieldNumber);

        // Name
        JLabel labelName1 = new JLabel("Patient Name:");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textfieldName = new JTextField();
        textfieldName.setBounds(271, 151, 150, 20);
        panel.add(textfieldName);

        // Gender
        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        r1.setBackground(new Color(109, 164, 170));
        r1.setForeground(Color.white);
        r1.setBounds(271, 191, 80, 12);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        r2.setBackground(new Color(109, 164, 170));
        r2.setForeground(Color.white);
        r2.setBounds(341, 191, 100, 12);
        panel.add(r2);

        // Button group for gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        // Disease
        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textfieldDisease = new JTextField();
        textfieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textfieldDisease);

        // Room
        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelRoom.setForeground(Color.WHITE); // Changed to white for better visibility
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room where avalibility = 'Availabil'");

            while (resultSet.next()) {
                c1.add(resultSet.getString("Room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(270, 274, 145, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        c1.setForeground(Color.black);
        c1.setBackground(Color.white);
        panel.add(c1);

        // Price
        JLabel labelPrice = new JLabel("Price:");
        labelPrice.setBounds(35, 314, 200, 14);
        labelPrice.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelPrice.setForeground(Color.WHITE);
        panel.add(labelPrice);

        textfieldPrice = new JTextField();
        textfieldPrice.setBounds(271, 314, 150, 20);
        textfieldPrice.setEditable(false);
        panel.add(textfieldPrice);

        // Deposit
        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(35, 354, 200, 14);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14)); // Corrected "Tohoma" to "Tahoma"
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textfieldDeposit = new JTextField();
        textfieldDeposit.setBounds(271, 354, 150, 20);
        panel.add(textfieldDeposit);

        // Add button
        b1 = new JButton("ADD");
        b1.setBounds(140, 430, 100, 30);
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        b1.addActionListener(this);
        panel.add(b1);

        // Cancel button
        b2 = new JButton("Cancel");
        b2.setBounds(250, 430, 100, 30);
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        b2.addActionListener(this);
        panel.add(b2);

        // Add item listener to Choice component
        c1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRoom = c1.getSelectedItem();
                    updatePrice(selectedRoom);
                }
            }
        });

        // Frame settings
        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    private void updatePrice(String roomNumber) {
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select price from Room where Room_number = '" + roomNumber + "'");
            if (resultSet.next()) {
                String price = resultSet.getString("price");
                textfieldPrice.setText(price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new new_patient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBtn = null;
            if (r1.isSelected()) {
                radioBtn = "Male";
            } else if (r2.isSelected()) {
                radioBtn = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textfieldNumber.getText();
            String s3 = textfieldName.getText();
            String s4 = radioBtn;
            String s5 = textfieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = textfieldPrice.getText();
            String s8 = textfieldDeposit.getText();

            try {
                String q = "insert into patient_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1 = "update Room set avalibility = 'Occupied' where Room_number = " + s6;
                c.statement.executeUpdate(q); // Changed to executeUpdate
                c.statement.executeUpdate(q1); // Changed to executeUpdate

                JOptionPane.showMessageDialog(null, "Added successfully.");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
