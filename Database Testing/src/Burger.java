import java.util.Scanner;

public class Burger {

    private Process mysql = new Process();
    private DisplayDesign go = new DisplayDesign();
    private Scanner sc = new Scanner(System.in);

    public void chosen(int choice) {

        try {
            switch (choice) {
                case 1: //SHOW ALL BURGERS
                    this.viewBurger();
                    break;

                case 2: //ADD BURGER ITEMS
                    this.addBurger();
                    break;

                case 3: //ADD BURGER QUANTITY
                    this.addBurgerQty();
                    break;

                case 4: //SELL BURGER AND DECREASE THE QUANTITY
                    this.sellBurger();
                    break;

                case 5:
                this.updateBurger();
                    break;

                case 6:
                    break;

            }
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            sc.nextLine();
            go.PauseClear();
        }

    }

    public void addBurger() { // adds a new burger in the table
        String burgerName;
        double price;
        int quantity;

        go.printBox("ADD A BURGER");

        System.out.print("Burger Name: ");
        burgerName = sc.nextLine();

        System.out.print("Price: ");
        price = sc.nextInt();

        System.out.print("Initial Stock: ");
        quantity = sc.nextInt();

        if (price <= 0 || quantity <= 0){
            System.out.println("Price/Quantity cannot be negative/zero!");
        }
        else {
            mysql.processQuery("INSERT into items (itemname, price, stock)" +
            " VALUES ('" + burgerName + "', " + price + ", " + quantity + ")");
        }
    }

    public void viewBurger() { // just to show all the rows in the table
        go.printBox("LIST OF BURGERS");
        mysql.viewQuery();

    }

    public void addBurgerQty() { // updates specific row to add stock
        this.viewBurger();
        int choice, amount;

        System.out.print("\nSelect ID# you want to add quantity: ");
        choice = sc.nextInt();

        if (mysql.searchQuery(choice) != null ){ //executes if the method returns a value, and not a null
            System.out.print("How many do you want to add in " + mysql.searchQuery(choice) + ": " );
            amount = sc.nextInt();

            if (amount <= 0){
                System.out.println("You cannot add NEGATIVE/ZERO amount!");
            }
            else {
                mysql.processQuery("update items set stock = (stock+" + amount + ") where id = " + choice + "");
            }
        
        }
        else {
            System.out.println("No ID found.");
        }
    }

    public void sellBurger() { // updates specific row to decrease stock, also insert a row in sales table
        this.viewBurger();
        int choice, amount;

        System.out.print("\nSelect ID# you want to sell: ");
        choice = sc.nextInt();

        if (mysql.searchQuery(choice) != null ){ //executes if the method returns a value, and not a null
            System.out.print("How many do you want to sell in " + mysql.searchQuery(choice) + ": " );
            amount = sc.nextInt();

            if (amount <= 0){
                System.out.println("You cannot sell NEGATIVE/ZERO amount!");
            }
            else {
                mysql.processQuery("update items set stock = (stock-" + amount + ") where id = " + choice + "");
            }
        
        }
        else {
            System.out.println("No ID found.");
        }

    }

    public void updateBurger() { // updates specific row to change burger name
        this.viewBurger();
        int choice;
        String name;

        System.out.print("\nSelect ID# you want to change name: ");
        choice = sc.nextInt();
        sc.nextLine(); //prevents reading the next sc.nextline

        if (mysql.searchQuery(choice) != null ){ //executes if the method returns a value, and not a null
            System.out.print("Enter a new name for " + mysql.searchQuery(choice) + ": " );
            name = sc.nextLine();

                mysql.processQuery("update items set itemname = '" + name + "' where id = " + choice + "");
        
        }
        else {
            System.out.println("No ID found.");
        }

    }

    public void deleteBurger() { // deletes a row

    }

}
