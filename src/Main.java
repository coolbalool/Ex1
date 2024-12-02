import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String[] nums = new String[4];
        // first number
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
        String num1 = in.nextLine();
        if (num1.equals("quit")) return;
        nums[0] = num1;
        int valNum1 = Ex1.number2Int(num1);
        System.out.println("num1= "+num1+" is number: "+Ex1.isNumber(num1)+" , value: "+valNum1);
// second number
        System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
        String num2 = in.nextLine();
        nums[1] = num2;
        int valNum2 = Ex1.number2Int(num2);
        if (num2.equals("quit")) return;
        System.out.println("num2= "+num2+" is number: "+Ex1.isNumber(num2)+" , value: "+valNum2);
        // result
        System.out.println("Enter a base for output: (a number [2,16] ");
        int base = in.nextInt();
        String sumNum = Ex1.int2Number(valNum1 + valNum2,base);
        String multNum = Ex1.int2Number(valNum1 + valNum2,base);
        nums[2] = sumNum;
        nums[3] = multNum;
        System.out.println(num1 + " + " + num2 +" = " +sumNum);
        System.out.println(num1 + " * " + num2 +" = " +multNum);
        System.out.println("Max number over "+Arrays.toString(nums)+" is: " + nums[Ex1.maxIndex(nums)]);

    }
}
