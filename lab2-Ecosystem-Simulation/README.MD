This project will test your ability to model dynamic systems with interacting objects.

Instructions:

The ecosystem is a river, modeled as a large array of Animal objects. Each cell can hold a Bear, a Fish, or be null.
Create an abstract Animal class, and have Bear and Fish extend it.
In each time step, every animal randomly attempts to move to an adjacent cell or stay put.
Interaction Rules: If two identical animals collide, a new one is born in a random empty cell. If a bear and fish collide, the fish disappears.
After each step, provide a text-based visualization of the river (e.g., using 'B' for Bear, 'F' for Fish, and '-' for null).
