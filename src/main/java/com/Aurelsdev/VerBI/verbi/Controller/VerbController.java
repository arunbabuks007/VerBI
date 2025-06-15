package com.Aurelsdev.VerBI.verbi.Controller;

import com.Aurelsdev.VerBI.verbi.Models.Verb;
import com.Aurelsdev.VerBI.verbi.Repository.VerbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/public/verbi")
public class VerbController {
    
    @Autowired
    private VerbRepository verbRepository;

    // Get all verbs
    @GetMapping
    public List<Verb> getAllVerbs() {
        return verbRepository.findAll();
    }

    // Search verbs by V1
    @GetMapping("/search")
    public List<Verb> searchVerbs(@RequestParam String query) {
        return verbRepository.findByV1ContainingIgnoreCase(query);
    }

    // Create a new verb
    @PostMapping
    public Verb createVerb(@RequestBody Verb verb) {
        return verbRepository.save(verb);
    }

    // Update a verb
    @PutMapping("/{id}")
    public ResponseEntity<Verb> updateVerb(@PathVariable Long id, @RequestBody Verb verbDetails) {
        Verb verb = verbRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verb not found"));
        verb.setV1(verbDetails.getV1());
        verb.setV2(verbDetails.getV2());
        verb.setV3(verbDetails.getV3());
        verb.setV4(verbDetails.getV4());
        verb.setV5(verbDetails.getV5());
        Verb updatedVerb = verbRepository.save(verb);
        return ResponseEntity.ok(updatedVerb);
    }

    // Delete a verb
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVerb(@PathVariable Long id) {
        Verb verb = verbRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Verb not found"));
        verbRepository.delete(verb);
        return ResponseEntity.ok().build();
    }
}