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
			int calcValueForThisSku(int count) {
				//buy three for 130, buy five for 150
				int total = 0;
				//apply the buy five rule first
				total += (count / 5) * 200;
				//apply the buy three rule to the remainder
				total += ((count % 5) / 3) * 130;
				//apply regular price to the remainder of the buy 5 and buy 3 offers
				total += ((count % 5) % 3) * this.normalValue();
				
				return total;
			}

			@Override
			int normalValue() {
				return 50;
			}

			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(getCount(counts));
			}
		}, B {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(getCount(counts));
			}

			@Override
			int normalValue() {
				return 30;
			}

			@Override
			int calcValueForThisSku(int count) {
				//Buy two for 45
				int total = 0;
				total += (count / 2) * 45;
				total += (count % 2) * this.normalValue();
				
				return total;
			}
		}, C {
			@Override
			int calcValueForThisSku(int count) {
				return count * this.normalValue();
			}

			@Override
			int normalValue() {
				return 20;
			}
			
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(getCount(counts));
			}
		}, D {
			@Override
			int calcValueForThisSku(int count) {
				return count * this.normalValue();
			}

			@Override
			int normalValue() {
				return 15;
			}
			
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(getCount(counts));
			}
		}, E {
			@Override
			int calcValueForThisSku(int count) {
				//Buy two at 40 get a B free
				int total = 0;
				total += count * this.normalValue();
				return total;
			}
			
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				int total = calcValueForThisSku(getCount(counts));
				int count = getCount(counts);
				//Remove all B values and re-add only the number we need to after removing the ones we get free
				total -= B.calcTotalValueWithCrossSkuOffers(counts);
				
				//Deduct the price of a B item for every 2 E items we have
				int bCount = B.getCount(counts);
				if(bCount > count / 2) {
					total += B.calcValueForThisSku(bCount - (count / 2));
				}
					
				return total;
			}

			@Override
			int normalValue() {
				return 40;
			}
		}, F {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				//if we have three F's one is free
				int total = 0;
				total += (count / 3) * (2 * normalValue());
				total += (count % 3) * normalValue();
				return total;
			}

			@Override
			int normalValue() {
				return 10;
			}
		}, G {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 20;
			}
		}, H {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 10;
			}
		}, I {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 35;
			}
		}, J {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 60;
			}
		}, K {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 80;
			}
		}, L {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 90;
			}
		}, M {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 15;
			}
		}, N {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 40;
			}
		}, O {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 10;
			}
		}, P {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 50;
			}
		}, Q {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 30;
			}
		}, R {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 50;
			}
		}, S {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 30;
			}
		}, T {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 20;
			}
		}, U {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 40;
			}
		}, V {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 50;
			}
		}, W {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 20;
			}
		}, X {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 90;
			}
		}, Y {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 10;
			}
		}, Z {
			@Override
			int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts) {
				return calcValueForThisSku(this.getCount(counts));
			}

			@Override
			int calcValueForThisSku(int count) {
				return count * normalValue();
			}

			@Override
			int normalValue() {
				return 50;
			}
		};
		
		abstract int calcTotalValueWithCrossSkuOffers(Map<SKUS, Integer> counts);
		
		abstract int calcValueForThisSku(int count);
		
		abstract int normalValue();
		
		public int getCount(Map<SKUS, Integer> counts) {
			return counts.getOrDefault(this, new Integer(0));
		}
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
			basketCount += sku.calcTotalValueWithCrossSkuOffers(skuCounts);
		}
		return basketCount;
	}
}
