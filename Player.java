import java.util.Scanner;


public class Player extends Person {

    Scanner input = new Scanner(System.in);

    public Player() {
        super.setName("Player");

    }

    public void makeDecision(Deck deck, Deck discard) {

        int  decision = 0;
        boolean getNum = true;

        while(getNum){

            try{
                System.out.println("1 to Hit");
                System.out.println("2 to Stand");
                decision = input.nextInt();
                getNum = false;

            }

            catch(Exception e){
                System.out.println("Invalid");

                input.next();
            }

        }

        if (decision == 1) {

            this.hit(deck, discard);

            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{

                this.makeDecision(deck, discard);
            }

        } else {

            System.out.println("Player stands.");
        }


    }


}