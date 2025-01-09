package leetcode_challenges.arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 * <p>
 * You want to maximize your profit by choosing a single day to
 * buy one stock and a different day to sell it in the future.
 * Return the maximum profit you can achieve. If you cannot achieve any profit, return 0.
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Exa
 */
public class BestTimeToBuy {

    public static void main(String[] args) {
        System.out.println(maxProf(new int[]{7, 1, 5, 3, 6, 4}));
    }

    private static int maxProf(int[] prices) {
        int minPrice = prices[0];

        int maxProfit = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            int price = prices[i];

            if (price < minPrice) {
                minPrice = price;

            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return  maxProfit;
    }
}
