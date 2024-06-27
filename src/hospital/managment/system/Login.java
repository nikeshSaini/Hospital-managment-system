package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;
    Login() {

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.black);
        add(namelabel);

        //for password

        JLabel passlabel = new JLabel("Password");
        passlabel.setBounds(40, 70, 100, 30);
        passlabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        passlabel.setForeground(Color.black);
        add(passlabel);


        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma", Font.BOLD, 16));
        textField.setBackground(new Color(255,170,0));
        add(textField);

        //password field
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.BOLD, 16));
        jPasswordField.setBackground(new Color(255, 170, 0));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1= new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300,-80,400,400);
        add(label);

        // Login Button
        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Serif", Font.BOLD, 16));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        // Sign Up Button
        b2 = new JButton(" Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Serif", Font.BOLD, 16));
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(109,164,170));
        setSize(750, 300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Optional: to close the application when the frame is closed
    }

    public static void main(String[] args) {
        // Create an instance of Login to display the frame
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //b2 is for cancel button
        if(e.getSource() == b2){
            try{
                System.exit(10);
            }catch(Exception err){
                err.printStackTrace();
            }
        }



        if(e.getSource() ==b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String pass = jPasswordField.getText();


                String q = "Select * from login where id ='"+user+"' and pass ='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid credentials");
                }

            }catch(Exception err){
                err.printStackTrace();
            }
        }
    }
}
