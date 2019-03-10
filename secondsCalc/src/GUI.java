
import javafx.scene.control.ColorPicker;
import org.w3c.dom.css.RGBColor;

import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

public class GUI {

    private int WIDTH = 600;
    private int HEIGHT = 60;


    private JFrame frame;
    private JPanel panel;

    private JLabel enterMoneyLabel, outputLabel, dot, quarterLabel, dimeLabel, nickelLabel, pennieLabel, blank;
    private JTextField dollarTextField, centsTextField;



    public GUI() {
        //Creates a new GUI frame with panel

        //When a new GUI is created, setup frame
        frame  = new JFrame("Efficient Coin");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enterMoneyLabel = new JLabel("Enter Money: $");
       outputLabel = new JLabel(" Powered by Sando Software...  ");
        dot = new JLabel(".");

        quarterLabel = new JLabel("Quarters: ____ " );
        dimeLabel = new JLabel("Dimes:_____");
        nickelLabel = new JLabel("Nickels:____");
        pennieLabel = new JLabel("Pennies:_____");
        blank = new JLabel("     ");

        dollarTextField = new JTextField(3);
        dollarTextField.addActionListener(new Lisener());

        centsTextField = new JTextField(3);
        centsTextField.addActionListener(new Lisener());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.ORANGE);


        panel.add(enterMoneyLabel, BorderLayout.CENTER);
        panel.add(dollarTextField, BorderLayout.CENTER);
        panel.add(dot, BorderLayout.CENTER);
        panel.add(centsTextField, BorderLayout.CENTER);

        panel.add(quarterLabel);
        panel.add(dimeLabel);
        panel.add(nickelLabel);
        panel.add(pennieLabel);
        panel.add(blank);


        panel.add(outputLabel);




        frame.getContentPane().add(panel);



    }



    public class Lisener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            calcChange();


        }

    }


    public void display() {

        frame.pack();
        frame.setVisible(true);
    }


    public void calcChange() {

        int dollars, cents;

        //This is our dollar value
        double $ = Double.parseDouble(dollarTextField.getText());
        dollars = (int)($/1);
        System.out.println("Dollars: " + dollars);



        //This is our centss
        cents = Integer.parseInt(centsTextField.getText());
        System.out.println("Cents: " + cents);


        System.out.println("______SANDO__ALGORITHM________");


        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        int QUARTER = 25;
        int DIME = 10;
        int NICKEL = 5;
        int PENNIE = 1;


        //Loop find most Q's

        for (int i = 1;  i <= cents; i++) {

            if (i % 25 == 0) {

                System.out.println(" Extracting Quarters...");




                quarters+=1;
            }

        }

        //adjust cents

        cents = cents - (QUARTER * quarters);
        System.out.println("cents after quarter check " + cents);




        //Loop find most D's

        for (int i = 1;  i <= cents; i++) {

            if (i % 10 == 0) {

                System.out.println("Extracting Dimes... ");

                dimes+=1;
            }

        }

        //adjust cents

        cents = cents - (DIME * dimes);
        System.out.println("cents after dime check: " + cents);



        //Loop find most N's

        for (int i = 1;  i <= cents; i++) {

            if (i % 5 == 0) {

                System.out.println("Extracting Nickels...");



                nickels+=1;
            }

        }

        //adjust cents

        cents = cents - (NICKEL * nickels);
        System.out.println("cents after nickel check: " + cents);



        //Loop final P's
        for (int i = 1;  i <= cents; i++) {

            if (i % 1 == 0) {

                System.out.println("Extracting Pennies...");


                pennies+=1;
            }

        }

        //adjust price -> should always print 0 meaning completion
        cents = cents - (PENNIE * pennies);
        System.out.println("cents after pennie check: " + cents);





        System.out.println("________Efficient Coin_____");



    System.out.println("Quarters:  " + quarters);
        quarterLabel.setText("Quarters:  "+ quarters);
    System.out.println("Dimes: " + dimes);
        dimeLabel.setText("Dimes:  " + dimes);
    System.out.println("Nickles: " + nickels);
        nickelLabel.setText("Nickles: " + nickels);
    System.out.print("Pennies: " + pennies);
        pennieLabel.setText("Pennies: " + pennies);




    }






}
