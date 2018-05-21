package com.example.asus.project.service;

import com.example.asus.project.model.CatagoryDao;
import com.example.asus.project.model.ContactDao;
import com.example.asus.project.model.EditAndSaveStatusDao;
import com.example.asus.project.model.HomeDao;
import com.example.asus.project.model.LevelDao;
import com.example.asus.project.model.ProjectDao;
import com.example.asus.project.model.SiteDao;
import com.example.asus.project.model.SiteEditDao;
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
    @GET("Service/get_sch")
    Call<List<ProjectDao>> get_sch();

    @GET("Service/get_team")
    Call<List<SystemDao>> get_team();

    @GET("Service/get_lv")
    Call<List<LevelDao>> get_lv();

    @GET("Service/get_ct_kn")
    Call<List<CatagoryDao>> get_ct_kn();

    @GET("Service/get_ctt")
    Call<List<ContactDao>> get_ctt();

    @FormUrlEncoded
    @POST("Service/get_sys")
    Call<List<SysDao>> get_sys(@Field("rq_scheme") String rq_scheme);


    @GET("Service/getSaveReportQuest")
    Call<List<EditAndSaveStatusDao>> getSaveReportQuest();

    @GET("Service/getSaveReportAnalysis")
    Call<List<EditAndSaveStatusDao>> getSaveReportAnalysis();

    @GET("Service/getSaveReportEdit")
    Call<List<EditAndSaveStatusDao>> getSaveReportEdit();

    @GET("Service/getSaveReportTest")
    Call<List<EditAndSaveStatusDao>> getSaveReportTest();

    @GET("Service/getSaveReportReport")
    Call<List<EditAndSaveStatusDao>> getSaveReportReport();

    @GET("Service/getSaveReportDone")
    Call<List<EditAndSaveStatusDao>> getSaveReportDone();

    @FormUrlEncoded
    @POST("Service/insertproject")
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

    @GET("Service/getSelectSite")
    Call<List<SiteDao>> getSelectSite();

    @GET("Service_home/get_graph")
    Call<HomeDao> getHome();

    @FormUrlEncoded
    @POST("Service/getSaveReportById")
    Call<List<SiteEditDao>> getSaveReportById(@Field("status_id") String status_id);

    @FormUrlEncoded
    @POST("Service/updateStatus")
    Call<List<Object>>updateStatus(@Field("status_id")String status_id);

}
