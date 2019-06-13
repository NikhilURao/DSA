//Java Program to demonstrate the working of a banking-system  
//where we deposit and withdraw amount from our account.  
//Creating an Account class which has deposit() and withdraw() methods
package com.objects_and_class_in_java;

public class Banking_Example_Objects_and_Classes {
	int acc_no;
	String name;
	float amount;

void insert(int user_acc_no,String user_name,float user_amt ) {
	acc_no = user_acc_no;
	name = user_name;
	amount = user_amt;
}

void deposit(float amt) {
	amount += amt;
	System.out.print("INR "+amt+" has been desposited into your account"+"\n"+"New balance in your account is INR "+amount);
	System.out.println("");
}

void withdraw(float amt) {
	if (amt > amount) {
		System.out.println("Insufficient balance");
	}
	else {
		amount -= amt;
		System.out.println("INR "+amt+" has been withdrawn from your account"+"\n"+"New balance in your account is INR "+amount);
		}
}

void checkbalance() {
	System.out.println("Balance in your account is"+amount);
}

	public static void main(String[] args) {
		
		Banking_Example_Objects_and_Classes bnk = new Banking_Example_Objects_and_Classes();
		bnk.insert(13347, "Nikhil", 10);//10
		bnk.deposit(15);//25
		bnk.withdraw(21);//4
		bnk.withdraw(5);//insufficient funds

	}

}
