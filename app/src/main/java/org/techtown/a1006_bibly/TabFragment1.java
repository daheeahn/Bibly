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

import butterknife.ButterKnife;

public class TabFragment1 extends Fragment implements OnButtonClickListener {

    Context context;

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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        TabFragment1_MyRecyclerViewAdapter_Big adapter =
                new TabFragment1_MyRecyclerViewAdapter_Big(context);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        return view;
    }

    @Override
    public void onClick(Fragment fragment) {
        fragManager = myContext.getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.tabfragment1_container1, fragment).commit();
    }
}

