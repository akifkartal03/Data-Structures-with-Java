package com.Akif;
/**
 * This is a test class for DigitalTime class.
 * Also it contains a global method to sort times by using compareTo method.
 * */
public class Main {
	/**
	 * This method sorts array of times by using compareTo method.
	 * It uses directly Bubble Sort.
	 * @param arr array of DigitalTime
	 * */
	public static void sortTimes(DigitalTime arr[]){

		for (int i=0; i<arr.length;i++){
			for (int j=0;j<arr.length-1-i;j++){
				if (arr[j].compareTo(arr[j+1])==1){
					//swap
					DigitalTime temp;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
    public static void main(String[] args) {
    	try{
			DigitalTime time=new DigitalTime();
			DigitalTime time2=new DigitalTime(17,37);
			time.setHour(17);
			time.setMinute(37);
			time.advance(0,2);
			System.out.println( time.compareTo(time2));
			System.out.println( time.toString());
			System.out.println( time2.toString());
			time.setHour(0);
			time.setMinute(5);
			System.out.println( time.toString());
			System.out.println("Double1: "+time.toDouble());
			System.out.println("Double2: "+time2.toDouble());
			DigitalTime arr[] = new DigitalTime[5];
			DigitalTime time3=new DigitalTime(22,23);
			DigitalTime time4=new DigitalTime(17,37);
			DigitalTime time5=new DigitalTime(15,14);
			DigitalTime time6=new DigitalTime(17,37);
			DigitalTime time7=new DigitalTime(0,7);
			arr[0]=time3;
			arr[1]=time4;
			arr[2]=time5;
			arr[3]=time6;
			arr[4]=time7;
			System.out.println("UnSorted Times:");
			for (int i=0;i<5;i++){
				System.out.println(arr[i].toString());
			}
			sortTimes(arr);
			System.out.println("Sorted Times:");
			for (int i=0;i<5;i++){
				System.out.println(arr[i].toString());
			}
		}
    	catch (Exception e){
			System.out.println(e.toString());
		}


    }
}
