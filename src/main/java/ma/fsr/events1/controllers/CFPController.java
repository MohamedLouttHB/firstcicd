package ma.fsr.events1.controllers;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.CFP;
import ma.fsr.events1.services.CFPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("api/cfps")
public class CFPController {
    private CFPService cfpService;

    @PostMapping
    public ResponseEntity<CFP> createCfp(@RequestBody CFP cfp){
        CFP savedCfp = cfpService.createCfp(cfp);
        return new ResponseEntity<>(savedCfp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CFP> getCfpById(@PathVariable("id") Long cfpId){
        CFP cfp = cfpService.getCfpById(cfpId);
        return new ResponseEntity<>(cfp, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CFP>> getAllCfps(){
        List<CFP> cfps = cfpService.getAllCfps();
        return new ResponseEntity<>(cfps, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CFP> updateCfp(@PathVariable("id") Long cfpId, @RequestBody CFP cfp){
        CFP updatedCfp = cfpService.updateCfp(cfpId, cfp);
        return new ResponseEntity<>(updatedCfp, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCfp(@PathVariable("id") Long cfpId){
        cfpService.deleteCfp(cfpId);
        return new ResponseEntity<>("CFP deleted Successfully !", HttpStatus.OK);
    }
}
