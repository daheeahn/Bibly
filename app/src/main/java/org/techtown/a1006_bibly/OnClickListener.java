package org.techtown.a1006_bibly;

import android.support.v4.app.Fragment;

public interface OnClickListener {
    public void onButtonClick(Fragment fragment);
    public void onBookClick(BookInfo bookInfo);
    public void onRecommendDetailButtonClick();
}
