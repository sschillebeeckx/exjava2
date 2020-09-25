import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExD2 {

	public static void main(String[] args) {

		Path path = Paths.get("instructors.txt");
		try (BufferedReader br = Files.newBufferedReader(path)) {
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

			ArrayList<String> instructors = new ArrayList<>();
			String name = null;
			while ((name = br.readLine()) != null) {
				instructors.add(name);
			}

			//double totalPrice = calculatePrice(numberOfDays, pricePerDay, priorKnowledgeRequired);

			printInfo(title, numberOfDays, pricePerDay, priorKnowledgeRequired, instructors);

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public static void printInfo(String title, int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired,
			List<String> instructors) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(Paths.get("courseinfo.txt"));
		double totalPrice = calculatePrice(numberOfDays, pricePerDay, priorKnowledgeRequired);
		bw.write("The " + title + " course takes " + numberOfDays + " days and costs " + totalPrice
				+ " euros. \nPrior knowledge required: " + priorKnowledgeRequired + "\n");
		String label;
		if (totalPrice < 500) {
			label = "CHEAP";
		} else if (totalPrice >= 500 && totalPrice <= 1500) {
			label = "OK";
		} else {
			label = "EXPENSIVE";
		}

		bw.write("That price is " + label + "\n");
		bw.write("There are " + instructors.size() + " instructors for this course:" + "\n");
		for (String instructor : instructors) {
			bw.write(instructor + "\n");
		}

		bw.close();
		System.out.println("info written to printing.txt");
	}

	public static double calculatePrice(int numberOfDays, double pricePerDay, boolean priorKnowledgeRequired) {
		double totalPrice = numberOfDays * pricePerDay;
		if (!(numberOfDays > 3 && priorKnowledgeRequired)) {
			totalPrice *= 1.21;
		}
		return totalPrice;
	}

}