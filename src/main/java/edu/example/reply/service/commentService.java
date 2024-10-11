//package edu.example.reply.service;
//
//import edu.example.reply.dto.CommentDto;
//import edu.example.reply.repository.ArticleRepository;
//import edu.example.reply.repository.CommentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class commentService {
//    @Autowired
//    private CommentRepository commentRepository;
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    public List<CommentDto> comments(Long articleId){
//        return commentRepository.findByArticleId(articleId)
//                .stream()
//                .map(comment->CommentDto.createCommentDto(comment))
//                .collect(Collectors.toList());
//    }
//}
