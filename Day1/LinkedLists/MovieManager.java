class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class MovieManagementSystem {
    private MovieNode head, tail;

    public MovieManagementSystem() {
        head = tail = null;
    }

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addMovieAtPosition(int position, String title, String director, int year, double rating) {
        if (position < 1) return;
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        
        MovieNode current = head;
        int index = 1;
        while (current != null && index < position) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = current;
            newMovie.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newMovie;
            }
            current.prev = newMovie;
        }
    }

    public void removeMovieByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public MovieNode searchMovieByDirector(String director) {
        MovieNode current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public MovieNode searchMovieByRating(double rating) {
        MovieNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }
}

public class MovieManagementApp {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        system.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addMovieAtEnd("The Matrix", "Lana Wachowski", 1999, 8.7);
        system.addMovieAtEnd("Titanic", "James Cameron", 1997, 7.8);
        system.addMovieAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.0);

        System.out.println("Display movies in forward order:");
        system.displayForward();

        System.out.println("\nDisplay movies in reverse order:");
        system.displayReverse();

        system.updateMovieRating("Titanic", 8.0);
        System.out.println("\nUpdated movie list after rating update:");
        system.displayForward();

        system.removeMovieByTitle("The Matrix");
        System.out.println("\nMovie list after removal:");
        system.displayForward();

        MovieNode searchedMovie = system.searchMovieByDirector("Christopher Nolan");
        if (searchedMovie != null) {
            System.out.println("\nFound movie by Director Christopher Nolan: " + searchedMovie.title);
        } else {
            System.out.println("\nNo movie found by Christopher Nolan.");
        }
    }
}
























public class MovieManager {
    
}
