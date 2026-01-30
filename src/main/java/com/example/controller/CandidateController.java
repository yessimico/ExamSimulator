package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.entity.Candidate;
import com.example.repository.CandidateRepository;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateRepository repository;

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate saved = repository.save(candidate);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = repository.findAll();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/university/{university}")
    public ResponseEntity<List<Candidate>> getCandidatesByUniversity(@PathVariable String university) {
        List<Candidate> candidates = repository.findByUniversity(university);
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/highscorers/{minScore}")
    public ResponseEntity<List<Candidate>> getHighScorers(@PathVariable int minScore) {
        List<Candidate> candidates = repository.findByScoreGreaterThan(minScore);
        return ResponseEntity.ok(candidates);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate details) {
        return repository.findById(id)
                .map(candidate -> {
                    candidate.setName(details.getName());
                    candidate.setSurname(details.getSurname());
                    candidate.setAge(details.getAge());
                    candidate.setSex(details.getSex());
                    candidate.setUniversity(details.getUniversity());
                    candidate.setScore(details.getScore());
                    Candidate updated = repository.save(candidate);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
