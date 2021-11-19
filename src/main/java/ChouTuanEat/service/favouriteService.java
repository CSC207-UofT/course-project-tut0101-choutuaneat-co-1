package ChouTuanEat.service;

import ChouTuanEat.entity.favourites;
import ChouTuanEat.entity.Dishes;
import java.util.List;
public interface favouriteService {

    Long getId();

    favourites getListByUserId(Long id);

    void saveOrUpdate(favourites favourite);

    List<Dishes> getFavouriteList(favourites favourite);

    Dishes[] getSortedFavouriteList(favourites favourite, String method);

}
