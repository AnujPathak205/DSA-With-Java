import java.util.ArrayList;


public class _2_FindSubSet {
    public static void printSubSets(String str,String subString,int i){
        if(i == str.length()){
            if(subString.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(subString);
            }
            return;
        }

        printSubSets(str, subString+str.charAt(i), i+1);
        printSubSets(str, subString, i+1);
    }

    public static void FillSubsetsToArr(String str,String subString,int i,ArrayList<String>subsetArr){
        if(i == str.length()){
            if(subString.length() == 0){
                subsetArr.add("null");
            }else{
                subsetArr.add(subString);
            }
            return;
        }

        FillSubsetsToArr(str, subString+str.charAt(i), i+1, subsetArr);
        FillSubsetsToArr(str, subString, i+1, subsetArr);
    }

    public static void printBinary(int n,int i,String binaryStr){
        if(i == n){
            
            System.out.println(binaryStr);
            return;
        }

        printBinary(n, i+1, binaryStr+"0");
        printBinary(n, i+1, binaryStr+"1");
    }

    

    public static void main(String[] args) {
        printSubSets("abc", "", 0);
        // printBinary(3, 0, "");
        ArrayList<String> subsetArray = new ArrayList<>();
        String str = "abc";
        FillSubsetsToArr(str, "", 0, subsetArray);
        System.out.println(subsetArray);
    }
}
