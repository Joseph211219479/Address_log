package com.example.login.domain;

/**
 * Created by joseph on 2014/08/20.
 */
public class Address
{
    private int id;
    private int  postel_code;
    private  String street_name;
    private  int street_number;
    private String town ;

    private Address(Builder b)
    {
        id            = b.id;
        postel_code   = b.postel_code;
        street_name   = b.street_name;
        street_number = b.street_number;
        town          = b.town;

    }

    public static class Builder
    {
        private int id;
        private int postel_code;
        private  String street_name;
        private  int street_number;
        private String town ;

        public Builder(String town)
        {
            this.town = town;
        }
        public Builder id(int id)
        {
            this.id = id;
            return this;
        }
        public Builder town(String town)
        {
            this.town = town;
            return this;
        }
        public Builder street_number(int street_number)
        {
            this.street_number = street_number;
            return this;
        }
        public Builder street_name(String street_name)
        {
            this.street_name = street_name;
            return this;
        }
        public Builder postel_code(int postel_code)
        {
            this.postel_code = postel_code;
            return this;
        }

        public  Builder address(Address address)
        {
            id = address.getId();
            town = address.getTown();
            street_number = address.getStreet_number();
            street_name = address.getStreet_name();
            postel_code = address.getPostel_code();
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }
    }

    public int getId() {
        return id;
    }

    public int  getPostel_code() {
        return postel_code;
    }

    public String getStreet_name() {
        return street_name;
    }

    public int getStreet_number() {
        return street_number;
    }

    public String getTown() {
        return town;
    }

}
