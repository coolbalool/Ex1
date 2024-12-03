import java.util.Arrays;
import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String[] nums = new String[4];

        nums[0] = assignNumber(1);
        if (nums[0].equals("Err")) return;
        int val1 = Ex1.number2Int(nums[0]);

        nums[1] = assignNumber(2);
        if (nums[1].equals("Err")) return;
        int val2 = Ex1.number2Int(nums[1]);

        // result
        System.out.println("Enter a base for output: (a number [2,16] ");
        String baseStr = in.nextLine();
        int base;
        if (baseStr.length() >1) base = Integer.parseInt(baseStr);
        else base = Ex1.charToInt(baseStr.charAt(0));

        String sumNum = Ex1.int2Number(val1 + val2,base);
        String multNum = Ex1.int2Number(val1 * val2,base);
        nums[2] = sumNum;
        nums[3] = multNum;
        System.out.println(nums[0] + " + " + nums[1] +" = " +sumNum);
        System.out.println(nums[0] + " * " + nums[1] +" = " +multNum);
        System.out.println("Max number over "+Arrays.toString(nums)+" is: " + nums[Ex1.maxIndex(nums)]);

    }

    public static String assignNumber(int index)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string as number#"+index+" (or \"quit\" to end the program): ");
        String num = in.nextLine();
        if (num.equals("quit")) {
            System.out.println("Quiting...");
            return "Err";}
        int valNum1 = Ex1.number2Int(num);
        System.out.println("num"+index+"= "+num+" is number: "+Ex1.isNumber(num)+" , value: "+valNum1);
        return num;
    }


}
