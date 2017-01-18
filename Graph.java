import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph{
	private HashMap<Product, List<Product>> adjList;
	private Map<String, Product> classes;
	@SuppressWarnings("unused")
	private int V;
	@SuppressWarnings("unused")
	private int E;

	private final Product C1=new Product("N/A", "N/A", "N/A", "Residential", "Indoor", "LED", "Downlight Recessed", "800", "1000", "50", "50", "0", "0", "25000", "0", "N/A", "N/A", "N/A", "N/A");
	private final Product C2=new Product("N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "Chandelier", "10000", "1000", "50", "50", "0", "0", "0", "0", "N/A", "N/A", "N/A", "N/A");
	private final Product C3=new Product("N/A", "N/A", "N/A", "Residential", "Indoor", "LED", "N/A", "500", "1000", "50", "50", "0", "0", "50000", "0", "N/A", "N/A", "N/A", "N/A");
	private final Product C4=new Product("N/A", "N/A", "N/A", "Residential", "Indoor", "N/A", "Floor Lamp", "1000", "1000", "50", "50", "0", "0", "10000", "0", "N/A", "N/A", "N/A", "N/A");

	/**
	 * Creates a new graph from a given list of products, using pre-existing categories
	 * @param bulbs - list of products to create a graph from
	 */
	public Graph(Product[] bulbs){
		adjList=new HashMap<Product, List<Product>>();
		classes=new HashMap<String, Product>();
		classes.put("C1", C1);
		classes.put("C2", C2);
		classes.put("C3", C3);
		classes.put("C4", C4);
		adjList.put(C1, new ArrayList<Product>());
		adjList.put(C2, new ArrayList<Product>());
		adjList.put(C3, new ArrayList<Product>());
		adjList.put(C4, new ArrayList<Product>());
		if(!(bulbs.length==0)){
			for(Product b:bulbs){
				adjList.put(b, new ArrayList<Product>());
				addBulb(b);
			}
		}
	}

	/**
	 * Creates a new graph from a given list of products, and given list of product categories
	 * @param bulbs - list of products
	 * @param cl - list of categories
	 */
	public Graph(Product[] bulbs, Product[] cl){
		adjList=new HashMap<Product, List<Product>>();
		classes=new HashMap<String, Product>();
		classes.put("C1", C1);
		classes.put("C2", C2);
		classes.put("C3", C3);
		classes.put("C4", C4);
		adjList.put(C1, new ArrayList<Product>());
		adjList.put(C2, new ArrayList<Product>());
		adjList.put(C3, new ArrayList<Product>());
		adjList.put(C4, new ArrayList<Product>());
		if(!(cl.length==0) && !(bulbs.length==0)){
			for(Product c:cl){
				this.classes.put(c.ID(), c);
				adjList.put(c, new ArrayList<Product>());
				V++;
			}
			for(Product b:bulbs){
				adjList.put(b, new ArrayList<Product>());
				V++;
				addBulb(b);
			}
		}	
	}

	/**
	 * Adds a bulb to the adjacency list of any classes that it fits into
	 * Fits into a class if it's values are greater than 
	 * @param bulb
	 */
	private void addBulb(Product bulb){
		if (!classes.isEmpty()){
			for(Product p:classes.values()){
				if(compareBulbs(bulb, p)){
					adjList.get(bulb).add(p);
					adjList.get(p).add(bulb);
					E++;
				}
			}
		}
	}

	/**
	 * For numeric properties, returns true if the bulb has better specifications than the given class, false otherwise; 
	 * For category properties, returns true if the bulb's category matches the classes'
	 * @param bulb - bulb to compare to class
	 * @param other - class to be compared to
	 * @return boolean 
	 */
	private boolean compareBulbs(Product bulb, Product other){
		if((equal(bulb.brand(), other.brand()) && equal(bulb.use(), other.use()) && equal(bulb.site(), other.site()) && 
				equal(bulb.technology(), other.technology()) && equal(bulb.type(), other.type()) && 
				equal(bulb.features(), other.features()) && equal(bulb.markets(), other.markets()) &&
				greater(bulb.colorQuality().replace(" CRI", ""),other.colorQuality().replace(" CRI", "")) && 
				greater(bulb.life().replace(" hours", ""),other.life().replace(" hours", "")) && 
				greater(other.input().replace(" Watt", ""), bulb.input().replace(" Watt", "")) &&
				greater(bulb.temperature().replace(" K", ""), other.temperature().replace(" K", "")) &&
				greater(bulb.output().replace(" lumens", ""), other.output().replace(" lumens", "")) && 
				(greater(bulb.atSource().replace(" lumens/Watt", ""), other.atSource().replace(" lumens/Watt", "")) || 
						greater(bulb.outFixture().replace(" lumens/Watt", ""), other.outFixture().replace(" lumens/Watt", ""))) &&
						greater(bulb.sources(), other.sources()))) return true;
		return false;
	}

	private boolean equal(String info1, String info2){
		if(!(info2.equals("N/A"))){
			if(info1.equals(info2)) return true;
			else return false;
		}
		return true;
	}

	/**
	 * Returns true if the value of the info1 and info2 is numeric and info1 >= info2, false otherwise
	 * @param info1 - first value
	 * @param info2 - second value
	 * @return
	 */
	private boolean greater(String info1, String info2){
		if((!(info1.equals("N/A")) && !(info1.equals("Othe"))) && !(info2.equals("N/A"))){
			if(Double.parseDouble(info1) >= Double.parseDouble(info2)) return true;
			else return false;
		}
		else return false;
	}

	/**
	 * Returns the adjacency list for the given category
	 * @param c - String, category to search for
	 * @return
	 */
	private List<Product> getAdjlist(String c){
		return adjList.get(classes.get(c));
	}

	/**
	 * Prints information on all products in the given categories adjacency list to stdout including header and footer
	 * @param c - the category to print
	 */
	public void print(String c, int Start, int End){
		if(!(getAdjlist(c).equals(null))){
			int size=getAdjlist(c).size();
			int count=0;
			System.out.println("\nE.S. ID		Brand Name		      Model Number	       Commercial Vs. Residential     "
					+"Indoor Vs. Outdoor     Technology      Fixture Type				  Light Output	  Input Power	"
					+"En. Eff.: At Source - Outside Fixture	  Temp.	     Color	Life Span     Sources	"
					+"Additional Information			     Date Available	Date Certified	Markets\n"
					+"_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_____________________________\n");

			for(int i=Start;(i<End && i<size);i++){
				System.out.println(getAdjlist(c).get(i).toString());
				count++;
			}

			System.out.println("_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_______________________________________________________________________________________________"
					+"_____________________________\n\nDisplaying "+count+" products.\n\n"
					+"Enter anything else to go home.");
		}
	}
}