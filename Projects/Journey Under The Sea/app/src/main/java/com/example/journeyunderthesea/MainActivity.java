package com.example.journeyunderthesea;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private ImageView mBackgroundImageView;
    private TextView mStoryTextView;
    private ImageButton mInfoImageButton;
    private Button mTopButton;
    private Button mBottomButton;

    /*@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }*/


    @SuppressLint({"SourceLockedOrientationActivity", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mBackgroundImageView = findViewById(R.id.BACKGROUND_IMAGEVIEW);
        mStoryTextView = findViewById(R.id.STORY_TEXTVIEW);
        mInfoImageButton = findViewById(R.id.INFO_BUTTON);
        mTopButton = findViewById(R.id.TOP_BUTTON);
        mBottomButton = findViewById(R.id.BOTTOM_BUTTON);
        Switch switchView = findViewById(R.id.SWITCH_VIEW);

        mBackgroundImageView.setImageAlpha(70);

        AlertDialog.Builder splashScreen = new AlertDialog.Builder(MainActivity.this);
        splashScreen.setTitle("INSTRUCTIONS:-");
        splashScreen.setMessage("This journey contains many different adventures you can go on as you dive under the sea.\n\n" +
                "From time to time as you read along, you will be asked to make a choice.\n\n" +
                "Your choice may lead to success or disaster!\n\n" +
                "The adventures you take are a result of your choice. You are responsible because you choose!\n\n" +
                "After making a choice follow the instructions to see what happens next.\n\n" +
                "REMEMBER you cannot go back! Think carefully before you make a move! \n\n" +
                "One mistake can be your last move or it may lead you to fame and fortune.\n\n" +
                "Click on the Image button2 at the top to view the sketch behind it\n\n" +
                "\nClick START below to begin the adventure");
        splashScreen.setCancelable(false);
        splashScreen.setPositiveButton("START", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                page2();
            }
        });
        splashScreen.show();

        Window window = getWindow();
        window.setStatusBarColor(R.color.colorAccent);

        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    mBackgroundImageView.setImageAlpha(255);
                    mStoryTextView.setVisibility(View.INVISIBLE);
                    mInfoImageButton.setVisibility(View.INVISIBLE);
                } else
                {
                    mBackgroundImageView.setImageAlpha(70);
                    mStoryTextView.setVisibility(View.VISIBLE);
                    mInfoImageButton.setVisibility(View.VISIBLE);
                }
            }
        });

        mInfoImageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder devInfo = new AlertDialog.Builder(MainActivity.this);
                devInfo.setTitle("Dev Information");
                devInfo.setMessage("Developer: Rishav Nath Pati" +
                        "\nClick the links below to visit profiles");
                devInfo.setCancelable(true);
                devInfo.setNeutralButton("Facebook", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://www.facebook.com/rishav.pati.1");
                    }
                });
                devInfo.setPositiveButton("Github", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://github.com/rishavnathpati");
                    }
                });
                devInfo.setNegativeButton("LinkedIn", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        goToUrl("https://www.linkedin.com/in/rishav-nath-p-67223bb9/");
                    }
                });
                devInfo.show();
            }

            private void goToUrl(String url)
            {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        mTopButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("Clicked", "Top Clicked");
                if (mTopButton.getText() == getString(R.string.ans2goto6))
                    page6();
                else if (mTopButton.getText() == getString(R.string.ans5goto8))
                    page8();
                else if (mTopButton.getText() == getString(R.string.ans6goto10))
                    page10();
                else if (mTopButton.getText() == getString(R.string.ans8goto11))
                    page11();
                else if (mTopButton.getText() == getString(R.string.ans9goto16))
                    page16();
                else if (mTopButton.getText() == getString(R.string.ans10goto17))
                    page17();
                else if (mTopButton.getText() == getString(R.string.ans11goto24))
                    page24();
                else if (mTopButton.getText() == getString(R.string.ans12goto21))
                    page21();
                else if (mTopButton.getText() == getString(R.string.ans14goto26))
                    page26();
                else if (mTopButton.getText() == getString(R.string.ans15goto23))
                    page23();
                else if (mTopButton.getText() == getString(R.string.ans16goto29))
                    page29();
                else if (mTopButton.getText() == getString(R.string.ans17goto32))
                    page32();
                else if (mTopButton.getText() == getString(R.string.ans18goto34))
                    page34();
                else if (mTopButton.getText() == getString(R.string.ans22goto38))
                    page38();
                else if (mTopButton.getText() == getString(R.string.ans24goto6))
                    page6();
                else if (mTopButton.getText() == getString(R.string.ans27goto39))
                    page39();
                else if (mTopButton.getText() == getString(R.string.ans28goto41))
                    page41();
                else if (mTopButton.getText() == getString(R.string.ans29goto43))
                    page43();
                else if (mTopButton.getText() == getString(R.string.ans33goto45))
                    page45();
                else if (mTopButton.getText() == getString(R.string.ans34goto48))
                    page48();
                else if (mTopButton.getText() == getString(R.string.ans35goto50))
                    page50();
                else if (mTopButton.getText() == getString(R.string.ans38goto55))
                    page55();
                else if (mTopButton.getText() == getString(R.string.ans39goto56))
                    page56();
                else if (mTopButton.getText() == getString(R.string.ans41goto58))
                    page58();
                else if (mTopButton.getText() == getString(R.string.ans43goto60))
                    page60();
                else if (mTopButton.getText() == getString(R.string.ans44goto64))
                    page64();
                else if (mTopButton.getText() == getString(R.string.ans45goto65))
                    page65();
                else if (mTopButton.getText() == getString(R.string.ans46goto48))
                    page48();
                else if (mTopButton.getText() == getString(R.string.ans48goto9))
                    page9();
                else if (mTopButton.getText() == getString(R.string.ans50goto67))
                    page67();
                else if (mTopButton.getText() == getString(R.string.ans51goto72))
                    page72();
                else if (mTopButton.getText() == getString(R.string.ans53goto69))
                    page69();
                else if (mTopButton.getText() == getString(R.string.ans55goto71))
                    page71();
                else if (mTopButton.getText() == getString(R.string.ans56goto75))
                    page75();
                else if (mTopButton.getText() == getString(R.string.ans57goto77))
                    page77();
                else if (mTopButton.getText() == getString(R.string.ans60goto80))
                    page80();
                else if (mTopButton.getText() == getString(R.string.ans61goto81))
                    page81();
                else if (mTopButton.getText() == getString(R.string.ans64goto63))
                    page63();
                else if (mTopButton.getText() == getString(R.string.ans65goto88))
                    page88();
                else if (mTopButton.getText() == getString(R.string.ans67goto6))
                    page6();
                else if (mTopButton.getText() == getString(R.string.ans69goto97))
                    page97();
                else if (mTopButton.getText() == getString(R.string.ans70goto99))
                    page99();
                else if (mTopButton.getText() == getString(R.string.ans71goto90))
                    page90();
                else if (mTopButton.getText() == getString(R.string.ans72goto93))
                    page93();
                else if (mTopButton.getText() == getString(R.string.ans79goto50))
                    page50();
                else if (mTopButton.getText() == getString(R.string.ans81goto116))
                    page116();
                else if (mTopButton.getText() == getString(R.string.ans82goto112))
                    page112();
                else if (mTopButton.getText() == getString(R.string.ans88goto95))
                    page95();
                else if (mTopButton.getText() == getString(R.string.ans90goto101))
                    page101();
                else if (mTopButton.getText() == getString(R.string.ans91goto103))
                    page103();
                else if (mTopButton.getText() == getString(R.string.ans94goto105))
                    page105();
                else if (mTopButton.getText() == getString(R.string.ans96goto110))
                    page110();
            }
        });


        mBottomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("Clicked", "Bottom Clicked");
                if (mBottomButton.getText() == getString(R.string.ans2goto5))
                    page5();
                else if (mBottomButton.getText() == getString(R.string.ans5goto9))
                    page9();
                else if (mBottomButton.getText() == getString(R.string.ans6goto12))
                    page12();
                else if (mBottomButton.getText() == getString(R.string.ans8goto15))
                    page15();
                else if (mBottomButton.getText() == getString(R.string.ans9goto14))
                    page14();
                else if (mBottomButton.getText() == getString(R.string.ans10goto18))
                    page18();
                else if (mBottomButton.getText() == getString(R.string.ans11goto22))
                    page22();
                else if (mBottomButton.getText() == getString(R.string.ans12goto19))
                    page19();
                else if (mBottomButton.getText() == getString(R.string.ans14goto28))
                    page28();
                else if (mBottomButton.getText() == getString(R.string.ans15goto27))
                    page27();
                else if (mBottomButton.getText() == getString(R.string.ans16goto31))
                    page31();
                else if (mBottomButton.getText() == getString(R.string.ans17goto33))
                    page33();
                else if (mBottomButton.getText() == getString(R.string.ans18goto37))
                    page37();
                else if (mBottomButton.getText() == getString(R.string.ans22goto35))
                    page35();
                else if (mBottomButton.getText() == getString(R.string.ans24goto6))
                    page6();
                else if (mBottomButton.getText() == getString(R.string.ans27goto40))
                    page40();
                else if (mBottomButton.getText() == getString(R.string.ans28goto42))
                    page42();
                else if (mBottomButton.getText() == getString(R.string.ans29goto44))
                    page44();
                else if (mBottomButton.getText() == getString(R.string.ans33goto46))
                    page46();
                else if (mBottomButton.getText() == getString(R.string.ans34goto47))
                    page47();
                else if (mBottomButton.getText() == getString(R.string.ans35goto53))
                    page53();
                else if (mBottomButton.getText() == getString(R.string.ans38goto51))
                    page51();
                else if (mBottomButton.getText() == getString(R.string.ans39goto57))
                    page57();
                else if (mBottomButton.getText() == getString(R.string.ans41goto59))
                    page59();
                else if (mBottomButton.getText() == getString(R.string.ans42goto6))
                    page6();
                else if (mBottomButton.getText() == getString(R.string.ans43goto61))
                    page61();
                else if (mBottomButton.getText() == getString(R.string.ans44goto63))
                    page63();
                else if (mBottomButton.getText() == getString(R.string.ans45goto66))
                    page66();
                else if (mBottomButton.getText() == getString(R.string.ans46goto48))
                    page48();
                else if (mBottomButton.getText() == getString(R.string.ans48goto9))
                    page9();
                else if (mBottomButton.getText() == getString(R.string.ans50goto68))
                    page68();
                else if (mBottomButton.getText() == getString(R.string.ans51goto74))
                    page74();
                else if (mBottomButton.getText() == getString(R.string.ans53goto70))
                    page70();
                else if (mBottomButton.getText() == getString(R.string.ans55goto73))
                    page73();
                else if (mBottomButton.getText() == getString(R.string.ans56goto76))
                    page76();
                else if (mBottomButton.getText() == getString(R.string.ans57goto79))
                    page79();
                else if (mBottomButton.getText() == getString(R.string.ans60goto82))
                    page82();
                else if (mBottomButton.getText() == getString(R.string.ans61goto86))
                    page86();
                else if (mBottomButton.getText() == getString(R.string.ans64goto85))
                    page85();
                else if (mBottomButton.getText() == getString(R.string.ans65goto89))
                    page89();
                else if (mBottomButton.getText() == getString(R.string.ans66goto32))
                    page32();
                else if (mBottomButton.getText() == getString(R.string.ans67goto6))
                    page6();
                else if (mBottomButton.getText() == getString(R.string.ans69goto98))
                    page98();
                else if (mBottomButton.getText() == getString(R.string.ans70goto100))
                    page100();
                else if (mBottomButton.getText() == getString(R.string.ans71goto91))
                    page91();
                else if (mBottomButton.getText() == getString(R.string.ans72goto94))
                    page94();
                else if (mBottomButton.getText() == getString(R.string.ans79goto50))
                    page50();
                else if (mBottomButton.getText() == getString(R.string.ans81goto117))
                    page117();
                else if (mBottomButton.getText() == getString(R.string.ans82goto114))
                    page114();
                else if (mBottomButton.getText() == getString(R.string.ans88goto96))
                    page96();
                else if (mBottomButton.getText() == getString(R.string.ans90goto102))
                    page102();
                else if (mBottomButton.getText() == getString(R.string.ans91goto104))
                    page104();
                else if (mBottomButton.getText() == getString(R.string.ans94goto106))
                    page106();
                else if (mBottomButton.getText() == getString(R.string.ans96gotoEnd))
                    page110();
                else if (mBottomButton.getText() == getString(R.string.ans100goto55))
                    page55();

                else if (mBottomButton.getText() == getString(R.string.exit) || mBottomButton.getText() == getString(R.string.ans96gotoEnd))
                    finish();
            }
        });
    }

    private void page2()
    {
        Log.d("Reached", "Page 2");
        mStoryTextView.setText(R.string.story2);
        mTopButton.setText(R.string.ans2goto6);
        mBottomButton.setText(R.string.ans2goto5);
        mBackgroundImageView.setImageResource(R.drawable.image2);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page5()
    {
        Log.d("Reached", "Page 5");
        mStoryTextView.setText(R.string.story5);
        mTopButton.setText(R.string.ans5goto8);
        mBottomButton.setText(R.string.ans5goto9);
        mBackgroundImageView.setImageResource(R.drawable.image5);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page6()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story6);
        mTopButton.setText(R.string.ans6goto10);
        mBottomButton.setText(R.string.ans6goto12);
        mBackgroundImageView.setImageResource(R.drawable.image6);
        mTopButton.setVisibility(View.VISIBLE);
    }

    private void page8()
    {
        Log.d("Reached", "Page 8");
        mStoryTextView.setText(R.string.story8);
        mTopButton.setText(R.string.ans8goto11);
        mBottomButton.setText(R.string.ans8goto15);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page9()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story9);
        mTopButton.setText(R.string.ans9goto16);
        mBottomButton.setText(R.string.ans9goto14);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page10()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story10);
        mTopButton.setText(R.string.ans10goto17);
        mBottomButton.setText(R.string.ans10goto18);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page11()
    {
        Log.d("Reached", "Page 11");
        mStoryTextView.setText(R.string.story11);
        mTopButton.setText(R.string.ans11goto24);
        mBottomButton.setText(R.string.ans11goto22);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page12()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story12);
        mTopButton.setText(R.string.ans12goto21);
        mBottomButton.setText(R.string.ans12goto19);
        mBackgroundImageView.setImageResource(R.drawable.image13);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page14()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story14);
        mTopButton.setText(R.string.ans14goto26);
        mBottomButton.setText(R.string.ans14goto28);
        mBackgroundImageView.setImageResource(R.drawable.image14);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page15()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story15);
        mTopButton.setText(R.string.ans15goto23);
        mBottomButton.setText(R.string.ans15goto27);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page16()
    {
        Log.d("Reached", "Page 16");
        mStoryTextView.setText(R.string.story16);
        mTopButton.setText(R.string.ans16goto29);
        mBottomButton.setText(R.string.ans16goto31);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page17()
    {
        Log.d("Reached", "Page 17");
        mStoryTextView.setText(R.string.story17);
        mTopButton.setText(R.string.ans17goto32);
        mBottomButton.setText(R.string.ans17goto33);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page18()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story18);
        mTopButton.setText(R.string.ans18goto34);
        mBottomButton.setText(R.string.ans18goto37);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page19()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end19);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page21()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end21);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image21);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page22()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story22);
        mTopButton.setText(R.string.ans22goto38);
        mBottomButton.setText(R.string.ans22goto35);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page23()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end23);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page24()
    {
        Log.d("Reached", "Page 24");
        mStoryTextView.setText(R.string.story24);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans24goto6);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page26()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end26);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image26);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page27()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story27);
        mTopButton.setText(R.string.ans27goto39);
        mBottomButton.setText(R.string.ans27goto40);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page28()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story28);
        mTopButton.setText(R.string.ans28goto41);
        mBottomButton.setText(R.string.ans28goto42);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page29()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story29);
        mTopButton.setText(R.string.ans29goto43);
        mBottomButton.setText(R.string.ans29goto44);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page31()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end31);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image31);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page32()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end32);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page33()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story33);
        mTopButton.setText(R.string.ans33goto45);
        mBottomButton.setText(R.string.ans33goto46);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page34()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story34);
        mTopButton.setText(R.string.ans34goto48);
        mBottomButton.setText(R.string.ans34goto47);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page35()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story35);
        mTopButton.setText(R.string.ans35goto50);
        mBottomButton.setText(R.string.ans35goto53);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page37()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end37);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image37);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page38()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story38);
        mTopButton.setText(R.string.ans38goto55);
        mBottomButton.setText(R.string.ans38goto51);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page39()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story39);
        mTopButton.setText(R.string.ans39goto56);
        mBottomButton.setText(R.string.ans39goto57);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page40()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end40);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page41()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story41);
        mTopButton.setText(R.string.ans41goto58);
        mBottomButton.setText(R.string.ans41goto59);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page42()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story42);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans42goto6);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page43()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story43);
        mTopButton.setText(R.string.ans43goto60);
        mBottomButton.setText(R.string.ans43goto61);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page44()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story44);
        mTopButton.setText(R.string.ans44goto64);
        mBottomButton.setText(R.string.ans44goto63);
        mBackgroundImageView.setImageResource(R.drawable.image44);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page45()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story45);
        mTopButton.setText(R.string.ans45goto65);
        mBottomButton.setText(R.string.ans45goto66);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page46()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story41);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans46goto48);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page47()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end47);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);

    }

    private void page48()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story48);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans48goto9);
        mBackgroundImageView.setImageResource(R.drawable.image48);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page50()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story50);
        mTopButton.setText(R.string.ans50goto67);
        mTopButton.setVisibility(View.VISIBLE);
        mBottomButton.setText(R.string.ans50goto68);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page51()
    {
        Log.d("Reached", "Page 51");
        mStoryTextView.setText(R.string.story51);
        mTopButton.setText(R.string.ans51goto72);
        mBottomButton.setText(R.string.ans51goto74);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page53()
    {
        Log.d("Reached", "Page 53");
        mStoryTextView.setText(R.string.story53);
        mTopButton.setText(R.string.ans53goto69);
        mBottomButton.setText(R.string.ans53goto70);
        mBackgroundImageView.setImageResource(R.drawable.image53);
        mBackgroundImageView.setVisibility(View.VISIBLE);
    }

    private void page55()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story55);
        mTopButton.setText(R.string.ans55goto71);
        mTopButton.setVisibility(View.VISIBLE);
        mBottomButton.setText(R.string.ans55goto73);
        mBackgroundImageView.setImageResource(R.drawable.image55);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page56()
    {
        Log.d("Reached", "Page 56");
        mStoryTextView.setText(R.string.story56);
        mTopButton.setText(R.string.ans56goto75);
        mBottomButton.setText(R.string.ans56goto76);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page57()
    {
        mStoryTextView.setText(R.string.story57);
        mTopButton.setText(R.string.ans57goto77);
        mBottomButton.setText(R.string.ans57goto79);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page58()
    {
        mStoryTextView.setText(R.string.end58);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page59()
    {
        mStoryTextView.setText(R.string.end59);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image59);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page60()
    {
        Log.d("Reached", "Page 60");
        mStoryTextView.setText(R.string.story60);
        mTopButton.setText(R.string.ans60goto80);
        mBottomButton.setText(R.string.ans60goto82);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page61()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story61);
        mTopButton.setText(R.string.ans61goto81);
        mBottomButton.setText(R.string.ans61goto86);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page63()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.end63);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image63);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page64()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story64);
        mTopButton.setText(R.string.ans64goto63);
        mBottomButton.setText(R.string.ans64goto85);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page65()
    {
        mStoryTextView.setText(R.string.story65);
        mTopButton.setText(R.string.ans65goto88);
        mBottomButton.setText(R.string.ans65goto89);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page66()
    {
        mStoryTextView.setText(R.string.story66);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans66goto32);
        mBackgroundImageView.setImageResource(R.drawable.image66);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page67()
    {
        Log.d("Reached", "Page 6");
        mStoryTextView.setText(R.string.story67);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans67goto6);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page68()
    {
        mStoryTextView.setText(R.string.end68);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page69()
    {
        mStoryTextView.setText(R.string.story69);
        mTopButton.setText(R.string.ans69goto97);
        mBottomButton.setText(R.string.ans69goto98);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page70()
    {
        mStoryTextView.setText(R.string.story70);
        mTopButton.setText(R.string.ans70goto99);
        mBottomButton.setText(R.string.ans70goto100);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page71()
    {
        mStoryTextView.setText(R.string.story71);
        mTopButton.setText(R.string.ans71goto90);
        mBottomButton.setText(R.string.ans71goto91);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page72()
    {
        mStoryTextView.setText(R.string.story72);
        mTopButton.setText(R.string.ans72goto93);
        mBottomButton.setText(R.string.ans72goto94);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page73()
    {
        mStoryTextView.setText(R.string.end73);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image73);
        mBackgroundImageView.setVisibility(View.VISIBLE);

    }

    private void page74()
    {
        mStoryTextView.setText(R.string.end74);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page75()
    {
        mStoryTextView.setText(R.string.end75);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page76()
    {
        mStoryTextView.setText(R.string.end76);
        mTopButton.setText(R.string.dont_like_ending);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page77()
    {
        mStoryTextView.setText(R.string.end77);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page79()
    {
        mStoryTextView.setText(R.string.story79);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans79goto50);
        mBackgroundImageView.setImageResource(R.drawable.image79);
    }

    private void page80()
    {
        mStoryTextView.setText(R.string.end80);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page81()
    {
        mStoryTextView.setText(R.string.story81);
        mTopButton.setText(R.string.ans81goto116);
        mBottomButton.setText(R.string.ans81goto117);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page82()
    {
        mStoryTextView.setText(R.string.story82);
        mTopButton.setText(R.string.ans82goto112);
        mBottomButton.setText(R.string.ans82goto114);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page85()
    {
        mStoryTextView.setText(R.string.end85);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image85);
    }

    private void page86()
    {
        mStoryTextView.setText(R.string.end86);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page88()
    {
        mStoryTextView.setText(R.string.story88);
        mTopButton.setText(R.string.ans88goto95);
        mBottomButton.setText(R.string.ans88goto96);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page89()
    {
        mStoryTextView.setText(R.string.end89);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page90()
    {
        mStoryTextView.setText(R.string.story90);
        mTopButton.setText(R.string.ans90goto101);
        mBottomButton.setText(R.string.ans90goto102);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page91()
    {
        mStoryTextView.setText(R.string.story91);
        mTopButton.setText(R.string.ans91goto103);
        mBottomButton.setText(R.string.ans91goto104);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page93()
    {
        mStoryTextView.setText(R.string.end93);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image92);
    }

    private void page94()
    {
        mStoryTextView.setText(R.string.story94);
        mTopButton.setText(R.string.ans94goto105);
        mBottomButton.setText(R.string.ans94goto106);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page95()
    {
        mStoryTextView.setText(R.string.end95);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page96()
    {
        mStoryTextView.setText(R.string.story96);
        mTopButton.setText(R.string.ans96goto110);
        mBottomButton.setText(R.string.ans96gotoEnd);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page97()
    {
        mStoryTextView.setText(R.string.end97);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image97);
    }

    private void page98()
    {
        mStoryTextView.setText(R.string.end98);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page99()
    {
        mStoryTextView.setText(R.string.end99);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page100()
    {
        mStoryTextView.setText(R.string.story100);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.ans100goto55);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page101()
    {
        mStoryTextView.setText(R.string.end101);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page102()
    {
        mStoryTextView.setText(R.string.end102);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image102);
    }

    private void page103()
    {
        mStoryTextView.setText(R.string.end103);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page104()
    {
        mStoryTextView.setText(R.string.end104);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

    private void page105()
    {
        mStoryTextView.setText(R.string.end105);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image105);
    }

    private void page106()
    {
        mStoryTextView.setText(R.string.end106);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image106);
    }

    private void page110()
    {
        mStoryTextView.setText(R.string.end110);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image110);
    }

    private void page112()
    {
        mStoryTextView.setText(R.string.end112);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image112);
    }

    private void page114()
    {
        mStoryTextView.setText(R.string.end114);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image114);
    }

    private void page116()
    {
        mStoryTextView.setText(R.string.end116);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image116);
    }

    private void page117()
    {
        mStoryTextView.setText(R.string.end117);
        mTopButton.setVisibility(View.INVISIBLE);
        mBottomButton.setText(R.string.exit);
        mBackgroundImageView.setImageResource(R.drawable.image0);
    }

}