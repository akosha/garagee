package com.psimic.model;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * Created by psimic on 31.03.15.
 */
public enum UserType {

    CAR(1),
    BYKE(2);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UserType getByValue(final int value) {
        Iterators.find(Iterators.forArray(UserType.values()), new Predicate<UserType>() {
            @Override
            public boolean apply(UserType userType) {
                return userType.getValue() == value;
            }
        });
        throw new IllegalArgumentException("No UserType with value: " + value);
    }
}
