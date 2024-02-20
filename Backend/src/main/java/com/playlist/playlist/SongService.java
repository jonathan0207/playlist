package com.playlist.playlist;

import com.playlist.playlist.model.Song;
import com.playlist.playlist.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Song")
public class SongService {
    @Autowired
    private SongRepository songRepository;

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song){
        if(song.getTitle() == null || song.getTitle().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Song newSong = songRepository.createSong(song);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Song>> getSong() {
        List<Song> song = songRepository.getSong();
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Song> getSongTitle(@PathVariable String title) {
        Song song = songRepository.getSongTitle(title);
        if (song == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deletedSong(@PathVariable String title) {
        boolean deleted = songRepository.deletedSong(title);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
