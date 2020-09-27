package com.melalex.hts.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class MessageDescriptor {

    private final byte key;
    private final byte type;
    private final byte[] delimiter;
    private final List<FieldDescriptor> fields;

    public MessageDescriptor(byte key, byte type, byte[] delimiter, List<FieldDescriptor> fields) {
        this.key = key;
        this.type = type;
        this.delimiter = delimiter;
        this.fields = List.copyOf(fields);
    }

    public byte getKey() {
        return key;
    }

    public byte getType() {
        return type;
    }

    public byte[] getDelimiter() {
        return delimiter;
    }

    public List<FieldDescriptor> getFields() {
        return fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (MessageDescriptor) o;
        return key == that.key &&
                type == that.type &&
                Arrays.equals(delimiter, that.delimiter) &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(key, type, fields);
        result = 31 * result + Arrays.hashCode(delimiter);
        return result;
    }

    @Override
    public String toString() {
        return "MessageDescriptor{" +
                "key=" + key +
                ", type=" + type +
                ", delimiter=" + Arrays.toString(delimiter) +
                ", fields=" + fields +
                '}';
    }
}
