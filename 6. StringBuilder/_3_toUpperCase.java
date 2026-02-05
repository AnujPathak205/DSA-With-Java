import java.util.Scanner;

public class _3_toUpperCase {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i = 1;i < str.length();i++){
            if(str.charAt(i-1) == ' '||str.charAt(i-1) == ','){
                 char ch = Character.toUpperCase(str.charAt(i));
                 sb.append(ch);
            }else{
                sb.append(str.charAt(i));
            }
        }

        
        return sb.toString();
    }

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence:");
        str = scanner.nextLine();

        System.out.println(toUpperCase(str));

        
    }
}
