public class _3_largestString {

    public static String largestString(String... strings){
        String largest = strings[0];
        for(int i = 1; i < strings.length;i++){
            if(largest.compareToIgnoreCase(strings[i]) < 0){
                largest = strings[i];
            }
        }
        return largest;
    }

    public static String smallestString(String... strings){
        String smallest = strings[0];
        for(int i = 1;i < strings.length;i++){
            if(smallest.compareToIgnoreCase(strings[i]) > 0){
                smallest = strings[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
       String str1 = "apple",
              str2 = "yellow",
              str3 = "name";
        
       System.out.println(largestString(str1,str2,str3));
        System.out.println(smallestString(str1,str2,str3));

        // Integer i = 100;
        // Integer j = 200;
        // String iString = i.toString();
        // String jString = j.toString();
        // System.out.println(iString + jString);



            
    }
}
