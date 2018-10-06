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

public class TabFragment1_view1_btn1 extends Fragment implements OnItemClickListener {

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.tab_fragment_1_recyclerview_container, container, false);

        //recyclerview
        context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        TabFragment1_MyRecyclerViewAdapter adapter =
                        new TabFragment1_MyRecyclerViewAdapter(0, context);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);



        return view;
    }

    @Override
    public void onClick(BookInfo bookInfo) {

        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra("bookInfo", bookInfo);
        startActivity(intent);

    }
}
