package com.example.android.notepad;

import android.app.Activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class NoteColor extends Activity {

    private Cursor mCursor;
    private Uri mUri;
    private  int color;
    private  static final int COLUMN_INDEX_TITLE=1;
    private  static final  String[] PROJECTION=new String[]{
            NotePad.Notes._ID,
            NotePad.Notes.COLUMN_NAME_BACK_COLOR,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_color);

        mUri = getIntent().getData();
        mCursor = managedQuery(
                mUri,
                PROJECTION,
                null,
                null,
                null
        );
    }

    @Override
    protected void onResume() {
        if (mCursor != null){
            mCursor.moveToFirst();
            color=mCursor.getInt(COLUMN_INDEX_TITLE);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ContentValues values=new ContentValues();
        values.put(NotePad.Notes.COLUMN_NAME_BACK_COLOR, color);
        getContentResolver().update(mUri, values,null,null);
    }

    public void white(View view){
        color = NotePad.Notes.DEFAULT_COLOR;
        finish();
    }

    public void grey(View view){
        color = NotePad.Notes.GREY_COLOR;
        finish();
    }

    public  void red(View view){
        color = NotePad.Notes.RED_COLOR;
        finish();
    }


    public void yellow(View V){
        color = NotePad.Notes.YELLOW_COLOR;
        finish();
    }

    public void green(View view){
        color = NotePad.Notes.GREEN_COLOR;
        finish();
    }

    public void teal_200(View view){
        color = NotePad.Notes.teal_200_COLOR;
        finish();
    }

    public void teal_700(View view){
        color = NotePad.Notes.teal_700_COLOR;
        finish();
    }


}