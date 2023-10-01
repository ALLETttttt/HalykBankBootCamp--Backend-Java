public class bestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i:prices){
            if(min>i){
                min=i;
            }
            int a=i-min;
            profit = Math.max(profit, a);
        }
        return profit;
    }
}
