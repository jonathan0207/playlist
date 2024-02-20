package com.playlist.playlist;

import com.playlist.playlist.model.PlayList;
import com.playlist.playlist.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlayListService {
    @Autowired
    private PlayListRepository playListRepository;

    @PostMapping
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayList playList){
        if(playList.getName() == null || playList.getName().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PlayList newPlayList = playListRepository.createPlayList(playList);
        return new ResponseEntity<>(newPlayList, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PlayList>> getPlayList() {
        List<PlayList> list = playListRepository.getPlayList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{nameList}")
    public ResponseEntity<PlayList> getPlaListForName(@PathVariable String nameList) {
        PlayList list = playListRepository.getPlaListForName(nameList);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/{nameList}")
    public ResponseEntity<Void> deletedPlayList(@PathVariable String nameList) {
        boolean deleted = playListRepository.deletedPlayList(nameList);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
