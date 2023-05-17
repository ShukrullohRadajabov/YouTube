package com.company.YouTubeProject.repository;

import com.company.YouTubeProject.entity.ProfileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer>, PagingAndSortingRepository<ProfileEntity, Integer> {
    Optional<ProfileEntity> findByEmailAndPassword(String email, String password);
    Optional<ProfileEntity> findByEmail(String email);
    @Transactional
    @Modifying
    @Query("update ProfileEntity set password = :password where id = :id")
    Boolean changePassword(@Param("password") String password, @Param("id") Integer id);

    @Query("SELECT new ProfileEntity(p.id,p.name,p.surname,p.email) FROM ProfileEntity as p " +
            " where p.id =:id ")
    ProfileEntity getAllId(@Param("id") Integer id);

}
