package com.supermarket.domain;

public class ItemSpec {
	
	//need this if persist to a database 
	//private Long id;
	
	//just use this as primary key for now
	private String name;
	
	private double unitPrice;
	
	private double specialPrice;
	
	private int unitForSpecialPrice;
	
	public ItemSpec() {}
	
	public ItemSpec(String name, double unitPrice, double specialPrice, int unitForSpecialPrice) {
		this.name = name;
		if (unitPrice > 0) {
			this.unitPrice = unitPrice;
		}
		
		if (specialPrice > 0 && unitForSpecialPrice > 0) {
			this.specialPrice = specialPrice;
			this.unitForSpecialPrice = unitForSpecialPrice;
		}
	}

	public boolean hasSpecialPrice() {
		return this.specialPrice > 0 && this.unitForSpecialPrice > 0;
	}
	
	public double getSpecialPrice() {
		return specialPrice;
	}

	public int getUnitForSpecialPrice() {
		return unitForSpecialPrice;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemSpec) {
			return ((ItemSpec) obj).getName().equals(this.name);
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ItemSpec [");
		sb.append("name:" + name + ", unitPrice:" + unitPrice);
		sb.append(", " + this.unitForSpecialPrice + " for " + this.specialPrice + "]");
		return sb.toString();
	}
	
	
}
