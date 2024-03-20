package com.backend.programming.learning.system.valueobject;

import java.util.Objects;

/**
 * com.backend.programming.learning.system.valueobject
 * Create by Dang Ngoc Tien
 * Date 3/20/2024 - 11:19 PM
 * Description: ...
 */
public abstract class BaseId<T> {
    private final T value;

    protected BaseId(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

