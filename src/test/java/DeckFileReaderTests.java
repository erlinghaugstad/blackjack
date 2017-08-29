import game.DeckFileReader;
import interfaces.IFileReader;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeckFileReaderTests
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ReadDeckFile_NonExistingFile_ThrowException()
    {
        IFileReader fileReader = new DeckFileReader();
        exception.expect(IllegalArgumentException.class);
        fileReader.ReadDeckFile("random.txt");
    }

    @Test
    public void ReadDeckFile_ExistingFile_ReturnsFileConentAsString()
    {
        IFileReader fileReader = new DeckFileReader();
        String testData = fileReader.ReadDeckFile("testdata/testdata1.txt");
        Assert.assertEquals("CA, D5, H9, HQ, S8,", testData.trim());
    }
}
