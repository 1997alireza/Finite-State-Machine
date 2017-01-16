package com._1997alireza.fsm;

import org.graphviz.GraphDrawer;

import java.util.ArrayList;

public class FiniteStateMachine {
    private int n, startState;
    private ArrayList<Character>[][] rowData;
    private boolean [] finalStates;
    public FiniteStateMachine(int n, ArrayList<Character>[][] rowData /* [startNode] [finishNode] */, int startState, boolean [] finalStates){
        this.n = n;
        this.rowData = rowData;
        this.startState = startState;
        this.finalStates = finalStates;
    }

    public String[] getAdjacencyList(){
        String adjacencyList [] = new String[n];

        for(int i = 0; i < n; i++) {
            adjacencyList[i] = "";
            for (int j = 0; j < n; j++) {
                for (char event : rowData[i][j])
                    adjacencyList[i] += "(" + (j + 1) + "," + event + ") ";
            }
        }
        return adjacencyList;
    }

    private String getDotLang(){
        String graphStr = "";
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                for (char event : rowData[i][j]) {
                    graphStr += (i + 1) + "->" + (j + 1) + "[label = " + event + "] ;";
                }
                if(rowData[i][j].size() == 0)
                    graphStr += (i+1) + ";";
            }

        for(int i = 0; i < n; i++)
            if(finalStates[i])
                graphStr += (i+1) + "[shape = doublecircle];";
        
        graphStr += "start [label = start shape = point ];";
        graphStr += "start -> " + startState + ";";

        return graphStr;
    }

    public String makeGraphModelImage(){
        String fileName = "result";
        GraphDrawer gd = new GraphDrawer();
        gd.draw(fileName, getDotLang());

        return "res/result/" + fileName + ".png";
    }
}
