package com.video.stream.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.video.stream.entities.Video;
import com.video.stream.repositories.VideoRepository;
import com.video.stream.services.VideoService;

@RestController
@RequestMapping("/v1/video")
public class VideoController {

	private VideoService vService;

	public VideoController(VideoService vService) {
		this.vService = vService;
	}

//	----------------

	@PostMapping
	public ResponseEntity<?> saveVideo(@RequestParam("title") String title, @RequestParam("description") String desc,
			@RequestParam("file") MultipartFile file) {

		Video v = Video.builder().title(title).description(desc).build();
		System.out.println(v);
		vService.save(v, file);
		return null;
	}

}
