import interfaces.IFileReader;

public class TestFileReader implements IFileReader
{
    private final String input;

    public TestFileReader(String input)
    {
        this.input = input;
    }

    @Override
    public String ReadDeckFile(String path)
    {
        return input;
    }
}
