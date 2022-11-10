import FileWork.*;
import ForArrays.*;
import NaturalMergeSort.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String args[]) throws IOException {
        FileWork base_file = new FileWork();
        NaturalMergeSort sort_arr = new NaturalMergeSort();
        ForArrays arr = new ForArrays();
        String filepath = "Big_Rand_Numbers.txt";


        arr.make_large_arr();
        System.out.println("\n");


        int count_lines = base_file.count_lines(filepath)/3374;
        System.out.println(count_lines);
        int add = count_lines/3;
        int counter_files = 0;
        int[] sizes = new int[3];
        for(int i =0; counter_files<3;i+=add) {
            // розберись з add
            // об'єднай ці файли в 3, а потім в 1
            int[] int_text_arr = base_file.text_in_arr(filepath, i, add*(counter_files+1), count_lines);
            sort_arr.sort(int_text_arr);
            String new_file_name = "A" + Integer.toString(counter_files)+".txt";
            base_file.fill_file(new_file_name, int_text_arr);
            if(i+add>count_lines)
                add=count_lines-i;
            sizes[counter_files] = int_text_arr.length;
            counter_files++;
        }

        int size_for_three_files = sizes[0]/3+sizes[1]/3+sizes[2]/3;

        int[] new_sizes = base_file.divide_and_sort(size_for_three_files, sizes,base_file, arr, sort_arr, 3,3,"A","B");
        int[] c_sizes = base_file.divide_and_sort(size_for_three_files, new_sizes,base_file, arr, sort_arr, 2,3,"B","C");
        int[] d_sizes = base_file.divide_and_sort(size_for_three_files, new_sizes,base_file, arr, sort_arr, 1,2,"C","D");






    }


}