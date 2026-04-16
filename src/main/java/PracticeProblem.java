import java.util.Random;
public class PracticeProblem {

	public static void main(String args[]) {

	}
	

    static Random rand = new Random();

    
    public static int randomNumber(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return rand.nextInt(max - min + 1) + min;
    }

   
    public static char randomChar(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }
        int index = rand.nextInt(s.length());
        return s.charAt(index);
    }

    
    public static int randomEvenNumber(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

       
        if (min % 2 != 0) min++;

        int range = ((max - min) / 2) + 1;
        if (range <= 0) {
            throw new IllegalArgumentException("No even numbers in range");
        }

        return min + rand.nextInt(range) * 2;
    }
}

