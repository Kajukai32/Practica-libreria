package practicalibreria;

public abstract class Product {

	protected String name;
	protected Integer nroArt;
	protected Double price;
	protected Integer pages;

	public abstract void calculatePrice();

	public Product(String name, Integer nroArt, Integer pages) {
		this.name = name;
		this.nroArt = nroArt;
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public Integer getNroArt() {
		return nroArt;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getPages() {
		return pages;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNroArt(Integer nroArt) {
		this.nroArt = nroArt;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}
	
	


}
