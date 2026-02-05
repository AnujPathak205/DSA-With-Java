public class _7_update_IthBit {
    public static int updateIthIndex(int n,int i,int newbit){
        //1.Clear ith bit.
        int bitmask = ~(1 << i);
        n = n & bitmask;

        //2.
        bitmask = newbit<<i;

        //3.
        return n | bitmask;
    }

    public static void main(String[] args) {
        System.out.println(updateIthIndex(13, 2, 0));
        System.out.println(updateIthIndex(13, 2, 1));


    }
}
