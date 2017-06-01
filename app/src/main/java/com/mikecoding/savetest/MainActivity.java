package com.mikecoding.savetest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "com.mikecoding.savetest.MyPREFERENCES";
    public static final String EMAIL_KEY = "emailKey";
    EditText myEmailView;
    SharedPreferences sharedPreferences;
    Button myButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding textview to layout test
        TextView helloView = (TextView) findViewById(R.id.hello);
        TextView myTextView = new TextView(this);
        myTextView.setText("Hej Världen");
        RelativeLayout.LayoutParams myLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        myLayoutParams.addRule(RelativeLayout.BELOW, R.id.text_login);
        myLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, 1);
        RelativeLayout myLayout =  (RelativeLayout) findViewById(R.id.activity_main);
        myTextView.setLayoutParams(myLayoutParams);
        myLayout.addView(myTextView);

        //saving test
        myEmailView = (EditText) findViewById(R.id.email_view);
        myButton = (Button) findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String storedEmail = sharedPreferences.getString(EMAIL_KEY, null);
        if(storedEmail != null){
            myEmailView.setText(storedEmail, TextView.BufferType.EDITABLE);
        }

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = myEmailView.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(EMAIL_KEY, email);
                editor.commit();

            }
        });



    }
}
