package com.cajadearena.springjax.daos;

import java.util.Collection;

import com.cajadearena.sprinjax.entities.StormTrooper;


public interface StormTrooperDao
{
	Collection<StormTrooper> listStormtroopers();

	StormTrooper getStormtrooper(String id);

	StormTrooper addStormtrooper(StormTrooper stormtrooper);

	StormTrooper updateStormtrooper(String id, StormTrooper stormtrooper);

    boolean deleteStormtrooper(String id);
}
