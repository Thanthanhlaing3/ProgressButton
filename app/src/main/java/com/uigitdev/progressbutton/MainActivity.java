package com.uigitdev.progressbutton;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {
    private CardView button_parent;
    private RelativeLayout button;
    private TextView button_title;
    private ProgressBar button_progress;
    private ImageView button_error_icon;

    public enum BUTTON_TYPES {
        SUCCESS,
        LOADING,
        ERROR
    }

    //Click test
    private int buttonStyleTestClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setType();
        setOnClickSubmit();
    }

    private void setType() {
        button_parent = findViewById(R.id.button_parent);
        button = findViewById(R.id.button);
        button_title = findViewById(R.id.button_title);
        button_progress = findViewById(R.id.button_progress);
        button_error_icon = findViewById(R.id.button_error_icon);
    }

    private void setOnClickSubmit() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonStyleTestClick++;
                if (buttonStyleTestClick == 1) {
                    //Loading
                    setButtonStyle(BUTTON_TYPES.LOADING);
                } else if (buttonStyleTestClick == 2) {
                    //Error
                    setButtonStyle(BUTTON_TYPES.ERROR);
                } else {
                    //Simple
                    setButtonStyle(BUTTON_TYPES.SUCCESS);
                    buttonStyleTestClick = 0;
                }
            }
        });
    }

    @SuppressLint("ResourceType")
    private void setButtonStyle(BUTTON_TYPES buttonType) {
        if (buttonType == BUTTON_TYPES.SUCCESS) {
            buttonErrorIconIsVisible(false);
            buttonProgressIsVisible(false);
            buttonTitleIsVisible(true);
            button_parent.setCardBackgroundColor(Color.parseColor(getString(R.color.colorSuccessful)));
            button_title.setText(getString(R.string.success_title));
            button_title.setTextColor(Color.parseColor(getString(R.color.colorWhite)));
        } else if (buttonType == BUTTON_TYPES.LOADING) {
            buttonErrorIconIsVisible(false);
            buttonProgressIsVisible(true);
            buttonTitleIsVisible(true);
            button_parent.setCardBackgroundColor(Color.parseColor(getString(R.color.colorLoading)));
            button_title.setText(getString(R.string.loading_title));
            button_title.setTextColor(Color.parseColor(getString(R.color.colorLoadingTitle)));
        } else {
            buttonErrorIconIsVisible(true);
            buttonProgressIsVisible(false);
            buttonTitleIsVisible(false);
            button_parent.setCardBackgroundColor(Color.parseColor(getString(R.color.colorUnsuccessful)));
        }
    }

    private void buttonErrorIconIsVisible(boolean isVisible) {
        if (isVisible) {
            button_error_icon.setVisibility(View.VISIBLE);
        } else {
            button_error_icon.setVisibility(View.GONE);
        }
    }

    private void buttonProgressIsVisible(boolean isVisible) {
        if (isVisible) {
            button_progress.setVisibility(View.VISIBLE);
        } else {
            button_progress.setVisibility(View.GONE);
        }
    }

    private void buttonTitleIsVisible(boolean isVisible) {
        if (isVisible) {
            button_title.setVisibility(View.VISIBLE);
        } else {
            button_title.setVisibility(View.GONE);
        }
    }
}
