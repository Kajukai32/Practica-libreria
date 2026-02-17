package data;

public abstract class Product implements Comparable<Product> {

	protected String name;
	protected Integer nroArt;
	protected Double price;
	protected Integer pages;
	protected Double purchasePrice;
	protected String isbn;
	protected Tipo tipo;

	public abstract void calculatePrice();


	

	public Product(String name, Integer nroArt, Integer pages, Double purchasePrice, String isbn, Tipo tipo) {
		this.name = name;
		this.nroArt = nroArt;
		this.pages = pages;
		this.purchasePrice = purchasePrice;
		this.isbn = isbn;
		this.tipo = tipo;
	}




	public String getIsbn() {
		return isbn;
	}




	public Tipo getTipo() {
		return tipo;
	}




	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}




	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}




	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
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

	@Override
	public int compareTo(Product o) {
		return this.getIsbn().trim().compareToIgnoreCase(o.getIsbn().trim());
	}




	@Override
	public String toString() {
		return "Product [name=" + name + ", nroArt=" + nroArt + ", price=" + price + ", pages=" + pages
				+ ", purchasePrice=" + purchasePrice + ", isbn=" + isbn + ", tipo=" + tipo + "]";
	}


	


}
