import java.util.Random;

/**
 * Represents a horse in a horse race.
 * A horse has a name, a current position, and win/loss/draw statistics.
 */
public class Horse {

    private String name;
    private int position;
    private int wins;
    private int losses;
    private int draws;
    private Random random;

    public static final int FINISH_LINE = 20;

    /**
     * Creates a Horse with the given name at position 0.
     */
    public Horse(String name) {
        this.name = name;
        this.position = 0;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.random = new Random();
    }

    /**
     * Advances the horse by a random number of spaces between 1 and 6.
     * @return the number of spaces advanced
     */
    public int advance() {
        // cannot move forward 0, so shift to the right by using + 1
        int advanceNum = random.nextInt(6) + 1;
        this.position += advanceNum;
        return advanceNum;
    }

    /**
     * Returns true if the horse has reached or passed the finish line.
     */
    public boolean hasFinished() {
       // simplify process of determining true or false by directly returning result
        return this.position >= FINISH_LINE;
    }

    /**
     * Resets the horse's position to 0 for a new race.
     * Does not clear statistics.
     */
    public void resetPosition() {
        position = 0;
    }

    /**
     * Clears the horse's win/loss/draw statistics.
     */
    public void clearStats() {
        wins = 0;
        losses = 0;
        draws = 0;
    }

    /**
     * Increases this horse's number of wins by 1
     */
    public void recordWin()  {
        this.wins += 1;
    }

    /**
     * Increases this horse's number of losses by 1
     */
    public void recordLoss() {
        this.losses += 1;
    }

    /**
     * Increases this horse's number of draws by 1
     */
    public void recordDraw() {
        this.draws += 1;
    }

    public String getName()  {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getWins()     {
        return wins;
    }

    public int getLosses()   {
        return losses;
    }

    public int getDraws()    {
        return draws;
    }
}
