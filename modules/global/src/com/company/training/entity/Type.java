package com.company.training.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum Type implements EnumClass<String> {

    FIX_PRICE("FixPrice"),
    TIME_AND_MATERIAL("TimeAndMaterial"),
    OUT_STAFF("OutStaff");

    private String id;

    Type(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Type fromId(String id) {
        for (Type at : Type.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}