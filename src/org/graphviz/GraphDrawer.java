/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.graphviz;

import java.io.File;

public class GraphDrawer {

    /**
     * Construct a DOT graph in memory, convert it to image and store the image
     * in the file system.
     * @param graph
     */
    public void draw(String fileName, String graph) {
        GraphViz gv = new GraphViz();
        gv.addln(gv.start_graph());
        gv.add(graph);
//        gv.addln("A -> B;");
//        gv.addln("A -> C;");
        gv.addln(gv.end_graph());
//        System.out.println(gv.getDotSource());

        gv.increaseDpi();   // 106 dpi

//        String type = "gif";
		//      String type = "dot";
        //      String type = "fig";    // open with xfig
        //      String type = "pdf";
        //      String type = "ps";
        //      String type = "svg";    // open with inkscape
              String type = "png";
        //      String type = "plain";

        String repesentationType = "dot";
		//		String repesentationType= "neato";
        //		String repesentationType= "fdp";
        //		String repesentationType= "sfdp";
        // 		String repesentationType= "twopi";
        // 		String repesentationType= "circo";

//		File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
        final String directory = "res/result/";
        File out = new File(directory + fileName + "." + type);    // Windows
        gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
    }
}