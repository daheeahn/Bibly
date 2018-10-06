package org.techtown.a1006_bibly;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabFragment1_view1_btn2 extends Fragment {

    int[] dummy_image = {R.drawable.dummy_2_1, R.drawable.dummy_2_2, R.drawable.dummy_2_3,
            R.drawable.dummy_2_4, R.drawable.dummy_2_5, R.drawable.dummy_2_6};

    @BindView(R.id.dummy1)
    ImageView dummy1;
    @BindView(R.id.dummy2)
    ImageView dummy2;
    @BindView(R.id.dummy3)
    ImageView dummy3;
    @BindView(R.id.dummy4)
    ImageView dummy4;
    @BindView(R.id.dummy5)
    ImageView dummy5;
    @BindView(R.id.dummy6)
    ImageView dummy6;

    ImageView[] dummy = {dummy1, dummy2, dummy3, dummy4, dummy5, dummy6};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.tab_fragment_1_view_1_btn_non_recycle, container, false);
        ButterKnife.bind(this, view);

        //recyclerview //오류
//        Context context = view.getContext();
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment1_recyclerview1);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager);
//
//        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(1);
//        recyclerView.setAdapter(adapter);

        //안되는 코드!
//        for (int i = 0; i < dummy.length; i++)
//            dummy[i].setImageResource(dummy_image[i]);

        dummy1.setImageResource(R.drawable.dummy_1_1);
        dummy2.setImageResource(R.drawable.dummy_1_2);
        dummy3.setImageResource(R.drawable.dummy_1_3);
        dummy4.setImageResource(R.drawable.dummy_1_4);
        dummy5.setImageResource(R.drawable.dummy_1_5);
        dummy6.setImageResource(R.drawable.dummy_1_6);


        return view;
    }


    @OnClick({R.id.dummy1, R.id.dummy2, R.id.dummy3, R.id.dummy4, R.id.dummy5, R.id.dummy6})
    void click(View v) {
        Intent myIntent;
        //Bitmap bitmap;
        switch (v.getId()) {
            case R.id.dummy1:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_1);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_1);
                myIntent.putExtra("title", "dummy_1_1");
                myIntent.putExtra("author", "person_1_1");
                startActivity(myIntent);
                break;

            case R.id.dummy2:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_2);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_2);
                myIntent.putExtra("title", "dummy_1_2");
                myIntent.putExtra("author", "person_1_2");
                startActivity(myIntent);
                break;

            case R.id.dummy3:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_3);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_3);
                myIntent.putExtra("title", "dummy_1_3");
                myIntent.putExtra("author", "person_1_3");
                startActivity(myIntent);
                break;

            case R.id.dummy4:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_4);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_4);
                myIntent.putExtra("title", "dummy_1_4");
                myIntent.putExtra("author", "person_1_4");
                startActivity(myIntent);
                break;

            case R.id.dummy5:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_5);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_5);
                myIntent.putExtra("title", "dummy_1_5");
                myIntent.putExtra("author", "person_1_5");
                startActivity(myIntent);
                break;

            case R.id.dummy6:
                myIntent = new Intent(getActivity(), BookDetailActivity.class);
//                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dummy_1_6);
//                myIntent.putExtra("book", bitmap);
                myIntent.putExtra("book", R.drawable.dummy_1_6);
                myIntent.putExtra("title", "dummy_1_6");
                myIntent.putExtra("author", "person_1_6");
                startActivity(myIntent);
                break;
        }
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        null.unbind();
//    }

    @OnClick({R.id.dummy4, R.id.dummy5})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.dummy4:
                    break;
                case R.id.dummy5:
                    break;
            }
    }
}