public class RatMilk {

    public static void main(String[] args) {
        // Time intervals for rat to drink milk from each bottle
        int[] bottles = {1, 2, 3, 4}; // Bottle numbers
        int ratLifeSpan = 10; // Rat dies after 10 hours if it drinks the poisoned milk

        // Assume poisoned bottle is bottle 3 for this simulation
        int poisonedBottle = 3;

        // Simulate the rat drinking from the bottles at different times
        int ratDeathTime = simulateRatDrinking(bottles, poisonedBottle, ratLifeSpan);

        if (ratDeathTime == -1) {
            System.out.println("Rat did not die within 24 hours. The poisoned bottle is bottle 4 (never drank from it).");
        } else {
            int poisonedBottleDetected = determinePoisonedBottle(ratDeathTime);
            System.out.println("The poisoned bottle is: Bottle " + poisonedBottleDetected);
        }
    }

    // Method to simulate rat drinking from bottles at different times
    private static int simulateRatDrinking(int[] bottles, int poisonedBottle, int ratLifeSpan) {
        int[] drinkingTimes = {0, 8, 16}; // Time intervals at which rat drinks from bottles

        for (int i = 0; i < drinkingTimes.length; i++) {
            if (bottles[i] == poisonedBottle) {
                return drinkingTimes[i] + ratLifeSpan; // Rat dies 10 hours after drinking from the poisoned bottle
            }
        }
        
        // If rat survives all tests, the poisoned bottle is bottle 4 (last bottle, not tested)
        return -1;
    }

    // Method to determine which bottle is poisoned based on the rat's death time
    private static int determinePoisonedBottle(int ratDeathTime) {
        if (ratDeathTime <= 10) {
            return 1; // Rat died 10 hours after drinking from bottle 1
        } else if (ratDeathTime <= 18) {
            return 2; // Rat died 18 hours after drinking from bottle 2
        } else if (ratDeathTime <= 26) {
            return 3; // Rat died 26 hours after drinking from bottle 3
        } else {
            return 4; // If rat survives, the poisoned bottle is 4
        }
    }
}
