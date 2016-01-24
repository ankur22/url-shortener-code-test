package com.ankur.urlshortener.common.model;

public class DataStoreId {
    final String value;

    private DataStoreId(String value) {
        this.value = value;
    }

    public static DataStoreId of(String id) {
        return new DataStoreId(id);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataStoreId that = (DataStoreId) o;

        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DataStoreId{" +
                "value='" + value + '\'' +
                '}';
    }
}
