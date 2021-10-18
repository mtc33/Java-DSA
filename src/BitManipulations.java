import java.util.*;

public class BitManipulations {

    public BitManipulations() {
        //
    }

    public int setBitAt(int set, int i) {
        return set | (1 << i);
    }

    public int clearBitAt(int set, int i) {
        return set & ~(1 << i);
    }

    public int toggleBitAt(int set, int i) {
        return set ^ (1 << i);
    }

    public int rightmostOneBitOff(int set) {
        return set & (set - 1);
    }

    public int rightmostOneBitOn(int set) {
        return set | (set + 1);
    }

    public int trailingOneBitsOff(int set) {
        return set & (set + 1);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public int numUniqueChars(String s) {
        Integer set = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (1 << (c - 'a'));
            set |= idx;
        }
        return Integer.bitCount(set);
    }

    public boolean hasOnlyUniqueChars(String s) {
        Integer set = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (1 << (c - 'a'));
            if ((set & idx) > 0) return false;
            set |= idx;
        }
        return true;
    }

    public List<List<Integer>> makeSubsets(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int bit = 0; bit < 32; bit++) {
                int isSet = i & (1 << bit);
                if (isSet > 0) subset.add(bit + 1);
            }
            res.add(subset);
        }
        return res;
    }
}
