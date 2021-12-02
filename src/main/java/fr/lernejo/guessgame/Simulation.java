package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

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

    public void loopUntilPlayerSucceed() {
        int counter = 0 ;
        do{
            counter ++ ;
        }while(!nextRound());
        logger.log("Félicitation, jeux réussie en :"+counter+"tours");
    }
}
