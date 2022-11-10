package ForArrays;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ForArrays {

    /* A utility function to print array of size n */
    public void printArray(int arr[]) {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }

    public void printStrArray(String arr[]) {
        int n = arr.length;
        for (String s : arr) System.out.print(s + " ");
        System.out.println();
    }


    // make int array
    public int[] make_str_arr_to_int(String arr1[])
    {
        int[] intList = new int[arr1.length];

        // parsing the String argument to make int array
        for (int i = 0; i < arr1.length; i++) {
            intList[i] = Integer.valueOf(arr1[i]);
        }
        return intList;
    }



    public void make_large_arr() throws FileNotFoundException, UnsupportedEncodingException {
        //Size in Gbs of my file that I want
        double wantedSize = 1.0;
        int line_count = 0;
        Random random = new Random();
        File file = new File("Big_Rand_Numbers.txt");
        long start = System.currentTimeMillis();
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")), false);
        int counter = 0;
        while (true) {
            for (int i = 0; i < 500; i++) {
                int number = random.nextInt(1000) + 1;
                writer.print(number);
                writer.print("\n");
            }

//            writer.println();
            //Check to see if the current size is what we want it to be
            if (++counter == 20000) {
                System.out.printf("Size: %.3f GB%n", file.length() / 1e9);
                if (file.length() >= wantedSize * 1e9) {
                    writer.close();
                    break;
                } else {
                    counter = 0;
                }
            }
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Took %.1f seconds to create a file of %.3f GB", time / 1e3, file.length() / 1e9);
    }


    public Integer[] make_from_int_Intenger(int[] arr)
    {
        Integer array[] = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.valueOf(arr[i]);
        }
        return array;
    }

    public int[] make_from_Intenger_int(Integer[] arr)
    {
        int array[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = (int)arr[i];
        }
        return array;
    }

    public int[] delete_values_from_array(int amount, int [] arr)
    {
        int[] arr_new = new int[arr.length-amount];
            for (int i = 0, k = 0; i < arr.length; i++) {
                if (i>amount) {
                    arr_new[k] = arr[i];
                    k++;
                }

        }
        return arr_new;
    }
}
