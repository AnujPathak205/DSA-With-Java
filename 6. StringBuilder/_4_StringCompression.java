public class _4_StringCompression {
    
    public static String StrCompression(String str){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1;i < str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }else{
                sb.append(str.charAt(i-1));
                if(count != 1)sb.append(count);
                count=1;
            }
        }
        sb.append(str.charAt(str.length()-1));
        if(count != 1)sb.append(count);
        return sb.toString();
    }

    public static String StrCompression2(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++){
            Integer count = 0;
            char ch = str.charAt(i);
            while(i < str.length() && ch == str.charAt(i) ){
                i++;
                count++;
            }
            sb.append(ch);
            if(count != 1)
            sb.append(count.toString());
            if(i != str.length())i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabbbcddddabcd";//a2b3c1d4
        System.out.println(StrCompression(str));
        System.out.println(StrCompression2(str));
    }
}
