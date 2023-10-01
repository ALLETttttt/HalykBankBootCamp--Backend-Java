package anonymclass;

public class Main {
    public static void main(String[] args) {
        IPayService swiftService= new IPayService() {
            @Override
            public void pay() {
                //logic
                //pay credit debit
            }
        };
        swiftService.pay();
    }
}
