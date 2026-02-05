public class _12_FriendPairingProblem {
    public static int FriendPairingProblem(int n){
        if(n == 1 || n == 2){
            return n;
        }
        int oneSingle = FriendPairingProblem(n-1);
        int onePair   = (n-1)*FriendPairingProblem(n-2);

        return oneSingle+onePair;
    }

    public static void main(String[] args) {
        System.out.println(FriendPairingProblem(4));
    }
}
