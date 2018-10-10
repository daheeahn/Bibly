package org.techtown.a1006_bibly;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabFragment2_MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BookInfo> bookInfos = new ArrayList<>();
    private OnClickListener clickListener;

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public TabFragment2_MyRecyclerViewAdapter() {

        bookInfos.add(new BookInfo(R.drawable.dummy_1_1, "dummy_1_1", "person_1_1"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_2, "dummy_1_2", "person_1_2"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_3, "dummy_1_3", "person_1_3"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_4, "dummy_1_4", "person_1_4"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_5, "dummy_1_5", "person_1_5"));
        bookInfos.add(new BookInfo(R.drawable.dummy_1_6, "dummy_1_6", "person_1_6"));
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //XML 가져오는 부분
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_2_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어주는 부분. 바인딩하는 부분
        ((ViewHolder) holder).book.setImageResource(bookInfos.get(position).book);
        ((ViewHolder) holder).title.setText(bookInfos.get(position).title);
        ((ViewHolder) holder).author.setText(bookInfos.get(position).author);
    }

    @Override
    public int getItemCount() {
        //카운터
        return bookInfos.size();
    }

    //소스코드 절약해주는 부분 static 넣으면 더 좋음
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //clickListener 쓰면 static 없애줘야하는 이유?

        @BindView(R.id.book)
        ImageView book;
        @BindView(R.id.like)
        ImageView like;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.review_text)
        EditText reviewText;
        @BindView(R.id.review_btn)
        Button reviewBtn;
        @BindView(R.id.review_star)
        RatingBar reviewStar;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            reviewBtn.setOnClickListener(this);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    // check if item still exists
                    if (pos != RecyclerView.NO_POSITION) {
                        Toast.makeText(v.getContext(), "You clicked " + pos, Toast.LENGTH_SHORT).show();
                        clickListener.onBookClick(bookInfos.get(pos));
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.review_btn:
                    //한줄평과 별점 저장하여 책상세페이지로 넘어가기
                    int pos = getAdapterPosition();


                    //only spacebar도 안되게 하기
                    if (reviewText.getText().toString().length() == 0 && reviewStar.getRating() == 0.0)
                        Toast.makeText(v.getContext(), "한줄평과 평점을 모두 입력해주세요 :) " + pos, Toast.LENGTH_SHORT).show();
                    else if (reviewText.getText().toString().length() == 0)
                        Toast.makeText(v.getContext(), "한줄평도 입력해주세요 :) " + pos, Toast.LENGTH_SHORT).show();
                    else if (reviewStar.getRating() == 0.0)
                        Toast.makeText(v.getContext(), "평점도 입력해주세요 :) " + pos, Toast.LENGTH_SHORT).show();
                    else {
                        bookInfos.get(pos).setReview(reviewText.getText().toString());
                        bookInfos.get(pos).setRate(reviewStar.getRating());
                        if (clickListener != null)
                            clickListener.onBookClick(bookInfos.get(pos));

                        //reviewBtn.setEnabled(false);
                        //reviewBtn.setText("평가완료");
                        //v.setBackgroundColor(Color.rgb(167, 167, 167));
                    }

                    break;
            }
        }
    }
}
