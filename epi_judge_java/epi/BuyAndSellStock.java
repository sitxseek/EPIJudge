package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class BuyAndSellStock {
  /*
  310,315, 275, 295, 260, 270, 290, 230, 255, 250
  min = 310, 275
   */
  @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
  public static double computeMaxProfit(List<Double> prices) {
    // TODO - you fill in here.
    double min = Double.MAX_VALUE, profit = 0;
    for (double p : prices) {
      min = Math.min(min, p);
      profit = Math.max(profit, p - min);
    }
    return profit;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
