package ArrWork;

import java.util.*;
import java.util.stream.IntStream;

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

    public static boolean check_in_arr(LinkedList<Integer> arr, int toCheckValue)
    {
        return arr.contains(toCheckValue);
    }


    public static boolean check_in_int_arr(int[] arr, int toCheckValue)
    {
        boolean test
                = IntStream.of(arr)
                .anyMatch(x -> x == toCheckValue);
        return test;
    }
    public static int[] linked_to_array(LinkedList<Integer> solution)
    {
        Object[] result = solution.toArray();
        int[] result_to_print = new int[solution.size()];
        for (int i = 0; i < solution.size(); i++)
            result_to_print[i] = (int) result[i];

        return result_to_print;
    }

    public static List<Integer> array_to_list(int []arr)
    {
        List<Integer> answer = new ArrayList<>();
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

    public static int[] addtoArr(int amount_to_add, int arr[])
    {
        int[] new_arr = new int[arr.length+amount_to_add];
        for(int i =0; i< new_arr.length; i++)
        {
            if(i<arr.length)
                new_arr[i]=arr[i];
            else
                new_arr[i] = 1;
        }
        return new_arr;
    }

}
