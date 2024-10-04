package com.sparta.schedular.service;

import com.sparta.schedular.domain.Post;
import com.sparta.schedular.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글을 찾거나 기본값 반환
    public Post getPostOrElse(Long id, Post defaultPost) {
        Post post = postRepository.findById(id).orElse(null); // 게시글 조회
        return (post != null) ? post : defaultPost; // 게시글이 존재하면 반환, 없으면 기본값 반환
    }

    // 비밀번호 확인 메서드
    public boolean checkPassword(Long id, String password) {
        // 게시글 조회
        Post post = postRepository.findById(id).orElse(null);

        // 게시글이 존재하지 않는 경우
        if (post == null) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다."); // 예외 처리
        }
        // 비밀번호 비교
        return post.getPassword().equals(password);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return Optional.ofNullable(postRepository.findById(id));
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Long id, Post post) {
        postRepository.update(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }



}


