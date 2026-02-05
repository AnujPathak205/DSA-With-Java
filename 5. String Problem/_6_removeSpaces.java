
import java.util.Scanner;

public class _6_removeSpaces {
    
    public static String removeSpaces(String sentence){
        StringBuilder result = new StringBuilder(sentence);
        for(int i = 0;i < result.length();i++){
                if(result.charAt(i) == ' '){
                    result.delete(i, i+1);
                    i--;
                }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = new Scanner(System.in).nextLine();
        System.out.println(sentence);
        System.out.println(removeSpaces(sentence));

       
    }
}
