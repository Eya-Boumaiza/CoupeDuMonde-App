package com.quatarfootball.qatarfootball.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quatarfootball.qatarfootball.Entity.Personne;

@Repository
public interface UserDao extends CrudRepository<Personne, Long> {
    Personne findByUsername(String username);
}
