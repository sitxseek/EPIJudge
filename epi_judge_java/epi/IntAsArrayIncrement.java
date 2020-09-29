package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class IntAsArrayIncrement {
  @EpiTest(testDataFile = "int_as_array_increment.tsv")
  public static List<Integer> plusOne(List<Integer> A) {
    // TODO - you fill in here.
    int i = A.size() - 1;
    while (i >= 0 && A.get(i) == 9) {
      A.set(i--, 0);
    }
    if (i < 0) A.add(0, 1);
    else A.set(i, A.get(i) + 1);
    return A;
  }
  /*
  1,2,9
  1,3,0

  while pointer >= 0 and A.get(pointer) == 9
    A.set(pointer, 0)
    move pointer--
  if pointer < 0
    A.add(1, 0)
  else
    A.set(pointer, A.get(pointer) + 1)
   */
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsArrayIncrement.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
