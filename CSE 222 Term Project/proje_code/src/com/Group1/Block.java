package com.Group1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Block information in the prison.
 */
public class Block {
    protected String blockName;
    protected ArrayList<Integer> wards;//koğuşlar
    protected ArrayList<String> otherRooms;//dinner room etc.
    public Block () {
        blockName = "A";
        wards = new ArrayList<> ();
        otherRooms = new ArrayList<> ();
    }

    public Block (String blockName) {
        this.blockName = blockName;
        wards=new ArrayList<> ();
        otherRooms = new ArrayList<> ();
    }

    public Block (String blockName, ArrayList<Integer> wards, ArrayList<String> otherRooms) {
        this.blockName = blockName;
        this.wards = wards;
        this.otherRooms = otherRooms;
    }

    public String getBlockName () {
        return blockName;
    }

    public void setBlockName (String blockName) {
        this.blockName = blockName;
    }

    public ArrayList<Integer> getWards () {
        return wards;
    }

    public void setWards (ArrayList<Integer> wards) {
        this.wards = wards;
    }

    public ArrayList<String> getOtherRooms () {
        return otherRooms;
    }

    public void setOtherRooms (ArrayList<String> otherRooms) {
        this.otherRooms = otherRooms;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Block block = (Block) o;
        return blockName.equals (block.blockName);
    }

    @Override
    public String toString () {
        int k;
        StringBuilder stringBuilder = new StringBuilder ();
        for ( k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        stringBuilder.append ("Block Name: "+blockName+"\n");
        stringBuilder.append ("Wards in this Block: ");
        for (Integer ward: wards) {
            stringBuilder.append (ward+",");
        }
        stringBuilder.deleteCharAt (stringBuilder.length ()-1);
        stringBuilder.append ("\n");
        stringBuilder.append ("Other Rooms in this Block: ");
        for (String room: otherRooms) {
            stringBuilder.append (room+",");
        }
        stringBuilder.deleteCharAt (stringBuilder.length ()-1);
        stringBuilder.append ("\n");
        for ( k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        return stringBuilder.toString ();
    }
}
