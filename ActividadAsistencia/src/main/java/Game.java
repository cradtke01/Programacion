public class Game {
    public static void play() {
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();
        dice1.roll();
        dice2.roll();
        int total = dice1.getUpperFace() + dice2.getUpperFace();
        System.out.println("Dice number 1: " + dice1.getUpperFace());
        System.out.println("Dice number 2: " + dice2.getUpperFace());
        System.out.println("Total: " + total);
        if (total == 7) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }
    }
}
