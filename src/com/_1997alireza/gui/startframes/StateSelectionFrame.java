package com._1997alireza.gui.startframes;

import com._1997alireza.fsm.FiniteStateMachine;
import com._1997alireza.gui.workingframes.MainWorkingFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class StateSelectionFrame extends JFrame {
    private int startStateNum = 1;
    private JCheckBox finalStateChecks [];
    private JLabel numberLabel;
    private int n;

    StateSelectionFrame(int n){
        this.n = n;
        this.setSize(new Dimension(405 , 145 + ((n > 10) ? (30 * ((n-6)/5)) : 20)));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select start and final states");
        setLayout(null);

        final JLabel startStateLabel = new JLabel("Choose start state");
        startStateLabel.setSize(160, 50);
        startStateLabel.setLocation(10, 0);
        add(startStateLabel);

        JButton downer = new JButton("-");
        downer.setMargin(new Insets(-10,-10,-5,-10));
        downer.setSize(20,20);
        downer.setLocation(25, 45);
        downer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(startStateNum > 1) {
                    startStateNum--;
                    numberLabel.setText(String.valueOf(startStateNum));
                }
            }
        });
        add(downer);

        JButton upper = new JButton("+");
        upper.setMargin(new Insets(-10,-10,-10,-10));
        upper.setSize(20,20);
        upper.setLocation(75, 45);
        upper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(startStateNum < StateSelectionFrame.this.n) {
                    startStateNum++;
                    numberLabel.setText(String.valueOf(startStateNum));
                }
            }
        });
        add(upper);

        numberLabel = new JLabel("1");
        numberLabel.setSize(20,20);
        numberLabel.setLocation(55,45);
        add(numberLabel);

        final JLabel finalStateLabel = new JLabel("Choose final state(s)");
        finalStateLabel.setSize(160, 50);
        finalStateLabel.setLocation(230 , 0);
        add(finalStateLabel);

        finalStateChecks = new JCheckBox[n];
        for(int i = 0; i < n; i++){
            finalStateChecks[i] = new JCheckBox(String.valueOf(i + 1));
            finalStateChecks[i].setSize(40, 30);
            finalStateChecks[i].setLocation((i % 5) * 40 + 190, (i / 5) * 30 + 40);
            add(finalStateChecks[i]);
        }

        JButton finishB = new JButton("Finish");
        finishB.setLocation(15, 75 + ((n > 10) ? (30 * ((n-6)/5)) : 15));
        finishB.setSize(100, 30);
        finishB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                int n = StateSelectionFrame.this.n;
                ArrayList<Character>[][] mainRowData = new ArrayList[n][n];
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++) {
                        String data[] = ((String) TableFrame.rowData[i][j + 1]).replace(" ", "").toUpperCase().split(",");
                        ArrayList<Character> chars = new ArrayList<>();
                        for (String aData : data) {
                            if(aData.length() != 0)
                                chars.add(aData.charAt(0));
                        }

                        mainRowData[i][j] = chars;
                    }

                boolean finalStates [] = new boolean[n];
                for(int i = 0; i < n; i++)
                    finalStates[i] = finalStateChecks[i].isSelected();

                (new MainWorkingFrame(new FiniteStateMachine(n, mainRowData, startStateNum, finalStates))).showFrame();
            }
        });
        add(finishB);
    }

    void showFrame(){
        setVisible(true);
    }
}
