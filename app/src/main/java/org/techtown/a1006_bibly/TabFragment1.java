package org.techtown.a1006_bibly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabFragment1 extends Fragment implements View.OnClickListener {


    private FragmentActivity myContext;
    private FragmentManager fragManager;
    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;
    @BindView(R.id.btn3) Button btn3;
    @BindView(R.id.btn4) Button btn4;
    @BindView(R.id.btn5) Button btn5;
    @BindView(R.id.btn_detail) TextView btn_detail;

    TabFragment1_view1_btn1 fragment1;
    TabFragment1_view1_btn2 fragment2;
    TabFragment1_view1_btn3 fragment3;
    TabFragment1_view1_btn4 fragment4;
    TabFragment1_view1_btn5 fragment5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        ButterKnife.bind(this, view);

        fragment1 = new TabFragment1_view1_btn1();
        fragment2 = new TabFragment1_view1_btn2();
        fragment3 = new TabFragment1_view1_btn3();
        fragment4 = new TabFragment1_view1_btn4();
        fragment5 = new TabFragment1_view1_btn5();

        fragManager = myContext.getSupportFragmentManager();
        fragManager.beginTransaction().add(R.id.tabfragment1_container1, fragment1).commit();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn_detail.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        Fragment selected = null;

        switch (v.getId()) {
            case R.id.btn_detail:
                Intent intent = new Intent(getActivity(), RecommendDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1:
                selected = fragment1;
                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
                break;
            case R.id.btn2:
                selected = fragment2;
                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
                break;
            case R.id.btn3:
                selected = fragment3;
                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
                break;
            case R.id.btn4:
                selected = fragment4;
                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
                break;
            case R.id.btn5:
                selected = fragment5;
                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
                break;

        }


    }

}

