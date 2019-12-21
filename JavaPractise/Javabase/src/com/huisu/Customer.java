package com.huisu;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 19-12-21 下午9:08
 * @Created by xns
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Integer zipCode;

    public Customer(String firstName, String lastName, Integer zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
