package com.playlist.playlist.repository;

import com.playlist.playlist.model.PlayList;
import com.playlist.playlist.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long > {

    Song createSong(Song song);

    List<Song> getSong();

    Song getSong(String title);

    boolean deletedSong(String title);

    Song getSongTitle(String title);
}
