//imports
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

    private MagicSquare(String fileName)
    {

    }

    private MagicSquare(String fileName, int n)
    {
        
    }
    //methods
	/**
	 * Evaluate the matrix (whether read from file or
	 * generated) and return a boolean verdict of
	 * whether the matrix is a magic square.
	 * 
	 * @return true if matrix is a magic square, else false
	 */
    @Override
    public boolean isMagicSquare() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isMagicSquare'");
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
        int[][] matrix = new int[][];
        for(int i = 0; i < this.matrix.getLength(); i++)
        {
            for(int j = 0; j < this.matrix[i].getLength(); j++)
            {
                matrix[i][j] = this.matrix[i][j];
            }
        }
        return matrix;
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
        if (isMagicSquare = true)
        {
            System.out.println("The matrix ");
            System.out.println( // TODO print 
            System.out.println("is a magic square.");
        }
        else
        {
            System.out.println("The matrix ");
            System.out.println( // TODO print 
            System.out.println("is not a magic square.");
        }
    }
}
