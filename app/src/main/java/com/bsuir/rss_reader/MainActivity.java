package com.bsuir.rss_reader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> rssLinks = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenLink = findViewById(R.id.btnOpenLink);
        btnOpenLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.linkText);
        rssLinks.add(editText.getText().toString());
        Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
        switch (view.getId()) {
            case R.id.btnOpenLink:
                intent.putExtra("rssLink", rssLinks.get(0));
                startActivity(intent);
                break;
        }
    }
}