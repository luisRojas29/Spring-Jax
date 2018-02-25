package com.cajadearena.springjax.daos;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.cajadearena.sprinjax.entities.StormTrooper;

public class DefaultStormTrooperDao implements StormTrooperDao
{
	final static private String[] trooperTypes = {"Basic", "Space", "Aquatic", "Marine", "Jump", "Sand"};
    final static private String[] planetsList = {"Coruscant", "Tatooine", "Felucia", "Hoth", "Naboo", "Serenno"};
    final static private String[] speciesList = {"Human", "Kel Dor", "Nikto", "Twi'lek", "Unidentified"};
    final static private Random RANDOM = new SecureRandom();

    final private Map<String, StormTrooper> trooperMap = Collections.synchronizedSortedMap(new TreeMap<String, StormTrooper>());

    public DefaultStormTrooperDao() {
        for (int i = 0; i < 50; i++) {
            addStormtrooper(randomTrooper());
        }
    }

	@Override
	public Collection<StormTrooper> listStormtroopers() {
		return Collections.unmodifiableCollection(trooperMap.values());
	}

	@Override
	public StormTrooper getStormtrooper(String id) {
		return trooperMap.get(id);
	}

	@Override
	public StormTrooper addStormtrooper(StormTrooper stormtrooper) {
		if (stormtrooper.getId() == null || stormtrooper.getId().trim().isEmpty()) {
            stormtrooper.setId(generateRandomId());
        }
        trooperMap.put(stormtrooper.getId(), stormtrooper);
        return stormtrooper;
	}

	@Override
	public StormTrooper updateStormtrooper(String id, StormTrooper stormtrooper) {
		// we are just backing with a map, so just call add.
        // NOTE: this does NOT cover all use-cases, null objects, id change, etc.
        return addStormtrooper(stormtrooper);
	}

	@Override
	public boolean deleteStormtrooper(String id) {
		return trooperMap.remove(id) != null;
	}
	
	///////////////////////////////////
	//  Dummy data generating below  //
	///////////////////////////////////
	
	private static StormTrooper randomTrooper(String id) {
	String planet = planetsList[RANDOM.nextInt(planetsList.length)];
	String species = speciesList[RANDOM.nextInt(speciesList.length)];
	String type = trooperTypes[RANDOM.nextInt(trooperTypes.length)];
	
	return new StormTrooper(id, planet, species, type);
	}
	
	private static String generateRandomId() {
	// HIGH chance of collisions, but, this is all for fun...
	return "FN-"  + String.format("%04d", RANDOM.nextInt(9999));
	}
	
	private static StormTrooper randomTrooper() {
	return randomTrooper(generateRandomId());
	}

}
