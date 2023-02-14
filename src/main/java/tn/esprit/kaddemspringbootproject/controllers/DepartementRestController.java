package tn.esprit.kaddemspringbootproject.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddemspringbootproject.entities.Departement;
import tn.esprit.kaddemspringbootproject.services.IDepartementServices;

import java.util.List;

@RestController
@Tag(name="Departments Management")
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartementRestController {
    private  final IDepartementServices departementsService;

    @Operation(description ="Retrieve all departments")
    @GetMapping("/all")
    public List<Departement> getAllDepartments(){
        return departementsService.retrieveAllDepartements();
    }
    @Operation(description ="Add depratment")
    @PostMapping("/add")
    public Departement addDepartment(@RequestBody Departement d){
        return  departementsService.addDepartement(d);
    }
    @Operation(description ="Assign department to student")
    @PutMapping("/affect/{idDep}/{idEtud}")
    public void AffectDepartementToStudent(@PathVariable("idDep") Integer idDep,@PathVariable("idEtud") Integer idEtud){
        departementsService.assignEtudiantToDepartement(idDep,idEtud);
    }
    @Operation(description ="Update department")
    @PutMapping("/update")
    public Departement updateDepartement(@RequestBody Departement d){
        return departementsService.updateDepartement(d);
    }
    @Operation(description ="Find Department By ID")
    @GetMapping("/find/{id}")
    public Departement findDepartment(@PathVariable("id") Integer id){
        return departementsService.retrieveDepartement(id);
    }
    @Operation(description ="Find Department by University")
    @GetMapping("/findDepartmentsByUniversite/{idUniv}")
    public List<Departement> findDepartmentsByidUniv(@PathVariable("idUniv") Integer idUniv){
        return departementsService.retrieveDepartementsByUniversite(idUniv);
    }
    @Operation(description ="Delete Department")
    @DeleteMapping("delete/{id}")
    public void deleteDepartment(@PathVariable("id") Integer id){
        departementsService.removeDepartment(id);
    }
}
