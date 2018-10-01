package com.board.services;

import com.board.domain.Board;
import com.board.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardRepository boardRepository;

    @Autowired
    public void setBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Iterable<Board> listAllBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoardById(Integer id) {
        return boardRepository.findOne(id);
    }

    @Override
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Integer id) {
        boardRepository.delete(id);
    }

    @Override
    public Page<Board> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override       //조회수 증가
    public void updatehit(int id) {
        Optional<Board> byId = boardRepository.findById(id);
        byId.ifPresent(_content ->{
            _content.setHit(_content.getHit()+1);
            boardRepository.save(_content);
        });
    }
}
