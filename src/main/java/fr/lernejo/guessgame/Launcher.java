package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Player player = new HumanPlayer();
        Simulation laSimulation = new Simulation (player);
        SecureRandom random = new SecureRandom();
        long randomnumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

        laSimulation.initialize(randomnumber);
        laSimulation.loopUntilPlayerSucceed();
    }
}
