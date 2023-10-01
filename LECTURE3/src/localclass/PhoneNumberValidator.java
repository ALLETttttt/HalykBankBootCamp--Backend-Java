package localclass;

public class PhoneNumberValidator {

    public void validatePhoneNumber(String number) {

        class PhoneNumber {

            private String phoneNumber;

            public PhoneNumber() {
                this.phoneNumber = number;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }

        try {
            Integer.parseInt(number);
            //logic
            System.out.println("This is number");
        }catch (Exception e){
            System.out.println("This is not number");
        }
    }
}
