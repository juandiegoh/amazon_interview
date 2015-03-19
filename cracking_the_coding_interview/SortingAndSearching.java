
public class SortingAndSearching {

    public int[] merge(int[] a, int[] b, int n, int m) {
        int k = m + n - 1; // Index of last location of array b
        int i = n - 1; // Index of last element in array a
        int j = m - 1; // Index of last element in array b
        // Start comparing from the last element and merge a and b
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }

        while (j >= 0) {
            a[k--] = b[j--];
        }

        return a;
    }

}
