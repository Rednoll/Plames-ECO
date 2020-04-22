package enterprises.inwaiders.plames.eco.domain.roles.additionals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;

import enterprises.inwaiders.plames.eco.domain.roles.Role;

@Embeddable
public class RolesStorage implements Collection<Role> {

	@ManyToMany
	private Set<Role> roles = new HashSet<>();

	public RolesStorage() {
		
	}
	
	@Override
	public int size() {
		
		return roles.size();
	}

	@Override
	public boolean isEmpty() {
		
		return roles.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return roles.contains(o);
	}

	@Override
	public Object[] toArray() {
		
		return roles.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return roles.toArray(a);
	}

	@Override
	public boolean add(Role e) {
		
		return roles.add(e);
	}

	@Override
	public boolean remove(Object o) {
		
		return roles.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		return roles.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Role> c) {
		
		return roles.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		return roles.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return roles.retainAll(c);
	}

	@Override
	public void clear() {
		
		roles.clear();
	}

	@Override
	public Iterator<Role> iterator() {
		
		return roles.iterator();
	}
}
