import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExC5b {
	
	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter the course title.");
		String title = sc.nextLine();
		
                boolean daysCorrect=false;		
		System.out.println("Enter the number of days for this course.");
		int numberOfDays=0;
		while (!daysCorrect) {
		  try {
		    numberOfDays = Integer.parseInt(sc.nextLine());
			daysCorrect=true;
		  } catch (NumberFormatException nfe){
		      System.out.println("Please enter a whole number. Try again.");
	          }		  
	       } 
		
                boolean priceCorrect=false;		
		System.out.println("What is the price per day?");
		double pricePerDay =0.0;
		while (!priceCorrect){
		 try {
		    pricePerDay = Double.parseDouble(sc.nextLine());
		    priceCorrect=true;
		 } catch (NumberFormatException nfe){
		    System.out.println("Please enter a correct number. Try again, you know the drill...");
	         }
		}
		
		sc.close();
		
		boolean priorKnowledgeRequired = true;
		
				
		List<String> instructors= new ArrayList<>();
		instructors.add("Sandy");
		instructors.add("Gie");
		
		
		
		//double totalPrice = calculatePrice(numberOfDays, pricePerDay, priorKnowledgeRequired );
				
		printInfo(title, numberOfDays, pricePerDay, priorKnowledgeRequired,instructors );
		
		
	  
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