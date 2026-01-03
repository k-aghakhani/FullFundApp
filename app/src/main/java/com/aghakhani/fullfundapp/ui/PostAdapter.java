package com.aghakhani.fullfundapp.ui;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aghakhani.fullfundapp.data.model.Post;
import com.aghakhani.fullfundapp.databinding.ItemPostBinding;

/**
 * RecyclerView adapter for displaying Post items in a modern Material card layout.
 */
public class PostAdapter extends ListAdapter<Post, PostAdapter.VH> {

    public interface OnPostClick {
        void onClick(Post post);
    }

    private final OnPostClick listener;

    public PostAdapter(OnPostClick listener) {
        super(DIFF);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<Post> DIFF = new DiffUtil.ItemCallback<Post>() {
        @Override
        public boolean areItemsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Post oldItem, @NonNull Post newItem) {
            return safe(oldItem.getTitle()).equals(safe(newItem.getTitle()))
                    && safe(oldItem.getUniversity()).equals(safe(newItem.getUniversity()))
                    && safe(oldItem.getCountry()).equals(safe(newItem.getCountry()))
                    && safe(oldItem.getCountryCode()).equals(safe(newItem.getCountryCode()))
                    && safe(oldItem.getLevel()).equals(safe(newItem.getLevel()))
                    && safe(oldItem.getFundType()).equals(safe(newItem.getFundType()))
                    && safe(oldItem.getDeadline()).equals(safe(newItem.getDeadline()))
                    && safe(oldItem.getLink()).equals(safe(newItem.getLink()));
        }

        private String safe(String s) { return s == null ? "" : s; }
    };

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull android.view.ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(getItem(position));
    }

    class VH extends RecyclerView.ViewHolder {

        private final ItemPostBinding b;

        VH(ItemPostBinding binding) {
            super(binding.getRoot());
            this.b = binding;
        }

        void bind(Post post) {
            b.tvTitle.setText(safe(post.getTitle()));

            String subtitle = safe(post.getUniversity());
            if (subtitle.isEmpty()) subtitle = safe(post.getCountry());
            b.tvSubtitle.setText(subtitle);

            b.chipCountry.setText(safe(post.getCountry()));
            b.chipLevel.setText(safe(post.getLevel()));
            b.chipFund.setText(safe(post.getFundType()));

            setChipVisibility(b.chipCountry);
            setChipVisibility(b.chipLevel);
            setChipVisibility(b.chipFund);

            if (!safe(post.getDeadline()).isEmpty()) {
                b.tvDeadline.setVisibility(View.VISIBLE);
                b.tvDeadline.setText("Deadline: " + post.getDeadline());
            } else {
                b.tvDeadline.setVisibility(View.GONE);
            }

            // Flag icon mapping by country code.
            b.imgFlag.setImageResource(FlagMapper.flagRes(post.getCountryCode()));

            b.getRoot().setOnClickListener(v -> {
                if (listener != null) listener.onClick(post);
            });
        }

        private void setChipVisibility(com.google.android.material.chip.Chip chip) {
            CharSequence text = chip.getText();
            chip.setVisibility((text == null || text.toString().trim().isEmpty()) ? View.GONE : View.VISIBLE);
        }

        private String safe(String s) { return s == null ? "" : s; }
    }
}
