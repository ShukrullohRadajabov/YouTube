package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends CrudRepository<TagEntity, String> {
    Optional<TagEntity> findByName(String name);
}
