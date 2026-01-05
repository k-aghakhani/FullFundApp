package com.aghakhani.fullfundapp.data.repository;

import com.aghakhani.fullfundapp.data.model.Post;
import com.aghakhani.fullfundapp.data.model.PostsResponse;
import com.aghakhani.fullfundapp.data.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Data repository for the posts feed.
 * Phase 1 (online): Fetches posts from the PHP/MySQL backend.
 */
public class PostRepository {

    public interface RepoCallback {
        void onSuccess(List<Post> posts);
        void onError(String message);
    }

    public void fetchPosts(int page, int limit, RepoCallback callback) {
        RetrofitClient.api().getPosts(page, limit).enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    callback.onError("Server response error (" + response.code() + ")");
                    return;
                }

                List<Post> data = response.body().getData();
                callback.onSuccess(data);
            }

            @Override
            public void onFailure(Call<PostsResponse> call, Throwable t) {
                callback.onError("Network error: " + (t.getMessage() != null ? t.getMessage() : "Unknown"));
            }
        });
    }
}
