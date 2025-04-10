import java.util.List;
public class StatementGenerator {
    public static String generateTextStatement(Customer customer) {
        double totalAmount = customer.calculateTotalAmount();
        int frequentRenterPoints = customer.calculateTotalFrequentRenterPoints();
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        
        for (Rental rental : customer.getRentalList()) {
            // Extract rental information
            String rentalInfo = extractRentalInfo(rental);
            result.append(rentalInfo);
        }
        
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }
    
    // Extracted method for formatting rental information
    private static String extractRentalInfo(Rental rental) {
        return "\t" + rental.getRentedMovie().getTitle() +
              "\t" + rental.calculateAmount() + "\n";
    }
    
    public static String generateXMLStatement(Customer customer) {
        StringBuilder result = new StringBuilder("<customer>\n<name>" + customer.getName() + "</name>\n");
        
        for (Rental rental : customer.getRentalList()) {
            result.append("<rental>\n")
                  .append("<movie>").append(rental.getRentedMovie().getTitle()).append("</movie>\n")
                  .append("<amount>").append(rental.calculateAmount()).append("</amount>\n")
                  .append("</rental>\n");
        }
        
        double totalAmount = customer.calculateTotalAmount();
        int totalPoints = customer.calculateTotalFrequentRenterPoints();
        
        result.append("<totalAmount>").append(totalAmount).append("</totalAmount>\n");
        result.append("<totalPoints>").append(totalPoints).append("</totalPoints>\n");
        result.append("</customer>");
        return result.toString();
    }
}
