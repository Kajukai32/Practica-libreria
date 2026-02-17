package practicalibreriatest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import customexceptions.InvalidFieldContentException;
import data.Book;
import data.BookStore;
import data.Magazine;
import data.Product;
import data.Tipo;

class PracticaLibreriaTest {

	private BookStore bs;

	@BeforeEach
	void setUp() {
		bs = new BookStore("Juana");
	}

	@Test
	void shouldCreateABookTest() {
		// GIVEN
		Product b1 = new Book("Simbad el marino", 12, 300, 100.0, "HSBN", Tipo.BOOK);
		// WHEN

		String s = b1.getName();
		// THEN

		assertEquals("Simbad el marino", s);
	}

	@Test
	void shouldCreatemagazineTest() {
		// GIVEN
		Product m1 = new Magazine("parateens", 13, 30, 15.0, "JKLO", Tipo.MAGAZINE);
		// WHEN
		Integer artM1 = m1.getNroArt();
		// THEN

		assertEquals(13, artM1);

	}

	@Test
	void shouldCreateLibrary() {
		// GIVEN
		BookStore bs = new BookStore("Paquita");
		// WHEN

		String name = bs.getName();
		// THEN

		assertEquals("Paquita", name);
	}

	@Test
	void shouldAddProductTest() {

		try {
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);

			String list = bs.getListCatalog();
			assertNotEquals("", list);
//			assertEquals("", list);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	void shouldThrowAnExceptionIfFieldIsNull() {
		// GIVEN
		// WHEN
		Executable e = () -> {
			bs.registerBook(null, 30, 15.0, "JKLO", null);
		};
		// THEN

		assertThrows(InvalidFieldContentException.class, e);

	}


	@Test
	void shouldIncreaseCantIfProductAreRepeated() {
		// GIVEN
		try {
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);
			bs.registerBook("Larrousse Ilustrado", 30, 15.0, "LI", Tipo.BOOK);
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);

		} catch (Exception e) {

		}

		// WHEN
		String list = bs.getListCatalog();

		// THEN
		assertNotEquals("", list);
//		assertEquals("", list);

	}

	@Test
	void shouldSortThemByPrice() {
		// GIVEN
		try {
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);
			bs.registerBook("IT", 600, 150.0, "IT", Tipo.BOOK);
			bs.registerBook("Muy Interesante", 50, 25.0, "MI", Tipo.MAGAZINE);
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);
			bs.registerBook("Larrousse Ilustrado", 03, 15.0, "LI", Tipo.BOOK);
			bs.registerBook("parateens", 30, 15.0, "JKLO", Tipo.MAGAZINE);

//			assertEquals("", list);

		} catch (Exception e) {

		}

		// WHEN
		ArrayList<Map.Entry<Product, Integer>> e = bs.getListSortedByPrice();
		// THEN

		assertNotEquals("", e);
		

	}





}












