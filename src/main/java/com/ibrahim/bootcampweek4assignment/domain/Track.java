package com.ibrahim.bootcampweek4assignment.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Track {
    private String name;
    private String length;
    private String artist;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return name.equals(track.name) &&
                length.equals(track.length) &&
                artist.equals(track.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, artist);
    }
}
