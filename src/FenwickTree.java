/**
 * An implementation of a Fenwick Tree supporting log(n) range queries
 * This Fenwick Tree supports update, sum, and rangeSum operations
 *
 * The update operation updates the element at a certain index by delta
 * The sum operation returns the prefix sum from 0 to i
 * The rangeSum operation returns the sum from an inclusive range [left, right]
 *
 * @author Mark Chen, chenmark33@gmail.com
 */
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
