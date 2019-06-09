import javax.swing.JFrame; //Imports for pictures
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.Scanner; //import scanner
public class Library {
    // method returnday which returns a string "return days"////////////////////////////////////////////////////////
    public static String returnday(int year, int month, int day){ //method heading
        int rday = 0; // declares integers return day, return month, return year
        int rmonth = 0;
        int ryear = 0;
        String rdate = ""; // initialize the date

        if ((month == 1) ||(month == 3)||(month == 5)||(month == 7)||(month == 8)||(month == 10)||(month == 12)) // condition if the months have 31 days
        {
            if (31-day >= 7) // if the day add 7 smaller than 31
            {rday = day+7;
                rmonth = month;}
            else // the day add 7 larger than 31, the month will be add up by 1
            {rday = 7-31+day;
                rmonth = month +1;}
        }

        if ((month == 2) ||(month == 4)||(month == 6)||(month == 9)||(month == 11)) // if the months have 30 days
        {

            if (30-day >= 7) // if the day add 7 smaller than 30
            {rday = day+7;
                rmonth = month;
            }
            else // if the day add 7 greater than 30, the month will add up by 1
            {rday = 7-30+day;
                rmonth = month +1;
            }
        }

        if (rmonth > 12) // if the return month is greater than 12, the return month will be 1 and the year will be added up by 1
        {rmonth = 1;
            ryear = year+1;}
        else
        {ryear = year;}

        rdate = ryear + "." + rmonth + "." + rday; // rdate is a string
        return rdate; // return the date
    }
    ///////////////////////////////////////////////////////

    public static void main(String []args){

        /////////////////// import pictures////////////
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("book.jpg");
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ////////////////////////////////////////////////

        int a, b, c, d, e, f,dcn1,dcn2, dcn3, dcn4,dcn6, checkNum, storedNum, borrowNum, quanBorrow, year, month, day; // declare int variables
        String cardNum, name, cellphone, email, rdate; // declare the string variables
        int z = 1;
        int g = 1;
        int dcn5 = 0;

        Scanner scan = new Scanner(System.in); // declare scanner
        Scanner scan2 = new Scanner(System.in); // declare scanner 2

        String booklist[] = new String[]{"Math", "English", "Computer Science", "Physics", "Chemistry", "Biology", "Science", "Business", "Cooking", "History", "Geography"};
        // declare book list array
        int storelist[] = new int[]{220, 200, 210, 180, 190, 160, 140, 130, 110, 120, 150};
        // declare store list array
        int pricelist[] = new int[]{60, 60, 50, 50, 50, 50, 50, 40, 40, 40, 40, 40};
        // declare preice list array
        String orderlist[] = new String[30];
        // declare a blank array order list
        String info[] = new String[30];
        // declare a blank array information list


        System.out.println("Welcome to the Library self-checkout."); // print out at the beginning of the program

        System.out.println("");

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        while (z==1) // the main loop, if the user want to borrow again the code will run again
        {

            System.out.println("# of book \t\t #s available \t\t Name of book"); // print out the book list and storage

            for (a = 0 ; a<11 ; a++) // loop to print out the store list and book list
                System.out.println(a + "\t\t "+  storelist[a]+ "\t\t\t " + booklist[a]);

            //////////////////////////////////////First array book list/////////////////////////////////////////

            System.out.println("");

            ////////////////////////////////////////////Info//////////////////////////////////////////

            System.out.println("Please Enter your Information"); // gather information

            System.out.print("Please Enter your Library Card Number: ");
            cardNum = scan.nextLine();
            System.out.print("Please Enter your Name: ");
            name = scan.nextLine();
            System.out.print("Please Enter your cellphone number: ");
            cellphone = scan.nextLine();
            System.out.print("Please Enter your E-mail address: ");
            email = scan.nextLine();

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.print("Do you want to check the price list of the book? (Enter '1' for checking)"); // check the price list
            dcn1 = scan2.nextInt();

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            if (dcn1==1) // loop to print out the price list
            {System.out.println("# of book \t\t Price Boughtin($) \t\t Fine if lost($)");
                for (b = 0; b<11 ; b++ )
                    System.out.println(b + "\t\t "+  pricelist[b]+ "\t\t\t " + (pricelist[b] + 5));}
            else
                System.out.println("Make sure you don't lose your book.");

            //////////////////////////////////Second array book price////////////////////////////////////////////

            System.out.println();

            System.out.print("Please enter the number of book you want to borrow:"); // ask users for the number of book
            borrowNum = scan2.nextInt();

            while (borrowNum>(booklist.length-1) || borrowNum<0) // if the number is not existing, the system will remind the user
            {System.out.println("Please enter the correct book number.(From 0 to "+(booklist.length-1)+" )");
                System.out.print("Please enter the number of book you want to borrow:");
                borrowNum = scan2.nextInt();}

            if (storelist[borrowNum]==0) // if there is no book in store, it is not available
            {System.out.println("The book is not available");
                System.out.println("Please choose another book:");
                borrowNum = scan2.nextInt();
            }



            System.out.println("How many you would like to borrow? (maximum 2)"); // ask users for the quantity of books
            quanBorrow = scan2.nextInt();

            while (quanBorrow>2) // if the quantity is larger than 2, the system will ask again
            {System.out.println("You can't borrow more than 2 books!");
                System.out.println("How many you would like to borrow? (maximum 2)");
                quanBorrow = scan2.nextInt();
            }

            if (quanBorrow>storelist[borrowNum]) // if there is only one book and the user want to borrow two
            {System.out.println("There is only one book left!");
                System.out.println("Do you want to borrow it? (Enter '1' for borrowing, else to quit)");
                dcn6 = scan.nextInt(); // if the user still wants the book, the quantity will be 1
                if (dcn6 == 1)
                {quanBorrow = 1;

                }

            }

            while (quanBorrow<0) // if the quantity is larger than 2, the system will ask again
            {System.out.println("Do you still want to borrow books?(Enter '1' to quit, enter others to continue)");
                dcn5=scan2.nextInt();
                System.out.println("How many you would like to borrow? (maximum 2)");
                quanBorrow = scan2.nextInt();
            }
            if (dcn5 == 1) // if the user answer 1 to quit, the program will terminate
                break;

            ///////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println();
            System.out.println("Make sure: you will borrow the book \'" + booklist[borrowNum] + "\'."); // check the book information with the user
            System.out.println();
            System.out.println("The price of the book is " +pricelist[borrowNum] + " dollars; if it is lost you will need to pay "+(pricelist[borrowNum]+5) +" dollars for each book");
            //print out the price reminder

            //////////////////////////////////price reminder printout///////////////////////////////////////////
            System.out.println();
            // ask users for the date of borrowing and the code will ask again if the year, month or day entered inappropriately
            System.out.println("Enter the date you borrow the book: (Year)");
            year = scan2.nextInt();

            while (year>2020 || year<2019)
            {System.out.println("Please Enter the correct year (Current year or next year).");
                System.out.println("Enter the date you borrow the book: (Year)");
                year = scan2.nextInt();
            }

            System.out.println("Enter the date you borrow the book: (Month)");
            month = scan2.nextInt();

            while (month>12 || month <1)
            {System.out.println("Please Enter the correct year (From 1 to 12).");
                System.out.println("Enter the date you borrow the book: (Month)");
                month = scan2.nextInt();
            }

            System.out.println("Enter the date you borrow the book: (Day)");
            day = scan2.nextInt();

            if ((month == 1) ||(month == 3)||(month == 5)||(month == 7)||(month == 8)||(month == 10)||(month == 12))
            {while (day>31 || day<1)
            {System.out.println("Please Enter the correct year (From 1 to 31).");
                System.out.println("Enter the date you borrow the book: (Day)");
                day = scan2.nextInt();
            }}

            if ((month == 2) ||(month == 4)||(month == 6)||(month == 9)||(month == 11))
            {while (day>31 || day<1)
            {System.out.println("Please Enter the correct year (From 1 to 30).");
                System.out.println("Enter the date you borrow the book: (Year)");
                day = scan2.nextInt();
            }}


            System.out.println("Your return day is: " + returnday(year,month,day)); // print out he return date by calling the method returnday
            ///////////////////////////////////call the method and find the return day//////////////////////////////////////////

            System.out.println();



            dcn2 = 1;

            c = 0;
            if (dcn2==1) // the user's information will be save into the blank information array one by one
            {
                info[c] = cardNum + " \t\t" + name + "     \t\t" + cellphone + "\t" + email;
                c++;}

            System.out.print("Enter '1' to check the information");
            dcn3 = scan2.nextInt();

            if (dcn3==1) { // loop to print out the users information
                System.out.println("CardNum  \t\tName     \t\tCellphone\t\t\tEmail");
                for (d = 0; d < g; d++) {///repetition changes
                    System.out.println(info[d]);
                }
            }
////////////////////////////////////////////////////customer info/////////////////////////
            System.out.println("");
            System.out.println("Enter '1' to check the order list of books: ");
            dcn4=scan2.nextInt();

            e = 0;
            if (dcn2==1) // store the information into order list one by one
            {
                orderlist[e] = borrowNum + "\t\t" + (year+"."+month+"."+day) + "\t\t\t" + returnday(year,month,day) + "\t\t" + cardNum + "\t\t" + quanBorrow;
                e++;}

            if (dcn4==1) { // loop to print out order list
                System.out.println("# of book \t\t Borrow Date \t\tReturn day \t\tCard number \t\tQuantity");
                for (f = 0; f < g; f++) {///repetition changes
                    System.out.println(orderlist[f]);
                }
            }

            System.out.println("Enter '1' for borrowing another book. Enter '2' to quit."); // ask users if they want to borrow another book or quit
            z = scan2.nextInt();

            g++; // the variable that control how many time the order list and information list will be printed out

            info[c] = cardNum + " \t\t" + name + "     \t\t" + cellphone + "\t" + email; // store the information
            orderlist[e] = borrowNum + "\t\t" + (year+"."+month+"."+day) + "\t\t\t" + returnday(year,month,day) + "\t\t" + cardNum + "\t\t" + quanBorrow; // store the order

            storelist[borrowNum] = storelist[borrowNum] - quanBorrow; // take out book from the storage


        }

        System.out.println("Thank you for using self-check out!");

    }

}


