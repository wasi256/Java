public class King extends Character {
    public King() {
        weapon = new SwordBehavior();
    }

    public void fight() {
        System.out.print("King: ");
        weapon.useWeapon();
    }
}
