package com.company.YouTubeProject.service;

import com.company.YouTubeProject.dto.tag.TagDTO;
import com.company.YouTubeProject.entity.TagEntity;

import com.company.YouTubeProject.exeption.AppBadRequestException;
import com.company.YouTubeProject.repository.TagRepository;
import com.company.YouTubeProject.utill.SpringSecurityUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public TagDTO create(TagDTO dto) {
        TagEntity entity =new TagEntity();
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        entity.setCreated_date(dto.getCreated_date());
        tagRepository.save(entity);
        return dto;

    }

    public Integer update(String name) {
        Integer tagID = get(SpringSecurityUtill.getProfileId()).getId();
        return tagRepository.changename(name,tagID);

    }

    public TagEntity get(Integer tagID) {
        Optional<TagEntity> optional = tagRepository.findById(tagID);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Profile not found: " + tagID);
        }
        return optional.get();
    }

    public boolean delete(Integer id) {
        Optional<TagEntity> optional = tagRepository.findById(id);
        if (optional.isEmpty()){
            throw new AppBadRequestException("bu foydalanuvchi yo'q ");
        }
        tagRepository.deleteById(id);
        return true;
    }

    public List<TagDTO> getAll() {
        List<TagDTO> dtoList = getdtoList(tagRepository.findAll());
        return dtoList;
    }
    public List<TagDTO> getdtoList(Iterable<TagEntity> dtos) {
        List<TagDTO> dtoList = new LinkedList<>();
        dtos.forEach(entity -> {
            TagDTO dto = new TagDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCreated_date(entity.getCreated_date());

            dtoList.add(dto);
        });
        return dtoList;
    }

}
