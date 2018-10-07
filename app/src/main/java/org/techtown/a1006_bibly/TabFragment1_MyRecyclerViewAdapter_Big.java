package org.techtown.a1006_bibly;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TabFragment1_MyRecyclerViewAdapter_Big extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<RecommendType> recommendTypes = new ArrayList<>();
    private Context context;
    private OnButtonClickListener clickListener;

    public void setClickListener(OnButtonClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public TabFragment1_MyRecyclerViewAdapter_Big(Context context) {
        this.context = context;

        recommendTypes.add(new RecommendType("장르"));
        recommendTypes.add(new RecommendType("기분"));
        recommendTypes.add(new RecommendType("날씨"));

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_1_recyclerview_item_big, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((ViewHolder) holder).type.setText(recommendTypes.get(position).type + "에 따른 책추천");
        if (clickListener != null)
            clickListener.onClick(new TabFragment1_view1_btn1());
    }

    @Override
    public int getItemCount() {
        //카운터
        return recommendTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.btn_detail)
        TextView btnDetail;
        @BindView(R.id.btn1)
        Button btn1;
        @BindView(R.id.btn2)
        Button btn2;
        @BindView(R.id.btn3)
        Button btn3;
        @BindView(R.id.btn4)
        Button btn4;
        @BindView(R.id.btn5)
        Button btn5;
        @BindView(R.id.linearLayout)
        LinearLayout linearLayout;
        @BindView(R.id.tabfragment1_container1)
        FrameLayout tabfragment1Container1;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);




            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn5.setOnClickListener(this);



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                     get position
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if(pos != RecyclerView.NO_POSITION){
                        Toast.makeText(v.getContext(), "You clicked " + pos, Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            switch (v.getId()) {
                case R.id.btn1:
                    fragment = new TabFragment1_view1_btn1();
                    break;
                case R.id.btn2:
                    fragment = new TabFragment1_view1_btn2();
                    break;
                case R.id.btn3:
                    fragment = new TabFragment1_view1_btn3();
                    break;
                case R.id.btn4:
                    fragment = new TabFragment1_view1_btn4();
                    break;
                case R.id.btn5:
                    fragment = new TabFragment1_view1_btn5();
                    break;
            }
            if (clickListener != null)
                clickListener.onClick(fragment);
        }
    }

    //    @Override
//    public void onClick(View v) {
//
//        Fragment selected = null;
//
//        switch (v.getId()) {
//            case R.id.btn_detail:
//                Intent intent = new Intent(getActivity(), RecommendDetailActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.btn1:
//                selected = fragment1;
//                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
//                break;
//            case R.id.btn2:
//                selected = fragment2;
//                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
//                break;
//            case R.id.btn3:
//                selected = fragment3;
//                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
//                break;
//            case R.id.btn4:
//                selected = fragment4;
//                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
//                break;
//            case R.id.btn5:
//                selected = fragment5;
//                fragManager.beginTransaction().replace(R.id.tabfragment1_container1, selected).commit();
//                break;
//
//        }
//
//
//    }


}
