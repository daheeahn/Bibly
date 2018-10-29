package org.techtown.a1006_bibly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.book)
    ImageView book;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.review_text)
    TextView review_text;

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.like)
    ImageView like;
    int i = 0;

    private BookInfo bookInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        bookInfo = (BookInfo) intent.getSerializableExtra("bookInfo");

        book.setImageResource(bookInfo.getBook());
        title.setText(bookInfo.getTitle());
        author.setText(bookInfo.getAuthor());
        ratingBar.setRating(bookInfo.getRate());
        review_text.setText(bookInfo.getReview());

        like.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.like:
                if (i == 0) {
                    like.setImageResource(R.drawable.ic_like_full);
                    i = 1;
                }
                else if (i == 1) {
                    like.setImageResource(R.drawable.ic_like_empty);
                    i = 0;
                }
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
