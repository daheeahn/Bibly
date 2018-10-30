package org.techtown.a1006_bibly;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class RecommendDetailKindFragment_Kind1 extends Fragment {
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_detail_kind_fragment, container, false);
        ButterKnife.bind(this, view);

        //recyclerview
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recommendDetailKindFragment_Recyclerview);
        context = view.getContext();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        RecommendDetailKindFragment_RecyclerViewAdapter adapter
                = new RecommendDetailKindFragment_RecyclerViewAdapter(1);
        recyclerView.setAdapter(adapter);
        //adapter.setClickListener(this);

        return view;
    }

    public RecommendDetailKindFragment_Kind1() {

    }


}
