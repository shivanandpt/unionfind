import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickUnionUF {
    private int [] id;

    QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    };

    private int root(int i) {
        while(i!=id[i]) {
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private  void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
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
