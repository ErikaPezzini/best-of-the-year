package com.example.best_of_the_year.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.best_of_the_year.models.Movie;
import com.example.best_of_the_year.models.Song;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nome", "Erika");
        return "index";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        Movie movie = getBestMovies().stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("movie", movie);
        return "movie-detail";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable int id, Model model) {
        Song song = getBestSongs().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        model.addAttribute("song", song);
        return "song-detail";
    }


    private List<Movie> getBestMovies() {
        return Arrays.asList(
                new Movie(1, "Inception"),
                new Movie(2, "Interstellar"),
                new Movie(3, "The Matrix")
        );
    }

    private List<Song> getBestSongs() {
        return Arrays.asList(
                new Song(1, "Bohemian Rhapsody"),
                new Song(2, "Imagine"),
                new Song(3, "Hotel California")
        );
    }
}