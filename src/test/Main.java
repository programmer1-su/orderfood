package test;

import java.util.Arrays;

import javax.swing.JOptionPane;

import coder.bar.Food;

public class Main {
	String title = "Self Service Bar";
	String loginMsg = "Please enter the member codes!";
	String orderMore = "More Order?";
	String [] memberCodes = {"1001","1002","1003","1004"};
	int orders[] = new int[10];
	int orderCount = 0;
	
	Food[] foods = {
			new Food("1.豚肉料理",1,3200),
			new Food("2.鳥肉料理",2,2200),
			new Food("3.牛肉料理",3,4200),
			new Food("6.Orange Juice",4,600),
			new Food("7.Coca Cola",5,400),
			new Food("8.Pepsi",6,400)
	};
	
	public static void main(String[] args) {
		Main m = new Main();
		if(m.memberLogin()) {
			String result = m.showInputDialog("1.Food \n 2.Drink");
			if(result.contentEquals("1")) {
				m.orderFood(m.getFood());
			}else {
				m.orderFood(m.getDrink());
			}
		}
	}
	
	public void orderFood(String orderList) {
		boolean b = true;
		int i = 0;
		while(b) {
			String order = showInputDialog(orderList);
			orders[i++] = Integer.parseInt(order);
			orderCount++;
			System.out.println(Arrays.toString(orders));
			int ret = showConfirmDialog(orderMore);
			switch(ret) {
			case 0:
				b = true;
				break;
			case 1:
				b = false;
				break;
			case 2:
				b = false;
				break;
			}
			if(!b) {
				showBill();
			}
		}
	}
	
	public void showBill() {
		System.out.println(orderCount);
		String bill = "";
		int total = 0;
		for(int i = 0; i < orderCount; i++) {
			bill += getCurrentFood(orders[i]).getName() + "\t" + getCurrentFood(orders[i]).getPrice() + "\n ";
			total += getCurrentFood(orders[i]).getPrice();
		}
		showMessageDialog(bill,total);
	}
	
	public void showMessageDialog(String ords,int total) {
		JOptionPane.showMessageDialog(null, ords + "\n Total is => "  + total);
	}
	
	public Food getCurrentFood(int id) {
		Food food = null;
		for(int i = 0;i < foods.length; i++) {
			if(foods[i].getId() == id) {
				food = foods[i];
				break;
			}
		}
		return food;
	}
	
	public int showConfirmDialog(String message) {
		//0 true
		//1 false
		//2 cancel =>false
		return JOptionPane.showConfirmDialog(null, message);
	}

	public boolean memberLogin() {
		boolean auth = true;
		while(auth) {
			String code = showInputDialog(loginMsg);
			boolean flag = Arrays.asList(memberCodes).contains(code);
			auth = !flag;
		}
		return true;
	}
	
	public String getFood() {
		String meatCurry = "";
		for(int i = 0; i < foods.length/2; i++) {
			meatCurry += foods[i].getName() + "\n";
		}
		return meatCurry;
	}
	
	public String getDrink() {
		String juice = "";
		for(int i = 5; i < foods.length; i++) {
			juice += foods[i].getName() + "\n";
		}
		return juice;
	}
	
	public String showInputDialog(String message) {
		return JOptionPane.showInputDialog(message);
		
	}
}
