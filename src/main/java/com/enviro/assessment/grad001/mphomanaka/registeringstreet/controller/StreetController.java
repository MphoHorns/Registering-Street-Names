package com.enviro.assessment.grad001.mphomanaka.registeringstreet.controller;

import com.enviro.assessment.grad001.mphomanaka.registeringstreet.entity.Street;
import com.enviro.assessment.grad001.mphomanaka.registeringstreet.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StreetController {
    private final StreetService streetService;
    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }
    @GetMapping("/all-street")
    public ResponseEntity<List<Street>> getAllStreets(){
        try {
            List<Street> streets = streetService.getAllStreets();

               if(streets.isEmpty()){
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(streets, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/street/{streetId}")
    public ResponseEntity<Street> getStreetById(@PathVariable Long streetId){
        try {
            Optional<Street> street = streetService.getStreetById(streetId);
             if(street.isPresent()){
                 return  new ResponseEntity<>(street.get(), HttpStatus.OK);
             }
             else {
                 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
             }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/add-street")
    public ResponseEntity<Street> addStreet(@RequestBody Street street){
        try{
        Street newStreet = streetService.addStreet(street);
        return new ResponseEntity<>(newStreet,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("update-street/{id}")
    public Street updateStreet(@PathVariable Long id, @RequestBody Street updatedStreet) {
        return streetService.updateStreet(id, updatedStreet);
    }
    @DeleteMapping("/delete-street/{streetId}")
    public ResponseEntity<Object> deleteStreet(@PathVariable Long streetId) {
        try {
             streetService.deleteStreet(streetId);
             return new ResponseEntity<>("Street deleted successfully", HttpStatus.OK);
        }
        catch (IllegalStateException e) {
             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
             return new ResponseEntity<>("An error occurred while deleting the street", HttpStatus.INTERNAL_SERVER_ERROR);
       }
}

}
