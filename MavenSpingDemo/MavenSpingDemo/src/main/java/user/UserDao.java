/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author zz
 */
public class UserDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new guest:
    @Transactional
    public void persist(User user) {
        em.persist(user);
    }
 
    // Retrieves all the guests:
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery(
            "SELECT * FROM User g ORDER BY g.userId", User.class);
        return query.getResultList();
    }
}
