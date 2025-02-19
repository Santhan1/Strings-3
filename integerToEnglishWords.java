
// Mostly asked in FB in interviews
//273. Integer to English Words
// LC Hard
// TC = O(1)
// SC = O(1)
class integerToEnglishWords {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String result = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                result = magic(num % 1000) + thousands[i] + " " + result; // Thousands array used here
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }

    // This functions helps building English words for 3 ints
    public String magic(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return below_20[num] + " "; // Unique words for 1 to 19
        } else if (num < 100) {
            return tens[num / 10] + " " + magic(num % 10); // Under 100 words would be build here
        } else {
            return below_20[num / 100] + " Hundred " + magic(num % 100); // Under 1000
        }
    }
}