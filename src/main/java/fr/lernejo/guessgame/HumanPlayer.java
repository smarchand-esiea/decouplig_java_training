package fr.lernejo.guessgame;

import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;

import java.util.Scanner;

public class HumanPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("player");
    Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        logger.log("Insérer un chiffre :");
        do{
            String guessText = scanner.nextLine();
            try{
                    Long guess = Long.parseLong(guessText);
                    return guess;
                }catch(NumberFormatException e){
                    logger.log("Pas un nombre");
                }
        }while (true);
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            logger.log("plus grand");
        }
        else logger.log("plus petit");
    }

}
