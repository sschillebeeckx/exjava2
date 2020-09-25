import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExC5a {
	
	public static void main (String[] args) {
		
		
	  try {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the course title.");
		String title = sc.nextLine();
		System.out.println("Enter the number of days for this course.");
		int numberOfDays = Integer.parseInt(sc.nextLine());		
		
		System.out.println("What is the price per day?");
		double pricePerDay = Double.parseDouble(sc.nextLine());
		
		sc.close();
		
		boolean priorKnowledgeRequired = true;
		
				
		List<String> instructors= new ArrayList<>();
		instructors.add("Sandy");
		instructors.add("Gie");
		
		
		//double totalPrice = calculatePrice(numberOfDays, pricePerDay, priorKnowledgeRequired );
				
		printInfo(title, numberOfDays, pricePerDay, priorKnowledgeRequired,instructors );
		
		
	  } catch (NumberFormatException nfe){
		  System.out.println("Sorry, we don't accept wrong stuff, run it again.");
	  }
	}
	 
	public static void printInfo(String title, int numberOfDays, double pricePerDay,boolean priorKnowledgeRequired, List<String> instructors ){
	   double totalPrice = calculatePrice(numberOfDays, pricePerDay, priorKnowledgeRequired );
	   System.out.println("The " + title + " course takes " + numberOfDays + " days and costs " + totalPrice + " euros. \nPrior knowledge required: " + priorKnowledgeRequired );
	   System.out.println("There are " + instructors.size() + " instructors for this course.");
		
		String label;
		if (totalPrice < 500) {
			label = "CHEAP";
		} else if (totalPrice >= 500 && totalPrice <=1500) {
			label = "OK";
		} else {
			label = "EXPENSIVE";
		}
		
		System.out.println("That price is " + label);
	}
	
	public static double calculatePrice(int numberOfDays, double pricePerDay,boolean priorKnowledgeRequired ){
		double totalPrice = numberOfDays*pricePerDay;
		if (!(numberOfDays>3 && priorKnowledgeRequired)) {
			totalPrice*=1.21;
		}
		return totalPrice; 
	}
	
}