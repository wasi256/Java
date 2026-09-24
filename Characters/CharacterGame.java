public class CharacterGame {
    public static void main(String[] args) {
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();

        king.fight();
        queen.fight();
        knight.fight();
        troll.fight();

        System.out.println("\n--- The King picks up an axe ---");
        king.setWeapon(new AxeBehavior());
        king.fight();
    }
}
