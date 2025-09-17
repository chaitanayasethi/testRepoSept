import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.itextpdf.text.List;

public class coreJavaThree {

	//Class 	  >> Object 			 >> Method
		//Luxury Cars >> BMW, Audi, Mercedes >> accelarate, break, speed up, speed down, sun roof
	
	
	
	// Instance variable
    boolean isOn;

    // Method to turn on the lamp
    public void turnOn() {
        isOn = true;
        System.out.println("Light on? " + isOn);
    }

    // Method to turn off the lamp
    public void turnOff() {
        isOn = false;
        System.out.println("Light on? " + isOn);
    }



    public static void main(String[] args) {
        // Creating objects of Lamp class without explicitly calling a constructor
    	coreJavaThree led = new coreJavaThree();
    	coreJavaThree halogen = new coreJavaThree();

        // Using object methods
        led.turnOn();     // Outputs: Light on? true
        halogen.turnOff(); // Outputs: Light on? false
    }

}
