package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;
public class SpiralOrdering {
  @EpiTest(testDataFile = "spiral_ordering.tsv")

  public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
    // TODO - you fill in here.
    List<Integer> spiralOrdering = new ArrayList<>();
    for (int offset = 0; offset < Math.ceil(0.5 * squareMatrix.size()); offset++) {
      matrixLayerInClockwise(squareMatrix, offset, spiralOrdering);
    }
    return spiralOrdering;
  }

  private static void matrixLayerInClockwise(List<List<Integer>> squareMatrix,
                                             int offset,
                                             List<Integer> spiralOrdering) {
    if (offset == squareMatrix.size() - offset - 1) {
      spiralOrdering.add(squareMatrix.get(offset).get(offset));
      return;
    }
    for (int j = offset; j < squareMatrix.size() - offset - 1; j++) {
      spiralOrdering.add(squareMatrix.get(offset).get(j));
    }
    for (int i = offset; i < squareMatrix.size() - offset - 1; i++) {
      spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
    }
    for (int j = squareMatrix.size() - offset - 1; j > offset; j--) {
      spiralOrdering.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
    }
    for (int i = squareMatrix.size() - offset - 1; i > offset; i--) {
      spiralOrdering.add(squareMatrix.get(i).get(offset));
    }
  }
  /*
  1 2 3 4
  5 6 7 8
  9 1 2 3
  4 5 6 7

  start at top bound, left bound
  keep track of valid bounds for each side (t, r, b, l)
  increment each bound for each layer

  len = squareMatrix.size() - 1;
  num of layers = squareMatrix.size() / 2
  for i in range(numLayers)
    for j: l to len-r
      list.add(A[t][j])
    increment t
    for i: t to len-b
      list.add(A[i][r])
    increment r
    for j: len-r to l
      list.add(A[b][j])
    increment b
    for i: len - b to t
      list.add(A[i][l])
    increment l
   */
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpiralOrdering.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
