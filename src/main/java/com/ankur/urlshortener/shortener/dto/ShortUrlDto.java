package com.ankur.urlshortener.shortener.dto;

public class ShortUrlDto {
    String url;

    public ShortUrlDto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortUrlDto that = (ShortUrlDto) o;

        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ShortUrlDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
