/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.primavera;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ControladorAlumno {
    
   @Autowired AlumnoRepositorio alumnRepo;
   
   //Este método busca a todos los alumnos guardados, si es qye hay
   @GetMapping ("/alumno")
   public List<Alumno> buscarTodos()throws Exception{
       return alumnRepo.findAll();
   }
   
   //Este método para guardar un nuevo alumno
   
   @PostMapping("/alumno")
    public Estatus guardarAlumno (@RequestBody String json ) throws Exception{
        //Primero el cuerpo que llega, lo desserializamos
        ObjectMapper maper =new ObjectMapper();
        //Lo mapeamos
        Alumno a=maper.readValue(json, Alumno.class);
        //Ahora lo guardamos:
        alumnRepo.save(a);
        //Debemos informar al cliente que mas adelante será android
        Estatus e= new Estatus();
        e.setMensaje("Alumno se guardo biennnn");
        e.setSuccess(true);
        return e;
        
    }
    

   
   
    
    
 
}
