// Question 2 :
// You are given a number (eg - 2019), convert it into a String of english like
// “two zero one nine”. Use a recursive function to solve this problem.
// NOTE - The digits of the number will only be in the range 0-9 and the last digit of a number
// can’t be 0.
// Sample Input : 1947
// Sample Output : “one nine four seven”
public class _15_NumberToEnglishStr {

    public static void convertIntoWords(int n){
        if(n <= 0){
            return;
        }

        convertIntoWords(n/10);
        int a = n%10;
        String newStr = "";

        switch(a){
            case 0:newStr +="Zero ";
            break;
            case 1:newStr += "One ";
            break;
            case 2:newStr += "two ";
            break;
            case 3:newStr +="Three ";
            break;
            case 4:newStr +="Four ";
            break;
            case 5:newStr +="Five  ";
            break;
            case 6:newStr +="Six  ";
            break;
            case 7:newStr +="Seven ";
            break;
            case 8:newStr += "Eight ";
            break;
            case 9:newStr += "Nine ";
            break;

        }
        System.out.print(" "+newStr);
    }




    public static String convertIntoEnglishString2(int n,String str){
        if(n <= 0){
            return str;
        }

        String newStr = convertIntoEnglishString2(n/10, str);
        int a = n%10;
        switch(a){
            case 0:newStr +="Zero ";
            break;
            case 1:newStr += "One ";
            break;
            case 2:newStr += "two ";
            break;
            case 3:newStr +="Three ";
            break;
            case 4:newStr +="Four ";
            break;
            case 5:newStr +="Five  ";
            break;
            case 6:newStr +="Six  ";
            break;
            case 7:newStr +="Seven ";
            break;
            case 8:newStr += "Eight ";
            break;
            case 9:newStr += "Nine ";
            break;

        }
         
        return newStr;
    }

    static String[] digits = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

    public static void convertIntoEnglishString3(int n){
        if(n <= 0){
            return;
        }

        int digit = n%10;
        convertIntoEnglishString3(n/10);
        System.out.print(digits[digit]+" ");
    }
    
    public static void main(String[] args) {
        convertIntoEnglishString3(1324);
        System.out.println("\n"+convertIntoEnglishString2(1324, ""));
    }
    
}
