package com.rishav.xylophone;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private SoundPool mSoundPool;
    private int mCSoundId;
    private int mDSoundId;
    private int mESoundId;
    private int mFSoundId;
    private int mGSoundId;
    private int mASoundId;
    private int mBSoundId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating a new SoundPool object
        mSoundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);


        // Loading and getting the IDs to identify the sounds for playing
        mCSoundId = mSoundPool.load(getApplicationContext(), R.raw.note1_c, 1);
        mDSoundId = mSoundPool.load(getApplicationContext(), R.raw.note2_d, 1);
        mESoundId = mSoundPool.load(getApplicationContext(), R.raw.note3_e, 1);
        mFSoundId = mSoundPool.load(getApplicationContext(), R.raw.note4_f, 1);
        mGSoundId = mSoundPool.load(getApplicationContext(), R.raw.note5_g, 1);
        mASoundId = mSoundPool.load(getApplicationContext(), R.raw.note6_a, 1);
        mBSoundId = mSoundPool.load(getApplicationContext(), R.raw.note7_b, 1);


    }

    public void playC(View view)
    {
        Log.d("Xylophone", "C pressed");
        mSoundPool.play(mCSoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playD(View view)
    {
        Log.d("Xylophone", "D pressed");
        mSoundPool.play(mDSoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playE(View view)
    {
        Log.d("Xylophone", "E pressed");
        mSoundPool.play(mESoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playF(View view)
    {
        Log.d("Xylophone", "F pressed");
        mSoundPool.play(mFSoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playG(View view)
    {
        Log.d("Xylophone", "G pressed");
        mSoundPool.play(mGSoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playA(View view)
    {
        Log.d("Xylophone", "A pressed");
        mSoundPool.play(mASoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

    public void playB(View view)
    {
        Log.d("Xylophone", "B pressed");
        mSoundPool.play(mBSoundId, 1.0f, 1.0f, 0, 0, 1.0f);

    }

}
