import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LargestConnectedComponent {
    private int id [];
    private int sz [];
    private int lg [];

    LargestConnectedComponent(int N) {
        sz = new int[N];
        id = new int[N];
        lg = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = i;
            id[i] = i;
            lg[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id [id[i]];
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return  root(p) == root(q);
    }

    private int getlargest(int p, int q) {
        if (p > q) {
            return  p;
        } else {
            return q;
        }
    }

    private void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] > sz[j]) {
            id[j] = i;
            sz[i] += sz[j];
            lg[i] = getlargest(lg[i], lg[j]);

        } else {
            id[i] = j;
            sz[j] += sz[i];
            lg[j] = getlargest(lg[i], lg[j]);
        }
    }

    public static  void main (String args[]) {
        int N = StdIn.readInt();
        LargestConnectedComponent uf = new LargestConnectedComponent(N);
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
        StdOut.println(Arrays.toString(uf.lg));
    }


}
