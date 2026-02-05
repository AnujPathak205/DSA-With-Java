public class _2_alphabetString {
    public static void main(String[] args) {
        StringBuilder alphabetSB = new StringBuilder();
        for(char ch = 'A';ch <= 'Z';ch++){
            alphabetSB.append(ch);
        }

        String alphabetString = alphabetSB.toString();
        System.out.println(alphabetString);
    }
}
