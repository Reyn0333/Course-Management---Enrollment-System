package com.example.enrollmentsystem;

import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/login/")
    Call<DataTable>login(@Body DataTable request); }