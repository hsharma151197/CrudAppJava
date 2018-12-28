import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Customer implements Comparable<Customer> {
	private int id;
	private String name;
	private String city;
	
	static List<Customer> list = new ArrayList<>();
	Customer(int id, String name, String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}
	Customer(int id){
		this.id = id;
	}
	public static void addCustomer(int id, String name, String city) {
		Customer customer = new Customer(id, name, city);
		list.add(customer);
	}
	public static ArrayList<Customer> getCustomer() {
		return (ArrayList<Customer>) list;
	}
	public static String searchCustomer(Customer customer) {
		if(list.contains(customer)) {
			return "Found: @" + list.indexOf(customer);  
		}
		else {
			return "Not Found: "; 
		}
	}
	public static String deleteCustomer(Customer customer) {
		if(list.contains(customer)) {
			list.remove(customer);
			System.out.println(list.indexOf(customer));
			return "Successfully Removed";
		}else {
			System.out.println(list.indexOf(customer));
			return "Record Not Found";
		}
	}
	public static void sortCustomers() {
		Collections.sort(list);
	}
	
	@Override
	public String toString(){
		return "id "+id+ " name "+name+" City "+city+"\n";
	}
	@Override
	public int compareTo(Customer o) {
		return ((Integer)this.id).compareTo(o.id);
	}
//	@Override
//	public boolean equals(Object object){
//		if(this==object){
//			return true;
//		}
//		if(object instanceof Customer){
//			Customer customer = (Customer) object;
//			if(this.id == customer.id && this.name==null){
//				return true;
//			}
//			if(this.id==customer.id && this.name.equals(customer.name) && this.city.equals(customer.city)){
//				return true;
//			}
//		}
//		return false;
//	}
}

public class CRUD_App {

	public static void main(String[] args) {
		while(true) {
			
			System.out.println("1. Add a Customer");
			System.out.println("2. Search a Customer");
			System.out.println("3. Delete a Customer");
			System.out.println("4. Update a Customer");
			System.out.println("5. Sort  Customers");
			System.out.println("6. Count Customers");
			System.out.println("7. Total Balance of All Customers");
			System.out.println("8. Print");
			System.out.println("9. exit");
			
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			
			switch(input) {
			case 1:
				System.out.println("Enter id, name, city");
				int id = sc.nextInt();
				String name = sc.next();
				String city = sc.next();
				Customer.addCustomer(id, name, city);
				break;
			case 8: 
				ArrayList<Customer> list =  Customer.getCustomer();
				list.forEach(y-> System.out.println(y));
				break;
			case 2:
				System.out.println("Enter id, name, city");
				int id1 = sc.nextInt();
				String name1 = sc.next();
				String city1 = sc.next();
				System.out.println(Customer.searchCustomer(new Customer(id1, name1, city1)));
				break;
			case 3:
				System.out.println("Enter id, name, city");
				int id2 = sc.nextInt();
				String name2 = sc.next();
				String city2 = sc.next();
				System.out.println(Customer.deleteCustomer(new Customer(id2, name2, city2)));
			case 5:
				Customer.sortCustomers();
			}
			
		}

	}

}
