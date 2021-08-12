package com.company.dbhelper;

public enum User {
    USERNAME("root"),
    PASSWORD("Abdurawidovna.91");

    private String value;

    User(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
