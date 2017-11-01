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
	String G = "G";
	String H = "H";
	String I = "I";
	String J = "J";
	String K = "K";
	String L = "L";
	String M = "M";
	String N = "N";
	String O = "O";
	String P = "P";
	String Q = "Q";
	String R = "R";
	String S = "S";
	String T = "T";
	String U = "U";
	String V = "V";
	String W = "W";
	String X = "X";
	String Y = "Y";
	String Z = "Z";
	
	@Test
	public void test_regex() {
		assertThat(App.regex, equalTo("(A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z)+"));
	}
	
	@Test
	public void checkout_santisedInputs() {
		assertThat(App.checkout(A), equalTo(50));
		assertThat(App.checkout(A.toLowerCase()), equalTo(-1));
		assertThat(App.checkout(B), equalTo(30));
		assertThat(App.checkout(B.toLowerCase()), equalTo(-1));
		assertThat(App.checkout(C), equalTo(20));
		assertThat(App.checkout(C.toLowerCase()), equalTo(-1));
		assertThat(App.checkout(D), equalTo(15));
		assertThat(App.checkout(D.toLowerCase()), equalTo(-1));
		assertThat(App.checkout(E), equalTo(40));
		assertThat(App.checkout(E.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_g() {
		assertThat(App.checkout(G), equalTo(20));
		assertThat(App.checkout(G.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_h() {
		assertThat(App.checkout(H), equalTo(10));
		assertThat(App.checkout(H.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_i() {
		assertThat(App.checkout(I), equalTo(35));
		assertThat(App.checkout(I.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_j() {
		assertThat(App.checkout(J), equalTo(60));
		assertThat(App.checkout(J.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_k() {
		assertThat(App.checkout(K), equalTo(80));
		assertThat(App.checkout(K.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_l() {
		assertThat(App.checkout(L), equalTo(90));
		assertThat(App.checkout(L.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_m() {
		assertThat(App.checkout(M), equalTo(15));
		assertThat(App.checkout(M.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_n() {
		assertThat(App.checkout(N), equalTo(40));
		assertThat(App.checkout(N.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_o() {
		assertThat(App.checkout(O), equalTo(10));
		assertThat(App.checkout(O.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_p() {
		assertThat(App.checkout(P), equalTo(50));
		assertThat(App.checkout(P.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_q() {
		assertThat(App.checkout(Q), equalTo(30));
		assertThat(App.checkout(Q.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_r() {
		assertThat(App.checkout(R), equalTo(50));
		assertThat(App.checkout(R.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_s() {
		assertThat(App.checkout(S), equalTo(30));
		assertThat(App.checkout(S.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_t() {
		assertThat(App.checkout(T), equalTo(20));
		assertThat(App.checkout(T.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_u() {
		assertThat(App.checkout(U), equalTo(40));
		assertThat(App.checkout(U.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_v() {
		assertThat(App.checkout(V), equalTo(50));
		assertThat(App.checkout(V.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_w() {
		assertThat(App.checkout(W), equalTo(20));
		assertThat(App.checkout(W.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_x() {
		assertThat(App.checkout(X), equalTo(90));
		assertThat(App.checkout(X.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_y() {
		assertThat(App.checkout(Y), equalTo(10));
		assertThat(App.checkout(Y.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_santisedInput_z() {
		assertThat(App.checkout(Z), equalTo(50));
		assertThat(App.checkout(Z.toLowerCase()), equalTo(-1));
	}
	
	@Test
	public void checkout_unknwown_sku() {
		assertThat(App.checkout("*"), equalTo(-1));
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
	public void checkout_multi_buy_F_2() {
		assertThat(App.checkout(F+F), equalTo(20));
	}
	
	@Test
	public void checkout_multi_buy_F_3() {
		assertThat(App.checkout(F+F+F), equalTo(20));
	}
	
	@Test
	public void checkout_multi_buy_F_4() {
		assertThat(App.checkout(F+F+F+F), equalTo(30));
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
//		50 + 30 + 40 + 10 + 50 + 30 + 40 + 10 + 50 + 40 + 10
//		3A = 130
//		2B = 45
//		3E = 120
//		3F = 20
//		Provisional total = 315
//		We get one B free so remove that and recalculate B values at 30 instead of 45 = 290
		assertThat(App.checkout(A+B+E+F+A+B+E+F+A+E+F), equalTo(300));
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
