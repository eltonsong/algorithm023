// Name:  Qinyang Song
// Email: qinyang.song@vanderbilt.edu
// Date:  1/20/2021

// 通过股票交易得出最大利益
// 每次只需要考虑一天的利益是否为正

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        if (n <= 1) return 0;
        for (int i = 0; i < n-1; i++) {
            profit += Math.max(0, prices[i+1] - prices[i]);
        }
        return profit;
    }
}
