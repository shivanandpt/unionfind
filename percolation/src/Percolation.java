import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF uf ;
    private int perArray [][];

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws  IllegalArgumentException {
        perArray = new int[n][n];
        if (n <= 0 ) {
            throw  new IllegalArgumentException();
        }
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                perArray[i][j] = 0;
            }
        }
        uf = new WeightedQuickUnionUF(n+2);
    };

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (perArray[row][col] == 0) {
            perArray[row][col] = 1;

        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return  perArray[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites() {

    }

    // does the system percolate?
    public boolean percolates() {

    }

    // test client (optional)
    public static void main(String[] args)
}