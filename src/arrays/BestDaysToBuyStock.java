package arrays;

public class BestDaysToBuyStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(findBestDaysToBuyStockV2(prices));
    }

    public static int findBestDaysToBuyStock(int[] prices) {
        int highestVale = 0;
        for (int i = 0; i < prices.length; i++) {
            var todaysValue = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                var tommorowsValue = prices[j];
                var profit = tommorowsValue - todaysValue;
                if (profit > highestVale)
                    highestVale = profit;
            }
        }
        return highestVale;
    }

    public static int findBestDaysToBuyStockV2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0; // Initialize profit to zero

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
