import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    //constructors

    public MagicSquare(String fileName) throws FileNotFoundException
    {
        isMagicSquare = false;
        readMatrix(fileName);
    }

    public MagicSquare(String fileName, int size) throws IOException
    {
        isMagicSquare = false;
        matrix = new int[size][size];
        writeMatrix(matrix, fileName, size);
    }

    //methods

    private void writeMatrix(int[][] matrix, String fileName, int size) throws IOException
    {
        File newFile = new File(fileName);
        PrintWriter outFile = new PrintWriter(new FileWriter(newFile));
        int row = size - 1;
        int col = size / 2;
        int oldRow;
        int oldCol;
        outFile.println(size);
        for (int i = 1; i < (size * size); i++)
        {
            matrix[row][col] = i;
            oldRow = row;
            oldCol = col;
            row++;
            col++;
            if (row == size)
            {
                row = 0;
            }
            if (col == size)
            {
                col = 0;
            }
            if (matrix[row][col] == 0)
            {
                row = oldRow;
                col = oldCol;
                row--;
            }
        }
        String matrixString = "";
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
            matrixString.concat((Integer.toString(matrix[i][j])) + " ");
            }
            matrixString.concat("\n");
        }
        outFile.println(matrixString);
        outFile.close();
    }

    private int[][] readMatrix(String fileName) throws FileNotFoundException
    {
        File readFile = new File(fileName);
        Scanner fileScan = new Scanner(readFile);
        int size = Integer.parseInt(fileScan.nextLine());
        matrix = new int[size][size];
        String line = fileScan.nextLine();
        Scanner lineScan = new Scanner(line);
        while (fileScan.hasNextLine())
        {
            while (lineScan.hasNext())
            {
                for (int row = 0; row < size; row++)
                {
                    for (int col = 0; col < size; col++)
                    {
                        int x = Integer.parseInt(lineScan.next());
                        matrix[row][col] = x;
                    }
                }
                line = fileScan.nextLine();
            }
            lineScan.close();
        }
        fileScan.close();
        return matrix;
    }

	/**
	 * Determine if the matrix associated with the MagicSquare instance is a magic square
	 * @return true if matrix is a magic square, else false
	 */
    public boolean isMagicSquare()
    {
        isMagicSquare = true;
        int size = matrix.length;
        int magicNum = (size * ((size * size) + 1)) / 2;
        int[] sumArray = new int[(size * size) + 2];
        boolean equalsMagicNum;
        int i = size;
        int sum = 0;
        int j;
        int count = 0;
        while (i > 0)
        {
            for (j = 0; j < size; j++)
            {
                sum += matrix[i][j];
            }
            sumArray[count] = sum;
            sum = 0;
            i--;
            count++;
        }
        j = size;
        while (j > 0)
        {
            for (i = 0; i < size; i++)
            {
                sum += matrix[i][j];
            }
            sumArray[count] = sum;
            sum = 0;
            j--;
            count++;
        }
        for (j = 0; j < size; j++)
        {
            sum += matrix[j][j];
        }
        sumArray[count] = sum;
        count++;
        sum = 0;
        for (i = 0; i < size; i ++)
        {
            for (j = (size - 1); j > 0; j--)
            {
                sum += matrix[i][j];
            }
        }
        sumArray[count] = sum;
        count++;
        sum = 0;
        equalsMagicNum = true;
        for (int k : sumArray)
        {
            if (k != magicNum)
            {
                equalsMagicNum = false;
            }
            else
            {
                equalsMagicNum = true;
            }
        }
        if (equalsMagicNum == false)
        {
            isMagicSquare = false;
        }
        return isMagicSquare;
    }

	/**
	 * Returns a copy of the matrix associated with a MagicSquare instance.
	 * @return 2D array of ints
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
     * Returns a string displaying the matrix and whether it is a magic square. 
	 * @return formatted String
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
