import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner inp=new Scanner(System.in);

        //Lab 1

        //---------------------------------------------------------------------------------------------------


        /*1. Write a Java program to print the sum (addition), multiply, subtract, divide and remainder of
two numbers , takes two numbers as input
        try {
            System.out.println("Enter First number: ");
            int num1= inp.nextInt();
            System.out.println("Enter Second number: ");
            int num2= inp.nextInt();
            equations(num1,num2);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (InputMismatchException e){
            System.out.println("Please input an integer");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

         */


        //---------------------------------------------------------------------------------------------------


/*        2. Write a Java program that takes a number as input and prints its multiplication table up to 10.
        Test Data:
        try {
            System.out.println("Enter a number: ");
            int num= inp.nextInt();
            System.out.println("The multiplication Table is: ");
            for (int i = 1; i <=10 ; i++) {
                System.out.println(num +" × "+i+" = "+ (num*i));
            }
        }catch (InputMismatchException e){
            System.out.println("Please input an integer");
        }

 */


        //---------------------------------------------------------------------------------------------------



/*        3. Write a Java program to print the area and perimeter of a circle.
        try {
            System.out.println("Enter the radius: ");
            double r= inp.nextDouble();
            double PI=Math.PI;
            double perimeter= 2*PI*r;
            double area=PI*(r*r);
            System.out.println("Perimeter is= "+ perimeter);
            System.out.println("Area is= "+area);
        }catch (InputMismatchException e){
        System.out.println("Please input an integer");
    }

 */





        //---------------------------------------------------------------------------------------------------



/*        4. Java program to find out the average of a set of integers
        System.out.print("Enter a set of integers: ");
        try {
            int set = inp.nextInt();

            double sum = 0;
            double avg = 0;

            for (int i = 0; i < set; i++) {
                System.out.print("Enter an integer: ");
                int num = inp.nextInt();
                sum=sum+num;
                avg=sum/set;
            }
            System.out.println("The average is: "+ avg);

        }catch (InputMismatchException e){
            System.out.println("please input a number");
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        5. Write a Java program that accepts three integers as input, adds the first two integers
        together, and then determines whether the sum is equal to the third integer.
        try {
            System.out.print("Enter the first number: ");
            double num1 = inp.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = inp.nextDouble();
            System.out.print("Enter the third number: ");
            double num3 = inp.nextDouble();
            equal(num1,num2,num3);

        }catch (InputMismatchException e){
            System.out.println("please input a number");
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        6. Write a Java program to reverse a word.

        System.out.println("Input a word: ");
        try {
            String word=inp.nextLine();
            System.out.println("Reversed word: "+ reverse(word));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

 */


        //---------------------------------------------------------------------------------------------------


/* 7 -  Java program to check whether the given number is even or odd
        try {
            System.out.println("Enter a number: ");
            int num= inp.nextInt();

            if (num%2==0){
                System.out.println("The number is Even");
            }
            else{
                System.out.println("The number is Odd");
            }
        }catch (InputMismatchException e){
            System.out.println("please input a number");
        }

 */


        //---------------------------------------------------------------------------------------------------



/*        8 - Java program to convert the temperature in Centigrade to Fahrenheit
        try {
            System.out.println("Enter temperature in Centigrade (°C):  ");
            int cel= inp.nextInt();

            double fah=(cel*1.8)+32;

            System.out.println("Temperature in Fahrenheit is: "+fah+" °F");
        }catch (InputMismatchException e){
            System.out.println("please input a number");
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        9.Write a Java program that takes a string and a number from the user,then prints the
        character in the given index.
        try {
            System.out.println("Enter a String:  ");
            String word=inp.nextLine();
            System.out.println("Enter a number from ("+0+" , "+(word.length()-1)+" )");
            int num= inp.nextInt();
            indexString(word,num);
        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

 */

        //---------------------------------------------------------------------------------------------------


/*        10. Write a Java program to print the area and perimeter of a rectangle.
        try {
            System.out.println("Enter the width:  ");
            double width= inp.nextDouble();

            System.out.println("Enter the height:  ");
            double height= inp.nextDouble();

            double area=width*height;
            double per=2*(width+height);
            System.out.println("Area is "+width+" × "+height+" = "+area);
            System.out.println("Perimeter is 2 × ("+width+" + "+height+") = "+per);

        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
        }

 */

        //---------------------------------------------------------------------------------------------------


/*        11. Write a Java program to compare two numbers.
        try {
            System.out.println("Enter first number: ");
            int num1= inp.nextInt();
            System.out.println("Enter Second number: ");
            int num2= inp.nextInt();
            compare(num1,num2);
        }catch (InputMismatchException e){
            System.out.println("Please input a number");
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        12. Write a Java program to convert seconds to hours, minutes and seconds.
        try {
            System.out.println("Input seconds: ");
            int sec=inp.nextInt();
            int min=(sec%3600)/60;
            int hours=sec/3600;
            int seconds=sec%60;
            System.out.println(hours+":"+min+":"+seconds);
        }catch (InputMismatchException e){
            System.out.println("Please input a number");
        }

 */

        //---------------------------------------------------------------------------------------------------


/*        13. Write a Java program that accepts four integers from the user and prints equal if all
        four are equal, and not equal otherwise.
        try {
            System.out.print("Enter the first number: ");
            int num1 = inp.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = inp.nextInt();
            System.out.print("Enter the third number: ");
            int num3 = inp.nextInt();
            System.out.print("Enter the fourth number: ");
            int num4 = inp.nextInt();
            isEqual(num1,num2,num3,num4);
        }catch (InputMismatchException e){
            System.out.println("Please input a number");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        14. Write a Java program that reads an integer and check whether it is negative, zero, or
        positive.
        try {
            System.out.println("Input a number");
            int num= inp.nextInt();
            npz(num);
        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        15.Write a program to enter the numbers till the user wants and at the end it should
        display the count of positive, negative and zeros entered
        
        int num=0,pos=0,neg=0,zero=0;
        try {
            do {
                System.out.print("Enter an integer or enter -1 to quit: ");
                num = inp.nextInt();
                if (num>0){
                    pos++;
                }
                else if (num<0){
                    neg++;
                }
                else zero++;
            }while(num!=-1);

            System.out.println(pos+ " Positives.");
            System.out.println(zero+ " Zero.");
            System.out.println(neg+ " Negatives.");
        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
        }

 */


        //---------------------------------------------------------------------------------------------------



/*        16 - Write a program that prompts the user to input an integer and then outputs the
        number with the digits reversed.
        try {
            System.out.println("Enter a number: ");
            int num= inp.nextInt();
            int rev=0;

            while (num!=0){
                int rem=num%10;
                rev=(rev*10)+rem;
                num=num/10;
            }
            System.out.println("The reversed number is: "+rev);
        }catch (InputMismatchException e){
            System.out.println("Please enter a number");
        }

 */


        //---------------------------------------------------------------------------------------------------


/*        17 - Write a program to enter the numbers till the user wants and at the end the program
        should display the largest and smallest numbers entered.
        int smallest=0,largest=0;
            try {
                System.out.print("Enter an integer or enter -1 to quit: ");
                int num = inp.nextInt();
                do {
                    System.out.print("Enter an integer or enter -1 to quit: ");
                    num = inp.nextInt();
                    if (num>largest){
                        largest=num;
                    }
                    else if (num<smallest){
                        smallest=num;
                    }
                }while(num!=-1);

                System.out.println("The largest number is: "+ largest);
                System.out.println("The Smallest number is: "+ smallest);
            }catch (InputMismatchException e){
                System.out.println("please enter a number");
            }

 */

        //---------------------------------------------------------------------------------------------------

        
/*        18 - Determine and print the number of times the character ‘a’ appears in the input
        entered by the user.
            try {
                System.out.println("Enter a string: ");
                String word= inp.nextLine();
                System.out.println("The number of (a) is: "+numOfA(word));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

 */

    }


public static void equal (double num1, double num2, double num3)throws Exception{
    double sum= num1+num2;
    boolean equal;
    if (sum==num3){
        equal=true;
        throw new Exception("The result is: "+equal);
    }
    else {
        equal=false;
        throw new Exception("The result is: "+equal);
    }
}

    public static void equations(int num1,int num2) throws Exception{
        System.out.println("Addition: "+num1+" + "+ num2 +" = "+(num1+num2));
        System.out.println("Subtract: "+num1+" - "+ num2 +" = "+(num1-num2));
        System.out.println("Multiply: "+num1+" × "+ num2 +" = "+(num1*num2));
        System.out.println("Division: "+num1+" / "+ num2 +" = "+(num1/num2));
        System.out.println("Reminder: "+num1+" mod "+ num2 +" = "+(num1%num2));
        if (num2==0){
            throw new Exception("Second number can not be 0");
        }
    }

    public static String reverse(String word)throws Exception{
        String rev= "";
        try {
            if (word.isEmpty()) {
                throw new Exception("String Cant be 0 or null");
            }
            else {
                String reverse = reverse(word);
                if (reverse.isEmpty()) {
                    throw new Exception("Reversed String Cant be 0 or null");
                }
                else {
                for (int i = word.length() - 1; i >= 0; i--) {
                    rev += word.charAt(i);
                }
            }
        }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return rev;
    }
    public static void indexString (String word, int num) throws Exception{
        try {
            if (word.isEmpty()) {
                throw new Exception("String cant be null");
            }
            else {
                try {
                    char cha = word.charAt(num);
                    System.out.println("The letter is: " + cha);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Invalid index. Please enter a valid index within the string length.");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void compare(int num1, int num2){
        if (num1 == num2)
            System.out.println( num1+" = "+ num2);
        if (num1 != num2)
            System.out.println(num1+" != "+num2);
        if (num1 < num2)
            System.out.println( num1+ " < "+num2);
        if (num1 > num2)
            System.out.println( num1+" > "+ num2);
        if (num1 <= num2)
            System.out.println( num1+ " <= "+num2);
        if (num1 >= num2)
            System.out.println(num1+" >= "+  num2);
    }

    public static void isEqual(int num1,int num2, int num3,int num4) throws Exception{

        if (num1==num2&&num2==num3&&num1==num4){
           throw new Exception("Numbers are Equal!");
        }
        else
            throw new Exception("Numbers are not Equal!");
    }

    public static void npz(int num)throws Exception{
            if (num>0){
                throw new Exception("Number is positive");
            }
            else if (num<0){
                throw new Exception("Number is negative");
            }
            else {
                throw new Exception("Number is zero");
            }

    }
    public static int numOfA(String word)throws Exception{
        int num=0;
        try {
            if (word.isEmpty()) {
                throw new Exception("String cant be null");
            }
            for (int i = word.length() - 1; i >= 0; i--) {
                    if (Character.isDigit(word.charAt(i))){
                        throw new Exception("Please enter a String");
                }

                if (word.charAt(i) == 'a') {
                    num++;
                }
            }

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return num;
    }
    }



