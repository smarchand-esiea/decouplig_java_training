package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("Launcher");;
        SecureRandom random = new SecureRandom();
        long randomnumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)


        if(args.length==1 && args[0].equals("-interactive"))
        {
            Player player = new HumanPlayer();
            Simulation laSimulation = new Simulation (player);
            laSimulation.initialize(randomnumber);
            laSimulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args.length == 2 && (args[0].equals("-auto") && args[1].matches("[0-9]+")))
        {
            Player computerplayer = new ComputerPlayer();
            Simulation laSimulation = new Simulation(computerplayer);
            laSimulation.initialize(Long.parseLong(args[1]));
            laSimulation.loopUntilPlayerSucceed(1000);
        }
        else {
            logger.log("Erreur Argument :\n -interactive => partie interactive\n -auto [0-9] => partie robot");
        }

    }
}
