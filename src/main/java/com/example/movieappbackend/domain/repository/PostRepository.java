package com.example.movieappbackend.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.movieappbackend.domain.model.Post;
import com.example.movieappbackend.domain.model.User;
import com.example.movieappbackend.domain.model.WatchedMovie;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@EntityGraph(attributePaths = {"usersThatLiked"})
	Page<Post> findAll(Pageable pageable);
	
	@Query("from Post p where p.watchedMovie.userMoviePair.user = :user")
	Page<Post> findAllByUser(@Param("user") User user, Pageable pageable);
	
	Optional<Post> findByUuid(String uuid);
	
	boolean existsByWatchedMovie(WatchedMovie watchedMovie);
	
	@EntityGraph(attributePaths = {"usersThatLiked"})
	@Query("from Post p where p.watchedMovie.userMoviePair.user in :following")
	Page<Post> findAllByUserFollowing(@Param("following") List<User> following, Pageable pageable);
}
