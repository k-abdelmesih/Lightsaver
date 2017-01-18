import java.io.IOException;
import java.util.Scanner;

public class UI{

	//Private Variables
	private static int N=13733; //number of rows in the data set
	private static int n=19; //number of columns in the data set
	private static Product[] product=new Product[N]; //To store products
	private static Scanner scan=new Scanner(System.in);
	private static String choice;

	//This method starts the whole program by parsing the data, and sending the control over to menu.
	public static void main(String[] args) throws IOException{
		Parse.parse(product,N,n);
		System.out.println("Welcome to Lightsaver.\nA Collection of All Energy Star Light Fixtures."); //Welcome message
		menu();
	}

	//This method displays a menu, then calls the appropriate method according to the user's input.
	private static void menu(){
		Scanner menuScan=new Scanner(System.in);
		System.out.println("\n\nPlease pick an option from the following:"
				+ "\n\n1) View All Energy Star Light Fixtures\n2) Sort Items\n3) Search Items\n4) Graph Items");

		choice=menuScan.next();

		//break statements required below to avoid leaking.
		switch(choice){
		case "1":print(); break;
		case "2":sort(); break;
		case "3":search(); break;
		case "4":graph(); break;

		//if input does not match any of the above:
		default:
			System.out.println("\n\nInvalid option.");
			menu();
			break;
		}
		menuScan.close(); //Closing scanner to avoid leak
	}

	//This method is used to print a header, with 100 products or less at a time.
	//It sends the user back to menu if requested, or if the end of a list is reached.
	private static void print(){

		//header:
		System.out.println("\nE.S. ID		Brand Name		      Model Number	       Commercial Vs. Residential     "
				+"Indoor Vs. Outdoor     Technology      Fixture Type				  Light Output	  Input Power	"
				+"En. Eff.: At Source - Outside Fixture	  Temp.	     Color	Life Span     Sources	"
				+"Additional Information			     Date Available	Date Certified	Markets\n"
				+"_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_____________________________\n");
		for(int i=0;i<N;i++){
			if(i>0&&i%100==0){
				//footer:
				System.out.println("_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_____________________________\n\nDisplaying "+i+" out of "+N+" products.\n\n"
						+"Enter 1 to see 100 more or type anything else to go home.");
				choice=scan.next();
				if(!choice.equals("1")) break;
				System.out.println("\nE.S. ID		Brand Name		      Model Number	       Commercial Vs. Residential     "
						+"Indoor Vs. Outdoor     Technology      Fixture Type				  Light Output	  Input Power	"
						+"En. Eff.: At Source - Outside Fixture	  Temp.	     Color	Life Span     Sources	"
						+"Additional Information			     Date Available	Date Certified	Markets\n"
						+"_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_______________________________________________________________________________________________"
						+"_____________________________\n");
			}
			System.out.println(product[i]);
			if(i==N-1) System.out.println("\n____________________________________________________________________________"
					+"___________________________________________________________________________________________________"
					+"___________________________________________________________________________________________________"
					+"___________________________________________________________________________________________________"
					+"____________________________________\n\nEnd of product list.");
		}
		menu();
	}

	//This method checks how the user wants to sort the products and calls the sort class accordingly.
	//It then calls print to print the new sorted list (since heapsort is in place).
	private static void sort(){
		System.out.println("\n\nSort By:\n 1) Energy Star ID\n 2) Brand Name\n 3) Model\n 4) Recommended Use"
				+"\n 5) Recommended Site\n 6) Technology Used\n 7) Fixture Type\n 8) Total Light Output\n 9) Total Input Power"
				+"\n10) Energy Efficiency- Measured At The Source\n11) Energy Efficiency- Measured Outside The Fixture"
				+"\n12) Color Temperature\n13) Color Quality\n14) Light Source Life\n15) Light Sources\n16) Additional Features"
				+"\n17) Date Available\n18) Date Certified\n19) Markets\n\n20) Go Home");

		choice=scan.next();

		if(choice.equals("20")) menu();

		else if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||
				choice.equals("6")||choice.equals("7")||choice.equals("8")||choice.equals("9")||choice.equals("10")||
				choice.equals("11")||choice.equals("12")||choice.equals("13")||choice.equals("14")||choice.equals("15")||
				choice.equals("16")||choice.equals("17")||choice.equals("18")||choice.equals("19"))){

			System.out.println("\nInvalid option.");
			sort();
		}

		else{
			Sort.sort(product,N,choice);
			print();
		}
	}

	//This search method works independently of print. It prints its own elements since this search is not in place.
	//It also gives options when applicable, to return search results higher, or lower, than a given value.
	private static void search(){
		String keyword=null;
		String choice2=null;

		System.out.println("\n\nSearch By:\n 1) Energy Star ID\n 2) Brand Name\n 3) Model\n 4) Recommended Use"
				+"\n 5) Recommended Site\n 6) Technology Used\n 7) Fixture Type\n 8) Total Light Output\n 9) Total Input Power"
				+"\n10) Energy Efficiency- Measured At The Source\n11) Energy Efficiency- Measured Outside The Fixture"
				+"\n12) Color Temperature\n13) Color Quality\n14) Light Source Life\n15) Light Sources\n16) Additional Features"
				+"\n17) Date Available\n18) Date Certified\n19) Markets\n\n20) Go Home");

		choice=scan.next();

		if(choice.equals("20")) menu();

		else if(!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5")||
				choice.equals("6")||choice.equals("7")||choice.equals("8")||choice.equals("9")||choice.equals("10")||
				choice.equals("11")||choice.equals("12")||choice.equals("13")||choice.equals("14")||choice.equals("15")||
				choice.equals("16")||choice.equals("17")||choice.equals("18")||choice.equals("19"))){

			System.out.println("\nInvalid option.");
			search();
		}

		else{
			choice2=null;
			if(choice.equals("1")||choice.equals("8")||choice.equals("9")||choice.equals("10")||choice.equals("11")||
					choice.equals("12")||choice.equals("13")||choice.equals("14")||choice.equals("15")||choice.equals("17")||
					choice.equals("18")){
				System.out.println("\n1) Exact Search\n2) Greater Than a Value \n3) Less Than a Value\n\n4) Go Home");
				choice2=scan.next();
				if(!(choice2.equals("1")||choice2.equals("2")||choice2.equals("3")||choice2.equals("4"))){
					System.out.println("\nInvalid option.");
					search();
				}
				else if(choice2.equals("4")) menu();

				else{
					System.out.println("\nPlease Enter Keyword:");
					keyword=scan.next();
				}
			}
			else{
				System.out.println("\nPlease Enter Keyword:");
				keyword=scan.next();
			}
			Search.search(product,N,choice,choice2,keyword);
			menu();
		}
	}

	//This method allows the user to filter bulbs by categories
	private static void graph(){
		Graph g;
		String[] custom=new String[14];
		Product[] categories=new Product[1];
		String choice2="";
		System.out.println("\n\nCategories:\n1) Bright Indoor LED Downlights\n2) Best Chandeliers\n3) Long lasting LED lights\n"
				+ "4) Best Floor Lamps\n5) Create Custom Category\n\n6) Go Home");
		choice=scan.next();
		if(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")){
			int start=0;
			int end=100;
			choice2="1";
			while(choice2.equals("1")){
				g=new Graph(product);
				g.print("C" + choice, start, end);
				start+=100;
				end+=100;
				choice2=scan.next();
			}
		}
		else if(choice.equals("5")){
			//Brand Filter
			System.out.println("Only return lights from brand:\nN/A to return all brands");
			choice=scan.next();
			custom[0]=choice;
			choice="";

			//Commercial vs. Residential Filter
			while(!(choice.equals("1") || choice.equals("2")|| choice.equals("N/A"))){
				System.out.println("Return only 1 'Residential' or  2 'Commercial' lights\nN/A to return both");
				choice=scan.next();
				switch(choice){
				case("1"):custom[1]="Residential"; break;
				case("2"):custom[1]="Commercial"; break;
				case("N/A"):custom[1]="N/A"; break;
				default:System.out.println("Enter '1', '2', or 'N/A'"); break;	
				}
			}
			choice="";

			//Indoor vs. Outdoor Filter
			while(!(choice.equals("1") || choice.equals("2")|| choice.equals("3") || choice.equals("N/A"))){
				System.out.println("Return only 1 'Indoor', 2 'Outdoor', or 3 'Indoor and Outdoor'\nN/A to return all");
				choice=scan.next();
				switch(choice){
				case("1"):custom[2]="Indoor"; break;
				case("2"):custom[2]="Outdoor"; break;
				case("3"):custom[2]="Indoor and Outdoor"; break;
				case("N/A"):custom[2]="N/A"; break;
				default:System.out.println("Enter '1', '2', '3', or 'N/A'"); break;	
				}
			}
			choice="";

			//Technology Filter
			while(!(choice.equals("1") || choice.equals("2")|| choice.equals("N/A"))){
				System.out.println("Return only 1 'LED' or 2 'Fluoresecent'\nN/A to return both");
				choice=scan.next();
				switch(choice){
				case("1"):custom[3]="LED"; break;
				case("2"):custom[3]="Fluorescent"; break;
				case("N/A"):custom[13]="N/A"; break;
				default:System.out.println("Enter '1', '2', or 'N/A'"); break;	
				}
			}
			choice="";

			//Fixture type Filter
			System.out.println("Only return lights with fixture type:\nN/A to return all fixture types");
			choice=scan.next();
			custom[4]=choice;
			choice="";

			//Output power Filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with total light output greater than:	lumens\n0 to return all");
				choice=scan.next();
				custom[5]=choice;
			}
			choice="";

			//Input power Filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with total input power less than:	watts\n1000 to return all");
				choice=scan.next();
				custom[6]=choice;
			}
			choice="";

			//Energy efficiency Filter
			while(!(checkNumber(choice))){ 
				System.out.println("Only return lights with Energy efficiency greater than:		 \n0 to return all");
				choice=scan.next();
				custom[7]=choice;
			}
			choice="";

			//Colour temperature filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with Correlated colour temperature greater than:      \n0 to return all");
				choice=scan.next();
				custom[8]=choice;
			}
			choice="";

			//Colour quality filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with colour quality greater than:		CRI\n0 to return all");
				choice=scan.next();
				custom[9]=choice;
			}
			choice="";

			//Light source life filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with light source life greater: 		Hours\n0 to return all");
				choice=scan.next();
				custom[10]=choice;
			}
			choice="";

			//Number of light sources filter
			while(!(checkNumber(choice))){
				System.out.println("Only return lights with greater than light fixtures:		\n0 to return all");
				choice=scan.next();
				custom[11]=choice;
			}
			choice="";

			//Special features filter
			while(!(choice.equals("1") || choice.equals("2") || choice.equals("N/A"))){ 
				System.out.println("Return only lights that are 1 'Non-Dimmable' or 2 'Continuous Dimmable':	\nN/A to return all");
				choice=scan.next();
				switch(choice){
				case("1"):custom[12]="Non-Dimmable"; break;
				case("2"):custom[12]="Continuous Dimmable"; break;
				case("N/A"):custom[12]="N/A"; break;
				default:System.out.println("Enter '1', '2', or 'N/A'"); break;	
				}
			}
			choice="";

			//Markets Filter
			while(!(choice.equals("1") || choice.equals("2")|| choice.equals("3") || choice.equals("N/A"))){ 
				System.out.println("Return only lights available in 1 'Canada', 2 'United States' or 3 'United States and Canada':	\nN/A to return all");
				choice = scan.next();
				switch(choice) {
				case("1"):custom[13]="Canada"; break;
				case("2"):custom[13]="United States"; break;
				case("3"):custom[13]="United States and Canada"; break;
				case("N/A"):custom[13]="N/A"; break;
				default:System.out.println("Enter '1', '2', '3', or 'N/A'"); break;
				}
			}
			choice="";	
			categories[0]=new Product("C5", custom[0], "N/A", custom[1], custom[2], custom[3], custom[4], custom[5], custom[6], custom[7], "0", custom[8], custom[9], custom[10], custom[11], custom[12], "N/A", "N/A", custom[13]);
			g=new Graph(product, categories);
			int start=0;
			int end=100;
			choice2="1";
			while(choice2.equals("1")){
				g.print("C5", start, end);
				start+=100;
				end+=100;
				choice2=scan.next();
			};
			menu();
		}
		else if(choice.equals("6")) menu();

		else{
			System.out.println("Invalid option");
			graph();
		}
		menu();
	}

	private static boolean checkNumber(String s){
		if(s.equals("") || s.equals(null)) return false;
		for (char c : s.toCharArray()) if (!Character.isDigit(c)) return false;
		return true;
	}
}