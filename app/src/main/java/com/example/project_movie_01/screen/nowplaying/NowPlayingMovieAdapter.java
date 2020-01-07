package com.example.project_movie_01.screen.nowplaying;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_movie_01.R;
import com.example.project_movie_01.data.model.NowPlayingMovie;
import java.util.List;

public class NowPlayingMovieAdapter extends RecyclerView.Adapter<NowPlayingMovieAdapter.NowPlayingViewHolder> {
    private List<NowPlayingMovie> mData;
    private LayoutInflater mLayoutInflater;
    private OnClickNowPlayingListener mOnClickNowPlayingListener;

    public void setData(List<NowPlayingMovie> data) {
        mData = data;
    }

    public NowPlayingMovieAdapter(OnClickNowPlayingListener onClickNowPlayingListener) {
        mOnClickNowPlayingListener = onClickNowPlayingListener;
    }

    public NowPlayingMovieAdapter(List<NowPlayingMovie> data) {
        mData = data;
    }

    @NonNull
    @Override
    public NowPlayingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_genres_movie, parent, false);
        return new NowPlayingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingViewHolder holder, int position) {
        holder.display(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class NowPlayingViewHolder extends RecyclerView.ViewHolder {
        TextView mTextTiTleFilm;
        TextView mTextPopularity;
        TextView mTextVoteAverage;
        TextView mTextReleaseDate;
        ImageView mImagePosterPath;
        NowPlayingMovie mNowPlaying;

        public NowPlayingViewHolder(@NonNull View itemView) {
            super(itemView);
            initComponents();
            registerListener();
        }

        private void registerListener() {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickNowPlayingListener.onClickNowPlayingListener(mNowPlaying);
                }
            });
        }

        private void initComponents() {
            mTextTiTleFilm = itemView.findViewById(R.id.text_title_film);
            mTextPopularity = itemView.findViewById(R.id.text_popularity);
            mTextVoteAverage = itemView.findViewById(R.id.text_vote_average);
            mTextReleaseDate = itemView.findViewById(R.id.text_release_date);
            mImagePosterPath = itemView.findViewById(R.id.image_poster_path);
        }

        public void display(NowPlayingMovie nowPlaying) {
            String url = nowPlaying.getImageFullUrl();
            Glide.with(itemView.getContext()).load(url).
                    placeholder(R.drawable.loading_shape).into(mImagePosterPath);
            mTextPopularity.setText(nowPlaying.getTitle());
            mTextPopularity.setText(nowPlaying.getPopularity());
            mTextVoteAverage.setText(nowPlaying.getVoteAverage());
            mTextReleaseDate.setText(nowPlaying.getReleaseDate());
        }
    }

    interface OnClickNowPlayingListener {
        void onClickNowPlayingListener(NowPlayingMovie nowPlaying);
    }
}
