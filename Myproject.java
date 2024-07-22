import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bubblegum = 202;
        int toffee = 118;
        int iceCream = 2250;
        int milkChocolate = 1680;
        int doughnut = 1075;
        int pancake = 80;

        System.out.println("Earned amount:");
        System.out.println("Bubblegum: $" + bubblegum);
        System.out.println("Toffee: $" + toffee);
        System.out.println("Ice cream: $" + iceCream);
        System.out.println("Milk chocolate: $" + milkChocolate);
        System.out.println("Doughnut: $" + doughnut);
        System.out.println("Pancake: $" + pancake);
        System.out.println("");

        int totalEarnings = bubblegum + toffee + iceCream + milkChocolate + doughnut + pancake;

        System.out.println("Income: $" + totalEarnings);
        System.out.println("Staff expenses:");
        int sExpensses = sc.nextInt();
        System.out.println("Other expenses:");
        int oExpensses = sc.nextInt();
        int totalAll = totalEarnings - (sExpensses + oExpensses);
        System.out.println("Net income: $" + totalAll);
    }

}
