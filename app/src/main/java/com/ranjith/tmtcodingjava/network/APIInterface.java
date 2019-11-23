package com.ranjith.tmtcodingjava.network;

import com.ranjith.tmtcodingjava.models.Home;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/test/home")
    Call<Home> doGetListResources();
}
