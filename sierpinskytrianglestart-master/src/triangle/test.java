package triangle;

public class test {

    public static void main(String[] args) {

        int n = 1000;
        int sum =0;
        // Fragment #1
        for ( int i = 0; i < n; i ++) {
            sum++;
        }
        System.out.println(sum);
        sum =0;
        // Fragment #2
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        // Fragment #3
        for ( int i = 0; i < n; i ++) {
            for (int j = i; j < n; j++) {
                sum++;
            }
        }
        // Fragment #4
        for ( int i = 0; i < n; i ++) {
            sum++;
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        // Fragment #5
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < n * n; j++) {
                sum++;
            }
        }
        // Fragment #6
        for ( int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        // Fragment #7
        for ( int i = 1; i < n; i ++) {
            for (int j = 0; j < n * n; j++) {
                if (j % i == 0) {
                    for (int k = 0; k < j; k++) {
                        sum++;
                    }
                }
            }
        }
    }
}