package com.quatarfootball.qatarfootball.Service;

import java.util.List;

import com.quatarfootball.qatarfootball.Entity.UserDto;

import com.quatarfootball.qatarfootball.Entity.Personne;

public interface UserService {
    Personne save(UserDto user);
    List<Personne> findAll();
    void delete(long id);
    Personne findOne(String username);

    Personne findById(Long id);

}
