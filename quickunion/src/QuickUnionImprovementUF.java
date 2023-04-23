import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickUnionImprovementUF {
    private int id [];
    private int  sz [];

    QuickUnionImprovementUF(int N) {
        id = new int [N];
        sz = new int [N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // point current node to its root
            i = id [i];

        }
        return i;
    }

    private boolean connected(int p, int q) {
        return  root(p) == root(q);
    }

    private void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        // Check for size 1st improvement
        if (sz[i] > sz[j]) {
            id[j] = i;
            sz[i] += sz[j];
        } else  {
            id[i] = j;
            sz[j] += sz[i];
        }
    }
    public static void main (String [] args) {
        int N = StdIn.readInt();
        QuickUnionImprovementUF uf = new QuickUnionImprovementUF(N);
        while(!StdIn.isEmpty()) {
            String cmd = StdIn.readString();
            int p = StdIn.readInt();
            int q =  StdIn.readInt();
            if (cmd.equals("union")) {
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                }
            } else {
                StdOut.println(uf.connected(p,q));
            }
        }
    }
}
