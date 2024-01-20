package com.agudelo.repository;

import java.util.Optional;

import com.agudelo.model.User;

public interface UserRepository {

	Optional<User> findByUsername(String username);
}
