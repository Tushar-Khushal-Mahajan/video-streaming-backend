package com.video.stream.services.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.video.stream.entities.Video;
import com.video.stream.repositories.VideoRepository;
import com.video.stream.services.VideoService;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoRepository vRepository;
	public final String DIR = "videos/";

	public VideoServiceImpl(VideoRepository vRepository) {
		this.vRepository = vRepository;
	}

//	create folder if not exists

	@PostConstruct
	public void createFolder() {

		File file = new File(DIR);

		if (!file.exists()) {
			file.mkdir();
			System.out.println("Folder created");
		} else {
			System.out.println("Folder already exists");
		}
	}

//	------

	@Override
	public Video save(Video v, MultipartFile file) {

		try {
			String folderPath = DIR;
			String fileName = file.getOriginalFilename();
			InputStream inputStream = file.getInputStream();
			String contentType = file.getContentType();

			fileName = StringUtils.cleanPath(fileName);
			folderPath = StringUtils.cleanPath(folderPath);

			Path path = Paths.get(folderPath, fileName);

			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);

			v.setVideoId(UUID.randomUUID().toString());
			v.setPath(folderPath);

			// save video
			return vRepository.save(v);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Video> getAllVideos() {
		return vRepository.findAll();
	}

	@Override
	public Video getById(String vId) {
		return vRepository.findById(vId).orElse(null);
	}

}
