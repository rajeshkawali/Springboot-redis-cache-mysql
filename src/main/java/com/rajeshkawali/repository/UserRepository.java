package com.rajeshkawali.repository;

import com.rajeshkawali.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rajesh_Kawali
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
