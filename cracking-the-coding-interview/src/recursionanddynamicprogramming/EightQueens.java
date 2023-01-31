package recursionanddynamicprogramming;

import java.awt.color.ColorSpace;
import java.util.ArrayList;

/**
 * FileName: EightQueens
 * author: gxs
 * Date: 2022/1/22  14:51
 */
/* write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them
 * share the same row, column or diagonal. In this case, "diagonal" means all diagonals, not just the two
 * that bisect the board */

public class EightQueens {
    public static final int GRID_SIZE = 8;

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> result) {
        if (row == GRID_SIZE) {
            result.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, result);
                }
            }
        }
    }
    /* check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for
     * queens in the same row because the calling placeQueen only attempts to
     * place one queen at a time. We know thi srow is empty */
    boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            if (column1 == column2) {
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);

            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) return false;
        }
        return true;
    }
}
