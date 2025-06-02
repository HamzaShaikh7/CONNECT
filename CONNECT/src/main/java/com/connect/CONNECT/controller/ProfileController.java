package com.connect.CONNECT.controller;


import com.connect.CONNECT.entry.ProfileEntry;
import com.connect.CONNECT.service.ProfileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profiles")
public class ProfileController
{

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<String> addContent(@RequestBody ProfileEntry profileEntry){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return new ResponseEntity<>(profileService.addContent(profileEntry,authentication.getName()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean removed = profileService.deleteById(id, authentication.getName());
        if (removed) {
            return new ResponseEntity<>("Entry deleted",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Entry not deleted.",HttpStatus.NOT_FOUND);
    }
}