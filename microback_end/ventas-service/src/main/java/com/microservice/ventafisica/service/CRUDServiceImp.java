package com.microservice.ventafisica.service;

import com.microservice.ventafisica.repo.GenericRepository;

import java.util.List;

public abstract class CRUDServiceImp<T,ID> implements CRUDService<T,ID> {

protected abstract GenericRepository<T,ID> getGenericRepo();

@Override
public T save(T t) {
    return getGenericRepo().save(t);}

@Override
public T update(T t) {
    return getGenericRepo().save(t);}

@Override
public T findById(ID id) {
    return getGenericRepo().findById(id).orElse(null);}

@Override
public List<T> findAll() {
    return getGenericRepo().findAll();}

@Override
public void delete(ID id) {
    getGenericRepo().deleteById(id);}

}
