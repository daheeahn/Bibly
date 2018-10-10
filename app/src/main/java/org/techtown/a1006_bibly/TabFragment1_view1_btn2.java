package org.techtown.a1006_bibly;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class TabFragment1_view1_btn2 extends Fragment implements OnClickListener {

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.tab_fragment_1_recyclerview_btn_container, container, false);
        ButterKnife.bind(this, view);

        //recyclerview
        context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        TabFragment1_MyRecyclerViewAdapter_Small adapter = new TabFragment1_MyRecyclerViewAdapter_Small(1, context);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        return view;
    }

    @Override
    public void onButtonClick(Fragment fragment) {

    }

    @Override
    public void onBookClick(BookInfo bookInfo) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra("bookInfo", bookInfo);
        startActivity(intent);

    }

    @Override
    public void onRecommendDetailButtonClick() {

    }

    //    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        null.unbind();
//    }
}