public class _3_evenORodd {
    public static void evenORodd(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("Even number.");
        }else{
            System.out.println("Odd number.");
        }
    }

    public static void main(String[] args) {
        evenORodd(8);
        evenORodd(9);
    }
}
