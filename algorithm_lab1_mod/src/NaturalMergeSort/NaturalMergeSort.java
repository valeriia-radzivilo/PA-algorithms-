package NaturalMergeSort;

public class NaturalMergeSort {

    public void sort(int[] elements) {
        // find array length
        int num_elem = elements.length;

        int[] tmp = new int[num_elem]; // temporary array for sorting
        int[] st = new int[num_elem + 1]; // starts

        // identify runs
        int run_c = 0; // counter
        st[0] = 0;
        for (int i = 1; i <= num_elem; i++) {

            if (i == num_elem || elements[i] < elements[i - 1]) {
                st[++run_c] = i;
            }
        }

        // merge runs, until only 1 run is left
        int[] from = elements;
        int[] to = tmp;

        while (run_c > 1) {
            // new counter
            int run_c_new = 0;

            // Merge two runs each
            for (int i = 0; i < run_c - 1; i += 2) {
                merge(from, to, st[i], st[i + 1], st[i + 2]);
                st[run_c_new++] = st[i];
            }

            // if there is odd number of runs - copy the last one
            if (isOdd(run_c)) {
                int lastStart = st[run_c - 1];
                System.arraycopy(from, lastStart, to, lastStart, num_elem - lastStart);
                st[run_c_new++] = lastStart;
            }

            // Prepare for next round
            st[run_c_new] = num_elem;
            run_c = run_c_new;

            // Swap "from" and "to" arrays
            int[] help = from;
            from = to;
            to = help;
        }

        // if final run is not in "elements", copy it there
        if (isNotSameArray(from, elements)) {
            System.arraycopy(from, 0, elements, 0, num_elem);
        }
    }

    private void merge(int[] source, int[] target, int start_left, int start_right, int end_right) {
        int left_pos = start_left;
        int right_pos = start_right;
        int target_pos = start_left;

        // As long as both arrays contain elements
        while (left_pos < start_right && right_pos < end_right) {
            // find out which one is smaller
            int leftValue = source[left_pos];
            int rightValue = source[right_pos];
            if (leftValue <= rightValue) {
                target[target_pos++] = leftValue;
                left_pos++;
            } else {
                target[target_pos++] = rightValue;
                right_pos++;
            }
        }
        // Copy the rest
        while (left_pos < start_right) {
            target[target_pos++] = source[left_pos++];
        }
        while (right_pos < end_right) {
            target[target_pos++] = source[right_pos++];
        }
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

   // check the same instance
    private boolean isNotSameArray(int[] array1, int[] array2) {
        return array1 != array2;
    }


}