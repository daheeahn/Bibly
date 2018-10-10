package org.techtown.a1006_bibly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainFragment extends Fragment implements OnClickListener {

    Context context;
    RecyclerView recyclerView;

    private FragmentActivity myContext;
    private FragmentManager fragManager;
    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        ButterKnife.bind(this, view);

        //recyclerview
        context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        TabFragment1_MyRecyclerViewAdapter_Big adapter =
                new TabFragment1_MyRecyclerViewAdapter_Big(context, getLists());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        return view;
    }


    public ArrayList<RecommendType> getLists(){
        ArrayList<RecommendType> recommendTypes = new ArrayList<>();
        recommendTypes.add(new RecommendType("장르"));
        recommendTypes.add(new RecommendType("기분"));
        recommendTypes.add(new RecommendType("날씨"));
        return recommendTypes;

    }
    @Override
    public void onButtonClick(Fragment fragment) {

        TabFragment1_MyRecyclerViewAdapter_Big adapter =
                new TabFragment1_MyRecyclerViewAdapter_Big(context, getLists());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

    }

    @Override
    public void onBookClick(BookInfo bookInfo) {

    }

    @Override
    public void onRecommendDetailButtonClick() {
        Intent intent = new Intent(context, RecommendDetailActivity.class);
        startActivity(intent);
    }
}

