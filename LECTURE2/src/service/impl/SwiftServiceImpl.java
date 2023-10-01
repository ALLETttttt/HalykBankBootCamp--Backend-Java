package service.impl;

import lecture2.service.IPayService;

public class SwiftServiceImpl implements IPayService {

    @Override
    public void pay() {
        System.out.println("swift");
    }
}
