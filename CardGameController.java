import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardGameController extends GameController {
    private List<Card> chanceCards;
    private List<Card> communityChestCards;

    public CardGameController(Player[] players, GameBoard board) {
        super(players);
        chanceCards = new LinkedList<>();
        communityChestCards = new LinkedList<>();
        loadCards(board);
    }

    private void loadCards(GameBoard board) {
        chanceCards.add(new Card("Advance to Go", Card.CardType.CHANCE));
        chanceCards.add(new Card("Go to Jail", Card.CardType.CHANCE));
        chanceCards.add(new Card("Bank pays you dividend of $50", Card.CardType.CHANCE));
        chanceCards.add(new Card("Pay poor tax of $15", Card.CardType.CHANCE));
        communityChestCards.add(new Card("Advance to Go", Card.CardType.COMMUNITY_CHEST));
        communityChestCards.add(new Card("Pay hospital fees of $100", Card.CardType.COMMUNITY_CHEST));
        communityChestCards.add(new Card("Bank error in your favor", Card.CardType.COMMUNITY_CHEST));
        communityChestCards.add(new Card("Go to Jail", Card.CardType.COMMUNITY_CHEST));
    }
    
    private void shuffleDeck(List<Card> deck) {
        Collections.shuffle(deck);
    }

    public void drawChanceCard(GameBoard board) {
        shuffleDeck(chanceCards);
        Card card = chanceCards.remove(0);
        System.out.println(getCurrentPlayer().getName() + " drew a Chance card: " + card.getDescription());
        card.applyEffect(getCurrentPlayer(), board);
    }

    public void drawCommunityChestCard(GameBoard board) {
        shuffleDeck(communityChestCards);
        Card card = communityChestCards.remove(0);
        System.out.println(getCurrentPlayer().getName() + " drew a Community Chest card: " + card.getDescription());
        card.applyEffect(getCurrentPlayer(), board);
    }

    @Override
    public void startTurn() {
        super.startTurn();

        if (Math.random() < 0.5) {
            drawChanceCard(new GameBoard());
        }
        else {
            drawCommunityChestCard(new GameBoard());
        }
    }
}
