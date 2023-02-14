package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Universite;
import tn.esprit.kaddemspringbootproject.services.IUniversiteServices;

import java.util.List;

@RestController
@Tag(name="Universities Management")
@RequestMapping("universite")
@RequiredArgsConstructor
public class UniversiteRestController {

    private final IUniversiteServices universiteServices;
    @Operation(description ="Retrive all universities")
    @GetMapping("/all")
    @ResponseBody
    public List<Universite> retrieveAllUniversite(){
        return universiteServices.retrieveAllUniversites();
    }
    @Operation(description ="Add University")
    @PostMapping("/add")
    @ResponseBody
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversite(u);
    }
    @Operation(description ="Find university by id")
    @GetMapping("find/{id}")
    @ResponseBody
    public Universite findUniversite(@PathVariable("id") Integer idUniversite){
        return universiteServices.retrieveUniversite(idUniversite);
    }
    @Operation(description ="Affect university to department")
    @PutMapping("/affect/{idUniversite}/{idDepartement}")
    public void AffectUniversityToDepartment(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
        universiteServices.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    

}
