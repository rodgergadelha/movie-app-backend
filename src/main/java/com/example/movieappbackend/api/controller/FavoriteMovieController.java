package com.example.movieappbackend.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieappbackend.domain.service.FavoriteMovieService;
import com.example.movieappbackend.domain.service.MovieListServiceAbstract;

import lombok.AllArgsConstructor;


@CrossOrigin
@RestController
@RequestMapping("/users/my-account/liked-movies")
@AllArgsConstructor
public class FavoriteMovieController extends MovieListControllerAbstract {
	
	private final FavoriteMovieService service;
	
	protected MovieListServiceAbstract getService() {
		return this.service;
	}
}
