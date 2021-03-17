package com.quatarfootball.qatarfootball.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quatarfootball.qatarfootball.dao.UserDao;
import com.quatarfootball.qatarfootball.Entity.UserDto;
import com.quatarfootball.qatarfootball.Entity.Personne;
import com.quatarfootball.qatarfootball.Service.UserService;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Personne user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Personne user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            //authorities.add(new SimpleGrantedAuthority(role.getName()));
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
        //return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<Personne> findAll() {
        List<Personne> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }

    @Override
    public Personne findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Personne findById(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    public Personne save(UserDto user) {
        Personne newUser = new Personne();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setFamName(user.getFamName());
        newUser.setAge(user.getAge());
        newUser.setCountry(user.getCountry());
        newUser.setEmail(user.getEmail());
        newUser.setTel(user.getTel());
        newUser.setName(user.getName());
        return userDao.save(newUser);
    }
}
