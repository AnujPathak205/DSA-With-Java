import java.util.Stack;

public class _4_ReverseAString {
   
    //Using Stack
    public static String ReverseString(String str){
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            stack.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.toString();
    }


    //Using iteration
    public static String ReverseString2(String Str){
        StringBuilder result = new StringBuilder("");
        for(int i = Str.length() -1;i >= 0;i--){
            result.append(Str.charAt(i));
        }
        return result.toString();
    }
    

    public static void main(String[] args) {
        String name = "1234567";
        System.out.println(ReverseString2(name));
    }
}
