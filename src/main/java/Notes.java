/**
	* Lesson: Random Module
	* Author: Mr. Kalisz
	* Date Created: April 17, 2023
	* Date Last Modified: April 17, 2023
	*/

import java.util.Random; //Import Random in order to use it

class Notes {
	public static void main(String args[]) {

		Random random = new Random(); //create a Random Object to get our random values from

		int num;

		num = random.nextInt(50); //generates a random number from 0 to one less than your argument (in this case 50)
		System.out.println(num);

		//extending/shifting range with integers
		num = random.nextInt(50); //generates a random number from 0 to one less than your argument (in this case 50)
		System.out.println(num*2+1); //only odd numbers 1-99

		//doubles
		double num2;

		num2 = random.nextDouble();
		System.out.println(num2);

		//change the range of the double

		num2 = random.nextDouble();
	
	//multiplication extends, addition shifts	
		System.out.println(num2*50+50);

		//booleans

		boolean bool;

		bool = random.nextBoolean();
		System.out.println(bool);

		//excluding values

		//range of integers from -5 to 5, exclude 0

		// num = random.nextInt(11);  //currently goes from 0 to 10
		
		// num = random.nextInt(11) - 5;  //currently goes from -5 to 5

		do {
			num = random.nextInt(11) - 5;
		} while (num == 0); //condition is what you are EXCLUDING

		System.out.println(num);
	}
}