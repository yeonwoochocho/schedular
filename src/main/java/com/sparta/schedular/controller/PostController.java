package com.sparta.schedular.controller;

import com.sparta.schedular.domain.Post;
import com.sparta.schedular.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.StyleSheet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // '글 등록' 버튼을 눌렀을 때 보여줄 페이지를 반환하는 메서드
    @GetMapping("/save")
    public String showSavePage() {
        return "post-save"; // post-save.mustache 파일을 렌더링
    }



    // 게시글 저장 처리 메서드 (POST 요청 처리)
    @PostMapping("/save")
    public ResponseEntity<String> savePost(@RequestParam String title,
                           @RequestParam String author,
                           @RequestParam String content,
                           @RequestParam String password,
                           @RequestParam String confirmPassword,
                           @RequestParam String eventDate, // 추가된 날짜
                           @RequestParam String eventTime) { // 추가된 시간
        // 비밀번호와 비밀번호 확인이 일치하는지 확인
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 날짜와 시간을 결합하여 LocalDateTime 객체 생성
        String dateTimeString = eventDate + "T" + eventTime; // "2024-10-01T14:30"
        LocalDateTime eventDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Post 객체 생성 후 저장
        Post post = new Post(title, author, content, password, eventDateTime);
        postService.savePost(post);

        return ResponseEntity.ok("게시글이 등록되었습니다."); // 메시지 반환
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id,
                                        @RequestBody Post post) {
        // 비밀번호 확인
        if (!postService.checkPassword(id, post.getPassword())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

        // 게시글 수정
        postService.updatePost(id, post);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String password = request.get("password");

        // 비밀번호 확인
        if (!postService.checkPassword(id, password)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("비밀번호가 일치하지 않습니다.");
        }

        // 게시글 삭제
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

}
