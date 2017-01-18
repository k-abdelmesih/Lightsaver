import java.util.Scanner;

public class Search{
	
	private static Scanner scan;

	//This method checks to see which category is to be searched.
	//It also looks checks to see if extra searching options are selected when applicable.
	//It also prints the search results, and calls onto the other functions in this class to print headers and footers.
	public static void search(Product[] product,int N,String searchBy,String type,String keyword){
		scan=new Scanner(System.in);
		String choice=null;
		int count=-1;
		boolean empty=true;

		printHead();

		switch(searchBy){
		case "1":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					
					//.toLowerCase() is used to ensure that capitalization does not make a difference and return all results.
					//.contains is used to return all possible instances of the keyword.
					if(product[i].ID().toLowerCase().contains(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;

							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].ID().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;

							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].ID().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;

							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "2":
			for(int i=0;i<N;i++){
				if(product[i].brand().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "3":
			for(int i=0;i<N;i++){
				if(product[i].model().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "4":
			for(int i=0;i<N;i++){
				if(product[i].use().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "5":
			for(int i=0;i<N;i++){
				if(product[i].site().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "6":
			for(int i=0;i<N;i++){
				if(product[i].technology().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "7":
			for(int i=0;i<N;i++){
				if(product[i].type().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
				}
			}
			break;

		case "8":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].output().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].output().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].output().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "9":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].input().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].input().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].input().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "10":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].atSource().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].atSource().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].atSource().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "11":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].outFixture().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].outFixture().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].outFixture().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "12":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].temperature().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].temperature().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].temperature().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "13":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].colorQuality().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].colorQuality().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].colorQuality().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "14":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].life().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].life().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].life().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "15":
			if(type.equals("1")){
				for(int i=0;i<N;i++){
					if(product[i].sources().toLowerCase().equals(keyword.toLowerCase())){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("2")){
				for(int i=0;i<N;i++){
					if(product[i].sources().toLowerCase().compareTo(keyword.toLowerCase())>0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}

			else if(type.equals("3")){
				for(int i=0;i<N;i++){
					if(product[i].sources().toLowerCase().compareTo(keyword.toLowerCase())<0){
						count++;
						if(i>0&&i%100==0){
							printTail(count);
							choice=scan.next();
							if(!choice.equals("1")) return;
							printHead();
						}
						System.out.println(product[i]);
						empty=false;
					}
				}
			}
			break;

		case "16":
			for(int i=0;i<N;i++){
				if(product[i].features().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "17":
			for(int i=0;i<N;i++){
				if(product[i].dateAvailable().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "18":
			for(int i=0;i<N;i++){
				if(product[i].dateCertified().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;

		case "19":
			for(int i=0;i<N;i++){
				if(product[i].markets().toLowerCase().contains(keyword.toLowerCase())){
					count++;
					if(i>0&&i%100==0){
						printTail(count);
						choice=scan.next();
						if(!choice.equals("1")) return;
						printHead();
					}
					System.out.println(product[i]);
					empty=false;
				}
			}
			break;
		}
		if(empty) System.out.println("\nNo results found.");
		else System.out.println("\n____________________________________________________________________________"
				+"___________________________________________________________________________________________________"
				+"___________________________________________________________________________________________________"
				+"___________________________________________________________________________________________________"
				+"____________________________________\n\nEnd of search results.");
	}

	//This method is used to printer the header.
	private static void printHead(){
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

	//This message is used to print the footer, using count to display the proper number of products shown already.
	private static void printTail(int count){
		System.out.println("_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_______________________________________________________________________________________________"
				+"_____________________________\n\nDisplaying "+count+" products.\n\n"
				+"Enter 1 to see more or type anything else to go home.");
	}

}