
Instructions:

Implement a LinkedPositionalList class using a doubly linked list, as described in the lecture notes. It must support `Position` objects.
Your LinkedPositionalList class must also implement the Iterable interface.
Implement the following methods in your list:
first(), last(), before(p), after(p)
addFirst(e), addLast(e), addBefore(p, e), addAfter(p, e)
set(p, e), remove(p)
iterator(): This method must return a new instance of your custom iterator class.
Create a private inner class that implements the Iterator interface. It will need to manage its state to traverse the list.
Create a main application to manage a travel itinerary (a list of Strings). Demonstrate adding stops, inserting a stop between two others, and traversing the final itinerary using a for-each loop (which will prove your iterator works).
