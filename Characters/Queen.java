public class Queen extends Character {
    public Queen() {
        weapon = new KnifeBehavior();
    }

    public void fight() {
        System.out.print("Queen: ");
        weapon.useWeapon();
    }
}
