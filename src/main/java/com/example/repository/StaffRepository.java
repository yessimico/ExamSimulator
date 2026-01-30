package com.example.repository;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findByPosition(String position);
}
