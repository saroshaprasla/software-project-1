public class Movie {
    // Constants kept for backward compatibility
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    
    private String title;
    private MovieType movieType;
    
    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }
    
    // Constructor for backward compatibility
    public Movie(String title, int priceCode) {
        this.title = title;
        this.movieType = MovieType.fromCode(priceCode);
    }
    
    public MovieType getMovieType() {
        return movieType;
    }
    
    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
    
    // For backward compatibility
    public int getPriceCode() {
        return movieType.getCode();
    }
    
    // For backward compatibility
    public void setPriceCode(int priceCode) {
        this.movieType = MovieType.fromCode(priceCode);
    }
    
    public String getTitle() {
        return title;
    }
    
    // Moved from Rental class - calculating amount based on movie type
    public double calculateAmount(int daysRented) {
        double amount = 0;
        
        switch (movieType) {
            case REGULAR:
                amount += 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case CHILDRENS:
                amount += 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                break;
        }
        
        return amount;
    }
    
    // Moved from Rental class - calculating frequent renter points
    public int calculateFrequentRenterPoints(int daysRented) {
        if (movieType == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2; // bonus for a two day new release rental
        }
        return 1;
    }
}
