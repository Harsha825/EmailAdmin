package EmailApp;

import java.util.Scanner;

public class Email 
{
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String companySuffix = "dev.company.com";
	
	private int mailboxCapacity = 500;
	private int passwordLength = 10;
	
	//constructor to receive first and last name
	public Email(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;

		//call method asking for department and return department
		this.department = askDepartment();
		
		//call method that returns random password
		this.password = randomPassword(passwordLength);
		System.out.println("Your password is: " + this.password);
		
		//combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
	}
	
	//ask for department (method)
	private String askDepartment() 
	{
		System.out.print("New Employee: " + firstName + lastName + "\nDepartment List\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department number: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if(departmentChoice == 1) 
		{
			return "sales";
		}
		else if(departmentChoice == 2)
		{
			return "Development";
		}
		else if(departmentChoice == 3)
		{
			return "Accounting";
		}
		else 
		{
			return "";
		}
	}
	//generate random password
	private String randomPassword(int length) 
	{
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		
		for(int i = 0; i < length; i++)
		{
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) 
	{
		this.alternateEmail = altEmail;
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) 
	{
		this.mailboxCapacity = capacity;
	}
	
	//change the password
	public void changePassword(String password)
	{
		this.password = password;
	}
	
	public int getMailboxCapacity()
	{
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() 
	{
		return alternateEmail;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String showInfo()
	{
		return "Display Name: " + firstName + " " + lastName +
				"\nCompany Email: " + email + 
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
