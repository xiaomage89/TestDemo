package it.com.service.impl;


import it.com.dao.FavoriteDao;
import it.com.dao.impl.FavoriteDaoImpl;
import it.com.service.FavoriteService;
import it.com.vo.Favorite;

public class FavoriteServiceImpl implements FavoriteService {

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public int favoriteCount(String rid) {
        int favoriteCount = favoriteDao.favoriteCount(Integer.parseInt(rid));

        return favoriteCount;
    }

    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);

        return favorite != null;//如果对象有值，则为true，反之，则为false
    }

    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}
