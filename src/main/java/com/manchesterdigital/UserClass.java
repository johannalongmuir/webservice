package com.manchesterdigital;

public class UserClass {
    // impliments User? + override methods as neccessary

    final int userId;
    String firstName;
    String lastName;

    public UserClass(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "UserClass " +
                "userId: " + userId +
                ", firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'';
    }
}

