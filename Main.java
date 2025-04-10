public class Main {
    public static void main(String[] args) {
        // Create movies with different types
        Movie movie1 = new Movie("The Matrix", MovieType.REGULAR);
        Movie movie2 = new Movie("Avengers: Endgame", MovieType.NEW_RELEASE);
        Movie movie3 = new Movie("Toy Story 4", MovieType.CHILDRENS);
        
        // Create customer
        Customer customer = new Customer("John Doe");
        
        // Add rentals
        customer.addRental(new Rental(movie1, 3));  // 3 days for a regular movie
        customer.addRental(new Rental(movie2, 2));  // 2 days for a new release
        customer.addRental(new Rental(movie3, 4));  // 4 days for a children's movie
        
        // Add customer to repository
        CustomerRepository.addCustomer(customer);
        
        // Print text statement
        System.out.println("TEXT STATEMENT:");
        System.out.println(customer.generateTextStatement());
        
        // Print XML statement
        System.out.println("\nXML STATEMENT:");
        System.out.println(customer.generateXMLStatement());
        
        // Demonstrate getting customer from repository
        System.out.println("\nCustomer lookup from repository:");
        Customer retrievedCustomer = CustomerRepository.getCustomer("John Doe");
        System.out.println("Customer found: " + (retrievedCustomer != null));
        
        // Create and add another customer
        Customer customer2 = new Customer("Jane Smith");
        customer2.addRental(new Rental(movie3, 5));
        CustomerRepository.addCustomer(customer2);
        
        // List all customers
        System.out.println("\nAll customers in repository:");
        for (Customer c : CustomerRepository.getAllCustomers()) {
            System.out.println("- " + c.getName());
        }
    }
}

