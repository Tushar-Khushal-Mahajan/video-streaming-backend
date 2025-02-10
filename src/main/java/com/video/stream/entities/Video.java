package com.video.stream.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "video_tbl")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Video {

	@Id
	private String videoId;
	private String title;
	private String description;
	private String path;

}
