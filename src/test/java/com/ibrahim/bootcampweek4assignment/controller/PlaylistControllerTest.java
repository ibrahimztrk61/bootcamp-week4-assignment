package com.ibrahim.bootcampweek4assignment.controller;

import com.ibrahim.bootcampweek4assignment.domain.Playlist;
import com.ibrahim.bootcampweek4assignment.domain.Track;
import com.ibrahim.bootcampweek4assignment.model.PlaylistCreateRequest;
import com.ibrahim.bootcampweek4assignment.service.PlaylistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaylistControllerTest {

    @Mock
    PlaylistService playlistService;
    @InjectMocks
    private PlaylistController playlistController;

    @Test
    public void it_should_create_playlist() {
        // Arrange
        PlaylistCreateRequest playlistCreateRequest = new PlaylistCreateRequest();

        // Act
        ResponseEntity<Void> response = playlistController.createPlaylist(playlistCreateRequest);
        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        ArgumentCaptor<PlaylistCreateRequest> requestArgumentCaptor = ArgumentCaptor.forClass(PlaylistCreateRequest.class);
        //verify(playlistService).createPlaylist(any(PlaylistCreateRequest.class));
        verify(playlistService).createPlaylist(requestArgumentCaptor.capture());
        PlaylistCreateRequest capturedRequest = requestArgumentCaptor.getValue();
        assertThat(capturedRequest).isEqualTo(playlistCreateRequest);
    }

    @Test
    public void it_should_delete_playlist() {
        // Arrange
        String id = "id";

        // Act
        ResponseEntity<Void> response = playlistController.deletePlaylist(id);
        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        ArgumentCaptor<String> idArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(playlistService).deletePlaylist(idArgumentCaptor.capture());
        String capturedId = idArgumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(id);
    }


    @Test
    public void it_should_get_playlists_by_playlist_id() {
        // Arrange
        String id = "id";
        Playlist playlist = new Playlist();

        when(playlistService.showPlaylistByPlaylistId(id)).thenReturn(playlist);
        // Act
        ResponseEntity<Playlist> playlistResponseEntity = playlistController.showPlaylistByPlaylistId(id);
        // Assert
        assertThat(playlistResponseEntity.getBody()).isEqualTo(playlist);
        assertThat(playlistResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

    @Test
    public void it_should_get_playlists_by_user_id() {
        // Arrange
        String id = "id";
        Playlist playlist = new Playlist();

        // Act
        ResponseEntity<List<Playlist>> listResponseEntity = playlistController.showPlaylistByUserId(id);

        // Assert
        assertThat(listResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    }


}