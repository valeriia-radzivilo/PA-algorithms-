package db;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class WriterReader {
    static final String pathname = "lab3_db.obj";

    public static String get_filepath()
    {
        return pathname;
    }


    public static void main(int amount_input) {


        try {
            FileOutputStream f = new FileOutputStream(new File(pathname));
            ObjectOutputStream o = new ObjectOutputStream(f);


            for(int i =0; i<amount_input;i++)
            {
                Random value = new Random();
                    db_input input = new db_input(value.nextInt(amount_input+i), value.nextInt(10000));
                // Write objects to file
                o.writeObject(input);
            }





            o.close();
            f.close();



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

    public static ArrayList<db_input> read_file(int amount) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File(pathname));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        ArrayList<db_input> get_input = new ArrayList<>();


        for(int i =0; i< amount;i++)
        {
           get_input.add(i,(db_input) oi.readObject());

        }


        oi.close();
        fi.close();

        return get_input;
    }

    public static ArrayList<db_input> deserealised_read()
    {
        ArrayList<db_input> emp = new ArrayList<>();
        try
        {
            FileInputStream fileIn =new FileInputStream(pathname);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            int i =  0;
            while (in.readObject()!=null) {
                emp.add(i,(db_input)in.readObject());
                i++;

            }
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }

        return emp;
    }

    public static void add_to_db(db_input additional_input)
    {
        try {
            FileOutputStream f = new FileOutputStream(new File(pathname));
            ObjectOutputStream o = new ObjectOutputStream(f);


                db_input input = additional_input;
                // Write objects to file
                o.writeObject(input);

            o.close();
            f.close();



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    static void clean_file() throws IOException {
        new FileWriter(pathname, false).close();
    }


    public static void write_to_db(ArrayList<db_input> new_input) throws IOException {
        clean_file();
        try {
            FileOutputStream f = new FileOutputStream(new File(pathname));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (db_input input : new_input) {

                o.writeObject(input);
            }

            o.close();
            f.close();



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}