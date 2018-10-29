package org.techtown.a1006_bibly;

import android.content.ClipData;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment_RecommendType_RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<RecommendType> recommendTypes = new ArrayList<>();
    private Context context;
    private OnClickListener clickListener;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    MainFragment_Books_RecyclerviewAdapter adapter;
    View view;

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public MainFragment_RecommendType_RecyclerviewAdapter(Context context) {
        this.context = context;

        recommendTypes.add(new RecommendType("장르"));
        recommendTypes.add(new RecommendType("기분"));
        recommendTypes.add(new RecommendType("날씨"));
        recommendTypes.add(new RecommendType("친구"));
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_fragment_recyclerview_item_recommend_type, parent, false);

        //books recyclerview 초기화
        recyclerView = (RecyclerView) view.findViewById(R.id.main_fragment_books_recyclerview);
        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainFragment_Books_RecyclerviewAdapter(1, context);
        recyclerView.setAdapter(adapter);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((ViewHolder) holder).type.setText(recommendTypes.get(position).type + "에 따른 책추천");

        //https://stackoverflow.com/questions/37194653/fragment-replacing-in-recyclerview-item
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btn1:
                        clickListener.onButtonClick(position, 1, v);
                        break;
                    case R.id.btn2:
                        clickListener.onButtonClick(position, 2, v);
                        break;
                    case R.id.btn3:
                        //오류
//                        context = v.getContext();
//                        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.main_fragment_books_recyclerview);
//
//                        layoutManager = new LinearLayoutManager(context);
//                        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                        recyclerView.setLayoutManager(layoutManager);
//
//                        adapter = new MainFragment_Books_RecyclerviewAdapter(3, context);
//                        recyclerView.setAdapter(adapter);

                        clickListener.onButtonClick(position, 3, v);
                        break;
                    case R.id.btn4:
                        clickListener.onButtonClick(position, 4, v);
                        break;
                    case R.id.btn5:
                        clickListener.onButtonClick(position, 5, v);
                        break;
                    case R.id.btn_detail:
                    case R.id.linearLayout:
                        clickListener.onRecommendDetailButtonClick(recommendTypes.get(position).type.toString());
                        break;
                }
            }
        };

        ((ViewHolder) holder).btn1.setOnClickListener(listener);
        ((ViewHolder) holder).btn2.setOnClickListener(listener);
        ((ViewHolder) holder).btn3.setOnClickListener(listener);
        ((ViewHolder) holder).btn4.setOnClickListener(listener);
        ((ViewHolder) holder).btn5.setOnClickListener(listener);
        ((ViewHolder) holder).btnDetail.setOnClickListener(listener);
        ((ViewHolder) holder).linearLayout.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        //카운터
        return recommendTypes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
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

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
