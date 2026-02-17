package data;

public class Book extends Product  {



	public Book(String name, Integer nroArt, Integer pages, Double purchasePrice, String isbn, Tipo tipo) {
		super(name, nroArt, pages, purchasePrice, isbn, tipo);
		calculatePrice();
	}

	@Override
	public void calculatePrice() {

		this.price = purchasePrice * 1.21;

	}

	@Override
	public void setPurchasePrice(Double purchasePrice) {

		super.setPurchasePrice(purchasePrice);
		calculatePrice();
	}



}
