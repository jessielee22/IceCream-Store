//Jessie Lee, Tyric
//CSC 210 Group Final Project CLASS Code
//05/12/2024
/* 
-----------------------------------
|           IceCreamStore         |
-----------------------------------
| - usersAndPasswords: String[][] |
| - items: String[]                |
| - prices: double[]               |
| - taxRate: double                |
-----------------------------------
| + validateUser(username: String,|
|     password: String): boolean   |
| + getUsername(): String          |
| + getPassword(): String          |
| + getPrice(item: String): double |
| + getItems(): String[]           |
| + calculateCost(item: String,    |
|     quantity: int): double       |
| + calculateTaxes(cost: double):  |
|     double                       |
| + calculateTotalCost(cost: double|
|     taxes: double): double       |
| + main(args: String[]): void     |
| + displayMenu(): void            |
-----------------------------------
*/


import java.util.Scanner; // Importing the Scanner class to get user input

public class IceCreamStore { // Defining the IceCreamStore class
    private String[][] usersAndPasswords = {{"Jessie Lee", "0222"}}; // Initializing the usersAndPasswords array with one user and password
    private String[] items = {"Vanilla", "Chocolate", "Strawberry", "Oreos"}; // Initializing the items array with the names of the ice cream flavors
    private double[] prices = {5.75, 3.50, 1.99, 6.99}; // Initializing the prices array with the prices of the ice cream flavors
    private double taxRate = 0.0875; // Initializing the taxRate variable with the tax rate

    public boolean validateUser(String username, String password) { // Defining the validateUser method to check if the user and password are valid
        for (String[] userAndPassword : usersAndPasswords) { // Looping through the usersAndPasswords array
            if (userAndPassword[0].equals(username) && userAndPassword[1].equals(password)) { // Checking if the username and password match
                return true; // Returning true if the username and password are valid
            }
        }
        return false; // Returning false if the username and password are not valid
    }

    public String getUsername() { // Defining the getUsername method to get the username
        return usersAndPasswords[0][0]; // Returning the username
    }

    public String getPassword() { // Defining the getPassword method to get the password
        return usersAndPasswords[0][1]; // Returning the password
    }

    public double getPrice(String item) { // Defining the getPrice method to get the price of an item
        int index = -1; // Initializing the index variable with -1
        for (int i = 0; i < items.length; i++) { // Looping through the items array
            if (items[i].equalsIgnoreCase(item)) { // Checking if the item matches the input
                index = i; // Setting the index variable to the index of the item
                break; // Breaking out of the loop
            }
        }
        if (index!= -1) { // Checking if the item was found
            return prices[index]; // Returning the price of the item
        }
        return -1; // Returning -1 if the item was not found
    }

    public String[] getItems() { // Defining the getItems method to get the array of items
        return items; // Returning the items array
    }

    public double calculateCost(String item, int quantity) { // Defining the calculateCost method to calculate the cost of an item
        int index = -1; // Initializing the index variable with -1
        for (int i = 0; i < items.length; i++) { // Looping through the items array
            if (items[i].equalsIgnoreCase(item)) { // Checking if the item matches the input
                index = i; // Setting the index variable to the index of the item
                break; // Breaking out of the loop
            }
        }
        if (index!= -1) { // Checking if the item was found
            return prices[index] * quantity; // Returning the cost of the item
        }
        return -1; // Returning -1 if the item was not found
    }

    public double calculateTaxes(double cost) { // Defining the calculateTaxes method to calculate the taxes
        return cost * taxRate; // Returning the taxes
    }

    public double calculateTotalCost(double cost, double taxes) { // Defining the calculateTotalCost method to calculate the total cost
        return cost + taxes; // Returning the total cost
    }

    public static void main(String[] args) { // Defining the main method
        Scanner scanner = new Scanner(System.in); // Initializing the Scanner object
        IceCreamStore iceCreamStore = new IceCreamStore(); // Initializing the IceCreamStore object

        // User validation
        String username, password;
        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        } while (!iceCreamStore.validateUser(username, password)); // Looping until the user and password are valid

        // Display menu
        iceCreamStore.displayMenu(); // Displaying the menu

        // Item selection
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); // Consuming the newline character

        // Quantity input
        System.out.print("Enter quantity: ");
        int quantity= scanner.nextInt();

        // Calculate and display costs
        String selectedItem = iceCreamStore.items[itemNumber - 1];
        double cost = iceCreamStore.calculateCost(selectedItem, quantity);
        double taxes = iceCreamStore.calculateTaxes(cost);
        double totalCost = iceCreamStore.calculateTotalCost(cost, taxes);

        System.out.println("\nReceipt:");
        System.out.println("Item: " + selectedItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Cost: $" + cost);
        System.out.println("Taxes: $" + taxes);
        System.out.println("Total Cost: $" + totalCost);
    }

    public void displayMenu() { // Defining the displayMenu method to display the menu
        System.out.println("Menu:");
        for (int i = 0; i < items.length; i++) { // Looping through the items array
            System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i]);
        }
    }
}

/* Enter username: jessie lee
Enter password: 0222
Enter username: Jessie Lee 
Enter password: 0222
Enter username: Jessie Lee
Enter password: 0222
Menu:
1. Vanilla - $5.75
2. Chocolate - $3.5
3. Strawberry - $1.99
4. Oreos - $6.99
Enter item number: 1 
Enter quantity: 3

Receipt:
Item: Vanilla
Quantity: 3
Cost: $17.25
Taxes: $1.3800000000000001
Total Cost: $18.63 */
