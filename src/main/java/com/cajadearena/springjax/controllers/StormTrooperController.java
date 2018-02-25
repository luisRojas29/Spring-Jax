package com.cajadearena.springjax.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cajadearena.springjax.daos.StormTrooperDao;
import com.cajadearena.sprinjax.entities.StormTrooper;

@RestController
@RequestMapping(path = "/troopers")
public class StormTrooperController
{
	private final StormTrooperDao trooperDao;

    @Autowired
    public StormTrooperController(StormTrooperDao trooperDao) {
        this.trooperDao = trooperDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<StormTrooper> listTroopers() {
        return trooperDao.listStormtroopers();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public StormTrooper getTrooper(@PathVariable("id") String id) throws NotFoundException {

    		StormTrooper stormtrooper = trooperDao.getStormtrooper(id);
        if (stormtrooper == null) {
            throw new NotFoundException();
        }
        return stormtrooper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public StormTrooper createTrooper(@RequestBody StormTrooper trooper) {

        return trooperDao.addStormtrooper(trooper);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public StormTrooper updateTrooper(@PathVariable("id") String id, @RequestBody StormTrooper updatedTrooper) throws NotFoundException {

        return trooperDao.updateStormtrooper(id, updatedTrooper);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTrooper(@PathVariable("id") String id) {
        trooperDao.deleteStormtrooper(id);
    }
}
