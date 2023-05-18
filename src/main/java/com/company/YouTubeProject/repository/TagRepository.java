package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.TagEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends CrudRepository<TagEntity, Integer>, PagingAndSortingRepository<TagEntity, Integer> {
    @Transactional
    @Modifying
    @Query("update TagEntity set name = :name where id = :id")
    Integer changename(@Param("name") String name, @Param("id") Integer id);


}
