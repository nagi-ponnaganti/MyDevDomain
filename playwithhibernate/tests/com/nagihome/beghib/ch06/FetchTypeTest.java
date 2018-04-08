package com.nagihome.beghib.ch06;

import com.nagihome.beghib.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FetchTypeTest {

    @Test
    public void testFetchType() {

        long item1Id;
        long item2Id;
        long cartId;

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Cart cart = new Cart();
            cart.setName("Only Beer Cart");

            session.save(cart);

            Item item1 = new Item();
            item1.setName("Peroni");
            item1.setQuantity(2);
            item1.setTotal(5.32D);
            item1.setCart(cart);

            Item item2 = new Item();
            item2.setName("Budweiser");
            item2.setQuantity(3);
            item2.setTotal(6.22D);
            item2.setCart(cart);

            session.save(item1);
            session.save(item2);

            cart.setTotal(cart.getItemSet().stream().map(i -> i.getTotal()).reduce(0.0, (i1, i2) -> i1 + i2));

            item1Id = item1.getId();
            item2Id = item2.getId();

            cartId = cart.getId();

            tx.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();

            Cart cart = session.load(Cart.class, cartId);

            Assert.assertTrue(cart.getName().equals("Only Beer Cart"));
            Assert.assertTrue(cart.getItemSet().size() == 2);

            Item item1 = session.load(Item.class, item1Id);
            Assert.assertTrue(item1.getName().equals("Peroni"));

            Item item2 = session.load(Item.class, item2Id);
            Assert.assertTrue(item2.getName().equals("Budweiser"));

            tx.commit();

        }

    }

}
