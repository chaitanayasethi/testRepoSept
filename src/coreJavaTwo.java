import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.itextpdf.text.List;

public class coreJavaTwo {

	public static void main(String[] args) {
		
		//Array
		
		//Example aircraftSeats[]
		
		int it = 2;
		
		// Store multiple test data points in an array
	
        int[] testDataPoints = {10, 20, 30, 40, 50};      
        String[] strName = {"Chaitanaya", "Sethi"};
        
        System.out.println(testDataPoints[0]);
        
        // Create an ArrayList of String type
        ArrayList<String> animals = new ArrayList<>();

        // Add elements to ArrayList
        animals.add("Cat");
        animals.add("Dog"); 
        animals.add("Cow");

        // Print ArrayList
        //System.out.println(animals);
        
        // Access element at index 1
        String secondAnimal = animals.get(1); // "Dog"
        System.out.println("Element at index 1: " + secondAnimal);

        // Modify element at index 2
        animals.set(2, "Sheep");
        System.out.println("Modified ArrayList: " + animals);

        animals.remove("Cat"); // Removes "Cat"
        animals.remove(1); // Removes element at index 1 ("Sheep")
        System.out.println("After removal: " + animals);

        
        // Iterate over the array using a for loop
        for (int i = 0; i < testDataPoints.length; i++) {
            //System.out.println("Data point at index " + i + ": " + testDataPoints[i]);
        }

        // Alternatively, iterate using enhanced for loop (for-each)
        System.out.println("Using enhanced for loop:");
        for (int dataPoint : testDataPoints) {
            System.out.println("Data point value: " + dataPoint);
        }


	}

}
