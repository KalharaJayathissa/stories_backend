package com.storyweb.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("stories")
public class Story {
    @Id
    private String id;
    private String title;
    private String thumbnailUrl;
    private String storyLink;
    private String description;

    public Story() {}

    public Story(String title, String thumbnailUrl, String storyLink, String id) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        
        this.storyLink = storyLink;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public String getStoryLink() { return storyLink; }
    public String getDescription() { return description; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    public void setStoryLink(String storyLink) { this.storyLink = storyLink; }
    public void setDescription(String description) { this.description = description; }
}
