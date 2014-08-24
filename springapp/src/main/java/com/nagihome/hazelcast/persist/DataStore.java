/**
 * 
 */
package com.nagihome.hazelcast.persist;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.hazelcast.core.MapStore;

/**
 * @author Nagi
 *
 */
public class DataStore<K, V> implements MapStore<K, V> {

	@Override
	public V load(K arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<K, V> loadAll(Collection<K> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<K> loadAllKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(K arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<K> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void store(K arg0, V arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeAll(Map<K, V> arg0) {
		// TODO Auto-generated method stub
		
	}

}
