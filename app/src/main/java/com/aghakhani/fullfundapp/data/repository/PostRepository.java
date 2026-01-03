package com.aghakhani.fullfundapp.data.repository;

import android.os.Handler;
import android.os.Looper;

import com.aghakhani.fullfundapp.data.mock.MockPosts;
import com.aghakhani.fullfundapp.data.model.Post;

import java.util.List;

/**
 * Data repository for the posts feed.
 * In Phase 1, it returns mock data (no backend integration).
 * In Phase 2, this will be replaced with an API-driven implementation.
 */
public class PostRepository {

    public interface RepoCallback {
        void onSuccess(List<Post> posts);
        void onError(String message);
    }

    // Toggle this later when your PHP API is ready.
    private static final boolean USE_MOCK = true;

    public void fetchPosts(RepoCallback callback) {
        if (USE_MOCK) {
            // Simulate network latency for a realistic loading experience.
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                callback.onSuccess(MockPosts.getDefault());
            }, 700);
            return;
        }

        // TODO: Replace with API call implementation.
        callback.onError("Backend API is not connected yet.");
    }
}
