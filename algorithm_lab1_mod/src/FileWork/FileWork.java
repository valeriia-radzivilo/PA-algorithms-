package FileWork;
import ForArrays.ForArrays;
import NaturalMergeSort.NaturalMergeSort;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class FileWork {


    public String[] get_array(String filepath) throws IOException {
            List<String> listOfStrings = new ArrayList<String>();

            // load data from file
            BufferedReader bf = new BufferedReader(new FileReader(filepath));

            // read entire line as string
            String line = bf.readLine();

            // checking for end of file
            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }

            // closing bufferreader object
            bf.close();

            // storing the data in arraylist to array
            String[] array = listOfStrings.toArray(new String[0]);

            // printing each line of file
            // which is stored in array
            for (String str : array) {
                System.out.println(str);
            }

            return array;
    }


    public void fill_file(String filepath, int[] arr) throws IOException {

        FileWriter writer = new FileWriter(filepath);
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
        System.out.println("File was filled successfully!\n");


    }

    public int[] text_in_arr(String filepath_old, int start_point, int add, int size_file) throws IOException {
        if (start_point!=0)
            start_point++;
        BufferedReader reader;
        if(size_file-add<1000)
            add = size_file;
        int[] int_text;
        if(add>start_point)
            int_text = new int[add-start_point+1];
        else
            int_text = new int[add+1];

        try {
            reader = new BufferedReader(new FileReader(filepath_old));
            String line = "1";
            int i = 0;
            int counter = 0;
            while (line != null && i < add) {
                // read next line
                line = reader.readLine();
                if(i>=start_point) {
                    int_text[counter] = Integer.parseInt(line);
                    counter++;
                }
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return int_text;
    }


    public int count_lines(String filepath) {
        long numOfLines;
        try (Stream<String> lines = Files.lines(Path.of(filepath), Charset.defaultCharset())) {
            numOfLines = lines.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (int) numOfLines;


    }

    public int[] divide_and_sort(int size_for_three_files, int[] sizes, FileWork base_file, ForArrays arr, NaturalMergeSort sort_arr, int amount_files,int old_amount_files, String old_letter, String new_letter) throws IOException {
        int[] full_array = new int[size_for_three_files+amount_files];
        int[]new_sizes = new int[amount_files];
        int start_point = 0;
        for(int j =0; j<amount_files; j++) {
            for (int i = 0; i < old_amount_files; i++) {
                String file_name = old_letter + Integer.toString(i) + ".txt";
                if (j!=0)
                    start_point=(sizes[i]/amount_files)*j;
                int[] half_array = base_file.text_in_arr(file_name, start_point, (sizes[i] / amount_files)*(j+1), sizes[i]);
                if (i!=0)
                    full_array = arr.make_from_Intenger_int(concatWithCollection(arr.make_from_int_Intenger(full_array), arr.make_from_int_Intenger(half_array)));
                else
                    full_array = half_array;
                sort_arr.sort(full_array);
            }
            full_array = arr.delete_values_from_array(old_amount_files-amount_files+2, full_array);
            String new_file_name = new_letter + Integer.toString(j) + ".txt";
            base_file.fill_file(new_file_name, full_array);
            new_sizes[j] = full_array.length;
        }
        return new_sizes;
    }

    static Integer[] concatWithCollection(Integer[] array1, Integer[] array2) {
        List<Integer> resultList = new ArrayList<>(array1.length + array2.length);
        Collections.addAll(resultList, array1);
        Collections.addAll(resultList, array2);

        @SuppressWarnings("unchecked")
//the type cast is safe as the array1 has the type T[]
        Integer[] resultArray = (Integer[]) Array.newInstance(array1.getClass().getComponentType(), 0);
        return resultList.toArray(resultArray);
    }
}
