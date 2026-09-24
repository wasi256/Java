public class Troll extends Character {
    public Troll() {
        weapon = new AxeBehavior();
    }

    public void fight() {
        System.out.print("Troll: ");
        weapon.useWeapon();
    }
}
