import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);


/*        1.Write a program to find all of the longest word in a given dictionary.

        String[] dict = {"cat", "dog", "red", "is", "am"};
        ArrayList<String>longest=new ArrayList<String>();
        int longestWord=0;
        for (String longArr : dict) {
            int length = longArr.length();
            if (length > longestWord) {
                longestWord = length;
                longest.clear();
            }
            if (length == longestWord) {
                longest.add(longArr);
            }
        }
        System.out.println(longest);

 */



/*        2. Write a program that displays the number of occurrences of an element in the array.

        int[] num={1,1,1,3,3,5};
        int count=0;
        System.out.println("Please enter a number: ");
        int number= inp.nextInt();

        for (int i = 0; i < num.length; i++) {
            if (number == num[i]) {
                count++;
            }
        }
            System.out.println(number+" Occurs "+count+" times");

 */



/*        3.Write a program to find the k largest elements in a given array. Elements in the array can be in
        any order.

        System.out.println("Please enter a number from 1 to 5 to find the largest element: ");
        int num= inp.nextInt();

        Integer[] elements=new Integer[]{1, 4, 17, 7, 25, 3, 100};
        System.out.println(num + " largest elements of the said array are: ");

        Arrays.sort(elements, Collections.reverseOrder());
        for (int i = 0; i < num; i++) {
            System.out.print(elements[i] + " ");
        }

 */

/*        4. Create a method to reverse an array of integers. Implement the method without creating a new
                array.

        int[] numbers={5,4,3,2,1};
        System.out.println("Original Array "+Arrays.toString(numbers));
        for (int i = 0; i < numbers.length/2; i++) {
            int temp=numbers[i];
            numbers[i]=numbers[numbers.length-i-1];
            numbers[numbers.length-i-1]=temp;
        }

        System.out.println("Reversed Array "+Arrays.toString(numbers));

 */
/*        5. Write a menu driven Java program with following option:
        int num;
        int[] arr;
        System.out.println("Please enter the size of the array");
        int size= inp.nextInt();
        int [] elements=new int[size];
        do {
            System.out.println("\nPlease choose an option from the following: \n1. Accept elements of an array  \n" +
                    "2. Display elements of an array  \n" +
                    "3. Search the element within array  \n" +
                    "4. Sort the array  \n" +
                    "5. To Stop ");

            num= inp.nextInt();

            switch (num){
                case 1:
                    System.out.println("Please enter elements: ");
                    for (int i = 0; i < size; i++) {
                        elements[i] = inp.nextInt();
                        }

                    break;

                case 2:
                    System.out.println("Displaying the Array: "+Arrays.toString(elements));
                    break;

                case 3:
                    System.out.println("Please enter the number you want to search for: ");
                    int search=inp.nextInt();
                    boolean found;
                        for (int i = 0; i < elements.length; i++) {
                            if (search==elements[i]){
                                System.out.println("The element "+search+" found in the array");
                                break;
                        }
                            else {
                                System.out.println("The element " + search + " does not exist in the array");
                                break;
                            }
                        }

                case 4:
                    Arrays.sort(elements);
                    System.out.println("Sorted array: ");
                    for (int sorted:elements){
                        System.out.print(sorted+" ");
                    }
                    break;
                case 5:
                    System.out.println("Thank you, goodbye! ");
                    num=5;
                    break;
                default:
                    System.out.println("Sorry please enter a number from the menu above");

            }
        }while (num!=5);

 */

/*        6. Create a method that generates a random number within a given range. Allow the user to
        specify the range and call the method to display random numbers.

        System.out.println("Enter the minimum value of the range: ");
        int minNum = inp.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int maxNum = inp.nextInt();
        System.out.println("Enter the number of random numbers to generate: ");
        int num = inp.nextInt();
        System.out.println("Random numbers within the specified range:");
        int[] numbers = rand(minNum, maxNum, num);
        for (int i = 0; i < num; i++) {
            System.out.print(numbers[i]+" ");
        }

 */

/*        7. Write a program that checks the strength of a password. Create a method that evaluates a
        password based on criteria like length, inclusion of special characters, and uppercase/lowercase
        letters.

        System.out.println("Enter a password: ");
        String pass= inp.nextLine();
        totalScore(pass);

 */

/*        8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
                Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
                and each subsequent number in the sequence is the sum of the two preceding ones.

        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int num= inp.nextInt();
        System.out.print("Fibonacci sequence with "+ num +" terms: \n");
        fibonacci(num);
        
 */






    }

    public static int[] rand(int min,int max,int range){
        Random random=new Random();
        int [] numbers=new int[range];
        for (int i = 0; i < range; i++) {
            numbers[i]=random.nextInt(max-min)+min;
        }
        return numbers;
    }


    public static void totalScore(String pass) {
        int totscore=checkLength(pass)+checkSpecialCharacters(pass)+checkUpperCaseLowerCase(pass);
        if (totscore>=8){
            System.out.println("Password is Strong");
        }
        else if(totscore>=5&&totscore<8){
            System.out.println("Password is moderately strong");
        }
        else
            System.out.println("Password is weak");



    }
    public static int checkLength(String pass){
        int lengthcount=0;
        if (pass.length()>=8){
            lengthcount=3;
        }
        if (pass.length()==6||pass.length()==7){
            lengthcount=2;
        }
        if (pass.length()==0||pass.length()<=5){
            lengthcount=0;
        }
        return lengthcount;
    }

    public static int checkSpecialCharacters(String pass){
        int checkSpecial=0;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(pass);
        boolean isStringContainsSpecialCharacter = matcher.find();

        if(isStringContainsSpecialCharacter){
            checkSpecial=2;
        }

return checkSpecial;
    }


    public static int checkUpperCaseLowerCase (String pass){
        char ch;
        int checkUpLow=0;
        for(int i=0;i < pass.length();i++) {
            ch = pass.charAt(i);
             if (Character.isUpperCase(ch)||Character.isLowerCase(ch)) {
                checkUpLow=3;
            }

        }
        return checkUpLow;
    }

    public static void fibonacci(int num){
        int num1 = 0, num2 = 1;
        for (int i = 0; i < num; i++) {
            System.out.printf(num1 + " ");
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }

    }
}
