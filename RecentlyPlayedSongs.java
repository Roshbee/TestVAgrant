package testVagarant;
import testVagarant.PlayedStore;
import static org.testng.Assert.assertEquals;
import java.util.Arrays;
import org.testng.annotations.Test;

public class RecentlyPlayedSongs  {
   @Test
    public void testAddSong() {
	   /*The first test case testAddSong() tests whether the addSong() method 
	    * of the PlayedStore class works correctly. It creates an instance of 
	    * PlayedStore with a capacity of 3, adds three songs for a user named "user1", and then
	    * checks if the getRecentlyPlayed() method returns the correct list of songs. Then it
	    * adds a fourth song and checks again if the getRecentlyPlayed() method returns the expected list.*/
        PlayedStore store = new PlayedStore(3);
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user1", "song3");
        assertEquals(Arrays.asList("song1", "song2", "song3"), store.getRecentlyPlayed("user1"));
        store.addSong("user1", "song4");
        assertEquals(Arrays.asList("song2", "song3", "song4"), store.getRecentlyPlayed("user1"));
    }

    @Test
    public void testGetRecentlyPlayed() {
    	/*The second test case testGetRecentlyPlayed() tests whether the getRecentlyPlayed()
    	 * method of the PlayedStore class works correctly. It creates an instance of PlayedStore
    	 * and adds some songs for two different users ("user1" and "user2"). Then it checks
    	 * if the getRecentlyPlayed() method returns the correct list of songs for each user.
    	 * */
        PlayedStore store = new PlayedStore(3);
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user1", "song3");
        store.addSong("user2", "song4");
        store.addSong("user2", "song5");
        assertEquals(Arrays.asList("song1", "song2", "song3"), store.getRecentlyPlayed("user1"));
        assertEquals(Arrays.asList("song4", "song5"), store.getRecentlyPlayed("user2"));
    }

    @Test
    public void testCapacity() {
    	/*The third test case testCapacity() tests whether the PlayedStore class 
    	 * respects the capacity limit. It creates an instance of PlayedStore with a 
    	 * capacity of 2 and adds three songs for a user named "user1". Then it checks if the
    	 *  getRecentlyPlayed() method returns the correct list of songs, which should only 
    	 *  contain the last two songs added.
    	 * */
        PlayedStore store = new PlayedStore(2);
        store.addSong("user1", "song1");
        store.addSong("user1", "song2");
        store.addSong("user1", "song3");
        assertEquals(Arrays.asList("song2", "song3"), store.getRecentlyPlayed("user1"));
    }
}
//These tests cover adding songs to the store, getting the recently played songs for a user,
//and ensuring that the capacity of the store is respected.



