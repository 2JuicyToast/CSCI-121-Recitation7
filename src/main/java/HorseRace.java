/**
 * Represents a race between two horses.
 * The race proceeds in rounds until at least one horse reaches the finish line.
 */
public class HorseRace {

    private Horse horse1;
    private Horse horse2;

    /**
     * Creates a HorseRace between two horses.
     */
    public HorseRace(Horse horse1, Horse horse2) {
        this.horse1 = horse1;
        this.horse2 = horse2;
    }

    public Horse getHorse1() {
        return horse1;
    }

    public Horse getHorse2() {
        return horse2;
    }

    /**
     * Runs the race. Each round both horses advance until at least one finishes.
     * Updates win/loss/draw statistics for both horses.
     * @return the winning horse, or null if it is a draw
     */
    public Horse race() {
        horse1.resetPosition();
        horse2.resetPosition();

        System.out.println("--- Race Start! Finish line at position " + Horse.FINISH_LINE + " ---");
        System.out.println();

        int round = 1;

        while (!horse1.hasFinished() && !horse2.hasFinished()) {
            int advanceNum1 = horse1.advance();
            int advanceNum2 = horse2.advance();

            System.out.println("Round " + round + ": "
                    + horse1.getName() + " advances " + advanceNum1
                    + " -> position: " + horse1.getPosition());
            System.out.println("         "
                    + horse2.getName() + " advances " + advanceNum2
                    + " -> position: " + horse2.getPosition());
            System.out.println();

            round++;
        }

        if (horse1.hasFinished() && horse2.hasFinished()) { // both crossed at the same time
            horse1.recordDraw();
            horse2.recordDraw();
            System.out.println("Result: Draw!");
            return null;
        } else if (horse1.hasFinished()) { // horse1 crossed first, and wins
            horse1.recordWin();
            horse2.recordLoss();
            System.out.println("Result: " + horse1.getName() + " wins!");
            return horse1;
        } else { // horse2 crossed first, and wins
            horse2.recordWin();
            horse1.recordLoss();
            System.out.println("Result: " + horse2.getName() + " wins!");
            return horse2;
        }
    }
}
