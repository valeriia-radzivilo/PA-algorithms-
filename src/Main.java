import db.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static interface_for_db.db_interface.create_frame;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame frame= new JFrame("DB");
        int amount_of_records = 100;
        WriterReader.main(amount_of_records);
        ArrayList<db_input> get_from_db = WriterReader.read_file(amount_of_records);
        ArrayList<db_input> sparse_get_from_db = new ArrayList<>();

        SparseArray sparseArray = new SparseArray(get_from_db,sparse_get_from_db);

        SparseArray.make_dense_sparse();
        System.out.println("DB:");
        arr_work.print_arr_list(sparse_get_from_db);

        System.out.println("Overflow:");
        arr_work.print_arr_list(sparseArray.getOverflowing_bucket());

        ArrayList<Integer> indexes = arr_work.get_indexes(sparse_get_from_db);
        ArrayList<Integer> values = arr_work.get_values(sparse_get_from_db);
        create_frame(frame,indexes,values,sparseArray);



    }


}