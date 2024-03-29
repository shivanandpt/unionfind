import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class QuickFindUF {
    private int [] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for(int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union (int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(N);
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
