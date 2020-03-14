import java.util.Scanner;
/**
 * This class is to test our class and methods.
 * It has main method
 * */
@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        try{
            testMyClasses();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    /**
     * Helper method to test Classes
     * */
    public static void testMyClasses(){
        //test my vector and set classes with all method that they have.
        Scanner input = new Scanner(System.in);
        int choice=1;
        while (choice!=0)
        {
            System.out.println("\nWelcome to HW8 ");
            System.out.println("[1] Test Set(type char)");
            System.out.println("[2] Test Vector(type int)");
            System.out.println("[0] Exit.");
            System.out.print("Answer: ");
            try{


	            choice=input.nextInt();
	            while (choice<0 || choice>2) //input checking
	            {
	                System.out.print("Please Enter a number between 0 and 2: ");
	                choice=input.nextInt();
	            }
	            /*check input from keyboard*/
	            if (choice==1)
	            {
	                testSet();
	            }
	            else if (choice==2)
	            {
	                testVector();
	            }
	            //0 will evaluate in the loop condition
	        }
	        catch(Exception e){
	        	choice=5;
                System.out.print("Please Enter a number between 0 and 2!\n");
                input.next();
	        }
        }


    }
    /**
     * Call all method of GTUVector with integer type.
     * */
    public static void testVector(){
        //test my vector class with all method that it has.
        System.out.println("\n****Welcome to GTUVector test Program.****");
        try
        {
            //create a integer vector and call necessary method
            GTUVector<Integer> v = new GTUVector<>();
            System.out.println("\nInformations About your integer GTUVector.\n");
            System.out.print("Empty: ");
            if (v.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + v.size() );
            System.out.println("Max size: " +  v.max_size() );
            System.out.println("\nInserting...");
            for (int i = 1; i <= 20; i++)
            {
                v.insert(i);
            }
            System.out.println("\nTracing through GTUVector with GTUIterator after inserting...");
            //create a iterator and assign it beginning of vector
            GTUVector.GTUIterator p=v.iterator();
            //go through the GTUVector by using hasNext and next method
            while(p.hasNext()){
                System.out.println(p.next());
            }
            System.out.println("\nErasing some of them...");
            for (int i = 5; i < 10; i++)
            {
                v.erase(i);
            }
            GTUVector.GTUIterator p1=v.iterator();
            p=v.iterator();
            p.setCursor(7); //go to the 7th element
            p1.setCursor(10); // go to the 10th element
            v.erase(p,p1); //erase given range [7,10)
            System.out.println("\nTracing through GTUVector with GTUIterator after erasing...");
            p=v.iterator();
            p.setCursor(5); //set position
            v.insert(p,50); //inset with position
            p.setCursor(8); //set
            v.insert(p,50); //insert
            p=v.iterator();
            while(p.hasNext()){
                System.out.println(p.next()); //print again
            }
            System.out.println("*13,14 and 15 erased by using 2th erase method.");
            System.out.println("*50 and 50 are new inserted elements after erasing by using 2th insert method.");
            System.out.print("\nFirst element of GTUVector: ");
            System.out.println((v.iterator()).toString());
            System.out.println("\nInformations About your integer GTUVector.\n");
            System.out.print("Empty: ");
            if (v.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + v.size() );
            System.out.println("Max size: " +  v.max_size());
            System.out.println("\nTest for contains... ");
            //test contains method
            if (v.contains(17))
                System.out.println("Is it contain 17 : Yes");
            else
                System.out.println("Is it contain 17 : No");
            if (v.contains(8))
                System.out.println("Is it contain 8 : Yes");
            else
                System.out.println("Is it contain 8 : No");
            System.out.println("\nClearing vector...");
            v.clear();
            System.out.println("\nInformations About your integer GTUVector.\n");
            System.out.print("Empty: ");
            if (v.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + v.size() );
            System.out.println("Max size: " +  v.max_size() );
            System.out.println("\nTest GTUVector with String type");
            //test with String type
            GTUVector<String> s1 = new GTUVector<>();
            s1.insert("Thank you.");
            s1.insert("Have a nice day!");
            GTUVector.GTUIterator a=s1.iterator();
            while(a.hasNext()){
                System.out.println(a.next());
            }
        }
        catch(Exception e) //catch errors
        {
            System.out.println(e.toString());
        }
    }
    /**
     * Call all method of GTUSet with Character type.
     * */
    public static void testSet(){
        //test my set class with all method that it has.
        System.out.println("\n****Welcome to GTUSet test Program.****");
        try
        {
            //create a char GTUSet and call necessary method to test
            GTUSet<Character> s = new GTUSet<>();
            System.out.println("\nInformations About your char GTUSet..\n");
            System.out.print("Empty: ");
            if (s.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + s.size() );
            System.out.println("Max size: " +  s.max_size() );
            System.out.println("\nInserting...");

            for (int i = 97; i <= 117; i++)
            {
                s.insert((char)i); //insert them by using converting from ascii code to a character
            }
            System.out.println("\nTracing through the GTUSet with GTUIterator after inserting...");
            GTUSet.GTUIterator p=s.iterator(); //Create Character iterator
            //go through the GTUSet by using hasNext and next method
            while(p.hasNext()){
                System.out.println(p.next());
            }
            System.out.println("\nErasing some of them...");
            for (int i = 105; i < 110; i++)
            {
                s.erase((char)i); //erase them by using converting from ascii code to a character
            }
            p=s.iterator();
            GTUSet.GTUIterator p1=s.iterator();
            p.setCursor(7); //set first iter
            p1.setCursor(10); //set second iter
            s.erase(p,p1); //erase element by given range [p ,p1)
            System.out.println("\nTracing with GTUIterator after erasing...");
            p=s.iterator();
            p.setCursor(5); //set
            s.insert(p,'Z'); //insert wit position
            p.setCursor(9); //set
            s.insert(p,'W'); //insert
            p=s.iterator();
            while(p.hasNext()){
                System.out.println(p.next()); //print again
            }
            System.out.println("*h,n and o erased by using 2th erase method.");
            System.out.println("*Z and W are new inserted elements after erasing by using 2th insert method.");
            System.out.print("\nFirst element of GTUSet: ");
            System.out.println((s.iterator()).toString());
            System.out.println("\nInformations About your char GTUSet.\n");
            System.out.print("Empty: ");
            if (s.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + s.size() );
            System.out.println("Max size: " +  s.max_size());
            System.out.println("\nTest for contains... ");
            //test contains
            if (s.contains('k'))
                System.out.println("Is it contain k : Yes");
            else
                System.out.println("Is it contain k : No");
            if (s.contains('u'))
                System.out.println("Is it contain u : Yes");
            else
                System.out.println("Is it contain u : No");
            System.out.println("\nClearing set...");
            s.clear();
            System.out.println("\nInformations About your char GTUSet.\n");
            System.out.print("Empty: ");
            if (s.empty())
                System.out.print("Yes\n");
            else
                System.out.print("No\n");
            System.out.println("Size: " + s.size());
            System.out.println("Max size: " +  s.max_size());
            System.out.println("\nTest set with String type");
            //Test GTUSet with String type
            GTUSet<String> s1 = new GTUSet<>();
            s1.insert("Thank you.");
            s1.insert("Have a nice day!");
            GTUSet.GTUIterator a=s1.iterator();
            while(a.hasNext()){
                System.out.println(a.next());
            }
        }
        catch(Exception e) //catch errors
        {
            System.out.println(e.toString());
        }
    }

}
