package com.nagihome.samplewebapp.temp.ch04;

import com.nagihome.samplewebapp.temp.AudioDisc;
import com.nagihome.samplewebapp.temp.Disc;
import com.nagihome.samplewebapp.temp.H2SessionUtil;
import com.nagihome.samplewebapp.temp.VideoDisc;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Recipe1Test {

    @BeforeMethod
    public void clearAll() {
        Session s = H2SessionUtil.getSession();
        Transaction tx = s.beginTransaction();
        s.createQuery("delete from Disc").executeUpdate();
        tx.commit();
        s.close();
    }

    @Test
    public void testHierarchy() throws Exception {
        Session session = H2SessionUtil.getSession();
        Transaction tx = session.beginTransaction();

        Disc disc = new Disc();
        disc.setName("Blank CDR");
        disc.setPrice(199D);
        session.save(disc);

        VideoDisc videoDisc = new VideoDisc();
        videoDisc.setName("Blazing Saddles");
        videoDisc.setPrice(1499D);
        videoDisc.setDirector("Mel Brooks");
        videoDisc.setLanguage("english");
        session.save(videoDisc);

        AudioDisc audioDisc = new AudioDisc();
        audioDisc.setName("Grace Under Pressure");
        audioDisc.setPrice(999D);
        audioDisc.setArtist("Rush");
        audioDisc.setTrackCount(8);
        session.save(audioDisc);

        tx.commit();
        session.close();

        session = H2SessionUtil.getSession();
        tx = session.beginTransaction();
        Disc d = session.load(Disc.class, disc.getId());
        Assert.assertEquals(disc.getName(), d.getName());

        VideoDisc vd = session.load(VideoDisc.class, videoDisc.getId());
        Assert.assertEquals(videoDisc.getDirector(), vd.getDirector());

        tx.commit();
        session.close();
    }

    @Test
    public void showGeneralQueryByPrice() throws Exception {

        testHierarchy();

        Session s = H2SessionUtil.getSession();
        s.setDefaultReadOnly(true);
        Transaction tx = s.beginTransaction();
        Query query = s.createQuery("from Disc d where d.price > :price");
        query.setParameter("price", 1299D);
        List<Disc> discs = query.list();
        Assert.assertEquals(discs.size(), 1);
        Assert.assertEquals(discs.get(0).getName(), "Blazing Saddles");
        tx.commit();
        s.close();
    }

    @Test
    public void showGeneralQuery() throws Exception {
        testHierarchy();
        Session s = H2SessionUtil.getSession();
        Transaction tx = s.beginTransaction();
        List<Disc> discs = s.createQuery("from Disc").list();
        Assert.assertEquals(discs.size(), 3);
        for (Disc d : discs) {
            switch (d.getClass().getSimpleName()) {
                case "Disc":
                    System.out.println("This is Disc");
                    Assert.assertEquals(d.getName(), "Blank CDR");
                    break;
                case "VideoDisc":
                    System.out.println("This is Video Disc");
                    Assert.assertEquals(((VideoDisc)d).getDirector(), "Mel Brooks");
                    break;
                case "AudioDisc":
                    System.out.println("This is Audio Disc");
                    Assert.assertEquals(((AudioDisc)d).getArtist(), "Rush");
                    break;
            }
        }
        tx.commit();
        s.close();

    }


}
