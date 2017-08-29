import interfaces.ILogger;

public class TestLogger implements ILogger
{
    private final StringBuilder allLogMessage = new StringBuilder();

    @Override
    public void Log(String logMessage)
    {
        allLogMessage.append(logMessage + "\r\n");
    }

    @Override
    public String toString()
    {
        return this.allLogMessage.toString();
    }
}
