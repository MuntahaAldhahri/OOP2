package projectapartment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bill extends JFrame implements ActionListener {


    private JLabel pageTitle = new JLabel("Apartment");


    private JLabel subTotal = new JLabel("SubTotal: ");
    private JLabel getSubTotatResult = new JLabel("0");
    private JLabel tax = new JLabel("Tax: ");
    private JLabel taxResult = new JLabel("0");
    private JLabel total = new JLabel("Total: ");
    private JLabel totalResult = new JLabel("0");


    private JButton submit = new JButton("    PAY    ");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,200,70));
    private JPanel billPanel = new JPanel(new GridLayout(3,2,50,50));


    public Bill(double priceTotal){

        setTitle("Apartment");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pageTitle.setFont(new Font("Serif",Font.BOLD,26));
        mainPanel.add(pageTitle);


        billPanel.add(subTotal);
        billPanel.add(getSubTotatResult);
        billPanel.add(tax);
        billPanel.add(taxResult);
        billPanel.add(total);
        billPanel.add(totalResult);




        submit.setBackground(Color.decode("#1D3240"));
        submit.setForeground(Color.white);
        billPanel.setBackground(Color.decode("#F2DAC4"));
        mainPanel.setBackground(Color.decode("#F2DAC4"));



        mainPanel.add(billPanel);
        mainPanel.add(submit);


        add(mainPanel);


        setVisible(true);



        double tax = priceTotal * 0.15;

        double totalTax = (priceTotal* 0.15) +priceTotal;

        getSubTotatResult.setText(String.valueOf(priceTotal));

        taxResult.setText(String.valueOf(tax));

        totalResult.setText(String.valueOf(totalTax));

        submit.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double total = 0;

        if (e.getSource() == submit){


            JOptionPane.showMessageDialog(null,"Thank you to visit us");
            System.exit(0);

        }

    }
}
