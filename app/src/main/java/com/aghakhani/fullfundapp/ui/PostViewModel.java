package com.aghakhani.fullfundapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aghakhani.fullfundapp.data.model.Post;
import com.aghakhani.fullfundapp.data.repository.PostRepository;

import java.util.List;

/**
 * ViewModel responsible for loading posts and exposing UI-friendly state.
 */
public class PostViewModel extends ViewModel {

    private final MutableLiveData<UiState<List<Post>>> state = new MutableLiveData<>();
    private final PostRepository repository = new PostRepository();

    public LiveData<UiState<List<Post>>> getState() {
        return state;
    }

    /**
     * Loads the feed for the main screen.
     */

    public void load() {
        state.setValue(UiState.loading());

        repository.fetchPosts(1, 30, new PostRepository.RepoCallback() {
            @Override
            public void onSuccess(List<Post> posts) {
                if (posts == null || posts.isEmpty()) {
                    state.setValue(UiState.empty());
                } else {
                    state.setValue(UiState.success(posts));
                }
            }

            @Override
            public void onError(String message) {
                state.setValue(UiState.error(message));
            }
        });
    }

}
