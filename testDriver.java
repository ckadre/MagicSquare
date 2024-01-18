import java.util.Random;

public class testDriver
{
    public static void main(String[] args)
    {
        boolean isMagicSquare = true;
        int[][] mat = new int[3][3];
        Random r = new Random();
        int k = 0;
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                k = r.nextInt(50);
                mat[i][j] = k;
            }
        }
        test newTest = new test(isMagicSquare, mat);
        System.out.println(newTest.toString());
    }
}
