import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.itextpdf.text.List;

public class coreJavaOne {

	public static void main(String[] args) {
		
	//TOPIC 1
		//Data Types and Variables
		
		// int (Integer)
		//Range: -2,147,483,648 to 2,147,483,647
		int age = 30;
		System.out.println(age); // Output: 30

		// double (Floating Point) //double vs float
		double price = 499.99;
		System.out.println(price); // Output: 499.99

		// boolean (True/False)
		boolean isAvailable = true;
		System.out.println(isAvailable); // Output: true

		// char (Character)
		char grade = 'A';
		System.out.println(grade); // Output: A


		// short (Short Integer)
		// Range:- -32,768 to 32,767
		short temperature = -200;
		System.out.println(temperature); // Output: -200

		// long (Large Integer)
		// Range:- -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		long population = 789654123L;
		System.out.println(population); // Output: 789654123

		// float (Single Precision Decimal)
		float average = 87.65f;
		System.out.println(average); // Output: 87.65

		//String and corresponding methods
		String str = "Hello, Selenium!";
        String str2 = "  hello, selenium!  ";
        String str3 = "Java Programming";

        // length() - returns length of the string
        System.out.println("Length: " + str.length()); // 16

        // charAt(int index) - returns char at specific index
        System.out.println("Char at 1: " + str.charAt(1)); // 'e'

        // toUpperCase() - converts string to uppercase
        System.out.println("Uppercase: " + str.toUpperCase()); // "HELLO, SELENIUM!"

        // toLowerCase() - converts string to lowercase
        System.out.println("Lowercase: " + str.toLowerCase()); // "hello, selenium!"

        // trim() - removes leading and trailing whitespace
        System.out.println("Trimmed: '" + str2.trim() + "'"); // "hello, selenium!"

        // substring(int beginIndex) - substring from beginIndex till end
        System.out.println("Substring from 7: " + str.substring(7)); // "Selenium!"

        // substring(int begin, int end) - substring start to end-1
        System.out.println("Substring (7,14): " + str.substring(7, 14)); // "Selenium"

        // contains(CharSequence) - checks if it contains a substring
        System.out.println("Contains 'Selenium'? " + str.contains("Selenium")); // true

        // equals(Object) - checks equality (case-sensitive)
        System.out.println("Equals str2? " + str.equals(str2)); // false

        // equalsIgnoreCase(String) - equals ignoring case
        System.out.println("EqualsIgnoreCase str2? " + str.equalsIgnoreCase(str2.trim())); // true

        // replace(char oldChar, char newChar) - replace characters
        System.out.println("Replace 'l' with 'x': " + str.replace('l', 'x')); // "Hexxo, Sexenium!"

        // split(String regex) - split string into array by delimiter
        String[] parts = str3.split(" ");
        System.out.println("Split parts:" + parts[0]);
        for (String part : parts) {
            System.out.println(part);
        }
        // Outputs "Java" and "Programming"

        // startsWith(String prefix) - checks prefix
        System.out.println("Starts with 'Hello'? " + str.startsWith("Hello")); // true

        // endsWith(String suffix) - checks suffix
        System.out.println("Ends with '!'? " + str.endsWith("!")); // true

        // isEmpty() - checks if string is empty
        System.out.println("Is empty? " + "".isEmpty()); // true
		
        
      //TOPIC 2
    	//Arithmetic, Comparison, and Logical operators

        // Arithmetic Operators
        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b));  // Addition: 13
        System.out.println("a - b = " + (a - b));  // Subtraction: 7
        System.out.println("a * b = " + (a * b));  // Multiplication: 30
        System.out.println("a / b = " + (a / b));  // Division (integer): 3
        System.out.println("a % b = " + (a % b));  // Modulus (remainder): 1

        
        // Comparison Operators
        System.out.println("a == b: " + (a == b));  // Equality: false
        System.out.println("a != b: " + (a != b));  // Not equal: true
        System.out.println("a > b: " + (a > b));    // Greater than: true
        System.out.println("a < b: " + (a < b));    // Less than: false
        System.out.println("a >= b: " + (a >= b));  // Greater or equal: true
        System.out.println("a <= b: " + (a <= b));  // Less or equal: false

        // Logical Operators
        boolean x = true, y = false;

        System.out.println("x && y: " + (x && y));  // Logical AND: false
        System.out.println("x || y: " + (x || y));  // Logical OR: true
        System.out.println("!x: " + (!x));          // Logical NOT: false

        // Usage in validation / assertion-like context
        if (a > b && b > 0) {
            System.out.println("Both conditions are true: a is greater than b, and b is positive.");
        }

        if (a == 10 || y) {
            System.out.println("At least one condition is true: a is 10 or y is true.");
        }
        
      //TOPIC 3
    	//Conditional Statements using if-else and switch-case
	
        int score = 40;

        // if-else example
        if (score >= 90) {
            System.out.println("Grade A: Excellent!");
        } else if (score >= 75) {
            System.out.println("Grade B: Good job.");
        } else if (score >= 60) {
            System.out.println("Grade C: You passed.");
        } else {
            System.out.println("Grade F: You failed.");
        }
        
        int u = 0;
        if (u%2!=0) {
        	System.out.println("odd");	
        }else if (u==0) {
        	System.out.println("out of scope");
        }
        else {
        	System.out.println("even");	

        }
        
        //Using if-else condition, print if a number is even or odd

        int dayOfWeek = 2;

        // switch-case example
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
        
      //TOPIC 4
    	//Iterations
        	//for
        for (int i = 1; i <= 5; i++) {
            System.out.println("Java is fun");
        }
        
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        
        	//while
        Scanner scanner = new Scanner(System.in);
        String input = "";

        // Keep reading user input until "exit" is typed
        while (!input.equalsIgnoreCase("ravalika")) {
            System.out.print("Enter text (type 'exit' to stop): ");
            input = scanner.nextLine();
            System.out.println("You typed: " + input);
        }
        scanner.close();
        
        	//do while
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while (j <= 10);


	}

}

/*
 * Chaitanaya 
 * Chaitanaya
 * Chaitanaya
 */
