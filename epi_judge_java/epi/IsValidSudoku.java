package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IsValidSudoku {
  @EpiTest(testDataFile = "is_valid_sudoku.tsv")

  // Check if a partially filled matrix has any conflicts.
  public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
    // TODO - you fill in here.
    for (int i = 0; i < partialAssignment.size(); i++) {
      Set<Integer> row = new HashSet<>();
      Set<Integer> col = new HashSet<>();
      Set<Integer> cube = new HashSet<>();
      for (int j = 0; j < partialAssignment.get(i).size(); j++) {
        if (partialAssignment.get(i).get(j) != 0 && !row.add(partialAssignment.get(i).get(j))) return false;
        if (partialAssignment.get(j).get(i) != 0 && !col.add(partialAssignment.get(j).get(i))) return false;
        int x = (i/3)*3 + j/3;
        int y = (i%3)*3 + j%3;
        if (partialAssignment.get(x).get(y) != 0 && !cube.add(partialAssignment.get(x).get(y))) return false;
      }
    }
    return true;
  }
  /*
  for i = 0 to 8
    set for row
    set for col
    set for cube
    for j = 0 to 8
      attempt add num[i][j] to row
      attempt add num[j][i] to col
      attempt add num[][] to cube


    i = 2
    ith cube
    upper left corner = i % 3
    start at correct row and column
    i = 4
    col =i%3 * 3 + j%3
    first row = i = 0 to 2
    second row = i = 3 - 5
    third row = i = 6 - 8

    row = i / 3 + j % 3
   */
  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidSudoku.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
