package com.example.repository;
import com.example.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByUniversity(String university);
    List<Candidate> findByScoreGreaterThan(int score);
}
