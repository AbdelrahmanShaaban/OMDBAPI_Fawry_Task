package com.example.model;

import java.io.IOException;

public enum Type {
    MOVIE, SERIES;

    public String toValue() {
        switch (this) {
            case MOVIE:
                return "movie";
            case SERIES:
                return "series";
        }
        return null;
    }

    public static Type forValue(String value) throws IOException {
        if (value.equals("movie")) return MOVIE;
        if (value.equals("series")) return SERIES;
        throw new IOException("Cannot deserialize Type");
    }
}
