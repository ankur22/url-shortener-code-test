package com.ankur.urlshortener.shortener.model;

public class HostName {
    final String value;

    private HostName(String value) {
        this.value = value;
    }

    public static HostName of(final String hostName) {
        return new HostName(hostName);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HostName hostName = (HostName) o;

        return value != null ? value.equals(hostName.value) : hostName.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "HostName{" +
                "value='" + value + '\'' +
                '}';
    }
}
