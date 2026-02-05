import java.util.Stack;

public class _6_StockSpanProblem {
    public static int[] StockSpan(int[] stockPrices){
        //Without using Stack: TC:O(n^2)
        //Brute-force O(n²) approach in StockSpan()
        int[] stockSpan = new int[stockPrices.length];

        stockSpan[0] = 1;

        for(int i = 1;i < stockPrices.length;i++){
            int prevHigh = -1;

            for(int j = i-1;j >= 0;j--){
                if(stockPrices[j] > stockPrices[i]){
                    prevHigh = j;
                    break;
                }
            }

            stockSpan[i] = i - prevHigh;
        }
        return stockSpan;
    }

    //Using Stack approack - TC: O(n)- linear
    public static int[] StockSpan2(int[] stockPrices){
        int[] span = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        span[0] = 1;

        for(int i = 1;i < stockPrices.length;i++){
            int currPrice = stockPrices[i];

            while(!stack.isEmpty() && currPrice >= stockPrices[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] stockPrices = {100,80,60,70,60,85,100};
        int[] stockSpan = StockSpan2(stockPrices);

        for(int i:stockSpan){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
