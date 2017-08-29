package game;

import interfaces.IFileReader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeckFileReader implements IFileReader
{
    public String ReadDeckFile(String path)
    {
        File file = new File(path);

        if (!file.exists())
        {
            throw new IllegalArgumentException(String.format("File with path %s does not exist", path));
        }

        try
        {
            return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Issues reading the deck file supplied: ", e);
        }
    }
}
