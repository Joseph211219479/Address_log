package com.example.login.repository.implementation;

import com.example.login.domain.Address;

import java.util.List;

/**
 * Created by joseph on 2014/08/20.
 */
public interface AddressDAO
{
    public void createAddress(Address address);
    public  void updateAddress(Address address);
    public Address findAddressByID(int id);
    public void deleteAddress(Address address);
    public Address getAddress();

    public List<Address> getAddressList();
}
