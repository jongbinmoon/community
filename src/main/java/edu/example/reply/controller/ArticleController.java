package edu.example.reply.controller;

import edu.example.reply.dto.ArticleForm;
import edu.example.reply.entity.Article;
import edu.example.reply.repository.ArticleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller //컨트롤러 선언
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new") //URL 요청 접수
    public String newArticleForm(){ // 메서드 생성 및 반환값 작성
        return "articles/new";
    }

    @PostMapping("/articles/create") // URL 요청 접수
    public String createArticle(ArticleForm form ){// 폼 데이터를 dto로 받기  //메서드 생성 및 반환값 작성
        //System.out.println(form.toString()); // DTO에 폼 데이터가 잘 담겼는지 확인 // 기존 println()문 주석 처리
        log.info(form.toString()); // 로깅 코드 추가
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());
        // DTO가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        //article 이 DB에 잘 저장되는지 확인 출력
        log.info(saved.toString());


        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        // 매개변수로 id 받아오기
        log.info("id = " + id); //id를 잘 받았는지 확인하는 로그 찍기
        // 1.id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article",articleEntity);
        model.addAttribute("commentDtos",commentsDtod);
        //댓글 목록 모델에 등록하기
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }
}
