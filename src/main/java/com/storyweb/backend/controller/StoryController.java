package com.storyweb.backend.controller;

import com.storyweb.backend.model.Story;
import com.storyweb.backend.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stories")
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @GetMapping
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    @PostMapping
    public Story addStory(@RequestBody Story story) {
        return storyRepository.save(story);
    }
    @PutMapping("/{id}")
public Story updateStory(@PathVariable String id, @RequestBody Story updatedStory) {
    return storyRepository.findById(id).map(story -> {
        story.setTitle(updatedStory.getTitle());
        story.setThumbnailUrl(updatedStory.getThumbnailUrl());
        story.setStoryLink(updatedStory.getStoryLink());
        story.setDescription(updatedStory.getDescription());
        return storyRepository.save(story);
    }).orElseThrow(() -> new RuntimeException("Story not found with id " + id));
    }

}
