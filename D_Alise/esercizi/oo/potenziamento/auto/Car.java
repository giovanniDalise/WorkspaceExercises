package esercizi.oo.potenziamento.auto;

public class Car {
	private String brand;
	private String model;
	private int productionYear;
	private double kilometers;

	public Car (String brand,String model,int productionYear,double kilometers){
		this.brand=brand;
		this.model=model;
		this.productionYear=productionYear;
		this.kilometers=kilometers;
	}

	public void setBrand(String newBrand){ 
		this.brand=newBrand;
	}
	public void setModel(String newModel){ 
		this.model=newModel;
	}
	public void setProductionYear(int newProductionYear){ 
		this.productionYear=newProductionYear;
	}

	public void setKilometers(double newKilometers){ //kilometraggio iniziale
		this.kilometers=newKilometers;
	}

	public void increaseKilometers(double additionalKilometers){	
		kilometers+=additionalKilometers;

	}

	public String getBrand(){		
		return brand;
	}
	public String getModel(){		
		return model;
	}
	public int getProductionYear(){		
		return productionYear;
	}
	public double getKilometers(){		
		return kilometers;
	}
}
