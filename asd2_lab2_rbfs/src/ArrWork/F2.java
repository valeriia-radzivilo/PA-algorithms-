package ArrWork;

public class F2 {
    public static int F2(int[]array, int n)
    {
        int pairs=0;
        for (int i=0; i<n;i++)
        {
            for(int j =i+1; j<n;j++)
                if(j!=i && Math.abs(array[i]-array[j])==Math.abs(i-j))
                    pairs++;

        }

        for(int i =0; i<n;i++)
        {
            int tmp =0;
            for(int j =i+1; j<n; j++)
                if(array[i]==array[j]&& i!=j)
                    tmp++;
            if (tmp>1){
                pairs+=tmp;
            }
            if(tmp==1)
                pairs++;
        }










        return pairs;
    }
}
