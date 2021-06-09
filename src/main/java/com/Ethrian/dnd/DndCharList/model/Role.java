package com.Ethrian.dnd.DndCharList.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        System.out.println(name());
        return name();
    }
}
