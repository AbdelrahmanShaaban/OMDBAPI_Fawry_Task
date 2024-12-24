package com.example.mapper;

import com.example.entities.MovieEntity;
import com.example.model.Movies;
import com.example.model.MoviesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    // Map MoviesDTO to MovieEntity
    @Mapping(source = "website", target = "website")
    MovieEntity toMovieEntity(Movies movies);

    @Mapping(source = "website", target = "website")
    Movies toMovieDTO(MovieEntity movieEntity);

}
