//imports

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Description
 *
 * @author Cameron Kadre
 * @version Spring 2024
 */

public class MagicSquare implements MagicSquareInterface
{
    //instance vars
    private boolean isMagicSquare;
    private int[][] matrix;
    private int size;

    //constructors

    public MagicSquare(String fileName) throws FileNotFoundException
    {
        readMatrix(fileName);
    }

    public MagicSquare(String fileName, int size) throws IOException
    {
        this.size = size;
    }
    
    //methods

    private int[][] readMatrix(String fileName) throws FileNotFoundException
    {
        File readFile = new File(fileName);
        Scanner fileScan = new Scanner(readFile);
        int size = Integer.parseInt(fileScan.next());
        matrix = new int[size][size];
        String line = "";
        Scanner lineScan = new Scanner(line);
        while (fileScan.hasNext())
        {
            line = fileScan.next();
            while (lineScan.hasNext())
            {
                int x = Integer.parseInt(lineScan.next());
                for (int i = 0; i < matrix.length; i++)
                {
                    for (int j = 0; j < matrix[i].length; j++)
                    {
                        matrix[i][j] = x;
                    }
                }
            }
        }
        fileScan.close();
        lineScan.close();
        return matrix;
    }

	/**
	 * Evaluate the matrix (whether read from file or
	 * generated) and return a boolean verdict of
	 * whether the matrix is a magic square.
	 *
	 * @return true if matrix is a magic square, else false
	 */
    public boolean isMagicSquare()
    {
        //TODO method
        return isMagicSquare;
    }

	/**
	 * Return a copy of the matrix (whether read from file
	 * or generated) as a 2D array of ints. Be sure this
	 * method does not compromise encapsulation.
	 *
	 * @return 2D array of ints that may or may not be a valid magic square
	 */
    public int[][] getMatrix()
    {
        int[][] returnMatrix;
        returnMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = this.matrix[i][j];
            }
        }
        return returnMatrix;
    }
    
	/**
	 * Return a string formatted as in these examples:
	 *   The matrix
	 *     4 9 2
	 *     3 5 7
	 *     8 1 6
	 *   is a magic square.
	 *  or
	 *    The matrix
	 *      5 3 7
	 *      9 4 2
	 *      1 6 5
	 *    is not a magic square.
	 *
	 * @return formatted string showing the matrix and whether it is a valid magic square
	 */
	public String toString()
    {
        String magicSquare = "";
        String matrixString = "";
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrixString += matrix[i][j] + " ";
            }
            matrixString += "\n";
        }
        if (isMagicSquare = true)
        {
            magicSquare = "The matrix \n" + matrixString + "is a magic square.";
        }
        else
        {
            magicSquare = "The matrix \n" + matrixString + "is not a magic square.";
        }
        return magicSquare;
    }
}
