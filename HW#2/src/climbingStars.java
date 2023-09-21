import java.util.Scanner;

public class climbingStars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] dp=new int[n];
        dp[0]= 1;
        if(n>1)
            dp[1]= 2;
        for(int i=3;i<=n;i++){
            dp[i-1]=dp[i-2]+dp[i-3];
        }
        return dp[n-1];
    }
}
