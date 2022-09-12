package adoptedfinal.com;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.graphics.fonts.FontFamily;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroSlide extends AppCompatActivity {

    private ViewPager introslide;
    private LinearLayout dots;
    private TextView[] thedot;
    private SliderAdapter sliderAdapter;
    private Button nextbtn;
    private Button backbtn;
    private Button skipbtn;
    private Button getstartbtn;
    private int lagiliatpagenya;
    private FontFamily font;
    private TextView subtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_layout);

        introslide = (ViewPager) findViewById(R.id.slideviewpager);
        dots = (LinearLayout) findViewById(R.id.indicator);
        sliderAdapter = new SliderAdapter(this);
        subtitle = (TextView) findViewById(R.id.subtitle);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        backbtn = (Button) findViewById(R.id.prevbtn);
        skipbtn = (Button) findViewById(R.id.skipbutton);
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skipbtn = new Intent(IntroSlide.this, MainActivity.class);
                startActivity(skipbtn);
                finish();
            }
        });
        getstartbtn = (Button) findViewById(R.id.getstart);
        getstartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getstartbtn = new Intent(IntroSlide.this, MainActivity.class);
                startActivity(getstartbtn);
                finish();
            }
        });
        introslide.setAdapter(sliderAdapter);
        dotsindicator(0);
        introslide.addOnPageChangeListener(userliat);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                introslide.setCurrentItem(lagiliatpagenya + 1);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                introslide.setCurrentItem(lagiliatpagenya - 1);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                introslide.setCurrentItem(lagiliatpagenya - 1);
            }
        });

    }


    public void dotsindicator(int postion) {
        thedot = new TextView[3];
        dots.removeAllViews();
        for (int i = 0; i < thedot.length; i++) {
            thedot[i] = new TextView(this);
            thedot[i].setText(Html.fromHtml("&#8226;"));
            thedot[i].setTextSize(35);
            thedot[i].setPadding(2, 0, 2, 0);
            thedot[i].setTextColor(getResources().getColor(R.color.gray));

            dots.addView(thedot[i]);
        }
        if (thedot.length > 0) {
            thedot[postion].setText(Html.fromHtml("&#8226;"));
            thedot[postion].setTextColor(getResources().getColor(R.color.base));
            thedot[postion].setPadding(2, 0, 2, 0);
        }
    }

    ViewPager.OnPageChangeListener userliat = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            dotsindicator(i);
            lagiliatpagenya = i;

            if (i == 0) {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                getstartbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);
                nextbtn.setVisibility(View.VISIBLE);
                getstartbtn.setVisibility(View.INVISIBLE);

                getstartbtn.setText("");
                nextbtn.setText("Next");
                backbtn.setText("");
            } else if (i == thedot.length - 1) {
                nextbtn.setEnabled(false);
                backbtn.setEnabled(false);
                getstartbtn.setEnabled(true);
                backbtn.setVisibility(View.INVISIBLE);
                nextbtn.setVisibility(View.INVISIBLE);
                getstartbtn.setVisibility(View.VISIBLE);

                getstartbtn.setText("Get Started");
                nextbtn.setText("");
                backbtn.setText("");
            } else {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                getstartbtn.setEnabled(false);
                backbtn.setVisibility(View.VISIBLE);
                getstartbtn.setVisibility(View.INVISIBLE);
                nextbtn.setVisibility(View.VISIBLE);

                getstartbtn.setText("");
                nextbtn.setText("Next");
                backbtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}