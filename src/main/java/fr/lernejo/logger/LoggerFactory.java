package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {

    public static Logger getLogger(String name)
    {
        Predicate<String> condition = message -> !message.contains("player");
        return new CompositeLogger(new ContextualLogger(name,new ConsoleLogger())
            ,new ContextualLogger(name,new FilteredLogger(
                new FileLogger("./Log.txt"), condition)
            )
        );
    }
}
