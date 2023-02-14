package tn.esprit.kaddemspringbootproject.dto;


import lombok.Data;
import tn.esprit.kaddemspringbootproject.entities.Option;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class RegisterDto {

    //it's a Data Trasfer Object for registration
    private String email ;
    private String password ;
    @Enumerated(EnumType.STRING)
    private Option option ;
    private String lastName ;
    private String username ;

}
