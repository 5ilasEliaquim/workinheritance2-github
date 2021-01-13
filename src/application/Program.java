package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> pro = new ArrayList<>();;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.print("Product #" + i + "data: ");
			System.out.println("Common, used or imported (c/u/i)");
			char c = sc.next().charAt(0);
			
			if(c == 'c') {
				System.out.print("Name:");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				pro.add(new Product(name, price));
			}
			
			if(c == 'u') {
				System.out.print("Name:");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date DD/MM/YYYY ");
				Date manufactureDate = sdf.parse(sc.next());
				
				pro.add(new UsedProduct(name, price, manufactureDate));				
			}
			
			if(c == 'i') {
				System.out.print("Name:");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				pro.add(new ImportedProduct(name, price, customsFee));
			}
			
			System.out.println();
			
			System.out.println("PRICE TAGS");
			
			for(Product x : pro) {
				System.out.println(x.priceTag());
			}
			
			
			
		}
		
		
		
		
		
		
		
		sc.close();

	}

}
