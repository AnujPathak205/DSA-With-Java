public class _1_PalindromeString {

    public static boolean isPalindrome(String str){
        int n = str.length();
        for(int i = 0;i <= n/2;i++){
            if(str.charAt(i) != str.charAt(n-i-1))return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str1 = "noon";
        String str2 = "racecar";
        String str3 = "name";

        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));

    }

}
