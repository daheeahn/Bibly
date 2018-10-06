package org.techtown.a1006_bibly;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TabFragment2_MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BookInfo> bookInfos = new ArrayList<>();

    public TabFragment2_MyRecyclerViewAdapter() {

        bookInfos.add(new BookInfo(R.drawable.dummy_1_1, "dummy_1_1", "person_1_1"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_2, "dummy_1_2", "person_1_2"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_3, "dummy_1_3", "person_1_3"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_4, "dummy_1_4", "person_1_4"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_5, "dummy_1_5", "person_1_5"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_6, "dummy_1_6", "person_1_6"));
    }
    public RowCell onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_2_recyclerview_item, parent, false);
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((RowCell) holder).book.setImageResource(bookInfos.get(position).book);
        ((RowCell) holder).title.setText(bookInfos.get(position).title);
        ((RowCell) holder).author.setText(bookInfos.get(position).author);
    }

    @Override
    public int getItemCount() {
        //카운터
        return bookInfos.size();
    }

    //소스코드 절약해주는 부분 static 넣으면 더 좋음
    private static class RowCell extends RecyclerView.ViewHolder {
        ImageView book;
        TextView title;
        TextView author;

        public RowCell(View view) {
            super(view);

            book = (ImageView) view.findViewById(R.id.book);
            title = (TextView) view.findViewById(R.id.title);
            author= (TextView) view.findViewById(R.id.author);
        }
    }
}
