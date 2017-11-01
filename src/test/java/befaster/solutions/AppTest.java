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
	String F = "F";
	
	@Test
	public void test_regex() {
		assertThat(App.regex, equalTo("(A|B|C|D|E)+"));
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
	public void checkout_E() {
		assertThat(App.checkout(E), equalTo(40));
	}
	
	@Test
	public void checkout_e() {
		assertThat(App.checkout(E.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_unknwown_sku_f() {
		assertThat(App.checkout(F), equalTo(-1));
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
	public void checkout_multi_buy_A_3() {
		assertThat(App.checkout(A+A+A), equalTo(130));
		assertThat(App.checkout(A+A+A + A), equalTo(180));
	}
	
	@Test
	public void checkout_multi_buy_A_5() {
		assertThat(App.checkout(A+A+A+A+A), equalTo(200));
		assertThat(App.checkout(A+A+A+A+A + A), equalTo(250));
	}
	
	@Test
	public void checkout_multi_buy_A_6() {
		assertThat(App.checkout(A+A+A+A+A+A), equalTo(250));
		assertThat(App.checkout(A+A+A+A+A+A + A), equalTo(300));
	}
	
	@Test
	public void checkout_multi_buy_A_8() {
		assertThat(App.checkout(A+A+A+A+A + A+A+A), equalTo(330));
		assertThat(App.checkout(A+A+A+A+A + A+A+A + A), equalTo(380));
	}
	
	@Test
	public void checkout_multi_buy_A_15() {
		assertThat(App.checkout(A+A+A+A+A + A+A+A+A+A + A+A+A+A+A), equalTo(600));
		assertThat(App.checkout(A+A+A+A+A + A+A+A+A+A + A+A+A+A+A + A), equalTo(650));
	}
	
	@Test
	public void checkout_multi_buy_B() {
		assertThat(App.checkout(B+B), equalTo(45));
		assertThat(App.checkout(B+B+B), equalTo(75));
		assertThat(App.checkout(B+B+B+B), equalTo(90));
	}
	
	@Test
	public void checkout_multi_buy_E_2() {
		assertThat(App.checkout(E+E), equalTo(80));
	}
	
	
	@Test
	public void checkout_multi_buy_E_2_B() {
		assertThat(App.checkout(E+E+B), equalTo(80));
	}
	
	@Test
	public void checkout_multi_buy_E_4_B_2() {
		assertThat(App.checkout(E+E+B+E+E+B), equalTo(160));
	}
	
	@Test
	public void checkout_multi_buy_E_5_B_3() {
		assertThat(App.checkout(E+E+B+E+E+B+B+E), equalTo(230));
	}
	
	@Test
	public void checkout_multiple_mixed_skus() {
		assertThat(App.checkout(A+B+C+D+E), equalTo(155));
	}
	
	@Test
	public void checkout_multiple_mixed_skus_with_lowercase() {
		assertThat(App.checkout(A+B+C+D+E+
				A.toLowerCase()+B.toLowerCase()+C.toLowerCase()+D.toLowerCase()+E.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_multiple_multi_buy_skus() {
//		50 + 30 + 40 + 50 + 30 + 40 + 50 + 40
//		3A = 130
//		2B = 45
//		3E = 120
//		Provisional total = 295
//		Subtract one B due to having 2E - 30 = 265,
//		then we don't get to apply for the B bonus so we need to add another 15 =
//		subtract all B then add only our B?
		assertThat(App.checkout(A+B+E+A+B+E+A+E), equalTo(280));
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
