import java.util.ArrayDeque;
import java.util.Queue;

public class _7_FirstNonRepeatingLetter{
    public static void firstNonRepeatingLetter(String str){
        int[] freq = new int[26];
        Queue<Character> queue = new ArrayDeque<>();

        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);

            freq[ch-'a']++;

            queue.add(ch);

            while(!queue.isEmpty()){
                if(freq[queue.peek()-'a'] == 1){
                    System.out.print(queue.peek()+" ");
                    break;
                }else{
                    queue.remove();
                }
            }

            if(queue.isEmpty()){
                System.out.print(-1+" ");
            }


        }

        System.out.println();
    }

    public static void main(String[] args) {
        firstNonRepeatingLetter("aabccxb");
    }
}
