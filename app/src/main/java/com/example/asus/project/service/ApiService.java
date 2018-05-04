package com.example.asus.project.service;

import com.example.asus.project.model.CatagoryDao;
import com.example.asus.project.model.ContactDao;
import com.example.asus.project.model.LevelDao;
import com.example.asus.project.model.ProjectDao;
import com.example.asus.project.model.SystemDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASUS on 3/5/2561.
 */

public interface ApiService {
    @GET("get_sch")
    Call<List<ProjectDao>> get_sch();

    @GET("get_team")
    Call<List<SystemDao>> get_team();

    @GET("get_lv")
    Call<List<LevelDao>> get_lv();

    @GET("get_ct_kn")
    Call<List<CatagoryDao>> get_ct_kn();

    @GET("get_ctt")
    Call<List<ContactDao>> get_ctt();
}
