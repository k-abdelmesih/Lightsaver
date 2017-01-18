public class Sort{
	public static void sort(Product[] product,int N,String sortBy){
		for(int i=N/2;i>=1;i--) sink(product,sortBy,i,N);
		while(N>1){
			swap(product,1,N--);
			sink(product,sortBy,1,N);
		}
	}

	//Helping function to sink an item in the heap
	private static void sink(Product[] product,String sortBy,int k,int N){
		while(2*k<=N){
			int j=2*k;
			if(j<N && less(product,sortBy,j,j+1)) j++;
			if(!less(product,sortBy,k,j)) break;
			swap(product,k,j);
			k=j;
		}
	}

	//Here's where the magic happens. Depending on what the user picks to sort by, it gets sorted accordingly
	private static boolean less(Product[] product,String sortBy,int i,int j){
		switch(sortBy){
		case "1":return product[i-1].ID().compareTo(product[j-1].ID())<0;
		case "2":return product[i-1].brand().compareTo(product[j-1].brand())<0;
		case "3":return product[i-1].model().compareTo(product[j-1].model())<0;
		case "4":return product[i-1].use().compareTo(product[j-1].use())<0;
		case "5":return product[i-1].site().compareTo(product[j-1].site())<0;
		case "6":return product[i-1].technology().compareTo(product[j-1].technology())<0;
		case "7":return product[i-1].type().compareTo(product[j-1].type())<0;
		case "8":return product[i-1].output().compareTo(product[j-1].output())<0;
		case "9":return product[i-1].input().compareTo(product[j-1].input())<0;
		case "10":return product[i-1].atSource().compareTo(product[j-1].atSource())<0;
		case "11":return product[i-1].outFixture().compareTo(product[j-1].outFixture())<0;
		case "12":return product[i-1].temperature().compareTo(product[j-1].temperature())<0;
		case "13":return product[i-1].colorQuality().compareTo(product[j-1].colorQuality())<0;
		case "14":return product[i-1].life().compareTo(product[j-1].life())<0;
		case "15":return product[i-1].sources().compareTo(product[j-1].sources())<0;
		case "16":return product[i-1].features().compareTo(product[j-1].features())<0;
		
		//For 17 and 18, a substring is used in order to sort by year, not day.
		case "17":return product[i-1].dateAvailable().substring(6).compareTo(product[j-1].dateAvailable().substring(6))<0;
		case "18":return product[i-1].dateCertified().substring(6).compareTo(product[j-1].dateCertified().substring(6))<0;
		
		case "19":return product[i-1].markets().compareTo(product[j-1].markets())<0;
		}
		return false;
	}

	//Helping function to swap items
	private static void swap(Object[] product,int i,int j){
		Object temp=product[i-1];
		product[i-1]=product[j-1];
		product[j-1]=temp;
	}
}