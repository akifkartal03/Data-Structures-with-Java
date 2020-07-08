package com.Group1;

import java.util.ArrayList;

enum Days {
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday
}

enum Shifts {
	daytime, // 08.00 - 16.00
	evening, // 16.00 - 00.00
	night // 00.00 - 08.00
}
/**
 * This class holds the personnel Shift information.
 */
public class PersonnelShift {

	protected ArrayList<Days> workdays;
	protected Shifts shift;

	public PersonnelShift() {
		workdays = new ArrayList<>();
		workdays.add(Days.Monday);
		workdays.add(Days.Tuesday);
		workdays.add(Days.Wednesday);
		workdays.add(Days.Thursday);
		workdays.add(Days.Friday);

		shift = Shifts.daytime;
	}

	public PersonnelShift (ArrayList<Days> days) {
		workdays = new ArrayList<>(days);
		shift = Shifts.daytime;
	}

	public PersonnelShift (Shifts s,ArrayList<Days> days) {
		workdays = new ArrayList<>(days);
		shift = s;
	}

	@Override
	public String toString () {
		StringBuilder stringBuilder = new StringBuilder ();
		stringBuilder.append ("Personnel WorkTime is: "+"\n");
		stringBuilder.append ("\tShift: "+shift.toString ()+"\n");
		stringBuilder.append ("\tWorkDays: ");
		for (Days d:workdays) {
			stringBuilder.append (d.toString ()+",");
		}
		stringBuilder.deleteCharAt (stringBuilder.length ()-1);
		stringBuilder.append ("\n");
		return stringBuilder.toString ();
	}
}
