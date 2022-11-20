package com.example.android.notepad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.View;
import android.widget.SimpleCursorAdapter;


public class MyCursorAdapter extends SimpleCursorAdapter {

    public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);

        @SuppressLint("Range") int x=cursor.getInt(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_BACK_COLOR));
        switch (x) {
            case NotePad.Notes.DEFAULT_COLOR:
                view.setBackgroundColor(Color.rgb(255, 255, 255));
                break;
            case NotePad.Notes.GREY_COLOR:
                view.setBackgroundColor(Color.rgb(186, 186, 182));
                break;
            case NotePad.Notes.YELLOW_COLOR:
                view.setBackgroundColor(Color.rgb(255, 235, 59));
                break;
            case NotePad.Notes.RED_COLOR:
                view.setBackgroundColor(Color.rgb(234, 43, 29));
                break;
            case NotePad.Notes.GREEN_COLOR:
                view.setBackgroundColor(Color.rgb(76, 175, 80));
                break;
            case NotePad.Notes.teal_200_COLOR:
                view.setBackgroundColor(Color.rgb(3, 218, 197));
                break;
            case NotePad.Notes.teal_700_COLOR:
                view.setBackgroundColor(Color.rgb(1, 135, 134));
                break;
            default:
                view.setBackgroundColor(Color.rgb(255, 255, 255));
                break;

        }

    }
}
