package com.board.repositories;

import com.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<Board, Integer>{
    Page<Board> findAll(Pageable pageable);

    Optional<Board> findById(int id);
}
