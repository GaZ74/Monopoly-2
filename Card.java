public class Card {
    private String description;
    private CardType type;

    public enum CardType {
        CHANCE,
        COMMUNITY_CHEST
    }
    
    public Card(String description, CardType type) {
        this.description = description;
        this.type = type;
    }
    
    public String getDescription() {
        return description;
    }

    public CardType getType() {
        return type;
    }

    public void applyEffect(Player player, GameBoard board) {
        System.out.println("Applying effect: " + description);
        if (type == CardType.CHANCE) {
            switch (description) {
                case "Advance to Go":
                player.setPosition(0);
                player.addMoney(200);
                break;
                case "Go to Jail":
                player.setPosition(board.getJailPosition());
                player.setInJail(true);
                break;
                case "bank pays you dividend of $50":
                player.addMoney(50);
                break;
                case "Pay poor tax of $15":
                player.deductMoney(15);
                break;
            }
        }
        else if (type == CardType.COMMUNITY_CHEST) {
            switch (description) {
                case "Advance to Go":
                player.setPosition(0);
                player.addMoney(200);
                break;
                case "Pay hospital fees of $100":
                player.deductMoney(100);
                break;
                case "Bank error in your favor":
                player.addMoney(100);
                break;
                case "Go to Jail":
                player.setPosition(board.getJailPosition());
                player.setInJail(true);
                break;
            }
        }
    }
}
