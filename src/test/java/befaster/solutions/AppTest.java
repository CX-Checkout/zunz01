package befaster.solutions;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static befaster.solutions.App.*;

import org.junit.Test;

public class AppTest {

	String A = "A";
	String B = "B";
	String C = "C";
	String D = "D";
	String E = "E";
	
	@Test
	public void test_regex() {
		assertThat(App.regex, equalTo("(A|B|C|D)+"));
	}
	
	@Test
	public void checkout_A() {
		assertThat(App.checkout(A), equalTo(50));
	}
	
	@Test
	public void checkout_a() {
		assertThat(App.checkout(A.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_B() {
		assertThat(App.checkout(B), equalTo(30));
	}
	
	@Test
	public void checkout_b() {
		assertThat(App.checkout(B.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_C() {
		assertThat(App.checkout(C), equalTo(20));
	}
	
	@Test
	public void checkout_c() {
		assertThat(App.checkout(C.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_D() {
		assertThat(App.checkout(D), equalTo(15));
	}
	
	@Test
	public void checkout_d() {
		assertThat(App.checkout(D.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_unknwown_sku_e() {
		assertThat(App.checkout(E), equalTo(-1));
	}
	
	@Test
	public void checkout_unknwown_sku_null() {
		assertThat(App.checkout(null), equalTo(-1));
	}
	
	@Test
	public void checkout_unknwown_sku_empty_string() {
		assertThat(App.checkout(""), equalTo(0));
		assertThat(App.checkout("    "), equalTo(-1));
		assertThat(App.checkout("\n"), equalTo(-1));
		assertThat(App.checkout("\r"), equalTo(-1));
		assertThat(App.checkout("\t"), equalTo(-1));
	}
	
	@Test
	public void checkout_multi_buy_a() {
		assertThat(App.checkout(A+A+A), equalTo(130));
		assertThat(App.checkout(A+A+A+A), equalTo(180));
	}
	
	@Test
	public void checkout_multi_buy_B() {
		assertThat(App.checkout(B+B), equalTo(45));
		assertThat(App.checkout(B+B+B), equalTo(75));
		assertThat(App.checkout(B+B+B+B), equalTo(90));
	}
	
	@Test
	public void checkout_multiple_mixed_skus() {
		assertThat(App.checkout(A+B+C+D), equalTo(115));
	}
	
	@Test
	public void checkout_multiple_mixed_skus_with_lowercase() {
		assertThat(App.checkout(A+B+C+D+A.toLowerCase()+B.toLowerCase()+C.toLowerCase()+D.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_multiple_multi_buy_skus() {
		assertThat(App.checkout(A+B+A+B+A), equalTo(175));
	}
	
	@Test
	public void checkout_multiple_multi_buy_skus_newline() {
		assertThat(App.checkout(A+B+A+B+A+NEWLINE), equalTo(-1));
	}
	
	@Test
	public void checkout_multiple_multi_buy_skus_spaces() {
		assertThat(App.checkout(A+B+A+B+A+SPACES), equalTo(-1));
	}
	
	@Test
	public void checkout_multiple_multi_buy_skus_null() {
		assertThat(App.checkout(A+B+A+B+A+null), equalTo(-1));
	}
}
