package com.labs.ArrWork;

import java.util.*;


public class ArrWork {

    public static String[][] create_matr(int[] arr, int n)
    {
        String[][] matr = new String[n][n];
        for(int i =0; i <n;i++)
        {
            for (int j = 0; j <n; j++)
            {
                if(arr[i]==j)
                    System.out.print(" Q ");
                else{
                    System.out.print(" # ");
                }

            }
            System.out.println();
        }
        return matr;
    }


    public static boolean place(int queen_number, int column_number, int[] columns_placed)
    {
        for(int j =0; j<queen_number;j++)
        {
            if(columns_placed[j]==column_number || Math.abs(columns_placed[j]-column_number)==Math.abs(j-queen_number))

            {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> array_to_list(int []arr)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int j : arr) {
            answer.add(j);
        }

        return answer;
    }



    public static int[] make_rand_int_arr (int n)
    {
        Random random = new Random();
        int[]result = new int[n];
        for(int i = 0; i <n; i++)
            result[i]=random.nextInt(n);
        return result;
    }

    public static int[] arrlist_to_arr(ArrayList<Integer>arrlist)
    {
        int[] answer = new int[arrlist.size()];
        int iter =0;
        for(int i: arrlist) {
            answer[iter] = i;
            iter++;
        }
        return answer;

    }

    static int amount_of_duplicates_in_arrlist(ArrayList<Integer> arr, int depth)
    {
        ArrayList<Integer> checked = new ArrayList<>();
        ArrayList<Integer>duplicates = new ArrayList<>();
        for(int i =0; i<depth;i++)
        {
            int a = arr.get(i);
            if(!checked.contains(a))
                checked.add(a);
            else
                duplicates.add(a);
        }
        return duplicates.size();
    }

}
