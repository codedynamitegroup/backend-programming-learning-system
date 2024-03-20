package com.backend.programming.learning.system.entity;

import java.util.Objects;

/**
 * com.backend.programming.learning.system.entity
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:13 PM
 * Description: ...
 */
public abstract class BaseEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
