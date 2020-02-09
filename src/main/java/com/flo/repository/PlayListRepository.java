package com.flo.repository;

import com.flo.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    List<PlayList> findAllByUserId(int uid);
}
