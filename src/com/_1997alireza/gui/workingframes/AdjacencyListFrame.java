package com._1997alireza.gui.workingframes;

import javax.swing.*;
import java.awt.*;

class AdjacencyListFrame extends JDialog {
    AdjacencyListFrame(String[] adjacencyList) {
        setTitle("Adjacency List");
        setSize(280, 80 + adjacencyList.length * 40);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);


        String rowData [][] = new String[adjacencyList.length][2];

        for(int i = 0; i < adjacencyList.length; i++){
            rowData[i][0] = String.valueOf(i + 1);
            rowData[i][1] = adjacencyList[i];
        }

        String columns [] = {"State", "Adjacent"};
        JTable table = new JTable(rowData, columns);
        table.getColumnModel().getColumn(0).setMaxWidth(45);
        table.setRowHeight(40);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    void showTable(){
        setVisible(true);
    }
}
