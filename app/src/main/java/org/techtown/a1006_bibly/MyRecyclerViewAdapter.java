package org.techtown.a1006_bibly;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BookInfo> bookInfos = new ArrayList<>();
    public MyRecyclerViewAdapter(int index) {
        if (index == 0) {
            bookInfos.add(new BookInfo(R.drawable.dummy_1_1)); bookInfos.add(new BookInfo(R.drawable.dummy_1_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_1_3)); bookInfos.add(new BookInfo(R.drawable.dummy_1_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_1_5)); bookInfos.add(new BookInfo(R.drawable.dummy_1_6));

            bookInfos.add(new BookInfo(R.drawable.dummy_2_1)); bookInfos.add(new BookInfo(R.drawable.dummy_2_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_2_3)); bookInfos.add(new BookInfo(R.drawable.dummy_2_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_2_5)); bookInfos.add(new BookInfo(R.drawable.dummy_2_6));

            bookInfos.add(new BookInfo(R.drawable.dummy_3_1)); bookInfos.add(new BookInfo(R.drawable.dummy_3_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_3_3)); bookInfos.add(new BookInfo(R.drawable.dummy_3_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_3_5)); bookInfos.add(new BookInfo(R.drawable.dummy_3_6));

            bookInfos.add(new BookInfo(R.drawable.dummy_4_1)); bookInfos.add(new BookInfo(R.drawable.dummy_4_3));
            bookInfos.add(new BookInfo(R.drawable.dummy_4_3)); bookInfos.add(new BookInfo(R.drawable.dummy_4_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_4_5)); bookInfos.add(new BookInfo(R.drawable.dummy_4_6));
        } else if (index == 1) {
            bookInfos.add(new BookInfo(R.drawable.dummy_1_1)); bookInfos.add(new BookInfo(R.drawable.dummy_1_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_1_3)); bookInfos.add(new BookInfo(R.drawable.dummy_1_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_1_5)); bookInfos.add(new BookInfo(R.drawable.dummy_1_6));
        } else if (index == 2) {
            bookInfos.add(new BookInfo(R.drawable.dummy_2_1)); bookInfos.add(new BookInfo(R.drawable.dummy_2_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_2_3)); bookInfos.add(new BookInfo(R.drawable.dummy_2_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_2_5)); bookInfos.add(new BookInfo(R.drawable.dummy_2_6));

        } else if (index == 3) {
            bookInfos.add(new BookInfo(R.drawable.dummy_3_1)); bookInfos.add(new BookInfo(R.drawable.dummy_3_2));
            bookInfos.add(new BookInfo(R.drawable.dummy_3_3)); bookInfos.add(new BookInfo(R.drawable.dummy_3_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_3_5)); bookInfos.add(new BookInfo(R.drawable.dummy_3_6));

        } else if (index == 4) {
            bookInfos.add(new BookInfo(R.drawable.dummy_4_1)); bookInfos.add(new BookInfo(R.drawable.dummy_4_3));
            bookInfos.add(new BookInfo(R.drawable.dummy_4_3)); bookInfos.add(new BookInfo(R.drawable.dummy_4_4));
            bookInfos.add(new BookInfo(R.drawable.dummy_4_5)); bookInfos.add(new BookInfo(R.drawable.dummy_4_6));

        }

    }
    public RowCell onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_1_recyclerview_item, parent, false);
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((RowCell) holder).book.setImageResource(bookInfos.get(position).book);
        ((RowCell) holder).ratingBar.setRating(bookInfos.get(position).rate);
    }

    @Override
    public int getItemCount() {
        //카운터
        return bookInfos.size();
    }

    //소스코드 절약해주는 부분 static 넣으면 더 좋음
    private static class RowCell extends RecyclerView.ViewHolder {
        ImageView book;
        RatingBar ratingBar;

        public RowCell(View view) {
            super(view);

            book = (ImageView) view.findViewById(R.id.dummy_book);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }
}
