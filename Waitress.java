public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    DinnerMenu dinnerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu, DinnerMenu dinnerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        System.out.println("BREAKFAST");
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        printMenu(pancakeIterator);
        System.out.println("...and then");
        System.out.println("the diner\nmenu...");
        System.out.println("LUNCH");
        Iterator dinerIterator = dinerMenu.createIterator();
        printMenu(dinerIterator);
        System.out.println("...and finally");
        System.out.println("DINNER");
        System.out.println("the new café");
        Iterator dinnerIterator = dinnerMenu.createIterator();
        printMenu(dinnerIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem)iterator.next();
            System.out.println(menuItem.getName() + ", " + menuItem.getPrice() + " -- " + menuItem.getDescription());
        }
    }
}