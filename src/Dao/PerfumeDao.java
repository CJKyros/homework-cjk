package Dao;

import entity.Perfume;

import java.util.List;

public interface PerfumeDao {
    List<Perfume> listAll();
    Perfume getPerfumeById(int id);
    List<Perfume> getPerfumesByName(String name);
    boolean update(Perfume perfume);
    boolean delete(int id);
    Perfume add(Perfume perfume);
}
