public class _6_JobSequencingProblem {
    public static int maxProfit(int[] deadlines,int[] profits){
        //Sorting by profits
        int n = deadlines.length;
        for(int i = 0;i < n-1;i++){
            for(int j = 0;j < n-i-1;j++){
                if(profits[j] < profits[j+1]){
                    int temp = profits[j];
                    profits[j] = profits[j+1];
                    profits[j+1] = temp;
                    
                    temp = deadlines[j];
                    deadlines[j] = deadlines[j+1];
                    deadlines[j+1] = temp; 
                }
            }
        }

        int maxDeadline = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            maxDeadline = Math.max(maxDeadline,deadlines[i]);
        }

        boolean[] seq = new boolean[maxDeadline];

        int profit = 0;

        for(int i = 0;i < n;i++){
            for(int j = deadlines[i]-1;j >= 0;j--){
                if(!seq[j]){
                    seq[j] = true;
                    profit += profits[i];
                    break;
                }
            }
        }


        return profit;
    }

    public static void main(String[] args) {
        int[] deadlines = {4,1,1,1};
        int[] profits = {20,10,40,30};
        System.out.println(maxProfit(deadlines, profits));
    }
}
