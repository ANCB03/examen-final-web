package com.examen.controller;

import com.examen.entity.Bill;
import com.examen.entity.User;
import com.examen.repository.BillRepository;
import com.examen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BillRepository billRepository;

    @ GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    @PostMapping("/{user}/bills")
    public Bill guardar(@RequestBody Bill bill,@PathVariable String user) {
        User usuario = userRepository.findMovimientos(user);
        bill.setUser_id(usuario);
        billRepository.save(bill);
        return bill;
    }


    @GetMapping("/{user}/bills")
    public List<Bill> getAdminbyId(@PathVariable String user) {

        User administrador = userRepository.findMovimientos(user);


            return administrador.getMovimientos();


    }

    @GetMapping("{user}/bills/{bill_id}")
    public Bill getMovimiento(@PathVariable String user, @PathVariable int bill_id){
        User administrador = userRepository.findMovimientos(user);

        for(Bill prueba: administrador.getMovimientos()){
            if(prueba.getId()==bill_id){
                return prueba;
            }
        }

        return null;
    }
}
