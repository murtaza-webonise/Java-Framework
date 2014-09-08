package com.address.pojo;

import com.session.manager.ReturnSession;

public class AddressDao {

    Address add;

    public void addAddress(Address add) {

        ReturnSession rs = new ReturnSession();
        rs.save(add);

    }
    
    public void removeAdd(int i) {

        ReturnSession rs = new ReturnSession();
        rs.delete(i);

    }

}
