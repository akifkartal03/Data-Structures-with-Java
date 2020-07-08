package com.Akif;

/**
 * This class is to validate entry information of Admin(Password).
 * */
public class Validate {
    /**
     * This will be used to validate information.
     * */
    Data data;
    /**
     * One parameter constructor.
     * This class needs to Data object to validate the Admin.
     * @param data all data regarding the system
     * */
    public Validate(Data data){
        this.data = data;
    }
    /**
     * This method validates the admin information.
     * @return Returns true if information are true otherwise return false.
     * */
    public int validateAdmin(){
        String password = GetChoiceFromUser.getStringFromUser ("Enter your Password: ");
        for (int i =0 ; i<data.numberOfAdmin();i++){
            if (data.getAdmin(i).getPassword().equals(password)){
                return i;
            }
        }
        return -1;
    }
}
