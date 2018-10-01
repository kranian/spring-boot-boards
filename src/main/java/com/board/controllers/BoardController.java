package com.board.controllers;

import com.board.domain.Board;
import com.board.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    // 시작 화면 //
    @RequestMapping(value = "/boards", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable){
        Page<Board> boardPage = boardService.findAll(pageable);
        PageWrapper<Board> page = new PageWrapper<Board>(boardPage, "/boards");
        model.addAttribute("boards", page.getContent());
        model.addAttribute("page", page);
        return "boards";
    }

    // 게시글 상세보기 //
    @RequestMapping("board/{id}")
    public String showboard(@PathVariable Integer id, Model model){

        boardService.updatehit(id);
        model.addAttribute("board", boardService.getBoardById(id));
        return "boardshow";
    }

    // 게시글 수정 //
    @RequestMapping("board/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("board", boardService.getBoardById(id));
        return "boardform";
    }

    // 게시글 작성 //
    @RequestMapping("board/new")
    public String newboard(Model model){
        model.addAttribute("board", new Board());
        return "boardform";
    }

    // 게시글 저장 //
    @RequestMapping(value = "board", method = RequestMethod.POST)
    public String saveboard(Board board){
        boardService.saveBoard(board);
        return "redirect:/boards";
    }

    // 게시글 삭제 //
    @RequestMapping("board/delete/{id}")
    public String delete(@PathVariable Integer id){
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }

}
