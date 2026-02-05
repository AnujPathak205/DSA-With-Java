public class _5_ReverseWords {
    public static String ReverseWords(String sentence){
        int n = sentence.length();
        StringBuilder newSentence = new StringBuilder();
        int end = n;
        for(int i = n-1;i >= 0;i--){
            if(i == 0 || sentence.charAt(i-1) == ' '){
                for(int j = i;j < end;j++){
                    newSentence.append(sentence.charAt(j));
                }
                newSentence.append(" ");
                end = i-1;

            }
        }

        return newSentence.toString();

    }

    public static void main(String[] args) {
        String sentence = "boy good a is Pathak Anuj";
        System.out.println(ReverseWords(sentence));
    }
}
