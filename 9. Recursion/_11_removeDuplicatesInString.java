public class _11_removeDuplicatesInString {
    public static String removeDuplicatesInString(String str){//O(n^2)

          StringBuilder newSb = new StringBuilder();
          for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            boolean isRepeated = false;
            for(int j = i-1;j >= 0;j--){
                if(str.charAt(j) == ch){
                    isRepeated = true;
                }
            }
            if(!isRepeated){
                newSb.append(ch);
            }
           
          }

          return newSb.toString();
          
    }

    //using iteration
    public static String removeDuplicatesInString2(String str){//O(n)
        StringBuilder sb = new StringBuilder();
        boolean[] map = new boolean[26];
        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            
            if(!map[ch-'a']){
                map[ch-'a'] = true;
                sb.append(ch);
            }
        }

        return sb.toString();

    }

    //using Recursion(only for lower case string)
    public static void removeDuplicatesInString3(String str,int idx,StringBuilder newstr,boolean[] map){
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }

        char ch = str.charAt(idx);
        if(map[ch-'a']){
            removeDuplicatesInString3(str,idx+1,newstr,map);
        }else{
            map[ch-'a'] = true;
            removeDuplicatesInString3(str,idx+1,newstr.append(ch),map);
        }
    }

    //using recursion(for all types of string)
    public static void removeDuplicatesInString4(String str,int idx,StringBuilder newstr,boolean[] map){
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }

        char ch = str.charAt(idx);
        if(map[ch]){
            removeDuplicatesInString4(str,idx+1,newstr,map);
        }else{
            map[ch] = true;
            removeDuplicatesInString4(str,idx+1,newstr.append(ch),map);

        }
    }

    public static void main(String[] args) {
        removeDuplicatesInString3("anujpathak",0,new StringBuilder(""),new boolean[26]);
        removeDuplicatesInString4("anujAnujPpPp23423@!@!@2", 0, new StringBuilder(),new boolean[128] );
    }
}