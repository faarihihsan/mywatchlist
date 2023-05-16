package com.mfaarihihsan.mywatchlist.services;

import com.mfaarihihsan.mywatchlist.models.ActorModel;
import com.mfaarihihsan.mywatchlist.models.ActorMovieModel;
import com.mfaarihihsan.mywatchlist.models.MovieModel;
import com.mfaarihihsan.mywatchlist.entities.PaginationRequest;
import com.mfaarihihsan.mywatchlist.entities.movie.CreateMovie;
import com.mfaarihihsan.mywatchlist.entities.movie.UpdateMovie;
import com.mfaarihihsan.mywatchlist.entities.PaginationResponse;
import com.mfaarihihsan.mywatchlist.entities.movie.MovieCast;
import com.mfaarihihsan.mywatchlist.entities.movie.DetailMovie;
import com.mfaarihihsan.mywatchlist.entities.movie.MovieList;
import com.mfaarihihsan.mywatchlist.entities.movie.Movie;
import com.mfaarihihsan.mywatchlist.repositories.ActorDb;
import com.mfaarihihsan.mywatchlist.repositories.ActorMovieDb;
import com.mfaarihihsan.mywatchlist.repositories.MovieDb;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieDb movieDb;
    private final ActorDb actorDb;
    private final ActorMovieDb actorMovieDb;

    @Override
    public MovieList getListMovie(PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());

        Page<MovieModel> movies = movieDb.findAll(pageable);

        return getListMovieResponse(movies);
    }

    @Override
    public MovieList searchMovie(String title, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getItemPerPage());

        Page<MovieModel> movies = movieDb.findMovieModelByTitle(title.toLowerCase(), pageable);

        return getListMovieResponse(movies);
    }

    private MovieList getListMovieResponse(Page<MovieModel> movieModels) {
        List<Movie> movieList = movieModels.getContent().stream()
                .map(movieModel -> new Movie(
                            movieModel.getId(),
                            movieModel.getTitle(),
                            movieModel.getYear(),
                            movieModel.getRating())).toList();
        PaginationResponse paginationResponse = new PaginationResponse(
                movieModels.getNumber(),
                movieModels.getSize(),
                movieModels.getTotalPages(),
                movieModels.getTotalElements()
        );
        return new MovieList(movieList, paginationResponse);
    }

    @Override
    public DetailMovie createMovie(CreateMovie createMovie) {
        MovieModel newMovie = new MovieModel(
                null,
                createMovie.getTitle(),
                createMovie.getYear(),
                createMovie.getRating(),
                null
        );
        MovieModel savedMovie = movieDb.save(newMovie);
        List<ActorMovieModel> actorMovieModels = createMovie.getCasts().stream().map(
                cast -> {
                    ActorModel targetActor = actorDb.findById(cast.getActorId())
                            .orElseThrow(() -> new NoSuchElementException(
                                    String.format("Actor with id %s is not found", cast.getActorId())
                            ));
                    return new ActorMovieModel(
                            null,
                            savedMovie,
                            targetActor,
                            cast.getCharacter(),
                            cast.isMain(),
                            cast.isSupport(),
                            cast.isGuest()
                            );
                }).toList();
        List<ActorMovieModel> savedCast = actorMovieDb.saveAll(actorMovieModels);

        return getDetailMovieResponse(savedMovie, savedCast);
    }

    @Override
    public DetailMovie updateMovie(UpdateMovie updateMovieRequest) {
        MovieModel targetMovie = movieDb.findById(updateMovieRequest.getMovieId())
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Movie with id %s is not found", updateMovieRequest.getMovieId())
                ));

        targetMovie.setTitle(updateMovieRequest.getTitle());
        targetMovie.setYear(updateMovieRequest.getYear());
        targetMovie.setRating(updateMovieRequest.getRating());

        MovieModel savedMovie = movieDb.save(targetMovie);

        List<ActorMovieModel> targetCastList = updateMovieRequest.getCasts().stream().map(
                cast -> {
                    ActorModel targetActor = actorDb.findById(cast.getActorId()).orElseThrow(() ->
                            new NoSuchElementException(String.format("Actor with id %s not found", cast.getActorId())));
                    ActorMovieModel targetCast = new ActorMovieModel();

                    if (cast.getCastId() != null) {
                        targetCast = actorMovieDb.findById(cast.getCastId()).orElseThrow(() ->
                                new NoSuchElementException(String.format("Cast with id %s not found", cast.getCastId())));
                    }

                    targetCast.setMovie(savedMovie);
                    targetCast.setActor(targetActor);
                    targetCast.setCharacter(cast.getCharacter());
                    targetCast.setMain(cast.isMain());
                    targetCast.setSupport(cast.isSupport());
                    targetCast.setGuest(cast.isGuest());

                    return targetCast;
                }).toList();
        List<ActorMovieModel> savedCast = actorMovieDb.saveAll(targetCastList);

        return getDetailMovieResponse(savedMovie, savedCast);
    }

    private DetailMovie getDetailMovieResponse(MovieModel savedMovie, List<ActorMovieModel> savedCast) {


        return new DetailMovie(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getYear(),
                savedMovie.getRating(),
                savedCast.stream().map(cast -> new MovieCast(
                        cast.getId(),
                        cast.getActor().getName(),
                        cast.getActor().getId(),
                        cast.getCharacter(),
                        cast.isMain(),
                        cast.isSupport(),
                        cast.isGuest()
                )).toList()
        );
    }

    @Override
    public DetailMovie getDetailMovie(Integer id) {
        MovieModel movieModel = movieDb.findById(id).orElseThrow(() -> new NoSuchElementException(String.format("Movie with id %s not found", id)));

        return new DetailMovie(
                movieModel.getId(),
                movieModel.getTitle(),
                movieModel.getYear(),
                movieModel.getRating(),
                movieModel.getCasts().stream()
                        .map(cast -> new MovieCast(
                                cast.getId(),
                                cast.getActor().getName(),
                                cast.getActor().getId(),
                                cast.getCharacter(),
                                cast.isMain(),
                                cast.isSupport(),
                                cast.isGuest()
                        )).toList()
        );
    }
}
