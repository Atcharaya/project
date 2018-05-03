package com.example.asus.project.service;

import com.example.asus.project.model.ProjectDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASUS on 3/5/2561.
 */

public interface ApiService {
    @GET("get_sch")
    Call<List<ProjectDao>> get_sch();
}
