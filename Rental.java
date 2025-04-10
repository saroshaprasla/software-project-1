public class Rental {
    private Movie rentedMovie;
    private int daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this.rentedMovie = movie;
        this.daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return daysRented;
    }
    
    public Movie getRentedMovie() {
        return rentedMovie;
    }
    
    // For backward compatibility
    public Movie getMovie() {
        return rentedMovie;
    }
    
    // Delegate to Movie class
    public double calculateAmount() {
        return rentedMovie.calculateAmount(daysRented);
    }
    
    // Delegate to Movie class
    public int calculateFrequentRenterPoints() {
        return rentedMovie.calculateFrequentRenterPoints(daysRented);
    }
}

