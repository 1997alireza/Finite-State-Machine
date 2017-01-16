package com._1997alireza.gui.startframes;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TableFrame extends JFrame{
    private int n;
    private JTable table;
    static Object rowData [][];
    TableFrame(int n){
        this.n = n;
        int width = (n+1) * 120, height = n * 40 + 110;
        setTitle("FSM Table");
        setSize(new Dimension((width > 1000) ? 1000 : width, (height > 1000) ? 1000 : height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        TableFrame.rowData = new Object[n][n+1];
        Object columns [] = new Object[n+1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n+1; j++)
                rowData[i][j] = "";
        columns[0] = "";
        for(int i = 1; i < n+1; i++) {
            columns[i] = i;
            rowData[i-1][0] = i;
        }

        table = new JTable(rowData, columns);
        table.setRowHeight(40);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                TableCellEditor cEditor = table.getCellEditor();
                if(cEditor != null)
                    cEditor.stopCellEditing();

                int n = TableFrame.this.n;
                for(int i = 0; i < n; i++)
                    for(int j = 0; j < n; j++)
                        rowData[i][j+1] = table.getModel().getValueAt(i, j+1);

                (new StateSelectionFrame(TableFrame.this.n)).showFrame();
            }
        });
        add(next, BorderLayout.SOUTH);
    }

    void showTable(){
        setVisible(true);
    }

}
