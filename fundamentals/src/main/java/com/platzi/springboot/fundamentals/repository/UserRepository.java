package com.platzi.springboot.fundamentals.repository;

import com.platzi.springboot.fundamentals.dto.UserDto;
import com.platzi.springboot.fundamentals.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query
    Optional<User> findByEmail(String email);

    @Query("SELECT u from User u where u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.platzi.springboot.fundamentals.dto.UserDto(u.id, u.name, u.birthDate)" +
            " FROM User u " +
            " WHERE u.birthDate =:paramDate " +
            " AND u.email =:paramEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("paramDate") LocalDate date, @Param("paramEmail") String email);

    List<User> findAll();

}
