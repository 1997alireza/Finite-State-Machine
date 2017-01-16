package com._1997alireza.gui.workingframes;

import com._1997alireza.fsm.FiniteStateMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWorkingFrame extends JFrame{
    private FiniteStateMachine finiteStateMachine;

    public MainWorkingFrame(final FiniteStateMachine finiteStateMachine){
        this.finiteStateMachine = finiteStateMachine;
        this.setSize(580, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Finite State Machine");
        setLayout(null);

        JButton adjacencyListB = new JButton("Show Adjacency List");
        adjacencyListB.setSize(200, 50);
        adjacencyListB.setLocation(10, 10);
        adjacencyListB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new AdjacencyListFrame(MainWorkingFrame.this.finiteStateMachine.getAdjacencyList())).showTable();
            }
        });
        add(adjacencyListB);

        JButton graphModelB = new JButton("Show Graph Model");
        graphModelB.setSize(200, 50);
        graphModelB.setLocation(220, 10);
        graphModelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new GraphModelFrame(finiteStateMachine.makeGraphModelImage())).showFrame();
            }
        });
        add(graphModelB);
    }

    public void showFrame(){
        setVisible(true);
    }
}
