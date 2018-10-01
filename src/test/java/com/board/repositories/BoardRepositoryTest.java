package com.board.repositories;

import com.board.configuration.RepositoryConfiguration;
import com.board.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class BoardRepositoryTest {

    private BoardRepository boardRepository;

    @Autowired
    public void setBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup board
        Board board = new Board();
        board.setTitle("Spring Framework Guru Shirt");
        board.setWriter("Writer3");

        //save board, verify has ID value after save
        assertNull(board.getId()); //null before save
        boardRepository.save(board);
        assertNotNull(board.getId()); //not null after save

        //fetch from DB
        Board fetchedBoard = boardRepository.findOne(board.getId());

        //should not be null
        assertNotNull(fetchedBoard);

        //should equal
        assertEquals(board.getId(), fetchedBoard.getId());
        assertEquals(board.getTitle(), fetchedBoard.getTitle());

        //update Title and save
        fetchedBoard.setTitle("New Title");
        boardRepository.save(fetchedBoard);

        //get from DB, should be updated
        Board fetchedUpdatedBoard = boardRepository.findOne(fetchedBoard.getId());
        assertEquals(fetchedBoard.getTitle(), fetchedUpdatedBoard.getTitle());

        //verify count of products in DB
        long productCount = boardRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<Board> products = boardRepository.findAll();

        int count = 0;

        for(Board p : products){
            count++;
        }

        assertEquals(count, 1);
    }
}
