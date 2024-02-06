/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapartment;


import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectApartment extends JFrame implements ActionListener {

    private JLabel pageTitle = new JLabel("Log Up");
    private JLabel idLabel = new JLabel("ID");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel phoneLabel = new JLabel("Phone");
    private JLabel passwordLabel = new JLabel("Password");


    private JTextField idField = new JTextField(15);
    private JTextField nameField = new JTextField(15);
    private JTextField phoneField = new JTextField(15);
    private JTextField passwordField = new JTextField(15);


    private JButton logButton = new JButton("Log Up");
    private JButton logInButton = new JButton("Log In");


    private JMenuBar menu = new JMenuBar();

    private JMenu filemenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");

    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem contact_us = new JMenuItem("Contact Us");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 250, 40));
    private JPanel logUpPanel = new JPanel(new GridLayout(4, 2, 0, 50));


    public ProjectApartment() {

        setTitle("Apartment");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pageTitle.setFont(new Font("Serif", Font.BOLD, 26));
        mainPanel.add(pageTitle);

        logUpPanel.add(idLabel);
        logUpPanel.add(idField);
        logUpPanel.add(nameLabel);
        logUpPanel.add(nameField);
        logUpPanel.add(phoneLabel);
        logUpPanel.add(phoneField);
        logUpPanel.add(passwordLabel);
        logUpPanel.add(passwordField);

        logButton.setBackground(Color.decode("#1D3240"));
        logButton.setForeground(Color.white);

        logInButton.setBackground(Color.decode("#1D3240"));
        logInButton.setForeground(Color.white);


        logUpPanel.setBackground(Color.decode("#F2DAC4"));
        mainPanel.setBackground(Color.decode("#F2DAC4"));


        mainPanel.add(logUpPanel);
        mainPanel.add(logButton);
        mainPanel.add(logInButton);

        filemenu.add(close);
        helpMenu.add(contact_us);
        menu.add(filemenu);
        menu.add(helpMenu);


        setJMenuBar(menu);


        add(mainPanel);


        setVisible(true);

        logButton.addActionListener(this);
        logInButton.addActionListener(this);
        close.addActionListener(this);

        contact_us.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logButton) {

            if (idField.getText().isEmpty()  || passwordField.getText().isEmpty()){

                JOptionPane.showMessageDialog(null, "You do not enter all information");


            }else {

                try {
                    FileWriter file= new FileWriter("customers.txt",true);

                    file.write(idField.getText()+"\n");
                    file.write(passwordField.getText()+"\n");

                    file.close();

                    setVisible(false);

                    new Apartments();

                } catch (Exception exception) {
                    exception.printStackTrace();
                }


            }

        }
        if (e.getSource() == close){

            System.exit(0);

        }if (e.getSource() == contact_us){

            JOptionPane.showMessageDialog(null,"Phone: 966545454547");

        }

        if (e.getSource() == logInButton){

            setVisible(false);

            new LogIn();

        }

    }


    public static void main(String[] args) {
         new ProjectApartment();


    }


}
