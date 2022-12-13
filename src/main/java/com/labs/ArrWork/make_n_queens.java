package com.labs.ArrWork;

import java.util.ArrayList;

public class make_n_queens {
    public static int[] make_n_queens(int n, boolean isRand, int[] notrand, int method) {
        int [ ] initial_placement = new int[n];
        if(isRand)
            initial_placement = ArrWork.make_rand_int_arr(n);
        else
            initial_placement =notrand.clone();

        System.out.println("Initial task: ");
        ArrWork.create_matr(initial_placement,n);

        System.out.println("F2: "+F2.F2(initial_placement,8));

        ArrayList<Integer> init_list = ArrWork.array_to_list(initial_placement);
        Tree tree = new Tree(new Node(init_list,0));
        tree.make_tree(tree);
        int[] answer = new int[8];
        if(method==0)
        {
            ArrayList<Integer> answer_bfs = BFS(tree);
            answer = ArrWork.arrlist_to_arr(answer_bfs);
        }

        else {
            ArrayList<Node> min_conflicts = new ArrayList<>();
            ArrayList<Tree> trees_in_mem = new ArrayList<>();
            ArrayList<Integer> answer_rbfs = null;

            answer_rbfs = RBFS(tree, min_conflicts, trees_in_mem, 0, tree, 0, answer_rbfs);
            answer = ArrWork.arrlist_to_arr(answer_rbfs);

        }

        return answer;
    }


    static ArrayList<Integer> BFS(Tree tree)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        answer = check_every_child(tree.getRoot().getChildren());
        if(answer==null) {

            ArrayList<Node> children_to_check = new ArrayList<>();
            children_to_check = tree.getRoot().getChildren();
            int iterator = 0;
            while(iterator<100) {
                ArrayList<Node> get_children = new ArrayList<>();
                for (Node child : children_to_check) {
                    answer = check_every_child(child.getChildren());
                    if(answer!=null)
                    {
                        return answer;
                    }
                    for(Node c: child.getChildren())
                        get_children.add(c);

                }
                children_to_check = get_children;
                iterator++;

            }
        }


        return answer;
    }

    static ArrayList<Integer> check_every_child(ArrayList<Node> children_to_check)
    {
        ArrayList<Integer> check = null;
            check = check_children(children_to_check);
            if (check != null) return check;
        return check;
    }

    static ArrayList<Integer> check_children (ArrayList<Node>children)
    {
        for(Node child:children)
        {
            if(!child.visited) {
                if (check_placement(child.get_col_list())) {
                    System.out.println("FOUND");
                    return child.get_col_list();
                }
                child.setVisited(true);
            }
        }
        return null;
    }


    static boolean check_placement(ArrayList<Integer>list)
    {
        int[]already_placed = new int[8];
        int iter =0;
        for(int i:list)
        {
            if(ArrWork.place(iter,i,already_placed)) {
                already_placed[iter] = i;
                iter++;
            }
            else break;
        }
        return iter == 8;
    }


    static ArrayList<Integer> RBFS(Tree tree, ArrayList<Node>min_conflicts, ArrayList<Tree> trees_in_mem, int iter, Tree primary_tree, int counter, ArrayList<Integer> answer){
        if(answer!=null)
            return answer;
        if(counter<1000)
        {
            if (trees_in_mem.size()>1&&counter%100==0)
            {
                Tree new_tree = trees_in_mem.get(0);
                trees_in_mem = new ArrayList<>();
                trees_in_mem.add(new_tree);
                Node min = min_conflicts.get(0);
                min_conflicts= new ArrayList<>();
                min_conflicts.add(min);
                answer = RBFS(new_tree,min_conflicts,trees_in_mem,iter=1, primary_tree,counter++,answer);
                if(answer!=null)
                    return answer;
            }
            if(counter%200==0)
            {
                trees_in_mem = new ArrayList<>();
                min_conflicts = new ArrayList<>();
                answer = RBFS(primary_tree,min_conflicts,trees_in_mem,iter =0,primary_tree,counter+=1,answer);
                if(answer!=null)
                    return answer;
            }
            Node start = choose_less_conflict_in_list(tree.getRoot().getChildren());
            if(start!=null && start.amount_of_conflicts==0)
            {
                System.out.println("FOUND");

                return answer= start.get_col_list();
            }
            else{
                if(start!=null &&(start.getDepth()==0 || start.getConflicts()<= find_min_node(min_conflicts).getConflicts()) ) {
                    Tree new_tree = new Tree(start);
                    trees_in_mem.add(new_tree);
                    min_conflicts.add(start);

                    answer = RBFS(new_tree,min_conflicts,trees_in_mem,iter+=1,primary_tree,counter+=1,answer);
                    if(answer!=null)
                        return answer;
                }
                else if(trees_in_mem.size()>1){
                    trees_in_mem.remove(trees_in_mem.size()-1);
                    min_conflicts.remove(min_conflicts.size()-1);
                    Tree new_tree = trees_in_mem.get(trees_in_mem.size()-1);

                    answer = RBFS(new_tree, min_conflicts,trees_in_mem,iter-=1,primary_tree,counter+=1,answer);
                    if(answer!=null)
                        return answer;
                }
                else {
                    counter =200;
                    answer = RBFS(null, min_conflicts,trees_in_mem,iter-=1,primary_tree,counter,answer);
                }
            }
            if(answer!=null)
                return answer;
        }

        return answer;
    }


    static Node find_min_node(ArrayList<Node> nodes)
    {
        int min = 10000;
        Node f_ans = null;
        for(Node n: nodes)
        {
            if(n.getConflicts()<min)
            {
                min = n.getConflicts();
                f_ans=n;

            }
        }
        if(f_ans!=null) f_ans.setVisited(true);
        return f_ans;
    }


    static Node choose_less_conflict_in_list(ArrayList<Node> nodes)
    {
        int min = 10000;
        Node f_ans = null;
        for(Node n: nodes)
        {
            if(n.getConflicts()<min&&!n.visited)
            {
                min = n.getConflicts();
                f_ans=n;

            }
        }
        if(f_ans!=null) f_ans.setVisited(true);
        return f_ans;
    }

}
