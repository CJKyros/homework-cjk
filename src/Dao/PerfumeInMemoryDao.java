package Dao;

import entity.Perfume;

import java.util.ArrayList;
import java.util.List;

public class PerfumeInMemoryDao implements PerfumeDao {

    private static List<Perfume> perfumeDB = new ArrayList<>();

    static {
        Perfume p1 = new Perfume(1,"香奈儿香水",500f,"20ml","花香");
        Perfume p2 = new Perfume(1,"迪奥香水",500f,"30ml","草香");
        Perfume p3 = new Perfume(1,"LV香水",500f,"40ml","山香");
        Perfume p4 = new Perfume(1,"Gucci香水",500f,"50ml","海香");
        Perfume p5 = new Perfume(1,"圣罗兰香水",500f,"60ml","木香");

        perfumeDB.add(p1);
        perfumeDB.add(p2);
        perfumeDB.add(p3);
        perfumeDB.add(p4);
        perfumeDB.add(p5);
    }

    @Override
    public List<Perfume> listAll() {
        return perfumeDB;
    }

    @Override
    public Perfume getPerfumeById(int id) {
        for (Perfume perfume : perfumeDB) {
            if(perfume.getId() == id) {
                return perfume;
            }
        }
        return null;
    }

    @Override
    public List<Perfume> getPerfumesByName(String name) {
        ArrayList<Perfume> perfumes = new ArrayList<>();
        for (Perfume perfume : perfumeDB) {
            String realName = perfume.getName().toLowerCase();
            if (realName.contains(name.toLowerCase())) {
                perfumes.add(perfume);
            }
        }
        return perfumes;
    }

    @Override
    public boolean update(Perfume perfume) {
        for (Perfume perfumeNew : perfumeDB){
            if(perfumeNew.getId() == perfume.getId()){
                perfumeNew.setName(perfume.getName());
                perfumeNew.setPrice(perfume.getPrice());
                perfumeNew.setCapacity(perfume.getCapacity());
                perfumeNew.setOther(perfume.getOther());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Perfume perfume : perfumeDB) {
            if(perfume.getId()==id){
                return perfumeDB.remove(perfume);
            }
        }
        return false;
    }

    @Override
    public Perfume add(Perfume perfume) {
        if(perfumeDB.add(perfume)){
            return perfume;
        }
        return null;
    }
}
