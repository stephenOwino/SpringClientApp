package com.stephenowino.Retrofit;

import com.stephenowino.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeApi {

    //specify the API Structure.
    @GET("/employee/get-all")
    Call<List<Employee>>getAllEmployees();


    @POST("/employee/save")
    Call<Employee>save(@Body Employee employee);





}
