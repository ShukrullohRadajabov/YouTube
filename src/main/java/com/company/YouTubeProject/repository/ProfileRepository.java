package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer>, PagingAndSortingRepository<ProfileEntity, Integer> {
    Optional<ProfileEntity> findByEmailAndPassword(String email, String password);
    Optional<ProfileEntity> findByEmail(String email);
}
