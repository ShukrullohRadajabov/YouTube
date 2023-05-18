package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.PlaylistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlaylistRepository extends CrudRepository<PlaylistEntity, String>, PagingAndSortingRepository<PlaylistEntity, String> {
    Page<PlaylistEntity> findAll(Pageable paging);
}
