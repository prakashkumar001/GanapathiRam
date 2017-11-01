package com.ganapathyram.theatre.helper;

import android.content.Context;


import com.ganapathyram.theatre.database.Categories;
import com.ganapathyram.theatre.database.DaoSession;
import com.ganapathyram.theatre.database.Login;
import com.ganapathyram.theatre.database.Product;
import com.ganapathyram.theatre.database.ProductDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Creative IT Works on 10-Aug-17.
 */

public class Helper {
    private final DaoSession daoSession;

    Context context;


    public Helper(DaoSession daoSession, Context context) {
        this.daoSession = daoSession;
        this.context = context;
        helper = this;
    }

    public static Helper getHelper() {
        return helper;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Helper helper;



    //getMenuItems
    public List<Categories> getCategoryItems() {

        QueryBuilder<Categories> qb = daoSession.queryBuilder(Categories.class);
        return qb.list();

    }

    //getMenuItems
    public List<Product> getProductItems(String categoryId) {

        QueryBuilder<Product> qb = daoSession.queryBuilder(Product.class);
        qb.where(ProductDao.Properties.CategoryUid.eq(categoryId));

        return qb.list();

    }

    //getLogin
    public Login getLogin() {

        QueryBuilder<Login> qb = daoSession.queryBuilder(Login.class);
        return qb.unique();

    }

}
