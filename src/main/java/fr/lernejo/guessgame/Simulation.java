package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player ;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        long reponse = player.askNextGuess();

        if (reponse == numberToGuess)
        {
            return true;
        }
        else player.respond(reponse < numberToGuess);
        return false;
    }

    public void loopUntilPlayerSucceed(long max) {
        logger.log("Debut de la partie");
        boolean test=nextRound();
        int i=0;
        long Start=System.currentTimeMillis();
        long End =0;
        while(!test && i<max )
        {
            test=nextRound();
            i++;
        }
        End=System.currentTimeMillis();
        long TimeTotal = End-Start;
        Timestamp timestamp=new Timestamp(TimeTotal);
        logger.log("Temps total execution: "+new SimpleDateFormat("mm:ss.SSS").format(timestamp));
    }

}
