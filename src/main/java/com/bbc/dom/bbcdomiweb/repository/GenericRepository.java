/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bbc.dom.bbcdomiweb.repository;

/**
 *
 * @author Christian Gutierrez
 */
public interface GenericRepository<T>{
 
    T create(T t);
 
    void delete(T t);
 
    T find(T t);
 
    T persist(T t);
     
    Iterable<T> findAll();
}

