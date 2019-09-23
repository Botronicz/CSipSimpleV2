package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.actionbarsherlock.internal.utils.UtilityWrapper;

public class CapitalizingTextView extends AppCompatTextView {
    private static final boolean SANS_ICE_CREAM = Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH;

    private static final int[] R_styleable_TextView = new int[] {
        android.R.attr.textAllCaps
    };
    private static final int R_styleable_TextView_textAllCaps = 0;

    private boolean mAllCaps;

    public CapitalizingTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CapitalizingTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R_styleable_TextView, defStyle, 0);
        mAllCaps = a.getBoolean(R_styleable_TextView_textAllCaps, true);
        a.recycle();
    }

    public void setTextCompat(CharSequence text) {
        if (SANS_ICE_CREAM && mAllCaps && text != null) {
            setText(UtilityWrapper.getInstance().stringToUpper(text));
        } else {
            setText(text);
        }
    }
}