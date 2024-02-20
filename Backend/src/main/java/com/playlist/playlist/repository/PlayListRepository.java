package com.playlist.playlist.repository;

import com.playlist.playlist.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList,Long > {

    PlayList createPlayList(PlayList playList);

    List<PlayList> getPlayList();

    PlayList getPlaListForName(String nameList);

    boolean deletedPlayList(String nameList);
}
