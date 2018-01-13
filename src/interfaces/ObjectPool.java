/**
 * Creator: Dutsadi Bunliang, Created: 2017-12-21 14:36:58 Updated: 
 */
package interfaces;

import java.util.HashMap;
import java.util.Map.Entry;

public interface ObjectPool {
	//VARIABLES

	
	//METHODS
	static void add(String id, Object o) {
		PoolHolder.pool.put(id, o);
	}
	
	static void addOf(Object... keyValue) {
		if(keyValue.length % 2 == 0) {
			for(int i = 0; i < keyValue.length - 1; i += 2) {
				PoolHolder.pool.put((String) keyValue[i], keyValue[i+1]);
			}
			
		}else {
			try {
				throw new ObjectPoolException("Incomplete key-value pair");
			} catch (ObjectPoolException e) {
				e.printStackTrace();
			}
		}
	}
	
	default Object getObject(String id) {
		return PoolHolder.pool.get(id);
	}
	
	default void printObject() {
		for(Entry<String, Object> entry : PoolHolder.pool.entrySet()) {
			System.out.println("Key: " + entry.getKey()+ " Value: " + entry.getValue());
		}
	}
	
	//Nested class
    public static class PoolHolder {
		//VARIABLES
		private static HashMap<String, Object> pool = new HashMap<>();
		 
		//CONSTRUCTORS
		private PoolHolder() {
			
		}
		
	}
	
}
