/* This is a stub for the Library class */
import java.util.Hashtable;

/**
 * Library is a subclass of Building that represents a library.
 * It stores a collection of books and tracks if they are checked out.
 */
public class Library extends Building implements LibraryRequirements {

    private Hashtable<String, Boolean> collection;

    /**
     * Creates a Library with the given details.
     * @param name Name of the library
     * @param address Address of the library
     * @param nFloors Number of floors
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library 📚");
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(String title)\n + removeTitle(String title)\n + checkOut(String title)\n + returnBook(String title)");
    }
    /**
     * Adds a book to the library collection.
     * @param title the title of the book
     */
    public void addTitle(String title) {
        collection.put(title, true);  // true = available
    }

    /**
     * Removes a book from the collection.
     * @param title the title to remove
     * @return the title that was removed
     */
    public String removeTitle(String title) {
        collection.remove(title);
        return title;
    }

    /**
     * Checks out a book (marks it as not available).
     * @param title the title to check out
     */
    public void checkOut(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, false);
        }
    }

    /**
     * Returns a book (marks it as available).
     * @param title the title to return
     */
    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, true);
        }
    }

    /**
     * Checks if the library contains a certain title.
     * @param title the title to search for
     * @return true if found
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if a book is currently available.
     * @param title the title to check
     * @return true if available, false if checked out
     */
    public boolean isAvailable(String title) {
        return collection.getOrDefault(title, false);
    }

    /**
     * Prints all books in the collection and their status.
     */
    public void printCollection() {
        for (String title : collection.keySet()) {
            String status = collection.get(title) ? "Available" : "Checked out";
            System.out.println(title + " — " + status);
        }
    }

    /**
     * Main method to test creating a Library.
     */
    public static void main(String[] args) {
        Library lib = new Library("Neilson Library", "7 Neilson Drive", 4);
        lib.addTitle("The Lorax by Dr. Seuss");
        lib.addTitle("Pride and Prejudice by Jane Austen");
        lib.printCollection();
    }
}
