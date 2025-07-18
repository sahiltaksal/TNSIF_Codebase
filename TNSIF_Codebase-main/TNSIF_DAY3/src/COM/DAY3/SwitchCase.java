package COM.DAY3;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter input");
		System.out.println("case 1:\r\n"
				+ "(\"choose your language\");");
		System.out.println("case 2:\r\n"
				+ "(\"current recharge details\");");
System.out.println("case 3:\r\n"
		+ "(\"current recharge expiry\");");
System.out.println("case 4:\r\n"
		+ "(\"new offers\");");
		
		int userInput= sc.nextInt();
		
		
		switch (userInput) {
		case 1:
			System.out.println("choose your language");
			break;
     case 2:
    	 System.out.println("current recharge details");
    	 break;
     case 3:
    	 System.out.println("current recharge expiry");
    	 break;
     case 4:
    	 System.out.println("new offers");
		default:
			System.out.println("invalid");
			break;
		}

	}

}
