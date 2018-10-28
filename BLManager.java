package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.City;
import com.pojo.Country;
import com.pojo.State;

public class BLManager {

	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	public void saveCountry(Country country) 
	{
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(country);
		t.commit();
		s.close();	
	}
	public Country searchCountry(String cname) {
		Session s=sf.openSession();
		Criteria c=s.createCriteria(Country.class);
		c.add(Restrictions.eq("cname", cname));
		Country country=new Country();
		country=(Country) c.uniqueResult();
		return country;
	}
	public void saveState(State state) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(state);
		t.commit();
		s.close();	
		
	}
	public State searchState(String sname) {
		Session s=sf.openSession();
		Criteria c=s.createCriteria(State.class);
		c.add(Restrictions.eq("sname", sname));
		State state=new State();
		state=(State) c.uniqueResult();
		return state;
	}
	public void saveCity(City city) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(city);
		t.commit();
		s.close();
		
	}
	public List<City> getCityList()
	{
		Session s=sf.openSession();
		Criteria c=s.createCriteria(City.class);
		@SuppressWarnings("unchecked")
		List<City> list=c.list();
		System.out.println(list);
		return list;
	}
	public City searchCity(int ciid) {
		Session s=sf.openSession();
		Criteria c=s.createCriteria(City.class);
		c.add(Restrictions.eq("ciid", ciid));
		City city=new City();
		city=(City) c.uniqueResult();
		return city;
		
	}
	public void deleteCity(City city) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.delete(city);
		t.commit();
		s.close();
	}
	public void updateData(City city) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(city);
		t.commit();
		s.close();
		
	}

}
