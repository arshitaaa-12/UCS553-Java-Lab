package assignment4;

import java.util.*;

class Song {
    String title;

    Song(String title) {
        this.title = title;
    }

    public String toString() {
        return title;
    }
}

public class q2 {
    LinkedList<Song> playlist = new LinkedList<>();
    LinkedList<Song> history = new LinkedList<>();

    void addSong(String title) {
        playlist.addLast(new Song(title));
    }

    void addPriority(String title) {
        playlist.addFirst(new Song(title));
    }

    void addAtPosition(int index, String title) {
        if (index < 0 || index > playlist.size()) {
            System.out.println("Invalid position!");
            return;
        }

        playlist.add(index, new Song(title));
    }

    void removeDuplicates() {
        HashSet<String> seen = new HashSet<>();
        ListIterator<Song> it = playlist.listIterator();

        while (it.hasNext()) {
            Song s = it.next();

            if (!seen.add(s.title)) {
                it.remove();
            }
        }
    }

    void playNext() {
        if (!playlist.isEmpty()) {
            Song s = playlist.removeFirst();
            history.addLast(s);
            System.out.println("Playing: " + s.title);
        } else {
            System.out.println("Playlist is empty!");
        }
    }

    void showHistory() {
        System.out.println("Recent History: " + history);
    }

    void traverseBothWays() {
        ListIterator<Song> it = playlist.listIterator();

        System.out.println("Forward:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Backward:");
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }

    void display() {
        System.out.println("Playlist: " + playlist);
    }

    public static void main(String[] args) {
        q2 mp = new q2();

        mp.addSong("Song A");
        mp.addSong("Song B");
        mp.addSong("Song A");
        mp.addPriority("Song C");
        mp.addAtPosition(2, "Song D");

        mp.display();

        mp.removeDuplicates();
        System.out.println("After removing duplicates:");
        mp.display();

        mp.traverseBothWays();

        mp.playNext();
        mp.playNext();

        mp.showHistory();
    }
}
