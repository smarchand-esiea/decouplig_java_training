package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("Computerplayer");
    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;
    @Override
    public long askNextGuess() {
        return middle() ;
    }
    private Long middle(){
        return (min + max) /2;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater){
            logger.log("plus grand");
            max = middle();
        }
        else {
            logger.log("plus petit");
            min = middle();
        }
    }
}
