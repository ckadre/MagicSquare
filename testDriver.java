import java.io.FileNotFoundException;

public class testDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
    
        String fileName = args[0];
        test newTest = new test(fileName);
        System.out.println(newTest.toString());
    }
}
