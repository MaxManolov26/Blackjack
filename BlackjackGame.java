public class BlackjackGame {
  
    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, ties;

    public BlackjackGame(){

        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();


        deck.shuffle();
        startRound();
    }

    private void startRound(){

        if(wins>0 || losses>0 || ties > 0){
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();

        player.printHand();

        if(dealer.hasBlackjack()){
            dealer.printHand();

            if(player.hasBlackjack()){
                System.out.println("You both have 21! It's a tie!");
                ties++;
                startRound();
            }
            else{
                System.out.println("Player takes an L - Dealer Blackjacks!");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! Player wins!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded);

        //Check if they busted
        if(player.getHand().calculatedValue() > 21){
            System.out.println("You busted!");
            losses ++;
            startRound();
        }

        //Now it's the dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //Check who wins and count wins or losses
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busted!");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("It's a tie.");
            ties++;
        }

        startRound();
    }






}