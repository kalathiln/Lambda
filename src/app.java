
/**
 * Demonstrate the usage of passing code as an argument prior to Java 8.
 * Demonstrates the use of Lambda
 */

// Using an interface we can use it in order to execute code within the 
// anonymous function which implements it. 
// These are called functional interfaces, having one Method.
interface Executable {
	// In the implementation of this method, we can write the code
	// that needs to be executed
	int execute(int a);
}

interface StringExecutable {
	// In the implementation of this method, we can write the code
	// that needs to be executed
	String execute(String a);
}

class Runner {
	// The run method takes in an object e of the interface Executable type
	public void run(Executable e) {
		System.out.println("Running the block of code!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// here we call the execute method of the object Executable.
		int val = e.execute(8);
		System.out.println("Value is: " + val);

	}
	
	public void run(StringExecutable e) {
		System.out.println("Running the block of code!!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// here we call the execute method of the object Executable.
		String val = e.execute("Nikhil");
		System.out.println("Value is: " + val);

	}
}

public class app {
	public static void main(String[] args) {
		Runner runner = new Runner();
		// This is how it was done before Java 8
		// using anonymous functions
		runner.run(new StringExecutable() {

			@Override
			public String execute(String a) {
				System.out.println("Hello World!");
				return a;
			}
		});

		System.out.println("===================================");

		runner.run( (String a) -> {
			System.out.println("Hello World using Lambda Java8!");
			return 7 + a;
		});
	}
}
