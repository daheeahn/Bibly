package org.techtown.a1006_bibly;

import android.support.v4.app.Fragment;
import android.view.View;

public interface OnClickListener {
    public void onButtonClick(int pos, int btn, View v);
    public void onBookClick(BookInfo bookInfo);
    public void onRecommendDetailButtonClick(String type);
}
