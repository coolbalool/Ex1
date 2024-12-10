
# Ex1 - readme

This project does arithmetic operations (+,*) on a numbers in different bases from [2,16].

A proper format for the numbers are (xbB) where x is the number, b is for seperation between the number and the base and B is the base represented as a char in the range of [2,9] or [A,G] ( A = 10,B = 11 etc...)
For example 1010b2  = 1010 in binary which is 10 in decimal.
for decimal number the user can type just the number without the bA part, for example 3bA := 3

In the main run the function recives 2 numbers from the user and convert them to decimal if the numbers are correct it asks the user for a base for output between [2,16].
then it prints the sum and the multiplication of the 2 numbers in the chosen base, adds all numbers to array and prints the biggest number in its base.

# Funcion of Ex1:
and the thought behind its implementation

* toStdNum
  public static String toStdNum(String num)

The function takes a number and if it is written in decimal without the bA part it adds it otherwise it returns num.

I checked if the string only has characters between [0,9] and if it does returns the string + "bA"

# 

* charToInt
  public static int charToInt(char ch)

The function takes a char and returns the int correlates to it in the range of [2,15] if the char is invalid it returns '-'

Checked if the char between [2,9] if it does return char - '0' because the ascii table value

#

* intToChar
  public static char intToChar(int num)

The function does the reverse of charToInt it takes a int and returns the correlating char
if the num is invalid returns '-'

#

* number2Int
  public static int number2Int(String num)

The function takes a number in the format and returns it as a integer in decimal

The conversion is done by running from length - 1
untill 0 becasue the 2 last numbers are b and the base. The number is the sum of the value in ith place times the mult which is the base and for each iteration we multiply the mult by the base

#

* isNumber
  public static boolean isNumber(String a)

The function takesa number and returns true if it in the format.

Minumun length for a number in the format is 3 so if length < 3 or the char before last is not b  you can return false then it runs on each char untill the b if the char is bigger or equals to the base or is smaller then 0 return false
if it hasnt happened you can return true

#

* int2Number
  public static String int2Number(int num, int base)

The function takes number and base and returns it as a valid number in the format

The number value is got by looping and adding to a new string the leftover from the division by the base untill the number has only leftover then it reverses it and adds 'b' and the base as a char to the end of it

#

* equals
  public static boolean equals(String n1, String n2)

The Function returns true if the value of 2 numbers is equal

The function converts the number to int and then checks if it equal

#

* maxIndex
  public static int maxIndex(String[] arr)

The function returns the index of the max value number in the array

The function iterates threw the array and saves the largest value by converting the num to integer then if a number has bigger value then the value it replaces it and its index then return the index



