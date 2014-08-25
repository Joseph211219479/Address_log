package com.example.login.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.login.R;

/**
 * Created by Common Sense on 8/24/2014.
 */
public class view_details extends Activity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_details);

        Button btnclose =  (Button) findViewById(R.id.btnClose);
        btnclose.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnClose:
                finish();
                break;
        }
    }
}