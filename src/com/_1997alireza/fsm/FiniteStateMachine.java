package com._1997alireza.fsm;

import com._1997alireza.datastructures.ArraySet;
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

    public boolean testString(String testString){
        testString = testString.toUpperCase();

        ArraySet<Integer> presentStates = new ArraySet<>();
        presentStates.add(startState-1);
        ArraySet<Integer> nextStates = new ArraySet<>();

        for(char c : testString.toCharArray()){
            if(presentStates.size() == 0)
                return false;

            for(int n : presentStates){
                ArrayList<Character> [] nexts = rowData[n];
                for(int i = 0; i < nexts.length; i++){
                    if(nexts[i].contains(c))
                        nextStates.add(i);
                }
            }

            presentStates.clear();
            for(int i = 0; i < nextStates.size(); i++)
                presentStates.add(nextStates.get(i));
            nextStates.clear();
        }

        for(int n : presentStates){
            if(finalStates[n])
                return true;
        }

        return false;

    }

    public boolean hasCycle(){
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(startState-1);
        return hasCycle(visited, startState-1);
    }

    private boolean hasCycle(ArrayList<Integer> visited, int pState){
        for(int i = 0; i < n; i++){
            if(rowData[pState][i].size() != 0){
                if(visited.contains(i))
                    return true;

                visited.add(i);
                if(hasCycle(visited, i))
                    return true;

                visited.remove((Object)i);

            }
        }
        return false;
    }
}
