package com._1997alireza.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame{
    private int number = 1;
    private JButton numberLabel;
    private MainFrame(){
        this.setSize(new Dimension(280, 90));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("FSM");
        setLayout(null);

        JLabel text = new JLabel("Enter number of nodes : ");
        text.setSize(160, 50);
        text.setLocation(10,0);
        add(text);

        JButton downer = new JButton("-");
        downer.setMargin(new Insets(-10,-10,-5,-10));
        downer.setSize(20,20);
        downer.setLocation(180, 15);
        downer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(number > 1) {
                    number--;
                    numberLabel.setText(String.valueOf(number));
                }
            }
        });
        add(downer);

        JButton upper = new JButton("+");
        upper.setMargin(new Insets(-10,-10,-10,-10));
        upper.setSize(20,20);
        upper.setLocation(230, 15);
        upper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number++;
                numberLabel.setText(String.valueOf(number));
            }
        });
        add(upper);

        numberLabel = new JButton("1");
        numberLabel.setSize(20,20);
        numberLabel.setMargin(new Insets(-10,-10,-10,-10));
        numberLabel.setLocation(205,15);
        numberLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TableFrame tf = new TableFrame(number);
                tf.showTable();
            }
        });
        add(numberLabel);
    }

    private void showFrame(){
        setVisible(true);
    }

    public static void main(String[] args) {
        (new MainFrame()).showFrame();
    }
}
