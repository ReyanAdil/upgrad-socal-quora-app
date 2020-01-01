package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity createUser(UserEntity user){
        entityManager.persist(user);
        return user;
    }

    public UserEntity getUserByUserName(final String userName){
        try{
            return entityManager.createNamedQuery("userByUserName", UserEntity.class).setParameter("username",userName).getSingleResult();
        }catch (NoResultException nre){
            return  null;
        }
    }

    public UserEntity getUserByEmail(final String email){
        try{
            return entityManager.createNamedQuery("userByEmailId", UserEntity.class).setParameter("email",email).getSingleResult();
        }catch (NoResultException nre){
            return  null;
        }
    }

    public UserEntity getUserByUUID(final String uuid){
        try{
            return entityManager.createNamedQuery("userByUUID", UserEntity.class).setParameter("uuid",uuid).getSingleResult();
        }catch (NoResultException nre){
            return  null;
        }
    }

    public UserEntity deleteUser(final UserEntity userEntity) {
        entityManager.remove(userEntity);
        return userEntity;
    }


}