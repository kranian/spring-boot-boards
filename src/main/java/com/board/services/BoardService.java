package com.board.services;


import com.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Iterable<Board> listAllBoards();

    Board getBoardById(Integer id);

    Board saveBoard(Board board);

    void deleteBoard(Integer id);

    Page<Board> findAll(Pageable pageable);

    void updatehit(int id);
}
