import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test
{
    private int[][] matrix;
    private boolean isMagicSquare;

    public test(String fileName) throws FileNotFoundException
    {
        isMagicSquare = false;
        readMatrix(fileName);
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
            while (lineScan.hasNextInt())
            {
                for (int row = 0; row < size; row++)
                {
                    for (int col = 0; col < size; col++)
                    {
                        int x = lineScan.nextInt();
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
}
