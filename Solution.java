import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, String> map;

    public Solution () {
        map = new HashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
    }

    private StringBuilder maxThreeNumberToWords(int num) {
        if (num >= 0 && num <= 20) {
            return new StringBuilder(map.get(num));
        }

        StringBuilder ans = new StringBuilder();

        int last = num % 10;
        int secondLast = (num / 10) % 10;
        int thirdLast = num / 100;

        if (thirdLast > 0) {
            ans.append(map.get(thirdLast))
            .append(" ")
            .append(map.get(100));
        }

        if (secondLast > 0) {
            if (ans.length() > 0) ans.append(" ");
            ans.append(map.get(secondLast * 10));
        }

        if (last > 0) {
            if (ans.length() > 0) ans.append(" ");
            ans.append(map.get(last));
        }

        return ans;
    }

    public String numberToWords(int num) {

        String digits = String.valueOf(num);

        StringBuilder leadingZero = new StringBuilder();

        int n = digits.length();

        for (int i = 0;i < 10 - n;i++) {
            leadingZero.append("0");
        }

        digits = leadingZero.toString() + digits;

        StringBuilder ans = new StringBuilder();

        int billion = Integer.valueOf(digits.substring(0,1));
        int million = Integer.valueOf(digits.substring(1,4));
        int thousand = Integer.valueOf(digits.substring(4,7));
        int hundred = Integer.valueOf(digits.substring(7,10));

        if (billion > 0) {
            ans.append(maxThreeNumberToWords(billion))
               .append(" ")
               .append(map.get(1000000000));
        }

        if (million > 0) {
            if (ans.length() > 0) ans.append(" ");

            ans.append(maxThreeNumberToWords(million))
               .append(" ")
               .append(map.get(1000000));
        }

        if (thousand > 0) {
            if (ans.length() > 0) ans.append(" ");

            ans.append(maxThreeNumberToWords(thousand))
               .append(" ")
               .append(map.get(1000));
        }

        if (hundred > 0) {
            if (ans.length() > 0) ans.append(" ");

            ans.append(maxThreeNumberToWords(hundred));
        }


        System.out.println(digits);

        return ans.toString();

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("#"+sol.numberToWords(111 ) + "#");
        System.out.println(Integer.MAX_VALUE);
    }
}