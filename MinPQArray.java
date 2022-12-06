package program_1;

/**
 *
 * @author rjpls
 */
public class MinPQArray<Key extends Comparable<Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public MinPQArray(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;  
    }
    public int size(){
        return n;       
    } 
    public Key delMin(){
        return pq[--n];
    }

    public void insert(Key key) {
        int i = n-1;
        while (i >= 0 && greater(key, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        n++;
    }

   
    private boolean greater(Key v, Key w) {                 //Helper Function
        // compareTo returns < 0 if v < w, > - if v > w, 0 if v == w
        return v.compareTo(w) > 0;
    }
}
