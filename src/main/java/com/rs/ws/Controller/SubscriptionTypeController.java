package com.rs.ws.Controller;
import com.rs.ws.dto.SubscriptionTypeDto;
import com.rs.ws.model.SubscriptionType;
import com.rs.ws.service.SubscriptionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sub-tp")
public class SubscriptionTypeController {
    @Autowired
    private SubscriptionTypeService subscriptionTypeService ;
    @GetMapping("/sub-all")
    public ResponseEntity<List<SubscriptionType>> findAll(){
       return ResponseEntity.status(HttpStatus.OK).body(subscriptionTypeService.findAll());
    }
    @GetMapping("/find-id/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable (name = "id") Long id){
            return ResponseEntity.status(HttpStatus.FOUND).body(subscriptionTypeService.findById(id));
    }
    @PostMapping
    public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto subscriptionType){
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionTypeService.create(subscriptionType));
    }
    @PutMapping("/up/{id}")
    public ResponseEntity<SubscriptionType> update(@PathVariable ("id") Long id,@Valid @RequestBody SubscriptionTypeDto subscriptionTypeDto){
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(subscriptionTypeService.update(id,subscriptionTypeDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SubscriptionType> delete(@PathVariable ("id") Long id){
        subscriptionTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
