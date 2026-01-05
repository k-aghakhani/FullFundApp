package com.aghakhani.fullfundapp.data.remote;

import com.aghakhani.fullfundapp.data.model.PostsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit API definitions.
 */
public interface ApiService {

    /**
     * Example:
     * GET https://rasfam.ir/fullfundapp/api/posts.php?page=1&limit=30
     */
    @GET("api/posts.php")
    Call<PostsResponse> getPosts(
            @Query("page") int page,
            @Query("limit") int limit
    );
}
