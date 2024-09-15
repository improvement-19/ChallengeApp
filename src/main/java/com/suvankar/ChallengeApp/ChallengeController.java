package com.suvankar.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final List<Challenge> challenges=new ArrayList<>();

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService)
    {
        this.challengeService=challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge)
    {
        boolean ischallengeAdded = challengeService.addChallenge(challenge);
        if(ischallengeAdded)
            return new ResponseEntity<>("challenge added successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("challenge not added successfully",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable  String month)
    {
        Challenge challenge=challengeService.getChallenge(month);
        if(challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable  Long id,@RequestBody Challenge updatedChallenge)
    {
        boolean ischallengeupdated= challengeService.updateChallenge(id,updatedChallenge);
        if(ischallengeupdated)
            return new ResponseEntity<>("challenge added successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("challenge not added successfully",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenege(@PathVariable  Long id)
    {
        boolean ischallenegeDeleted = challengeService.deleteChallenge(id);
        if(ischallenegeDeleted)
            return new ResponseEntity<>("Challenge deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenege not deleted",HttpStatus.NOT_FOUND);
    }
}
