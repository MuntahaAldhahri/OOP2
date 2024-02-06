package projectapartment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LogIn extends JFrame implements ActionListener {



    private JLabel pageTitle = new JLabel("Log In");
    private JLabel idLabel =new JLabel("ID");
    private JLabel passwordLabel = new JLabel("Password");


    private JTextField idField = new JTextField(15);
    private JTextField passwordField = new JTextField(15);


    private JButton logButton = new JButton("Log In");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,100,40));
    private JPanel logInPanel = new JPanel(new GridLayout(2,2,0,50));


    public LogIn(){

        setTitle("Apartment");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pageTitle.setFont(new Font("Serif",Font.BOLD,26));
        mainPanel.add(pageTitle);

        logInPanel.add(idLabel);
        logInPanel.add(idField);
        logInPanel.add(passwordLabel);
        logInPanel.add(passwordField);

        logButton.setBackground(Color.decode("#1D3240"));
        logButton.setForeground(Color.white);


        logInPanel.setBackground(Color.decode("#F2DAC4"));
        mainPanel.setBackground(Color.decode("#F2DAC4"));



        mainPanel.add(logInPanel);
        mainPanel.add(logButton);


        add(mainPanel);


        setVisible(true);

        logButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logButton) {

            if (idField.getText().isEmpty()  || passwordField.getText().isEmpty()){

                JOptionPane.showMessageDialog(null, "You do not enter all information");


            }else {

                try {
                    File file = new File("customers.txt");
                    Scanner read = new Scanner(file);

                    boolean userFound = false;

                    while (read.hasNextLine()){

                        String id = read.nextLine();
                        String pass = read.nextLine();

                        if (id.equals(idField.getText()) && pass.equals(passwordField.getText())){

                            setVisible(false);

                            new Apartments();

                            userFound = true;

                        }

                    }

                    if (!userFound){

                        JOptionPane.showMessageDialog(null,"password or id is not correct");

                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }

        }

    }
}
