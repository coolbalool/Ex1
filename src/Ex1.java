    //package assignments.ex1;
    /// This class represents a simple solution for Ex1.
    /// As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
    /// In this assignment, we will design a number formatting converter and calculator.
    /// In general, we will use Strings as numbers over basis of binary till Hexa.
    /// [2-16], 10-16 are represented by A,B,..G.
    /// The general representation of the numbers is as a String with the following format:
    /// <number>**<base> e.g., &ldquo;135bA&rdquo; (i.e., &ldquo;135&rdquo;, as 10 is the default base), &ldquo;100111b2&rdquo;, &ldquo;12345b6&rdquo;,&rdquo;012b5&rdquo;, &ldquo;123bG&rdquo;, &ldquo;EFbG&rdquo;.
    /// The following are NOT in the format (not a valid number):
    /// &ldquo;b2&rdquo;, &ldquo;0b1&rdquo;, &ldquo;123b&rdquo;, &ldquo;1234b11&rdquo;, &ldquo;3b3&rdquo;, &ldquo;-3b5&rdquo;, &ldquo;3 b4&rdquo;, &ldquo;GbG&rdquo;, "", null,
    /// You should implement the following static functions:
    public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param ch a String representing a number in basis [2,16]
         */

        public static int charToInt(char ch)
        {

            if ((ch >= '0' && ch <= '9')) return ch - '0';
            else if (ch == 'A' || ch == 'a') return 10;
            else if (ch == 'B' || ch == 'b') return 11;
            else if (ch == 'C' || ch == 'c') return 12;
            else if (ch == 'D' || ch == 'd') return 13;
            else if (ch == 'E' || ch == 'e') return 14;
            else if (ch == 'F' || ch == 'f') return 15;
            return -1;

        }

        public static char intToChar(int num)
        {
            if (num < 0 || num > 15) return '-';
            if (num == 10) return 'A';
                else if (num == 11) return 'B';
                else if (num == 12) return 'C';
                else if (num == 13) return 'D';
                else if (num == 14) return 'E';
                else if (num == 15) return 'F';
                else return (char) ('0' + num);
        }

        public static int number2Int(String num) {
            if (!isNumber(num)) return -1;
            int  base = charToInt(num.charAt(num.length()-1));
            if (num.charAt(num.length()-1) == 'G') base = 16;
            int ans = 0;
            int mult = 1;

            for (int i = num.length() - 3;i >= 0;i--) // runs until the 2 last characters (b and the base)
            {
                ans += charToInt(num.charAt(i)) * mult;
                mult *= base;
            }
            return ans;
        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            if (a == null || a.length() < 3) return false;

            int base = charToInt(a.charAt(a.length()-1));
            if (a.charAt(a.length()-1) == 'G') base = 16;
            if (base == -1) return false;

            if(a.charAt(a.length()-2) != 'b') return false;

            boolean ans = true;
            for (int i = 0; i < a.length() -2; i++ ) {
                int num = charToInt(a.charAt(i));
                if (num == -1 || num >= base) return false;        }

            return ans;
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            StringBuilder ans = new StringBuilder();
            int division = num;
            if (num == 0) return "0b" + intToChar(base);

            while (division >= 1)
            {
                ans.append(intToChar(division % base));
                division -= division % base;
                division /= base;
            }
            if (num < 0 || base < 2 || base > 16) return "";
            ans.reverse();
            return ans. append("b").append(intToChar(base)).toString();
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            if (isNumber(n1) && isNumber(n2))
                return (number2Int(n1) == number2Int(n2));
            return false;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = -1;
            int maxValue = -1;

            for (int i = 0; i < arr.length; i++)
            {
                int numberValue = number2Int(arr[i]);
                if (numberValue > maxValue)
                {
                maxValue = numberValue;
                ans = i;
                }
            }

            return ans;
        }
    }