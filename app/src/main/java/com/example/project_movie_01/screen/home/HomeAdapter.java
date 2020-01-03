package com.example.project_movie_01.screen.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.data.model.Popular;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Popular> mPopulars;

    public HomeAdapter(List<Popular> populars) {
        mPopulars = populars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_film_genres, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Popular popular = mPopulars.get(position);
        holder.mTextViewTitle.setText(popular.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPopulars == null ? 0 : mPopulars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTitle = itemView.findViewById(R.id.text_title_film);
        }

    }
}
