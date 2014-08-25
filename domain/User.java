package com.example.login.domain;

/**
 * Created by joseph on 2014/08/20.
 */
public class User
{
    private int id;
    private  String fist_name;
    private  String surname;
    private  String email;
    private String cell;
    private String password;

    private  User(Builder b)
    {
        fist_name = b.fist_name;
        surname = b.surname;
        email = b.email;
        cell = b.cell;
        id = b.id;
        password = b.password;
    }

    public static class Builder
    {
        private int id;
        private String password;

        private  String fist_name;
        private  String surname;
        private  String email;
        private String cell;

        public Builder(String first_name)
        {
            this.fist_name = first_name;
        }

        public Builder first_name(String name)
        {
            this.fist_name = name;
            return this;
        }

        public Builder id(int id)
        {
            this.id = id;
            return this;
        }
        public Builder password(String password)
        {
            this.password = password;
            return this;
        }
        public Builder cell(String cell)
        {
            this.cell = cell;
            return this;
        }
        public Builder email(String email)
        {
            this.email = email;
            return this;
        }
        public Builder surname(String surname)
        {
            this.surname = surname;
            return this;
        }



        public Builder user(User user)
        {
            this.cell = user.getCell();
            this.email = user.getEmail();
            this.fist_name = user.getFist_name();
            this.surname = user.getSurname();
            this.id = user.getId();
            this.password = user.getPassword();

            return this;
        }

        public User build()
        {
            return new User(this);
        }

    }

    public String getPassword()
    {
        return password;
    }

    public String getCell()
    {
        return cell;
    }

    public String getEmail()
    {
        return email;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getFist_name()
    {
        return fist_name;
    }

    public int getId()
    {
        return id;
    }
}
