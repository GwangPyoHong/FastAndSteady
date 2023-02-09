package backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9663 {
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        chessboard(N, arr, 0, 0);
        System.out.println(count);

    }

    private static void chessboard(int N, int arr[], int x, int y) {
        if (x == N) count++;
        if (check_queen(N, arr, x, y)) {
            arr[x] = y;
            chessboard(N, arr, x + 1, 0);
        }
        if (x < N && y < N - 1)chessboard(N, arr, x, y + 1);
    }

    private static boolean check_queen(int N, int[] arr, int x, int y) {

        int basic_x = x;
        int basic_y = y;
        while (--x >= 0) {
            if (basic_y == arr[x]) return (false);
            if ((basic_x - basic_y == x - arr[x]) || (basic_x + basic_y == x + arr[x])) return (false);
        }
        return (true);
    }
}