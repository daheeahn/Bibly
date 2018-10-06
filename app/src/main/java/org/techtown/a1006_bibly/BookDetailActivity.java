package org.techtown.a1006_bibly;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookDetailActivity extends AppCompatActivity {

    @BindView(R.id.book) ImageView book;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.author) TextView author;

    @BindView(R.id.back) ImageView back;
    @BindView(R.id.like) ImageView like;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

//        Bitmap bitmap = (Bitmap) intent.getExtras().get("book");
//        book.setImageBitmap(bitmap);
        book.setImageResource((Integer) intent.getExtras().get("book"));
        title.setText(intent.getStringExtra("title"));
        author.setText(intent.getStringExtra("author"));
    }

    @OnClick({R.id.back, R.id.like}) void click(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;

            case R.id.like:
                if (i == 0) {
                    like.setImageResource(R.drawable.ic_like_full);
                    i = 1;
                } else if (i == 1) {
                    like.setImageResource(R.drawable.ic_like_empty);
                    i = 0;
                }

        }
    }
}
