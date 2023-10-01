package service;

public interface IPayService {

    void pay();

    default void calcCommission() {
        System.out.println("qwerqwer");
    }

    static double getCommission(){
        return 2.4;
    }
}
