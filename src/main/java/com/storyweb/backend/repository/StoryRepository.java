package com.storyweb.backend.repository;

import com.storyweb.backend.model.Story;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoryRepository extends MongoRepository<Story, String> {}
