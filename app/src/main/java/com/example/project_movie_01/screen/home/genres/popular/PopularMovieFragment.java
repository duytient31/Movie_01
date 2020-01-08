package com.example.project_movie_01.screen.home.genres.popular;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.screen.home.genres.GenresAdapter;
import com.example.project_movie_01.data.repository.GenresReponsitory;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class PopularMovieFragment extends BaseFragment implements
        PopularMovieContract.View, GenresAdapter.OnClickGenresListener {
    private RecyclerView mRecyclerViewPopular;
    private GenresAdapter mGenresAdapter;
    private PopularMoviePresenter mPopularMoviePresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerViewPopular = view.findViewById(R.id.recycler_movie_popular);

        mGenresAdapter = new GenresAdapter(this);
        mRecyclerViewPopular.setAdapter(mGenresAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerViewPopular.setLayoutManager(layoutManager);

        mPopularMoviePresenter = new PopularMoviePresenter(this, GenresReponsitory.
                getInstance());
        mPopularMoviePresenter.getPopularMovie();
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popular_movie;
    }

    @Override
    public void onGetPopularMovieSucces(List<Genres> populars) {
        mGenresAdapter.setData(populars);
        mGenresAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetPoplarMovieFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickGenresListener(Genres genres) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }
}
