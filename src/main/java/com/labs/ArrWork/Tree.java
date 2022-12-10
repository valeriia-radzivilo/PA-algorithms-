package com.labs.ArrWork;
import java.util.ArrayList;

public class Tree{
    private final Node root;
    public Node getRoot(){
        return root;
    }
    Tree(Node root){
        this.root = root;
    }
    public void generateBranch(Node parent) {
        int starter = change_value(parent.get_col_list(),0);
        make_node_for_tree(parent,starter,0);
    }
    public void make_tree(Tree tree)
    {
            tree.generateBranch(tree.root);


    }

    public Node make_node_for_tree(Node chilld, int starter, int depth)
    {

        Node chiiild = null;
        for (int j = 0; j < 8; j++) {
            ArrayList<Integer> new_new_list = new ArrayList<>(chilld.get_col_list());
            new_new_list.set(depth, starter);
            chiiild = new Node(new_new_list, depth);
            starter = change_value(new_new_list,depth);
            if(depth<7) make_node_for_tree(chiiild,starter,depth+1);
            chilld.addChild(chiiild);
            starter = change_value(new_new_list, depth);
        }
        return chiiild;
    }

    int change_value(ArrayList<Integer>arrayList, int index)
    {
        int val = arrayList.get(index);
        if(val+1>7)
            val=0;
        else val++;
        return val;
    }
}