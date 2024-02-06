package projectapartment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Apartments extends JFrame implements ActionListener {



    private JLabel pageTitle = new JLabel("Apartment");

    private ImageIcon imageIcon = new ImageIcon("logo.jpg");
    private JLabel image = new JLabel(imageIcon);

    private JRadioButton aprt1;
    private JRadioButton aprt2;
    private JRadioButton aprt3;
    private JRadioButton aprt4;



    private JButton submit = new JButton("    Submit    ");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,150,30));
    private JPanel ApartPanel = new JPanel(new GridLayout(2,2,50,50));


    public Apartments(){

        setTitle("Apartment");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pageTitle.setFont(new Font("Serif",Font.BOLD,26));


        aprt1 = new JRadioButton("duplex Apartment    3000SAR per month");
        aprt1.setBackground(Color.decode("#658DA6"));
        aprt2 = new JRadioButton("loft apartment      2000SAR per month");
        aprt2.setBackground(Color.decode("#658DA6"));

        aprt3 = new JRadioButton("Garden apartment    3500SAR per month");
        aprt3.setBackground(Color.decode("#658DA6"));

        aprt4 = new JRadioButton("Micro apartment     1500SAR per month");
        aprt4.setBackground(Color.decode("#658DA6"));


        ButtonGroup group = new ButtonGroup();
        group.add(aprt1);
        group.add(aprt2);
        group.add(aprt3);
        group.add(aprt4);

        aprt1.setSelected(true);





        submit.setBackground(Color.decode("#1D3240"));
        submit.setForeground(Color.white);
        ApartPanel.add(aprt1);
        ApartPanel.add(aprt2);
        ApartPanel.add(aprt3);
        ApartPanel.add(aprt4);
        ApartPanel.setBackground(Color.decode("#F2DAC4"));
        mainPanel.setBackground(Color.decode("#F2DAC4"));


        mainPanel.add(image);
        mainPanel.add(pageTitle);

        mainPanel.add(ApartPanel);
        mainPanel.add(submit);


        add(mainPanel);


        setVisible(true);

        submit.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double total = 0;

        if (e.getSource() == submit){


            if (e.getSource() == submit){

                if (aprt1.isSelected()){

                    total+=3000;

                }if (aprt2.isSelected()){

                    total+=2000;

                }if (aprt3.isSelected()){

                    total+=3500;

                }if (aprt4.isSelected()){

                    total+=1500;

                }

                setVisible(false);

                new Bill(total);

            }


        }

    }



}
