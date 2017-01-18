public class Product{

	//Private Variables
	private String ID;
	private String brand;
	private String model;
	private String use;
	private String site;
	private String technology;
	private String type;
	private String output;
	private String input;
	private String atSource;
	private String outFixture;
	private String temperature;
	private String colorQuality;
	private String life;
	private String sources;
	private String features;
	private String dateAvailable;
	private String dateCertified;
	private String markets;

	//Constructor
	public Product(String ID,String brand,String model,String use,String site,String technology, String type,String output,String input,String atSource,String outFixture,String temperature, String colorQuality,String life,String sources,String features,String dateAvailable,String dateCertified,String markets){
		this.ID=ID;
		this.brand=brand;
		this.model=model;
		this.use=use;
		this.site=site;
		this.technology=technology;
		this.type=type;
		this.sources=sources;
		this.features=features;
		this.dateAvailable=dateAvailable;
		this.dateCertified=dateCertified;
		this.markets=markets;
		
		this.output=output;
		if(!output.equals("N/A")) this.output+=" lumens"; //Checks if it is appropriate to add units

		this.input=input;
		if(!input.equals("N/A")) this.input+=" Watt";

		this.atSource=atSource;
		if(!atSource.equals("N/A")) this.atSource+=" lumens/Watt";

		this.outFixture=outFixture;
		if(!outFixture.equals("N/A")) this.outFixture+=" lumens/Watt";

		this.temperature=temperature;
		if(!temperature.equals("N/A")) this.temperature+=" K";

		this.colorQuality=colorQuality;
		if(!colorQuality.equals("N/A")) this.colorQuality+=" CRI";

		this.life=life;
		if(!life.equals("N/A")) this.life+=" hours";
	}

	//Getters:
	public String ID(){
		return ID;
	}

	public String brand(){
		return brand;
	}

	public String model(){
		return model;
	}

	public String use(){
		return use;
	}

	public String site(){
		return site;
	}

	public String technology(){
		return technology;
	}

	public String type(){
		return type;
	}

	public String output(){
		return output;
	}

	public String input(){
		return input;
	}

	public String atSource(){
		return atSource;
	}

	public String outFixture(){
		return outFixture;
	}

	public String temperature(){
		return temperature;
	}

	public String colorQuality(){
		return colorQuality;
	}

	public String life(){
		return life;
	}

	public String sources(){
		return sources;
	}

	public String features(){
		return features;
	}

	public String dateAvailable(){
		return dateAvailable;
	}

	public String dateCertified(){
		return dateCertified;
	}

	public String markets(){
		return markets;
	}

	//Formats the information nicely for any printing command
	public String toString(){
		String space="                                             ";

		//Spacing needs to be equivalent from one column to another to look nice.
		//When the expected output of a column is about the same length, a tab character is used.
		//Otherwise, the substring function is used to take away some of the spaces from the String space.
		String outputString=ID+"		"+brand+space.substring(brand.length()+15)+model+space.substring(model.length()+20)+
				use+space.substring(use.length()+14)+site+space.substring(site.length()+22)+
				technology+space.substring(technology.length()+29)+type+space.substring(type.length())+
				output+space.substring(output.length()+29)+input+space.substring(input.length()+31)+
				atSource+space.substring(atSource.length()+24)+outFixture+space.substring(outFixture.length()+24)+
				temperature+space.substring(temperature.length()+34)+colorQuality+"	"+life+"	"+sources+"	"+
				features+space.substring(features.length())+dateAvailable+"		"+dateCertified+"	"+markets;
		return outputString;
	}
}