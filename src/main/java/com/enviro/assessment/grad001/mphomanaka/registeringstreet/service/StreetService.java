package com.enviro.assessment.grad001.mphomanaka.registeringstreet.service;

import com.enviro.assessment.grad001.mphomanaka.registeringstreet.entity.Street;
import com.enviro.assessment.grad001.mphomanaka.registeringstreet.repository.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetService {
    private  final StreetRepository streetRepository;

    public StreetService(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    public List<Street> getAllStreets() {
        return streetRepository.findAll();
    }

    public Optional<Street> getStreetById(Long streetId) {
        return streetRepository.findById(streetId);
    }

    public Street addStreet(Street street) {
        return streetRepository.save(street);
    }
    public void deleteStreet(Long streetId) {
        boolean exists = streetRepository.existsById(streetId);
        if(!exists){
            throw new IllegalStateException("Street with id "+ streetId +" does not exists.");

        }
        streetRepository.deleteById(streetId);
    }
    public Street updateStreet(Long streetId, Street updatedStreet) {
        Street existingStreet = streetRepository.findById(streetId)
                .orElseThrow(() -> new RuntimeException("Street not found with id: " + streetId));

        existingStreet.setName(updatedStreet.getName());
        existingStreet.setCity(updatedStreet.getCity());
        existingStreet.setSuburb(updatedStreet.getSuburb());
        existingStreet.setCode(updatedStreet.getCode());

        return streetRepository.save(existingStreet);
    }
}
