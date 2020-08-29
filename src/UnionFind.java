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
