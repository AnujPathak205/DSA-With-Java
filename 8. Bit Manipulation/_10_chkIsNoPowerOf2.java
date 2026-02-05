public class _10_chkIsNoPowerOf2 {
    public static boolean IsPowerOf2(int n){
        if((n & (n-1)) == 0){
            return true;
        }else{
            return false;
        }//return ((n & (n-1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(IsPowerOf2(8));
        System.out.println(IsPowerOf2(13));
    }
}
