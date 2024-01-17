//imports


/**
 * Description
 *
 * @author Cameron Kadre
 * @version Spring 2024
 */

public class MagicSquareDriver
{
    public static void main(String[] args)
    {

        if ((args.length < 2) || (args.length > 3))
        {
            System.err.println("Usage: java MagicSquareDriver <-check | -create> <filename> < | size>");
            System.exit(1);
        }
        String operation = args[0];
        String fileName = args[1];
        MagicSquare magicSquare;

        if (operation.equals("-check"))
        {
            magicSquare = new MagicSquare(fileName);
            System.out.println(magicSquare.toString());
        } else if (operation.equals("-create"))
        {
            int size = Integer.parseInt(args[2]);
            magicSquare = new MagicSquare(fileName, size);
        } else
        {
            System.err.println("Usage: java MagicSquareDriver <-check | -create> <filename> < | size>");
            System.exit(1);
        }
    }

}