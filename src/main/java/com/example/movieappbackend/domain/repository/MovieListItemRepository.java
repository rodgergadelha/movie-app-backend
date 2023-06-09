package com.example.movieappbackend.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movieappbackend.domain.model.MovieListItem;

@Repository
public interface MovieListItemRepository extends JpaRepository<MovieListItem, String>{

	Optional<MovieListItem> findByImdbId(String imdbId);
}
