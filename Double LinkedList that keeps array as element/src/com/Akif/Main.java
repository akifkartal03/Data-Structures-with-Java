package com.Akif;

/***
 * Main class to test each method in LinkedArrayClass.
 */
public class Main {

    public static void main(String[] args) {
    	//here, everything is clear without comments.
		System.out.println ("\t\t***TEST WITH INTEGER VALUES***");
    	for (int i = 0 ; i<100;i++) System.out.print("-");
	    LinkedArrayList<Integer> linkedArrayList = new LinkedArrayList<> ();
		System.out.println ("\nAdd 12(0-11) piece element with 'addFirst' method");
	    for (int i = 0 ; i<12;i++){
	        linkedArrayList.addFirst (i);
        }
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nAdd 12(12-24) piece element with 'add(E o)' method");
		for (int i = 12 ; i<25;i++){
			linkedArrayList.add(i);
		}
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nAdd element '25' with 'add(index,E obj)' method to 1th index(full)");
		linkedArrayList.add (1,25);
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element in 5th index with 'remove(index)' method");
		linkedArrayList.remove (5);
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element in 17th index with 'remove(index)' method");
		linkedArrayList.remove (17);
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element '25' with 'remove(E obj)' method");
		linkedArrayList.remove (Integer.valueOf (25));
		System.out.println (linkedArrayList);
		System.out.println ("Size: "+linkedArrayList.size ());
		System.out.println ("Number of Node: "+linkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nTest get methods");
		System.out.println ("get(9): "+linkedArrayList.get (9));
		System.out.println ("getFirst(): "+linkedArrayList.getFirst ());
		System.out.println ("getLast(): "+linkedArrayList.getLast ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nTest other methods");
		System.out.println ("IndexOf(20): "+linkedArrayList.indexOf (20));
		System.out.println ("isEmpty: "+linkedArrayList.isEmpty ());
		System.out.println ("contains(48): "+linkedArrayList.contains (48));
		for (int i = 0 ; i<100;i++) System.out.print("-");

		//----------------------TEST FOR CHARACTER--------------------------------------------------
		
		System.out.println ("\n\t\t***TEST WITH CHARACTER VALUES***");
		for (int i = 0 ; i<100;i++) System.out.print("-");
		LinkedArrayList<Character> characterLinkedArrayList = new LinkedArrayList<> ();
		System.out.println ("\nAdd 12(a-k) piece element with 'add(E o)' method");
		for (int i = 97; i < 108; i++)
		{
			characterLinkedArrayList.add ((char)i); //insert them by using converting from ascii code to a character
		}
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nAdd 12(m-x) piece element with 'addFirst' method");
		for (int i = 109 ; i<121;i++){
			characterLinkedArrayList.addFirst ((char)i);
		}
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nAdd element '!' with 'add(index,E obj)' method to 2th index(full)");
		characterLinkedArrayList.add (2,'!');
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element in 7th index with 'remove(index)' method");
		characterLinkedArrayList.remove (7);
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element in 11th index with 'remove(index)' method");
		characterLinkedArrayList.remove (11);
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nRemove element 'e' with 'remove(E obj)' method");
		characterLinkedArrayList.remove (Character.valueOf ('e'));
		System.out.println (characterLinkedArrayList);
		System.out.println ("Size: "+characterLinkedArrayList.size ());
		System.out.println ("Number of Node: "+characterLinkedArrayList.getNodeSize ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nTest get methods");
		System.out.println ("get(13): "+characterLinkedArrayList.get (13));
		System.out.println ("getFirst(): "+characterLinkedArrayList.getFirst ());
		System.out.println ("getLast(): "+characterLinkedArrayList.getLast ());
		for (int i = 0 ; i<100;i++) System.out.print("-");
		System.out.println ("\nTest other methods");
		System.out.println ("IndexOf('!'): "+characterLinkedArrayList.indexOf ('!'));
		System.out.println ("isEmpty: "+characterLinkedArrayList.isEmpty ());
		System.out.println ("contains('k'): "+characterLinkedArrayList.contains ('k'));
		for (int i = 0 ; i<100;i++) System.out.print("-");
    }
}
