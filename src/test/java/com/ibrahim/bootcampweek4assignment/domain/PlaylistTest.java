package com.ibrahim.bootcampweek4assignment.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    @Test
    public void it_should_create_empty_playlist() {
        // Arrange
        Playlist playlist = new Playlist();

        // Assert
        assertNull(playlist.getId());
        assertNull( playlist.getName());
        assertNull( playlist.getUserId());
        assertNull( playlist.getDescription());
        assertEquals(0, playlist.getFollowersCount());
        assertEquals(0, playlist.getTracks().size());
        assertEquals(0, playlist.getTracksCount());

    }

}
