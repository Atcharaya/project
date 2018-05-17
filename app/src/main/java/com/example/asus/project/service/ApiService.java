package com.example.asus.project.service;

import com.example.asus.project.model.CatagoryDao;
import com.example.asus.project.model.ContactDao;
import com.example.asus.project.model.EditAndSaveStatusDao;
import com.example.asus.project.model.LevelDao;
import com.example.asus.project.model.ProjectDao;
import com.example.asus.project.model.Success;
import com.example.asus.project.model.SysDao;
import com.example.asus.project.model.SystemDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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

    @FormUrlEncoded
    @POST("get_sys")
    Call<List<SysDao>> get_sys(@Field("rq_scheme") String rq_scheme);


    @GET("getSaveReportQuest")
    Call<List<EditAndSaveStatusDao>> getSaveReportQuest();

    @GET("getSaveReportAnalysis")
    Call<List<EditAndSaveStatusDao>> getSaveReportAnalysis();

    @GET("getSaveReportEdit")
    Call<List<EditAndSaveStatusDao>> getSaveReportEdit();

    @GET("getSaveReportTest")
    Call<List<EditAndSaveStatusDao>> getSaveReportTest();

    @GET("getSaveReportReport")
    Call<List<EditAndSaveStatusDao>> getSaveReportReport();

    @GET("getSaveReportDone")
    Call<List<EditAndSaveStatusDao>> getSaveReportDone();

    @FormUrlEncoded
    @POST("insertproject")
    Call<Success> insert(@Field("rq_scheme") String rq_scheme,
                         @Field("rq_subject") String rq_subject,
                         @Field("rq_sys_id") String rq_sys_id,
                         @Field("rq_detail") String rq_detail,
                         @Field("rq_ct_id") String rq_ct_id,
                         @Field("rq_lv_id") String rq_lv_id,
                         @Field("rq_name_reply") String rq_name_reply,
                         @Field("rq_name") String rq_name,
                         @Field("rq_team_id") String rq_team_id,
                         @Field("rq_date") String rq_date);
}
