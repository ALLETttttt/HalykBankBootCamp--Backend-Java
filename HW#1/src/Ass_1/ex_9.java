package Ass_1;

public class ex_9 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, 9, -5, -234, -44, 23, 0, 23, 0, 0, 0, -34, -7, 10000, 0};
        int cntPos = 0, cntNeg = 0, cntZero = 0;
        for (int j : arr) {
            if (j == 0) {
                cntZero++;
            } else if (j > 0) {
                cntPos++;
            } else {
                cntNeg++;
            }
        }
        System.out.println("Zero: " + cntZero + "\nPositive: " + cntPos + "\nNegative: " + cntNeg);
    }
}
