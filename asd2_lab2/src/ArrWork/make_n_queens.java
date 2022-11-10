package ArrWork;

public class make_n_queens {
    public static int[] make_n_queens(int n, boolean isRand, int[] notrand)
    {
        int [ ] initial_placement = new int[n];
        if(isRand)
            initial_placement = ArrWork.make_rand_int_arr(n);
        else
            initial_placement =notrand.clone();

        System.out.println("Initial task: ");
        ArrWork.create_matr(initial_placement,n);
        int k =0;
        if(n<8)
            k =n;
        else
            k=n-2;
        Graph gr = new Graph((int) Math.pow(n,k));
        int pairs = F2.F2(initial_placement,n);
        System.out.println("Pairs F2: ");
        System.out.println(pairs);
        Searches.fill_graph(gr,n,initial_placement);
        int[] result = Searches.find_result(gr,n);
        pairs = F2.F2(result,n);
        System.out.println("Pairs F2 after replacement: ");
        System.out.println(pairs);
        return result;
    }
}
