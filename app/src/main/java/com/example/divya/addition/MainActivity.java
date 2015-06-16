package com.example.divya.addition;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.divya.addition.models.Controller;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = new WebView(this);
        GlobalVariables.MainWebView = myWebView;
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
        myWebView.loadUrl("http://172.16.3.203:9000/app-int/app-int/");
        Controller a = new Controller(this);
        a.name.value = "Divya";
        a.status.value = true;
        a.last_contact.value = "TODAY!!!!!!";
        a.save();
        // TODO: to make class with all the specifications kc gave.:-)
    }
    public void onButtonClick(View v){

        WebView myWebView = GlobalVariables.MainWebView;
        myWebView.loadUrl("javascript:check();");
        Controller b = new Controller(this);
        b.get(" 1 ");
        Toast.makeText(this, b.name.value , Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
