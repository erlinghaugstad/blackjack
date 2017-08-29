package game;

import interfaces.ILogger;

public class Logger implements ILogger
{
    @Override
    public void Log(String logMessage)
    {
        System.out.println(logMessage);
    }
}
