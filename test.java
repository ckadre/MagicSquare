public class test
{
    private int[][] matrix;
    private boolean isMagicSquare;

    public test(boolean isMagSq, int[][] mat)
    {
        isMagicSquare = isMagSq;
        matrix = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[i].length; j++)
            {
                matrix[i][j] = mat[i][j];
            }
        }
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
}
