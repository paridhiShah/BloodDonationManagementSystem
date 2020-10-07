import java.util.*;
public class Donar
{
	String name;
	String address;
	String bloodType;
	int age;
	String[][] disease = new String[3][2];
	boolean firstDonation;

	Donar(){
		disease[0][0] = "Dibetic";
		disease[1][0] = "Anaemic";
		disease[2][0] = "Other";
	}

	public void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter the name\t:\t");
		name = sc.nextLine();
		System.out.print("\nEnter the address\t:\t");
		address = sc.nextLine();
		System.out.print("\nEnter the bloodType\t:\t");
		bloodType = sc.nextLine();
		System.out.print("\nEnter the Yes or No (If disease or not)\t:\t");
		for(int i = 0;i<disease.length;i++){
			System.out.println(disease[i][0]+"\t:\t");
			disease[i][1] = sc.nextLine();
		}
		System.out.print("\nEnter the yes or no firstDonation\t:\t");
		firstDonation = sc.nextBoolean();
	}

	public void display(){
		System.out.print("\nName\t:\t"+name);
		System.out.print("\nAddress\t:\t"+address);
		System.out.print("\nBlood Group\t:\t"+bloodType);
		for(int i = 0;i<disease.length;i++){
			System.out.println(disease[i][0]+"\t:\t"+disease[i][1]);
		}
		System.out.print("\nFirst Donation\t:\t"+ firstDonation);
	}
    public static void main(String args[]){
    	Donar ob = new Donar();
    	ob.input();
    	ob.display();
    }
}

