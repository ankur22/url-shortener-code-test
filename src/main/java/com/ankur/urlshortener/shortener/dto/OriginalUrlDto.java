package com.ankur.urlshortener.shortener.dto;

public class OriginalUrlDto {
    String url;

    public OriginalUrlDto(){
        url = "";
    }

    public OriginalUrlDto(String url) {
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

        OriginalUrlDto that = (OriginalUrlDto) o;

        return url != null ? url.equals(that.url) : that.url == null;

    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OriginalUrlDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
