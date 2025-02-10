package com.video.stream.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.video.stream.entities.Video;

public interface VideoService {

//save video
	Video save(Video v,MultipartFile file);

//get all videos
	List<Video> getAllVideos();

//get video by title
	Video getById(String vId);

}
