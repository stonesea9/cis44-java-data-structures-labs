
Instructions:

Create a simple Item class with a String name attribute.

Create an Inventory class that uses an ArrayList<Item> to store the player's items.

Implement the following methods in your Inventory class:

addItem(Item item): Adds an item to the inventory.

display(): Prints all items in the inventory.

combineItems(String name1, String name2): This is the core method. It must use an Iterator to search the list for items with names matching name1 and name2. If both are found, they must be removed using the iterator.remove() method, and a new combined item (e.g., "Magic Staff") is added to the inventory.

Create a main application class that tests your inventory system. Show the process of adding initial items, displaying the inventory, combining two items, and displaying the final inventory.
