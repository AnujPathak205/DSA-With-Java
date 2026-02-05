public class _5_IndianCoins {
    public static int minCoins(int value){
        int[] coins = {2000, 500, 100, 50, 20, 10, 5, 2, 1};
        
        int count = 0;
        System.out.print("Coins used for "+value+" : ");
        for (int i = 0; i < coins.length; i++) {
            while(value >= coins[i]){
                count++;
                value -= coins[i];
                System.out.print(coins[i]+" ");
            }
        }
        System.out.println();

        return count;
    }

    public static void main(String[] args) {
        int v1 = 121;
        int v2 = 590;
        System.out.println(minCoins(v1));
        System.out.println(minCoins(v2));
        System.out.println(minCoins(4341));
    }
}
