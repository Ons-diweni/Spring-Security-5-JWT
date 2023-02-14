package tn.esprit.kaddemspringbootproject.dto;


import lombok.Data;

@Data
public class LoginDto {

    //it's a Data Trasfer Object for authentication
    private String email ;
    private String password ;
}
