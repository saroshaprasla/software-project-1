import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private static Map<String, Customer> customers = new HashMap<>();
    
    public static void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }
    
    public static Customer getCustomer(String name) {
        return customers.get(name);
    }
    
    public static List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }
    
    public static void removeCustomer(String name) {
        customers.remove(name);
    }
    
    public static boolean customerExists(String name) {
        return customers.containsKey(name);
    }
}
