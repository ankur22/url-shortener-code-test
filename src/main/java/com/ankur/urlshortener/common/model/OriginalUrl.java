package com.ankur.urlshortener.common.model;

public class OriginalUrl {
    final String value;

    private OriginalUrl(String value) {
        this.value = value;
    }

    public static OriginalUrl of(final String url) {
        return new OriginalUrl(url);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OriginalUrl that = (OriginalUrl) o;

        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OriginalUrl{" +
                "value='" + value + '\'' +
                '}';
    }
}
