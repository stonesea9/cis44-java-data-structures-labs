import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    // An abstract toString() helps visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class ecosystem {
    private Animal[] river;
    private Random random;

    // You can adjust these to control how many animals to start with
    private static final double INITIAL_BEAR_RATE = 0.20; // 20%
    private static final double INITIAL_FISH_RATE = 0.30; // 30%

    public ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();

        // Initially populate the river (optional but useful)
        populateInitialRiver();
    }
    
    private void populateInitialRiver() {
        for (int i = 0; i < river.length; i++) {
            double r = random.nextDouble();
            if (r < INITIAL_BEAR_RATE) {
                river[i] = new Bear();
            } else if (r < INITIAL_BEAR_RATE + INITIAL_FISH_RATE) {
                river[i] = new Fish();
            } else {
                river[i] = null;
            }
        }
    }

    public void runStep() {
        Animal[] next = new Animal[river.length];
        int bearBirths = 0;
        int fishBirths = 0;
        // Move animals from current river into next river
        for (int i = 0; i < river.length; i++) {
            Animal current = river[i];
            if (current == null) continue;
            int move = random.nextInt(3) - 1;
            int target = i + move;

            if (target < 0 || target >= river.length) {
                target = i;
            }
            
            if (next[target] == null) {
                next[target] = current;
            } else {
                // Collision!
                Animal existing = next[target];

                // Same type => keep one, record a birth
                if (sameType(existing, current)) {
                    if (existing instanceof Bear) bearBirths++;
                    else fishBirths++;
                } else {
                    // Different types: Bear + Fish => Fish disappears, Bear survives
                    next[target] = resolveBearFish(existing, current);
                }
            }
        }

        // Apply births (place newborns into random empty cells)
        spawnNewborns(next, bearBirths, fishBirths);
        // Replace old river with new
        river = next;
    }

    /**
     * Check whether two animals are the same type (both Bear or both Fish).
     */
    private boolean sameType(Animal a, Animal b) {
        return (a instanceof Bear && b instanceof Bear) ||
                (a instanceof Fish && b instanceof Fish);
    }

    /**
     * Resolve a collision between a Bear and a Fish.
     * Returns the surviving Animal (Bear always survives).
     */
    private Animal resolveBearFish(Animal a, Animal b) {
        // If either is Bear, the result is Bear
        if (a instanceof Bear) return a;
        if (b instanceof Bear) return b;
        // Should never happen because only Bear/Fish exist, but safe fallback:
        return a;
    }

    /**
     * Spawn newborns into random empty cells in the next river.
     * If no empty cells, extra births are ignored.
     */
    private void spawnNewborns(Animal[] next, int bearBirths, int fishBirths) {
        // Spawn bears first, then fish (order isn't important)
        for (int k = 0; k < bearBirths; k++) {
            int idx = findRandomEmptyIndex(next);
            if (idx == -1) break; // no space
            next[idx] = new Bear();
        }

        for (int k = 0; k < fishBirths; k++) {
            int idx = findRandomEmptyIndex(next);
            if (idx == -1) break; // no space
            next[idx] = new Fish();
        }
    }
    
    private int findRandomEmptyIndex(Animal[] arr) {
        // Try a limited number of random attempts first (fast in practice)
        for (int tries = 0; tries < arr.length * 2; tries++) {
            int idx = random.nextInt(arr.length);
            if (arr[idx] == null) return idx;
        }
        // Fallback: scan to guarantee correctness
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) return i;
        }
        return -1;
    }
    
    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ecosystem eco = new ecosystem(20); // Create a river of size 20

        // Run and display multiple steps
        for (int step = 0; step < 10; step++) {
            System.out.print("Step " + step + ": ");
            eco.visualize();
            eco.runStep();
        }

        System.out.print("Final: ");
        eco.visualize();
    }
}

