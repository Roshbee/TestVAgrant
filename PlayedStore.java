package testVagarant;

import java.util.*;

public class PlayedStore {
    private final int capacity;//represents maximum number of songs that can be stored per user.
    private final Map<String, LinkedList<String>> recentlyPlayed;//a variable ,which stores recently played songs for each user.

    public PlayedStore(int capacity) {//created a constructor  having int parameter named capacity,which initializes the capacity variable
        this.capacity = capacity;
        recentlyPlayed = new HashMap<>();//here we are initializing recentlyplayed map with an empty HashMap 
    }

    public void addSong(String user, String song) {//add song method which adds songs for a user with two parameter User and Song which that user played
        LinkedList<String> songs = recentlyPlayed.computeIfAbsent(user, k -> new LinkedList<>());//It first gets the list of recently played songs for the given user from the recentlyPlayed map using computeIfAbsent() method. Then, it adds the song to the end of the list.
                                                                     //If the size of the list exceeds the capacity, it removes the first song from the list.
        songs.add(song);
        if (songs.size() > capacity) {
            songs.removeFirst();
        }
    }

    public List<String> getRecentlyPlayed(String user) {/*getRecentlyPlayed(String user) retrieves the recently played songs for a user. It takes a String parameter named user representing the user whose recently played songs need to be retrieved. It returns a List<String> containing the recently played songs for the given user. If there are no recently played songs for the given user, it returns an empty LinkedList.*/
        return recentlyPlayed.getOrDefault(user, new LinkedList<>());
    }
}
/*here we are using a HashMap to store the recently played songs for each user, with each user's songs being stored in a LinkedList. When a new song is played, we add it to the user's list of recently played songs. If the list is longer than the capacity, we remove the oldest song from the beginning of the list. The getRecentlyPlayed method returns the list of recently played songs for the specified user.

To test the implementation, we can use a testing framework like TestNG
I have created the different class for the test logic called "RecentlyPlayedSongs".
*/