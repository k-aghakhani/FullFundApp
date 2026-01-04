package com.aghakhani.fullfundapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aghakhani.fullfundapp.R;
import com.aghakhani.fullfundapp.data.model.Post;
import com.aghakhani.fullfundapp.databinding.ActivityMainBinding;

import java.util.List;

/**
 * Main screen (Phase 1):
 * - Loads a list of posts (mocked for now)
 * - Displays them in a RecyclerView
 * - Opens the provided link when an item is clicked
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;
    private PostViewModel vm;
    private PostAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setSupportActionBar(b.toolbar);


// Ensure the default ActionBar title/subtitle don't interfere with our custom centered header.
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setSubtitle("");
        }


        vm = new ViewModelProvider(this).get(PostViewModel.class);

        setupRecycler();
        setupActions();
        observeState();

        vm.load();
    }

    private void setupRecycler() {
        adapter = new PostAdapter(this::openPostLink);

        b.recycler.setLayoutManager(new LinearLayoutManager(this));
        b.recycler.setAdapter(adapter);

        int space = (int) (getResources().getDisplayMetrics().density * 8);
        b.recycler.addItemDecoration(new SpacingItemDecoration(space));
    }

    private void setupActions() {
        b.swipeRefresh.setOnRefreshListener(() -> vm.load());
        b.btnRetry.setOnClickListener(v -> vm.load());
    }

    private void observeState() {
        vm.getState().observe(this, state -> {
            b.swipeRefresh.setRefreshing(false);

            if (state == null) return;

            switch (state.status) {
                case LOADING:
                    showLoading(true);
                    hideStateView();
                    break;

                case SUCCESS:
                    showLoading(false);
                    hideStateView();
                    submitList(state.data);
                    break;

                case EMPTY:
                    showLoading(false);
                    submitList(null);
                    showEmptyState();
                    break;

                case ERROR:
                    showLoading(false);
                    submitList(null);
                    showErrorState(state.message);
                    break;
            }
        });
    }

    private void submitList(List<Post> posts) {
        adapter.submitList(posts);
    }

    private void showLoading(boolean show) {
        b.progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void hideStateView() {
        b.stateView.setVisibility(View.GONE);
    }

    private void showEmptyState() {
        b.stateView.setVisibility(View.VISIBLE);
        b.stateIcon.setImageResource(R.drawable.ic_inbox);
        b.stateTitle.setText(getString(R.string.empty_title));
        b.stateDesc.setText(getString(R.string.empty_desc));
        b.btnRetry.setVisibility(View.GONE);
    }

    private void showErrorState(String message) {
        b.stateView.setVisibility(View.VISIBLE);
        b.stateIcon.setImageResource(R.drawable.ic_inbox);
        b.stateTitle.setText(getString(R.string.error_title));
        b.stateDesc.setText(message != null ? message : getString(R.string.error_desc));
        b.btnRetry.setVisibility(View.VISIBLE);
    }

    private void openPostLink(Post post) {
        if (post == null || !post.hasLink()) {
            Toast.makeText(this, "لینک برای این مورد ثبت نشده است", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri uri = Uri.parse(post.getLink().trim());

        // Prefer Chrome Custom Tabs for a smoother UX.
        try {
            CustomTabsIntent intent = new CustomTabsIntent.Builder().build();
            intent.launchUrl(this, uri);
        } catch (Exception e) {
            // Fallback to regular browser intent.
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            } catch (Exception ex) {
                Toast.makeText(this, "امکان باز کردن لینک وجود ندارد", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
