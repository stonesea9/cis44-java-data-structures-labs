public class Playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Adds a song to the end of the playlist.
    public void addSong(Song song) {
        if (song == null) return;

        Node newNode = new Node(song);

        if (head == null) {         
            head = newNode;
            tail = newNode;
            currentNode = null;      
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean removeSong(String title) {
        if (head == null) return false;
        if (title == null) return false;

        String target = title.trim();
        if (target.isEmpty()) return false;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(target)) {
                // Case 1: removing head
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }

            
                if (curr == tail) {
                    tail = prev;
                }
              
                if (curr == currentNode) {
                    currentNode = (curr.next != null) ? curr.next : head;
                }

                size--;

                if (size == 0) {
                    head = null;
                    tail = null;
                    currentNode = null;
                }

                return true;
            }

            prev = curr;
            curr = curr.next;
        }

        return false; // not found
    }
  
    public Song playNext() {
        if (head == null) {
            return null;
        }

       
        if (currentNode == null) {
            currentNode = head;
        }

        Song nowPlaying = currentNode.song;
      
        currentNode = (currentNode.next != null) ? currentNode.next : head;

        return nowPlaying;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("(Playlist is empty)");
            return;
        }

        Node temp = head;
        int index = 1;
        while (temp != null) {
            System.out.println(index + ". " + temp.song);
            temp = temp.next;
            index++;
        }
    }
}
