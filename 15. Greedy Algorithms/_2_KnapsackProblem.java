import java.util.Arrays;
import java.util.Comparator;

public class _2_KnapsackProblem {
    public static double  maxProfit(int[] value,int[] weight,int capacity){
        double[][] ratio = new double[value.length][2];

        for(int i = 0;i < value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        double profit = 0;
        for(int i = value.length-1;i >= 0 ;i--){
            int currWeight = weight[(int)ratio[i][0]];
            int currProfit = value[(int)ratio[i][0]];

            if(capacity >= currWeight){
                profit += currProfit;
                capacity -= currWeight;
            }else{
                profit += ratio[i][1]*capacity;
                break;
            }
        }

        return profit;
    } 

    public static void main(String[] args) {
        int[] value = {60,100,120};
        int[] weight = {10,20,30};

        System.out.println(maxProfit(value, weight, 50));
    }
}
