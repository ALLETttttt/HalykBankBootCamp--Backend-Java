package generics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        IPayService<String, Integer> payService = new PayServiceImpl();
//        System.out.println(payService.invoke("qwe"));
//        System.out.println(payService.invoke("ss"));

        List<String> strings = new ArrayList<>();//List strings
        List<Integer> numbers = new ArrayList<>();//List numbers
        List<Date> dates = new ArrayList<>();//List dates
        System.out.println(strings.getClass() == numbers.getClass());
        System.out.println(numbers.getClass() == dates.getClass());
    }
}
