public class ChanceCard {
    private String description;
    
    public ChanceCard(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    public void applyEffect(Player player, GameBoard board) {
        System.out.println("Applying effect: " + description);

        if (description.equalsIgnoreCase("Advance to go")) {
            player.setPosition(0);
            player.addMoney(200);
        }
        else if (description.equalsIgnoreCase("Go to jail")) {
            player.setPosition(board.getJailPosition());
            player.setInJail(true);
        }
        else if (description.equalsIgnoreCase("Bank pays you dividend of $50")) {
            player.addMoney(50);
        }
        else if (description.equalsIgnoreCase("Pay poor tax of $15")) {
            player.deductMoney(15);
        }

    }
}
