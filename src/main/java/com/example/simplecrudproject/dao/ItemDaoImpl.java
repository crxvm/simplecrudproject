package com.example.simplecrudproject.dao;


import com.example.simplecrudproject.model.Item;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Repository
public class ItemDaoImpl implements ItemDao {
    @PersistenceContext
    EntityManager em;

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateDescription(String name, String description) {
        Item item = getItemByName(name);
        item.setDescription(description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Item item) {
        em.persist(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItemByName(String name) {
        try{
            Item item = em.createQuery("Select i from Item i where i.name =: name", Item.class).setParameter("name", name).getSingleResult();
            return item;
        }
        catch (NoResultException e) {
            throw new NoResultException("cannot find item with name: " + name);
        }

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String name) {
        Item item = getItemByName(name);
        em.remove(item);
    }
}
