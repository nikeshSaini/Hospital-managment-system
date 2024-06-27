package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){
        // Upper Panel
        JPanel panelupper = new JPanel();
        panelupper.setLayout(null);
        panelupper.setBounds(5, 5, 1525, 150);
        panelupper.setBackground(new Color(109, 164, 170));
        add(panelupper);

        // Doctor Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300, 0, 220, 250);
        panelupper.add(label);

        // Ambulance Image
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1 = i12.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label2 = new JLabel(i22);
        label2.setBounds(1000, 50, 300, 100);
        panelupper.add(label2);

        //Add patient Button
        JButton btn1 = new JButton("Add new Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panelupper.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new new_patient();
            }
        });

        //Room
        JButton btn2 = new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        panelupper.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        //Department
        JButton btn3 = new JButton("Department");
        btn3.setBounds(30,101,200,30);
        btn3.setBackground(new Color(246,215,118));
        panelupper.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });


        //All EmployeeInfo
        JButton btn21 = new JButton("All EmployeeInfo");
        btn21.setBounds(270,15,200,30);
        btn21.setBackground(new Color(246,215,118));
        panelupper.add(btn21);
        btn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        //All Patient info
        JButton btn22 = new JButton("All Patient Info");
        btn22.setBounds(270,58,200,30);
        btn22.setBackground(new Color(246,215,118));
        panelupper.add(btn22);
        btn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });

        //Patient discharge
        JButton btn23 = new JButton("Patient Discharge");
        btn23.setBounds(270,101,200,30);
        btn23.setBackground(new Color(246,215,118));
        panelupper.add(btn23);
        btn23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        //Update Patient Info
        JButton btn11 = new JButton("Update Patient Info");
        btn11.setBounds(510,15,200,30);
        btn11.setBackground(new Color(246,215,118));
        panelupper.add(btn11);
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_info();

            }
        });

        //Hospital ambulance
        JButton btn12 = new JButton("Hospital ambulance");
        btn12.setBounds(510,58,200,30);
        btn12.setBackground(new Color(246,215,118));
        panelupper.add(btn12);
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //search room
        JButton btn13 = new JButton("search room");
        btn13.setBounds(510,101,200,30);
        btn13.setBackground(new Color(246,215,118));
        panelupper.add(btn13);
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new searchroom();

            }
        });


        //Logout
        JButton btn31 = new JButton("Logout");
        btn31.setBounds(750,15,200,30);
        btn31.setBackground(new Color(246,215,118));
        panelupper.add(btn31);
        btn31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
            }
        });





        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);


        // Frame settings
        setSize(1920, 1080);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
