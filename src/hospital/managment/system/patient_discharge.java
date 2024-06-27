package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame implements ActionListener {

    Choice choice;
    JLabel RNo, inTime, checkOut, DM, patientName;
    JButton discharge, Check, cancel;

    patient_discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-out");
        label.setBounds(300, 20, 300, 30);
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30, 80, 150, 30);
        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label2);

        choice = new Choice();
        choice.setBounds(200, 80, 150, 30);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel nameLabel = new JLabel("Patient Name");
        nameLabel.setBounds(30, 120, 150, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(nameLabel);

        patientName = new JLabel();
        patientName.setBounds(200, 120, 150, 30);
        patientName.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(patientName);

        JLabel label3 = new JLabel("Room No.");
        label3.setBounds(30, 160, 150, 30);
        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label3);

        RNo = new JLabel();
        RNo.setBounds(200, 160, 150, 30);
        RNo.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(RNo);

        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(30, 200, 150, 30);
        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(label4);

        inTime = new JLabel();
        inTime.setBounds(200, 200, 300, 30);
        inTime.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(inTime);

        JLabel outTime = new JLabel("Check-Out Time");
        outTime.setBounds(30, 240, 200, 30);
        outTime.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(outTime);

        Date date = new Date();
        checkOut = new JLabel("" + date);
        checkOut.setBounds(200, 240, 250, 30);
        checkOut.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(checkOut);

        JLabel deposit = new JLabel("Deposit Money");
        deposit.setBounds(30, 280, 150, 30);
        deposit.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(deposit);

        DM = new JLabel();
        DM.setBounds(200, 280, 150, 30);
        DM.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(DM);



        discharge = new JButton("Discharge");
        discharge.setBounds(30, 340, 120, 30);
        discharge.setBackground(Color.white);
        discharge.setForeground(Color.black);
        discharge.addActionListener(this);
        panel.add(discharge);

        Check = new JButton("Check");
        Check.setBounds(170, 340, 120, 30);
        Check.setBackground(Color.white);
        Check.setForeground(Color.black);
        Check.addActionListener(this);
        panel.add(Check);

        cancel = new JButton("Cancel");
        cancel.setBounds(310, 340, 120, 30);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        panel.add(cancel);

        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(350, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new patient_discharge();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Check) {
            try {
                conn c = new conn();
                String customerID = choice.getSelectedItem();
                String query = "select * from patient_info where Number = '" + customerID + "'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()) {
                    RNo.setText(resultSet.getString("Room_Number"));
                    inTime.setText(resultSet.getString("Time"));
                    DM.setText(resultSet.getString("Deposit"));
                    patientName.setText(resultSet.getString("Name"));
                } else {
                    JOptionPane.showMessageDialog(null, "Customer ID not found");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == discharge) {
            try {
                conn c = new conn();
                String customerID = choice.getSelectedItem();
                String roomNo = RNo.getText();

                String deleteQuery = "delete from patient_info where Number = '" + customerID + "'";
                String updateRoomQuery = "update room set avalibility = 'Availabil' where Room_Number = '" + roomNo + "'";

                c.statement.executeUpdate(deleteQuery);
                c.statement.executeUpdate(updateRoomQuery);

                JOptionPane.showMessageDialog(null, "Patient discharged successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }
}
