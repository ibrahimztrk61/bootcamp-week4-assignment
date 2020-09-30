package com.ibrahim.bootcampweek4assignment.service;

import com.ibrahim.bootcampweek4assignment.domain.Playlist;
import com.ibrahim.bootcampweek4assignment.repository.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlaylistServiceTest {
    @Mock
    PlaylistRepository playlistRepository;


    @InjectMocks
    private PlaylistService playlistService;

    @Test
    public void it_should_get_playlists_by_playlist_id() {
        // Arrange
        String id = "id";
        Playlist playlist = new Playlist();

        when(playlistRepository.findById(id)).thenReturn(playlist);
        // Act
        Playlist playlistByPlaylistId = playlistService.showPlaylistByPlaylistId(id);

        // Assert
        assertThat(playlistByPlaylistId.getId()).isEqualTo(playlist.getId());
        assertThat(playlistByPlaylistId.getName()).isEqualTo(playlist.getName());
        assertThat(playlistByPlaylistId.getDescription()).isEqualTo(playlist.getDescription());
        assertThat(playlistByPlaylistId.getTracks()).isEqualTo(playlist.getTracks());
        assertThat(playlistByPlaylistId.getUserId()).isEqualTo(playlist.getUserId());
        assertThat(playlistByPlaylistId.getFollowersCount()).isEqualTo(playlist.getFollowersCount());
        assertThat(playlistByPlaylistId.getTracksCount()).isEqualTo(playlist.getTracksCount());

    }

}