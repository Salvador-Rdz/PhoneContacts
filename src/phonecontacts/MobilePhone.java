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
public class MobilePhone {
    public ArrayList<Contact> contacts;
    
    public MobilePhone()//Initializes the arraylist
    {
        this.contacts=new ArrayList<Contact>(); 
    }
    public boolean addContact(Contact contact) //Adds a pre-defined contact object
    {   
        if(findContact(contact.getName())== -1) //Checks for duplicates
        {
            this.contacts.add(contact); //Adds to the contacts list
            return true;
        }
        return false;
    }
    public boolean addContact(String name, int number) //Creates and adds a contact to the list
    {
        return addContact(new Contact(name, number)); //Utilizes the other method that receives a pre-defined contact, which is defined here
    }

    public int findContact(String name) //Finds a contact and returns it index value
    {
        for(int i=0;i < contacts.size(); i++)
        {
            if(contacts.get(i).getName().equals(name))
            {
                return i; //If found, returns the index
            }
        }
        return -1; //If not found, returns -1, an impossible value on a list
    }
    public boolean removeContact(Contact contact) //Removes a predefined contact
    {
        int index = findContact(contact.getName()); //Gets the index of the contact
        if(index==-1) //If not found, it can't be removed
        {
            return false;
        }
        contacts.remove(index); //Removes it using the index
        return true;
    }
    public boolean removeContact(String name, int number)
    {
        return removeContact(new Contact(name, number)); //Utilizes the previous method
    }
    public boolean removeContact(String name)
    {
        return removeContact(new Contact(name, 123)); //Utilizes the previous method, using a dummy number, since its not necessary
    }
    public boolean updateContact(Contact contact) //Updates the contact info
    {
        int index=findContact(contact.getName()); //Gets the index
        if(index==-1) //If it doesn't exist, there's no change
        {
            return false;
        }
        this.contacts.get(index).setName(contact.getName()); //Uses the setters to change the values
        this.contacts.get(index).setNumber(contact.getNumber());
        return true;
    }
    public boolean updateContact(String name, int number)
    {
        return updateContact(new Contact(name, number)); //Utilizes the previous method
    }
    public String queryContacts(String name) //Searches for a specific contact, and returns a String with info
    {
        int index = findContact(name); //Gets index
        if(index == -1)
        {
            return "Contact not found";
        }
        return this.contacts.get(index).toString(); //Uses the method toString from the contact class
    }
    public void listContacts() //Lists all contacts in the database
    {
        for(Contact tempContact : contacts) //Iterates the list
        {
            System.out.println(tempContact.toString()); //Prints the contact info one by one, using customer's toString()
        }
    }
}
