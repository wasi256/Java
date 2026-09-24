public class Knight extends Character {
    public Knight() {
        weapon = new BowAndArrowBehavior();
    }

    public void fight() {
        System.out.print("Knight: ");
        weapon.useWeapon();
    }
}
