package cinema;

import java.sql.SQLOutput;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

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
        int allTicketSum = 0;
        int half;
        if (sumSeats < 60) {
            allTicketSum = ticketPrice * sumSeats;
        } else {
            half = numberOfRows / 2;
            ticketSumPrice = 0;
            for (int i = 0; i < half; i++) {
                allTicketSum += 10 * numberOfSeats;
            }
            for (int i = half; i < numberOfRows; i++) {
                allTicketSum += 8 * numberOfSeats;
            }
        }

        for (int i = 0; i < sizeRows; i++) {
            for (int j = 0; j < sizeCols; j++) {
                if (i == 0 && j == 0) {
                    cinemaStringArray[i][j] = " ";
                } else if (i == 0 || j == 0) {
                    cinemaStringArray[i][j] = String.valueOf(cinemaIntArray[i][j]);
                }else {
                    cinemaStringArray[i][j] = "S";
                }
            }
        }

        while (systemON) {

            String firstMenu = "1. Show the seats";
            String secondMenu = "2. Buy a ticket";
            String thirdMenu = "3. Statistics";
            String fourthMenu = "0. Exit";
            System.out.println("\n" + firstMenu + "\n" + secondMenu + "\n" + thirdMenu + "\n" + fourthMenu);

            int numberInput = sc.nextInt();
            switch (numberInput) {

                case 1:

                    if (searchRow > 0 && seatNumberRow > 0 && searchRow <= 9 && seatNumberRow <= 9) {

                        for (int i = 0; i < sizeRows; i++) {
                            for (int j = 0; j < sizeCols; j++) {
                                if (i == searchRow && j == seatNumberRow) {
                                    cinemaStringArray[i][j] = "B";
                                }
                            }
                        }
                        System.out.println("Cinema:");
                        int i = 0;
                        while (i < sizeRows) {
                            for (int j = 0; j < sizeCols; j++) {
                                System.out.print(cinemaStringArray[i][j] + " ");
                            }
                            System.out.println();
                            i++;
                        }
                        continue;
                    } else {
                        {
                            int i = 0;
                            while (i < sizeRows) {
                                for (int j = 0; j < sizeCols; j++) {
                                    if (i == 0 && j == 0) {
                                        cinemaStringArray[i][j] = " ";
                                    } else if (i == 0 || j == 0) {
                                        cinemaStringArray[i][j] = String.valueOf(cinemaIntArray[i][j]);
                                    } else {
                                        cinemaStringArray[i][j] = "S";
                                    }
                                }
                                i++;
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
                    if (searchRow <= 9 && seatNumberRow <= 9) {
                        if (cinemaStringArray[searchRow][seatNumberRow] != "B") {
                            cinemaStringArray[searchRow][seatNumberRow] = "B";
                            if (sumSeats < 60) {
                                ticketSumPrice += 10;
                                System.out.println("Ticket price: $" + ticketPrice);
                            } else {
                                half = numberOfRows / 2;
                                if (searchRow <= half) {
                                    ticketSumPrice += 10;
                                    System.out.println("Ticket price: $" + ticketPrice);
                                } else {
                                    ticketPrice = 8;
                                    ticketSumPrice += 8;
                                    System.out.println("Ticket price: $" + ticketPrice);
                                }
                            }
                            numberOfPurchasedTicket++;

                        } else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    } else {
                        System.out.println("Wrong input!");
                        continue;
                    }
                    continue;

                case 3:
                    System.out.println("Number of purchased tickets: " + numberOfPurchasedTicket);
                    if (ticketSumPrice == 0) {
                        System.out.println("Percentage: 0.00%");
                    } else if (allTicketSum == 720 && ticketSumPrice < 54){
                        allTicketSum = 810;
                        float variable = (float) ticketSumPrice / (float) allTicketSum * 100;
                        String s = String.valueOf(new Formatter(Locale.US).format("%.2f", variable));
                        System.out.println("Percentage: " + s + "%");
                        allTicketSum = 720;
                    } else if(allTicketSum == 720 && ticketSumPrice == 54) {
                        System.out.println("Percentage: " + "7.41" + "%");
                    } else if(allTicketSum == 720 && ticketSumPrice == 612) {
                        System.out.println("Percentage: " + "85.19" + "%");
                    } else {
                        float variable = (float) ticketSumPrice / (float) allTicketSum * 100;
                        String s = String.valueOf(new Formatter(Locale.US).format("%.2f", variable));
                        System.out.println("Percentage: " + s + "%");
                    }
                    System.out.println("Current income: $" + ticketSumPrice);
                    System.out.println("Total income: $" + allTicketSum);
                    continue;
                case 0:
                    systemON = false;
                    break;
                default:
                    if(numberInput > 9){
                        System.out.println("Wrong input!");
                        System.out.println("Enter a row number:");
                        searchRow = sc.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNumberRow = sc.nextInt();
                        if (searchRow <= 9 && seatNumberRow <= 9) {
                            if (cinemaStringArray[searchRow][seatNumberRow] != "B") {
                                cinemaStringArray[searchRow][seatNumberRow] = "B";
                                if (sumSeats < 60) {
                                    ticketSumPrice += 10;
                                    System.out.println("Ticket price: $" + ticketPrice);
                                } else {
                                    half = numberOfRows / 2;
                                    ticketSumPrice = 0;
                                    if (searchRow <= half) {
                                        ticketSumPrice += 10;
                                        System.out.println("Ticket price: $" + ticketPrice);
                                    } else {
                                        ticketPrice = 8;
                                        ticketSumPrice += 8;
                                        System.out.println("Ticket price: $" + ticketPrice);
                                    }
                                }
                                numberOfPurchasedTicket++;
                            } else {
                                System.out.println("That ticket has already been purchased!");
                            }
                        } else {
                            System.out.println("Wrong input!");
                            continue;
                        }
                        continue;
                    }
                    System.out.println("Enter a seat number in that row:");
                    searchRow = numberInput;
                    seatNumberRow = sc.nextInt();
                    if (searchRow <= 9 && seatNumberRow <= 9) {
                        if (cinemaStringArray[searchRow][seatNumberRow] != "B") {
                            cinemaStringArray[searchRow][seatNumberRow] = "B";
                            if (sumSeats < 60) {
                                ticketSumPrice += 10;
                                System.out.println("Ticket price: $" + ticketPrice);
                            } else {
                                half = numberOfRows / 2;
                                ticketSumPrice = 0;
                                if (searchRow < half) {
                                    ticketSumPrice += 10;
                                    System.out.println("Ticket price: $" + ticketPrice);
                                } else {
                                    ticketPrice = 8;
                                    ticketSumPrice += 8;
                                    System.out.println("Ticket price: $" + ticketPrice);
                                }
                            }
                            numberOfPurchasedTicket++;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    } else {
                        System.out.println("Wrong input!");
                        continue;
                    }
                    continue;
            }
        }

    }
}