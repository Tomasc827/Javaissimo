package lt.techin;

import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class MobilePhoneAdapter implements Phone {
    private final MobilePhone mobilePhone;
    private String response;

    public MobilePhoneAdapter(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public void dial(String number) {
        response = mobilePhone.dial(number);
    }

    @Override
    public String getReponse() {
        return response;
    }
}