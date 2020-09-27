package com.melalex.hts.model;

import java.util.Objects;

public final class FieldDescriptor {

    private final String name;
    private final FieldType type;
    private final Class<?> aClass;
    private final int offset;
    private final int size;

    public FieldDescriptor(String name, FieldType type, Class<?> aClass, int offset, int size) {
        this.name = name;
        this.type = type;
        this.aClass = aClass;
        this.offset = offset;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public FieldType getType() {
        return type;
    }

    public Class<?> getaClass() {
        return aClass;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (FieldDescriptor) o;
        return offset == that.offset &&
                size == that.size &&
                Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(aClass, that.aClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, aClass, offset, size);
    }

    @Override
    public String toString() {
        return "FieldDescriptor{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", aClass=" + aClass +
                ", offset=" + offset +
                ", size=" + size +
                '}';
    }
}
