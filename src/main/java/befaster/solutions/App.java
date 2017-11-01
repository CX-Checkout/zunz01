package befaster.solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {
	public static String NEWLINE = "\n";
	public static String TAB = "\t";
	public static String SPACES = "     ";
	
	public enum SKUS {
		A {
			@Override
			int getOfferValue(int count) {
				int total = 0;
				total += (count % 3) * 50;
				total += (count / 3) * 130;
				
				return total;
			}
		}, B {
			@Override
			int getOfferValue(int count) {
				int total = 0;
				total += (count % 2) * 30;
				total += (count / 2) * 45;
				
				return total;
			}
		}, C {
			@Override
			int getOfferValue(int count) {
				// TODO Auto-generated method stub
				return count * 20;
			}
		}, D {
			@Override
			int getOfferValue(int count) {
				// TODO Auto-generated method stub
				return count * 15;
			}
		};
		
		abstract int getOfferValue(int count);
	}
	
	static String regex = "";
	static {
		//Produce a regex that states we expect one or more of any sku value, e.g. A or B or C or D (A|B|C|B)+
		regex += "(";
		for(int i = 0; i <SKUS.values().length; i++) {
			regex += SKUS.values()[i].name();
			if(i != SKUS.values().length - 1) {
				regex += "|";
			}
		}
		regex += ")+";
	}
	
	public static int checkout(String rawSkus) {
		//Sanitise input
		if(rawSkus == null) {
			return -1;
		}
		if(rawSkus.isEmpty()) {
			return 0;
		}
		if(rawSkus.trim().isEmpty()) {
			return -1;
		}
		//Verify we have valid SKUS
		if(!rawSkus.matches(regex)) {
			System.err.println("Input has sku values we don't recognise ["+rawSkus+"]");
			return -1;
		}
		//Tally up the number of each type of SKU we have
		Map<SKUS, Integer> skuCounts = new HashMap<SKUS, Integer>();
		
		for(char skuChar: rawSkus.toCharArray()) {
			try {
				SKUS sku = SKUS.valueOf(""+skuChar);
				int currentCount = skuCounts.getOrDefault(sku, new Integer(0));
				currentCount++;
				skuCounts.put(sku, currentCount);
			}  catch(IllegalArgumentException iae) {
				System.err.println("Unrecognized SKU "+skuChar+" found for intput "+rawSkus);
				return -1;
			}
		}
		
		//Performs basic calcs without offers
		int basketCount = 0;
		for(SKUS sku: SKUS.values()) {
			basketCount += sku.getOfferValue(skuCounts.getOrDefault(sku, new Integer(0)));
		}
		return basketCount;
	}
}
