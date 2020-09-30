package com.ibrahim.bootcampweek4assignment.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Playlist {

    private String id;
    private String name;
    private String userId;
    private String description;
    private int followersCount;
    private List<Track> tracks = new ArrayList<>();
    private int tracksCount;

    public Playlist() {
    }

    public Playlist(String name, String userId, String description){
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.name=name;
        this.description = description;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

}
