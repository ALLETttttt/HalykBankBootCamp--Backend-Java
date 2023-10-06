package generics;

import java.util.List;

public class PayServiceImpl implements IPayService<String, Integer> {

    @Override
    public Integer invoke(String s) {
        List<Integer> list;
        //logic
        if ("qwe".equals(s)) {
            return 1;
        }
        return 0;
    }
}
