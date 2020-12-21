import java.util.*;

public class FenwickTree {
    int size;
    int[] table;

    public FenwickTree(int size, int[] arr) {
        this.size = size;
        this.table = new int[size];
        for (int i = 0; i < arr.length; i++) {
            this.update(i, arr[i]);
        }
    }

    public void update(int idx, int delta) {
        // idx = idx|(idx+1) is equivalent to idx += Integer.lowestOneBit(idx)
        for (; idx < size; idx = idx | (idx + 1)) { // right most one bit ON
            table[idx] += delta;
        }
    }

    public int sum(int i) {
        int sum = 0;
        for (; i >= 0; i = (i & (i + 1)) - 1) { // right most one bit OFF
            sum += table[i];
        }
        return sum;
    }

    public int rangeSum(int left, int right) {
        return sum(right) - sum(left - 1);
    }
}
