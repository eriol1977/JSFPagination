/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

/**
 *
 * @author Francesco
 */
@Named("ccController")
@SessionScoped
public class CCController implements Serializable
{

    private PaginationHelper pagination;

    private DataModel items = null;

    private List<CC> allCCs;

    @PostConstruct
    public void init()
    {
        allCCs = new ArrayList<>();
        for (int i = 1; i < 38; i++) {
            allCCs.add(new CC(i, i * 5));
        }
    }

    public PaginationHelper getPagination()
    {
        if (pagination == null) {
            pagination = new PaginationHelper(7)
            {
                @Override
                public int getItemsCount()
                {
                    return allCCs.size();
                }

                @Override
                public DataModel createPageDataModel()
                {
                    List<CC> lista = allCCs.subList(getPageFirstItem(), getPageLastItem()+1);
                    return new ListDataModel(lista);
                }
            };
        }
        return pagination;
    }

    public DataModel getItems()
    {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    public void next()
    {
        getPagination().nextPage();
        items = getPagination().createPageDataModel();
    }

    public void previous()
    {
        getPagination().previousPage();
        items = getPagination().createPageDataModel();
    }
}
