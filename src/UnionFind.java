/**
 * An implementation of a a Union Find (Disjoint Set) data structure.
 * This Union Find supports find, sizeOf, inSameSet, and union operations.
 *
 * The find operation returns the index of the root of the given element's "tree", or set.
 * The sizeOf operation returns the size of the given element's set.
 * The inSameSet operation returns true if the two given elements belong to the same set.
 * The union operation merges the sets of two given elements together.
 *
 * @author Mark Chen, chenmark33@gmail.com
 */
import java.util.*;

public class UnionFind {
    int[] size;
    int groups;

    public UnionFind(int n) {
        this.size = new int[n];
        this.groups = n;
        Arrays.fill(size, -1);
    }

    public int find(int element) {
        if (size[element] < 0) return element;
        return size[element] = find(size[element]);
    }

    public int sizeOf(int element) {
        int rootIndex = find(element);
        return -size[rootIndex];
    }

    public boolean inSameSet(int x, int y) {
        return (find(x) == find(y));
    }

    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false;

        int sizeX = sizeOf(x), sizeY = sizeOf(y);
        if (sizeX < sizeY) {
            size[rootY] -= sizeX;
            size[rootX] = rootY;
        }
        else {
            size[rootX] -= sizeY;
            size[rootY] = rootX;
        }
        groups--;
        return true;
    }
}
