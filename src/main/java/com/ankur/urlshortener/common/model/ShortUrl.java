package com.ankur.urlshortener.common.model;

public class ShortUrl {
    final String value;

    private ShortUrl(String value) {
        this.value = value;
    }

    public static ShortUrl of(final String url) {
        return new ShortUrl(url);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortUrl shortUrl = (ShortUrl) o;

        if (value != null ? !value.equals(shortUrl.value) : shortUrl.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "value='" + value + '\'' +
                '}';
    }
}
