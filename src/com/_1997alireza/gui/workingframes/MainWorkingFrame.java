package com._1997alireza.gui.workingframes;

import com._1997alireza.fsm.FiniteStateMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWorkingFrame extends JFrame{
    private FiniteStateMachine finiteStateMachine;

    public MainWorkingFrame(final FiniteStateMachine finiteStateMachine){
        this.finiteStateMachine = finiteStateMachine;
        this.setSize(770, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finite State Machine");
        setLayout(null);

        JButton adjacencyListB = new JButton("Show Adjacency List");
        adjacencyListB.setSize(200, 30);
        adjacencyListB.setLocation(10, 10);
        adjacencyListB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new AdjacencyListFrame(MainWorkingFrame.this.finiteStateMachine.getAdjacencyList())).showTable();
            }
        });
        add(adjacencyListB);

        JButton graphModelB = new JButton("Show Graph Model");
        graphModelB.setSize(200, 30);
        graphModelB.setLocation(10, 90);
        graphModelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new GraphModelFrame(finiteStateMachine.makeGraphModelImage())).showFrame();
            }
        });
        add(graphModelB);

        final JTextField testString = new JTextField();
        testString.setSize(250, 30);
        testString.setLocation(300, 10);
        add(testString);

        final JLabel testResult = new JLabel();
        testResult.setSize(100, 30);
        testResult.setLocation(720, 10);
        add(testResult);

        JButton testStringB = new JButton("Test String");
        testStringB.setSize(150, 30);
        testStringB.setLocation(560, 10);
        testStringB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testResult.setText(String.valueOf(finiteStateMachine.testString(testString.getText())));
            }
        });
        add(testStringB);

        final JLabel checkCycleResult = new JLabel();
        checkCycleResult.setSize(100, 30);
        checkCycleResult.setLocation(720, 90);
        add(checkCycleResult);

        JButton checkCycleB = new JButton("Check Cycle");
        checkCycleB.setSize(150, 30);
        checkCycleB.setLocation(560, 90);
        checkCycleB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCycleResult.setText(String.valueOf(finiteStateMachine.hasCycle()));
            }
        });
        add(checkCycleB);

        JButton deleteCyclesB = new JButton("Delete Cycles");
        deleteCyclesB.setSize(150, 30);
        deleteCyclesB.setLocation(560, 170);
        deleteCyclesB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finiteStateMachine.deleteCycles();
            }
        });
        add(deleteCyclesB);


    }

    public void showFrame(){
        setVisible(true);
    }
}
