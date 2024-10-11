//package edu.example.reply.repository;
//
//import edu.example.reply.entity.Article;
//import edu.example.reply.entity.Comment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface CommentRepository extends JpaRepository<Article,Long> {
//    @Query(value = "SELECT * FROM comment WHERE article_id = :articleId",
//            nativeQuery = true)
//    List<Comment>findByArticleId(Long articleId);
//    List<Comment>findByNickname(String nickname);
//}
