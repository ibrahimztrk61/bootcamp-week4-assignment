package com.ibrahim.bootcampweek4assignment.repository;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.ibrahim.bootcampweek4assignment.domain.Playlist;
import com.ibrahim.bootcampweek4assignment.domain.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {
    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;


    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void insert(Playlist playlist) {

        playlistCollection.insert(playlist.getId(), playlist);
    }

    public Playlist findById(String playlistId) {
        GetResult getResult = playlistCollection.get(playlistId);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }

    public List<Playlist> findAllByUserId(String userId) {

        String statement = "SELECT id, name, userId, description, followersCount,tracks,tracksCount FROM playlist WHERE userId = \"" + userId + "\"";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);

    }

    public void deletePlaylist(String playlistId) {
        playlistCollection.remove(playlistId);

    }

    public void addTrack(String playlistId, Track track) {
        GetResult getResult = playlistCollection.get(playlistId);
        Playlist playlist = getResult.contentAs(Playlist.class);
        playlist.addTrack(track);
        playlistCollection.replace(playlist.getId(), playlist);
    }

    public void deleteTrack(String id, Track track) {
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        playlist.getTracks().remove(track);

        playlistCollection.replace(id, playlist);
    }
}

