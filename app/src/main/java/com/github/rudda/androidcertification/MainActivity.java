package com.github.rudda.androidcertification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showToastButton;
    private Button showToastOnTopRightButton;
    private Button showCustomToastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    /**
     * this method init all views and set click method for each button
     */
    private void init() {
        showToastButton = (Button) findViewById(R.id.button);
        showToastOnTopRightButton = (Button) findViewById(R.id.button2);
        showCustomToastButton = (Button) findViewById(R.id.button3);

        showToastButton.setOnClickListener(this);
        showCustomToastButton.setOnClickListener(this);
        showToastOnTopRightButton.setOnClickListener(this);

    }

    /**
     * init and return a Toast Object
     * @return Toast
     */

    public Toast initToast() {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        return Toast.makeText(context, text, duration);
    }


    public void showBasicToast(Toast toast) {
        toast.show();
    }

    public void showToastOnRightCorner(Toast toast) {
        toast.setGravity(Gravity.TOP| Gravity.RIGHT, 0, 0);
        toast.show();
    }

    public void showCustomToast(Toast toast) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.layout_custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.show();

    }

    /**
     * handle click events
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                showBasicToast(initToast());
                break;
            case R.id.button2:
                showToastOnRightCorner(initToast());
                break;
            case R.id.button3:
                showCustomToast(initToast());
                break;
        }
    }
}