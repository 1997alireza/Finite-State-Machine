package com._1997alireza.gui.workingframes;

import javax.swing.*;
import java.awt.*;

class GraphModelFrame extends JDialog {
    GraphModelFrame(String imagePath){
        setTitle("Graph Model");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        java.awt.Image image = Toolkit.getDefaultToolkit().createImage(imagePath);
        ImageIcon imageIcn = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcn);
        add(imageLabel);
        setSize(image.getWidth(null) + 15, image.getHeight(null) + 50);
    }

    void showFrame(){
        setVisible(true);
    }
}
