/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class Main {
    private static char[][] seats;
    private static int rows;
    private static int cols;

    
    public static void initializeSeats(int r, int c) {
        rows = r;
        cols = c;
        seats = new char[rows][cols];

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = 'A';
            }
        }
    }

   public static void displaySeats() {
        System.out.println("\n--- Seating Layout ---");
        System.out.print("   ");
        for (int j = 0; j < cols; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat(int row, int col) {
        if (row < 1 || row > rows || col < 1 || col > cols) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats[row - 1][col - 1] == 'B') {
            System.out.println("Seat already booked!");
        } else {
            seats[row - 1][col - 1] = 'B';
            System.out.println("Seat booked successfully!");
        }
    }

    public static void cancelSeat(int row, int col) {
        if (row < 1 || row > rows || col < 1 || col > cols) {
            System.out.println("Invalid seat number.");
            return;
        }
        if (seats[row - 1][col - 1] == 'A') {
            System.out.println("Seat is already available!");
        } else {
            seats[row - 1][col - 1] = 'A';
            System.out.println("Booking cancelled successfully!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        initializeSeats(5, 6);

        while (true) {
            System.out.println("\n--- Movie Ticket Booking System ---");
            System.out.println("1. View seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displaySeats();
                case 2 -> {
                    System.out.print("Enter row number: ");
                    int r = sc.nextInt();
                    System.out.print("Enter column number: ");
                    int c = sc.nextInt();
                    bookSeat(r, c);
                }
                case 3 -> {
                    System.out.print("Enter row number: ");
                    int r = sc.nextInt();
                    System.out.print("Enter column number: ");
                    int c = sc.nextInt();
                    cancelSeat(r, c);
                }
                case 4 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
