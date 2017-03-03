/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonecontacts;
import java.util.*;
/**
 *
 * @author Salvador
 */
public class PhoneContacts {

    public static Scanner in = new Scanner(System.in);
    public static MobilePhone myPhone = new MobilePhone();
    public static void main(String[] args) {
        int option;
        printMenu();
        option=in.nextInt();
        in.nextLine();
        while(option > 0 && option < 7) //Basic menu structure, that calls for methods
        {
            switch(option)
            {
                case 1:
                    addContact();
                    break;
                case 2:
                    updateContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    listContacts();
                    break;
                case 6:
                    printMenu();
                    break;
            }
            System.out.println("Option :");
            option = in.nextInt();
            in.nextLine();
        }
    }
    public static void printMenu() //Prints the menu
    {
        System.out.println("---------------  [Menu]  ---------------");
        System.out.println("0. Quit");
        System.out.println("1. Add contact");
        System.out.println("2. Update contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Query contact");
        System.out.println("5. List all contacts");
        System.out.println("6. Print options");
        System.out.println("Option:");
    }
    public static void addContact() //Adds a contact, asking for info and using the class methods
    {
        String name = getName("add");
        int number = getNumber("add");
        if(myPhone.addContact(name, number))
        {
            System.out.println("Contact added!");
        }
        else
        {
            System.out.println("Contact is already on the list");
        }
    }
    public static void updateContact() //Calls the updateContact function in MobilePhone
    {
        String name = getName("update");
        int number = getNumber("update");
        if(myPhone.updateContact(name, number))
        {
            System.out.println("Contact updated!");
        }
        else
        {
            System.out.println("Contact not found");
        }
    }
    public static void deleteContact() //Calls the removeContact function in MobilePhone
    {
        String name = getName("remove");
        int number = getNumber("remove");
        if(myPhone.removeContact(name, number))
        {
            System.out.println("Contact removed!");
        }
        else
        {
            System.out.println("Contact not found");
        }
    }
    public static void queryContact() //Calls the query function in MobilePhone
    {
        String name = getName("query");
        System.out.println(myPhone.queryContacts(name));
    }
    public static void listContacts()
    {
        myPhone.listContacts();
    }
    public static String getName(String instruction) //Methods used to print and ask for information, used for saving lines
    {
        System.out.println("Contact name to "+instruction+" :"); //Receives the instruction, and prints.
        return in.nextLine();
    }
    public static int getNumber(String instruction) //Similar to getName, but instead returns an int value
    {
        System.out.println("Contact number to "+instruction+" :");
        int number=in.nextInt();
        in.nextLine();
        return number;
    }
}
