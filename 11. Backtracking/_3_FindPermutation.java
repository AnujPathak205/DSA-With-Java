

public class _3_FindPermutation {
    public static void printSubSets(String str,int i,String ans){
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        printSubSets(str, i+1, ans+str.charAt(i));
        printSubSets(str, i+1, ans);
    }

    public static void printPermutation(String str,int i,String ans){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        for(int idx = 0;idx < str.length();idx++){
            char ch = str.charAt(idx);
            boolean isTaken = false;
            for(int jdx = 0;jdx < ans.length();jdx++){
                if(ch == ans.charAt(jdx)){
                    isTaken = true;
                    break;
                }
            }
            if(!isTaken)printPermutation(str, i+1, ans+str.charAt(idx));

        }
    }

    public static void printPermutation2(String str,int i,String ans,boolean map[]){
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        for(int idx = 0;idx < str.length();idx++){
            char ch = str.charAt(idx);
            if(!map[idx]){
                map[idx] = true;
                printPermutation2(str, i+1, ans+ch,map);
                map[idx] = false;
            }
        }
    }


    //BEST
    public static void printPermutation3(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0;i < str.length();i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            printPermutation3(newStr, ans+curr);
        }
    }

    public static void main(String[] args) {
        printPermutation3("abc","");
    }
}
