package com.Aurelsdev.VerBI.verbi.Repository;
import com.Aurelsdev.VerBI.verbi.Models.Verb;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VerbRepository extends JpaRepository<Verb, Long> {
    List<Verb> findByV1ContainingIgnoreCase(String v1);
}