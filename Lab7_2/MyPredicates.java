package Lab7_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
	 Iterator<T> it = coll.iterator();
	 while(it.hasNext()) {
		 T t = it.next();
		 if(p.test(t)) {
			 it.remove();
		 }
	 }
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> it = coll.iterator();
		while(it.hasNext()) {
			T t = it.next();
			if(!p.test(t)) {
				it.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> set = new HashSet<>();
		for(T t : coll) {
			if(p.test(t)) {
				set.add(t);
			}
		}
		return set;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for(T t : coll) {
			if(p.test(t)) {
				return index;
			}
			index++;
			
		}
		return -1;
	}
}

