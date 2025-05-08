public class JailablePlayer extends Player {
    private boolean inJail = false;
    private int jailTurnsRemaining = 3;

    public void goToJail(int jailPosition) {
        inJail = true;
        jailTurnsRemaining = 3;
        setPosition(jailPosition);
        System.out.println(getName() + " is sent to jail.");
    }


    public boolean shouldSkipTurn(int die1, int die2) {
        if (inJail) {
            if (die1 == die2) {
                inJail = false;
                jailTurnsRemaining = 0;
                System.out.println(getName() + " rolled doubles and is released from jail!");
                return false;
            }

            if (jailTurnsRemaining > 1) {
                jailTurnsRemaining--;
                System.out.println(getName() + " is still in jail. Turns remaining: " + jailTurnsRemaining);
                return true;
            } else {
                inJail = false;
                jailTurnsRemaining = 0;
                System.out.println(getName() + " has served 3 turns and is now released.");
                return false;
            }
        }
        return false;
    }

    public boolean isInJail() {
        return inJail;
    }
}
