
import java.util.HashMap;

public class _6_ValidAnagram {
    public static boolean isValidAnagram(String s,String t){
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,1+hm.getOrDefault(ch, 0));
        }

        for(int i = 0;i < t.length();i++){
            char ch = t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch, 0)-1);
            if(hm.get(ch) < 0) return false;
        }

        return hm.isEmpty();
    }

    public static void main(String[] args) {
        String s = "abababab";
        String t = "bbbaaaba";
        
        System.out.println(isValidAnagram(s, t));
    }
}
