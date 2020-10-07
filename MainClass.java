import java.util.*;
import java.time.*;
class Donar
{
	String name;
	private String address;
	String bloodType;
	int age;
	String[][] disease = new String[3][2];
	boolean firstDonation;
	String lastDonation;
	static int ldonate;
	int dob[] = new int[3]; // day moth year
	boolean eligible;

	Donar(){
		disease[0][0] = "Dibetic";
		disease[1][0] = "Anaemic";
		disease[2][0] = "Other";
		lastDonation = null;
		ldonate = 100;
	}

	public void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the name\t\t:\t");
		name = sc.nextLine();
		System.out.print("\nEnter the address\t:\t");
		address = sc.nextLine();
		System.out.print("\nEnter the bloodType\t:\t");
		bloodType = sc.nextLine();
		System.out.print("\n\t\tDate of Birth\t");
		System.out.print("\nEnter the date(01-31)\t:\t");
		dob[0] = sc.nextInt();
		System.out.print("\nEnter the month(01-12)\t:\t");
		dob[1] = sc.nextInt();
		System.out.print("\nEnter the year\t\t:\t");
		dob[2] = sc.nextInt();			
		sc.nextLine();
		System.out.print("\nEnter the Yes or No (If disease or not)\t:\t\n");
		for(int i = 0;i<disease.length;i++){
			System.out.print(disease[i][0]+"\t:\t");
			disease[i][1] = sc.nextLine();
		}
		System.out.print("\nIs it your first Donation? (true/false)\t:\t");
		firstDonation = sc.nextBoolean();
		age = getYear(dob);
		sc.nextLine();
		if(firstDonation==false){
				System.out.print("\nEnter the Last Donation date\t:\t");
				lastDonation = sc.nextLine();	
				eligible = isEligible(age,getYear(lastDonation));
		}
		else
			eligible = isEligible(age);
		
		
	}

//function overloading 
	public static int getYear(int arr[]){
		LocalDate start_date = LocalDate.of(arr[2],arr[1],arr[0]);
		Period diff = Period.between(start_date,LocalDate.now());
		return diff.getYears();
	}

	public static int getYear(String ldate){
		LocalDate start_date = LocalDate.parse(ldate);
		Period diff = Period.between(start_date,LocalDate.now());
		if(diff.getYears() < 0 || diff.getMonths() < 6)
			ldonate = -1;
		return ldonate;

	}

//function overloading 
	public boolean isEligible(int age,int value){  
			if(value == -1 || age<18)
				return false;
			else
				return true;
	}
	public boolean isEligible(int age){
			if(age<18)
				return false;
			else
				return true;
	}


	public void display(){
		System.out.print("\n\t*********************************************************************\n");
		System.out.print("\n\t\tName\t\t\t:\t"+name);
		System.out.print("\n\t\tAddress\t\t\t:\t"+address);
		System.out.print("\n\t\tBlood Group\t\t:\t"+bloodType);
		System.out.print("\n\t\tAge\t\t\t:\t"+age+"\n");
		for(int i = 0;i<disease.length;i++){
			System.out.println("\t\t"+disease[i][0]+"\t\t\t:\t"+disease[i][1]);
		}
		System.out.print("\t\tFirst Donation\t\t:\t"+ firstDonation);
		System.out.print("\n\t\tLast Donation\t\t:\t"+ lastDonation);
		System.out.print("\n\t\tEligible for Donation\t:\t"+ eligible);
		System.out.println("\n\n\t***********************************************************************\n");
	}
}

public class MainClass{
	 public static void main(String args[]){
    	Donar ob = new Donar();
    	ob.input();

    	ob.display();
    }
}
