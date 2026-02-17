package data;

public class Magazine extends Product {


	public Magazine(String name, Integer nroArt, Integer pages, Double purchasePrice, String isbn, Tipo tipo) {
		super(name, nroArt, pages, purchasePrice, isbn, tipo);
		calculatePrice();
	}

	@Override
	public void calculatePrice() {

		this.price = this.purchasePrice * 1.17;
	}

}
