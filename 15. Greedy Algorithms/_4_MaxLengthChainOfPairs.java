import java.util.Arrays;
import java.util.Comparator;

public class _4_MaxLengthChainOfPairs{
    public static int maxLengthChainOfPairs(int[][] pairs){
        if(pairs[0].length != 2){
            System.out.println("Invalid pairs");
            return -1;
        }

        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairs[0][1];
        System.out.print("start -> ("+pairs[0][0]+","+pairs[0][1]+") ");

        for(int i = 0;i < pairs.length;i++){
            if(pairs[i][0] > chainEnd){
                chainLength++;
                chainEnd = pairs[i][1];
                System.out.print("-> ("+pairs[i][0]+","+pairs[i][1]+") ");
            }
        }

        System.out.println(" -> end");

        return chainLength;

    }

    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println(maxLengthChainOfPairs(pairs));
    }
}