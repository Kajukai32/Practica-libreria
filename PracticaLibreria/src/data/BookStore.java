package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import customexceptions.InvalidFieldContentException;

public class BookStore {

	private Integer cantLibros = 0;
	private String name;
	private Map<Product, Integer> catalog;

	public BookStore(String name) {
		this.name = name;
		this.catalog = new TreeMap<Product, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void registerBook(String name, Integer pages, Double purchasePrice, String isbn, Tipo tipo)
			throws InvalidFieldContentException {

		if (name == null || name.isEmpty() || pages == null || pages < 0 || purchasePrice < 0 || purchasePrice == null
				|| isbn == null || isbn.isEmpty() || tipo == null) {
			throw new InvalidFieldContentException("no se admiten campos vacios ni nulos");
		}
		switch (tipo) {
		case MAGAZINE: {

			Product p = new Magazine(name, cantLibros, pages, purchasePrice, isbn, tipo);
			putBookToList(p);
			break;
		}
		case BOOK: {
			Product p = new Book(name, cantLibros, pages, purchasePrice, isbn, tipo);
			putBookToList(p);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

	}

	private void putBookToList(Product p) {

		if (catalog.containsKey(p)) {

			catalog.put(p, catalog.get(p) + 1);

		} else {

			catalog.put(p, 1);
		}

	}

	public String getListCatalog() {

		String s = "";

		for (Map.Entry<Product, Integer> entrada : catalog.entrySet()) {
			s += "\n" + entrada.getKey() + " cantidad: " + entrada.getValue();
		}
		return s;
	}

	public ArrayList<Map.Entry<Product, Integer>> getListSortedByPrice() {

		ArrayList<Map.Entry<Product, Integer>> listaOrdenada = new ArrayList<Map.Entry<Product, Integer>>();

		for (Map.Entry<Product, Integer> entrada : catalog.entrySet()) {

			listaOrdenada.add(entrada);

			Collections.sort(listaOrdenada, new Comparator<Map.Entry<Product, Integer>>() {

				@Override
				public int compare(Entry<Product, Integer> o1, Entry<Product, Integer> o2) {
					Integer comp = o1.getKey().getPrice().compareTo(o2.getKey().getPrice());
					if (comp == 0) {
						comp = o1.getKey().getIsbn().compareToIgnoreCase(o2.getKey().getIsbn());
					}
					return comp;
					
				}
			});
		}
		return listaOrdenada;

	}



}












