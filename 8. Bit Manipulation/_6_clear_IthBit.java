public class _6_clear_IthBit {
    public static int clearIthBit(int n,int i){
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int clearRangeOfBits(int n,int startingI,int endingI){
        for(int i = startingI;i <= endingI;i++){
            n = clearIthBit(n, i);
        }
        return n;
    }
    

    public static void main(String[] args) {
        System.out.println(clearIthBit(9, 3));

        System.out.println(clearRangeOfBits(37, 2, 4));
    }
}
