package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        //Stage 1:
        boolean systemON = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = sc.nextInt();
        int sumSeats = numberOfRows * numberOfSeats;
        int sizeRows = numberOfRows + 1;
        int sizeCols = numberOfSeats + 1;
        int[][] cinemaIntArray = new int[sizeRows][sizeCols];
        for (int i = 0; i < sizeRows; i++) {
            cinemaIntArray[i][0] = i;
        }
        for (int i = 0; i < sizeCols; i++) {
            cinemaIntArray[0][i] = i;
        }
        String[][] cinemaStringArray = new String[sizeRows][sizeCols];
        int searchRow = 0;
        int seatNumberRow = 0;
        int numberOfPurchasedTicket = 0;
        int ticketPrice = 10;
        int ticketSumPrice = 0;

        while (systemON) {

            String firstMenu = "1. Show the seats";
            String secondMenu = "2. Buy a ticket";
            String thirdMenu = "3. Statistics";
            String fourthMenu = "0. Exit";
            System.out.println("\n" + firstMenu + "\n" + secondMenu + "\n" + thirdMenu + "\n" + fourthMenu);

            int numberInput = sc.nextInt();
            switch (numberInput) {

                case 1:

                    if (searchRow > 0 && seatNumberRow > 0) {

                        for (int i = 0; i < sizeRows; i++) {
                            for (int j = 0; j < sizeCols; j++) {
                                if (cinemaStringArray[i][j].equals("B")) {
                                    System.out.println("That ticket has already been purchased!");
                                } else {
                                    if (i == 0 && j == 0) {
                                        cinemaStringArray[i][j] = " ";
                                    } else if (i == 0 || j == 0) {
                                        cinemaStringArray[i][j] = String.valueOf(cinemaIntArray[i][j]);
                                    } else if (i == searchRow && j == seatNumberRow) {
                                        cinemaStringArray[i][j] = "B";
                                    } else {
                                        cinemaStringArray[i][j] = "S";
                                    }
                                }
                            }
                        }
                        System.out.println("Cinema:");
                        for (int i = 0; i < sizeRows; i++) {
                            for (int j = 0; j < sizeCols; j++) {
                                System.out.print(cinemaStringArray[i][j] + " ");
                            }
                            System.out.println();
                        }
                        continue;
                    } else {
                        for (int i = 0; i < sizeRows; i++) {
                            for (int j = 0; j < sizeCols; j++) {
                                if (i == 0 && j == 0) {
                                    cinemaStringArray[i][j] = " ";
                                } else if (i == 0 || j == 0) {
                                    cinemaStringArray[i][j] = String.valueOf(cinemaIntArray[i][j]);
                                } else {
                                    cinemaStringArray[i][j] = "S";
                                }
                            }
                        }
                        System.out.println("Cinema:");
                        for (int i = 0; i < sizeRows; i++) {
                            for (int j = 0; j < sizeCols; j++) {
                                System.out.print(cinemaStringArray[i][j] + " ");
                            }
                            System.out.println();
                        }
                        continue;
                    }

                case 2:
                    System.out.println("Enter a row number:");
                    searchRow = sc.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatNumberRow = sc.nextInt();
                    if(searchRow > 9 || seatNumberRow > 9){
                        System.out.println("Wrong input!");
                    }else{
                        int half;
                        if (sumSeats < 60) {
                            ticketSumPrice = ticketPrice * sumSeats;
                            System.out.println("Ticket price: $" + ticketPrice);
                        } else {
                            half = numberOfRows / 2;
                            ticketSumPrice = 0;
                            for (int i = 0; i < half; i++) {
                                ticketSumPrice += 10 * numberOfSeats;
                            }
                            for (int i = half; i < numberOfRows; i++) {
                                ticketSumPrice += 8 * numberOfSeats;
                            }
                            if (searchRow <= half) {
                                System.out.println("Ticket price: $" + ticketPrice);
                            } else {
                                ticketPrice = 8;
                                System.out.println("Ticket price: $" + ticketPrice);
                            }
                        }
                        numberOfPurchasedTicket++;
                        continue;
                    }
                case 3:
                    System.out.println("Number of purchased tickets: " + numberOfPurchasedTicket);
                    System.out.println("Percentage: ");
                    System.out.println("Current income: $" + ticketSumPrice);
                    System.out.println("Total income: $");
                case 0:
                    systemON = false;
            }
        }

    }
}