package com.marcelo721.SEI.services;

import com.marcelo721.SEI.entities.Resume;
import com.marcelo721.SEI.entities.Topic;
import com.marcelo721.SEI.repositories.ResumeRepository;
import com.marcelo721.SEI.services.exceptions.EntityNotFoundException;
import com.marcelo721.SEI.web.dto.resumeDto.ResumeCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final TopicService topicService;

    @Transactional
    public Resume save(ResumeCreateDto resume) {

        Topic topic = topicService.findById(resume.idTopic());
        Resume saved = new Resume();
        saved.setTopic(topic);
        saved.setText(resume.text());
        saved.setTitle(resume.title());
        return resumeRepository.save(saved);
    }

    @Transactional(readOnly = true)
    public List<Resume> findAll() {
        return resumeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Resume findById(Long id) {
        return resumeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Resume not found"));
    }
}
