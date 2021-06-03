package com.snapp.dev.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    
    private static RetrofitAPI dataProvider;
    private static Retrofit categoriesRetrofit;
    private static Retrofit productsRetrofit;

    /**
     * \brief       Method d'instanciation des Controlleur Retrofit
     * \details     On envoi une URL qui est l'adresse de L'API, et une String qui détermine le type d'api que nous voulons contacter.
     * \return      Void
     */

    private static void Instantiate(String r) {
        Gson gson = new GsonBuilder().setLenient().create();

        if (r.equals("categories")) {
            categoriesRetrofit = new Retrofit.Builder()
                    //you need to add your root url
                    .baseUrl("https://djemam.com/epsi/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        } else if (r.equals("products")) {
            productsRetrofit = new Retrofit.Builder()
                    //you need to add your root url
                    .baseUrl("https://djemam.com/epsi/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
    }

    /**
     * \brief       Method pour récupérer le controlleur rétrofit en charge des données textuel
     * \details     Si le Controlleur n'est pas instancié, il est instancié avec l'url de L'api tourinsoft.
     * \return      Objet Retrofit
     */
    private static Retrofit getCategoriesRetrofit() {
        if (categoriesRetrofit == null) {
            Instantiate("categories");
        }
        return categoriesRetrofit;
    }

    /**
     * \brief       Method pour récupérer le controlleur rétrofit en charge des médias
     * \details     Si le Controlleur n'est pas instancié, il est instancié avec l'url de L'api test.
     * \return      Objet Retrofit
     */
    //Todo Modifié l'Api des médias avec l'intégralité des médias
    private static Retrofit getProductsRetrofit() {
        if (productsRetrofit == null) {
            Instantiate("products");
        }
        return productsRetrofit;
    }

    public static RetrofitAPI getCategoryProvider() {
        dataProvider = getCategoriesRetrofit().create(RetrofitAPI.class);
        return dataProvider;
    }

    public static RetrofitAPI getProductProvider() {
        dataProvider = getProductsRetrofit().create(RetrofitAPI.class);
        return dataProvider;
    }
}
