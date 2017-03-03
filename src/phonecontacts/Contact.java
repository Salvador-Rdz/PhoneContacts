/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonecontacts;

/**
 *
 * @author Salvador
 */
public class Contact {
    private String name;
    private int number;
    //Constructor
    public Contact(String name, int number) 
    {
        this.name = name;
        this.number = number;
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() //Returns a formatted String with the contact's info.
    {
        return this.name + " : "+this.number;
    }
}
