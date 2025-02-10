package com.video.stream.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.video.stream.entities.Video;

public interface VideoRepository extends JpaRepository<Video, String> {

	Optional<Video> findByTitle(String title);
}
