package com.labs.ArrWork;

import java.util.ArrayList;

public class Node {
    private final ArrayList<Integer> col_list;
    private final int depth;
    private final ArrayList<Node> children ;
    int amount_of_conflicts;

    boolean visited = false;

    Node(ArrayList<Integer> col_list, int depth){
        this.col_list = col_list;
        this.children = new ArrayList<>();
        this.depth = depth;
        this.amount_of_conflicts = F2.F2(ArrWork.arrlist_to_arr(col_list),8)+ArrWork.amount_of_duplicates_in_arrlist(col_list,depth)*10;
    }

    public int getConflicts ()
    {
        return this.amount_of_conflicts;
    }
    public void setVisited(boolean val)
    {
        visited = val;
    }
    public ArrayList<Integer> get_col_list(){
        return col_list;
    }



    public void addChild(Node child){
        children.add(child);
    }
    public ArrayList<Node> getChildren() {
        return children;
    }

    public int getDepth() {
        return depth;
    }
}