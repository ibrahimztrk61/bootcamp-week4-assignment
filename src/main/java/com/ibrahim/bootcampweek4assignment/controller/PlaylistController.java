package com.ibrahim.bootcampweek4assignment.controller;

import com.ibrahim.bootcampweek4assignment.domain.Playlist;
import com.ibrahim.bootcampweek4assignment.domain.Track;
import com.ibrahim.bootcampweek4assignment.model.PlaylistCreateRequest;
import com.ibrahim.bootcampweek4assignment.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody PlaylistCreateRequest playlistCreateRequest) {
        playlistService.createPlaylist(playlistCreateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<Playlist> showPlaylistByPlaylistId(@PathVariable String playlistId){
        Playlist playlistById = playlistService.showPlaylistByPlaylistId(playlistId);
        return ResponseEntity.ok(playlistById);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> showPlaylistByUserId(@PathVariable String userId){
        List<Playlist> playlists = playlistService.showPlaylistByUserId(userId);
        return ResponseEntity.ok(playlists);
    }


    @DeleteMapping("/{playlistId}")
    public ResponseEntity deletePlaylist(@PathVariable("playlistId") String playlistId){
        playlistService.deletePlaylist(playlistId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/tracks")
    public ResponseEntity addTrack(@PathVariable("id") String id, @RequestBody Track track){
         playlistService.addTrack(id, track);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/playlists/{playlistId}/tracks")
    public ResponseEntity deleteTrack(@PathVariable("playlistId") String playlistId, @RequestBody Track track){
        playlistService.deleteTrack(playlistId,track);
        return ResponseEntity.ok().build();
    }
}
