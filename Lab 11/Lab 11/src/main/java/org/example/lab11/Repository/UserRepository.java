package org.example.lab11.Repository;

import org.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserId(Integer user_id);

    @Query("select user from User user where user.username=?1 and user.password=?2")
    User logIn(String username, String password);
}
