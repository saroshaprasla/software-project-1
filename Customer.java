import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentalList = new ArrayList<>();
    
    public Customer(String name) {
        this.name = name;
    }
    
    public void addRental(Rental rental) {
        rentalList.add(rental);
    }
    
    public String getName() {
        return name;
    }
    
    public List<Rental> getRentalList() {
        return rentalList;
    }
    
    // Extracted method for calculating total amount
    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentalList) {
            totalAmount += rental.calculateAmount();
        }
        return totalAmount;
    }
    
    // Extracted method for calculating frequent renter points
    public int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
    
    public String generateTextStatement() {
        return StatementGenerator.generateTextStatement(this);
    }
    
    public String generateXMLStatement() {
        return StatementGenerator.generateXMLStatement(this);
    }
    
    // For backward compatibility
    public String statement() {
        return generateTextStatement();
    }
    
    // For backward compatibility
    public String xmlStatement() {
        return generateXMLStatement();
    }
}

