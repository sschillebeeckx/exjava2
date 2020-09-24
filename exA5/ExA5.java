import java.util.ArrayList;
import java.util.Scanner;

public class ExA5 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the course title.");
		String title = sc.nextLine();
		
		System.out.println("Enter the number of days for this course.");
		int numberOfDays = sc.nextInt();
		
		System.out.println("What is the price per day?");
		double pricePerDay = Double.parseDouble(sc.nextLine());
		
		sc.close();
		
		boolean priorKnowledgeRequired = false;
		
		
		System.out.println("The " + title + " course takes " + numberOfDays + " days and costs " + pricePerDay + " euros per day. \nPrior knowledge required: " + priorKnowledgeRequired );
		
		ArrayList<String> instructors= new ArrayList<>();
		instructors.add("Sandy");
		instructors.add("Gie");
		
		System.out.println("There are " + instructors.size() + " instructors for this course.");
		
		double totalPrice = numberOfDays*pricePerDay*1.21;
		System.out.println("The total price is " + totalPrice + " euro.");
		
	}
}