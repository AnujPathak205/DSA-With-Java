public class _11_BuyAndSellStocks {
    public static int MaxProfit(int[] stockPrices){
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0;i < stockPrices.length-1;i++){
            int buyingPrice = stockPrices[i];
            for(int j = i+1;j < stockPrices.length;j++){
                int sellingPrice = stockPrices[j];
                int profit = Math.max(0,(sellingPrice - buyingPrice));
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;
    }


    //Better way with low time complexity
    public static int MaxProfit_2(int[] stockPrices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price:stockPrices){
            if(price < minPrice){
                minPrice = price;
            }else{
                int profit = price-minPrice;
                maxProfit = Math.max(profit,maxProfit);
            }
        }

        return maxProfit;
    }

    
   

    public static void main(String[] args) {
        int[] stockPrices = {7,1,5,3,6,4};
        System.out.println(MaxProfit(stockPrices));
        System.out.println(MaxProfit(stockPrices));
    }
}

