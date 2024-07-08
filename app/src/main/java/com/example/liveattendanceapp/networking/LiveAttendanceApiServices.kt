package com.example.liveattendanceapp.networking

import com.example.liveattendanceapp.model.ActivitiesOutResponse
import com.example.liveattendanceapp.model.AttendanceResponse
import com.example.liveattendanceapp.model.ChangePasswordResponse
import com.example.liveattendanceapp.model.ForgotPasswordResponse
import com.example.liveattendanceapp.model.HistoryResponse
import com.example.liveattendanceapp.model.LastLocation
import com.example.liveattendanceapp.model.LocationResponse
import com.example.liveattendanceapp.model.LoginResponse
import com.example.liveattendanceapp.model.LogoutResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap
import retrofit2.http.Query

interface LiveAttendanceApiServices {

    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/login")
    fun loginRequest(@Body body: String): Call<LoginResponse>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/password/forgot")
    fun forgotPasswordRequest(@Body body: String): Call<ForgotPasswordResponse>

    @Multipart
    @Headers("Accept: application/json")
    @POST("attendance")
    fun attend(@Header("Authorization") token: String,
               @PartMap params: HashMap<String, RequestBody>,
               @Part photo: MultipartBody.Part
    ): Call<AttendanceResponse>

    @Headers("Accept: application/json")
    @GET("attendance/history")
    fun getHistoryAttendance(@Header("Authorization") token: String,
                             @Query("from") fromDate: String,
                             @Query("to") toDate: String
    ): Call<HistoryResponse>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/logout")
    fun logoutRequest(@Header("Authorization") token: String): Call<LogoutResponse>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("auth/password/reset")
    fun changePassword(@Header("Authorization") token: String, @Body body: String): Call<ChangePasswordResponse>

    @Headers("Accept: application/json")
    @GET("locations/getLocation")
    fun getLocation(@Header("Authorization") token: String): Call<LocationResponse>


    @Headers("Accept: application/json")
    @POST("activitiesout")
    fun activity(@Header("Authorization") token: String,
               @PartMap params: HashMap<String, RequestBody>
    ): Call<ActivitiesOutResponse>


    @Headers("Accept: application/json", "Content-Type: application/json")
    @POST("activitiesout")
    fun activityRequest(@Header("Authorization") token: String, @Body body: String): Call<ActivitiesOutResponse>

}