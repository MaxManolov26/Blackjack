public class Dealer extends Person {

    public Dealer(){

        super.setName("Dealer");

    }

    public void printFirstHand(){
        System.out.println();
        System.out.println("Dealer's Hand");
        System.out.println();
        System.out.println(super.getHand().getCard(0));
        System.out.println();
        System.out.println("(You don't know their second card yet)");
    }



}
