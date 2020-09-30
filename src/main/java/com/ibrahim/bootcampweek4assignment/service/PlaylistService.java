package com.ibrahim.bootcampweek4assignment.service;

import com.ibrahim.bootcampweek4assignment.domain.Playlist;
import com.ibrahim.bootcampweek4assignment.domain.Track;
import com.ibrahim.bootcampweek4assignment.model.PlaylistCreateRequest;
import com.ibrahim.bootcampweek4assignment.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;


    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }


    public void createPlaylist(PlaylistCreateRequest request) {
        Playlist playlist = new Playlist(request.getName(), request.getUserId(), request.getDescription());
        playlistRepository.insert(playlist);
    }

    public Playlist showPlaylistByPlaylistId(String playlistId) {
        return playlistRepository.findById(playlistId);
    }

    public void deletePlaylist(String playlistId) {
        playlistRepository.deletePlaylist(playlistId);
    }

    public List<Playlist> showPlaylistByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void addTrack(String id, Track track) {
        playlistRepository.addTrack(id, track);
    }

    public void deleteTrack(String playlistId, Track track) {
        playlistRepository.deleteTrack(playlistId, track);
    }
}
