package com.example.project_movie_01.screen.home.genres.toprated;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.data.repository.GenresReponsitory;
import com.example.project_movie_01.screen.home.genres.GenresAdapter;
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class TopRatedMovieFragment extends BaseFragment implements GenresAdapter.OnClickGenresListener
        , TopRatedMovieContract.view {
    private RecyclerView mRecyclerViewTopRated;
    private GenresAdapter mGenresAdapter;
    private TopRatedMoviePresenter mTopRatedMoviePresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerViewTopRated = view.findViewById(R.id.recycler_movie_upcoming);
        mGenresAdapter = new GenresAdapter(this);
        mRecyclerViewTopRated.setAdapter(mGenresAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        mRecyclerViewTopRated.setLayoutManager(linearLayoutManager);
        mTopRatedMoviePresenter = new TopRatedMoviePresenter(
                GenresReponsitory.getInstance(), this);
        mTopRatedMoviePresenter.getTopRatedMovie();
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_toprated_movie;
    }

    @Override
    public void onGetTopRatedMovieSuccess(List<Genres> genres) {
        mGenresAdapter.setData(genres);
        mGenresAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetTopRatedMovieFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickGenresListener(Genres genres) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }
}
