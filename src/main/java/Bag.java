/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    protected String color;
    protected int numberOfContents;
    protected int capacity;
    protected String [] Contents;


    /**
     *
     * @param color         represents name of the Bag.
     * @param capacity      represents the capacity of the Bag.
     */
    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag (String color, int capacity){
        this.color = color;
        this.numberOfContents = 0;
        this.capacity = capacity;
        this.Contents = new String[capacity];
    }




    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    /**
     *
     * @return the color of this Bag.
     */
    public String getColor() {
        return this.color;
    }

    /**
     *
     * @return the number of contents of this Bag.
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    /**
     *
     * @return the capacity of this Bag.
     */
    public int getCapacity() {
        return this.capacity;
    }



    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    /**
     *
     * @param color The color to which the color of the Bag is set to.
     */
    public void setColor(String color) {
        this.color = color;
    }





    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */

    /**
     *
     * @param item The item which is added to the Bag.
     * @return True if the item is added or otherwise return False.
     */
    public boolean addItem(String item) {
        if (this.numberOfContents < this.capacity) {
            for (int i = 0; i < this.capacity; i++){
                if (this.Contents[i] == null) {
                    this.Contents[i] = item;
                    this.numberOfContents ++;
                    return true;
                }
//                this.Contents[i] = item;
//                this.numberOfContents ++;
//                return true;
            }
        }
        return false;
    }






    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return the last item added into the Bag and remove it from the bag. If the Bag
     * is empty, return null.
     */
    public String popItem() {
        if (numberOfContents == 0){
            return null;
        } else{
            String removed = this.Contents[numberOfContents - 1];
            this.Contents[numberOfContents - 1] = null;
            this.numberOfContents--;
            return removed;
        }
    }





    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        String[] newarray = new String [this.capacity + n];
        for (int i = 0; i < this.capacity; i++){
            newarray[i] = this.Contents[i];

        }
        this.Contents = newarray;
        this.capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return the details of this Bag.
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}