package lt.techin;

import itaphones.phone.AutomaticDialer;
import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class Main {
    public static void main(String[] args) {
        MobilePhone mP = new MobilePhone();
        Phone p = new MobilePhoneAdapter(mP);
        System.out.println(AutomaticDialer.dial(p));
    }
}