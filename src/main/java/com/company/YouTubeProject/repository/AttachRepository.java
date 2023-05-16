package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.AttachEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachRepository extends CrudRepository<AttachEntity, String> {
}
