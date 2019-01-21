package com.example.sazib.routersetuppage;

import android.app.Activity;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private TextView f5577a;
    /* renamed from: b */
    /*private TextView f5578b;*/
    /* renamed from: c */
    private WifiManager f5579c;
    /* renamed from: d */
    private DhcpInfo f5580d;

    /* renamed from: a */
    private String m8758a(int i) {
        return String.valueOf(Formatter.formatIpAddress(i));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.f5579c = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        this.f5580d = this.f5579c.getDhcpInfo();
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

       /* C0602h.m2544a(getApplicationContext(), "ca-app-pub-1488938730579338~6342530207");
        ((AdView) findViewById(R.id.adView)).mo428a(new C0589a().m2489a());*/
        this.f5577a = (TextView) findViewById(R.id.routerIp);
        Button button = (Button) findViewById(R.id.bGo);
        ((Button) findViewById(R.id.btPress)).setOnClickListener(this);
        button.setOnClickListener(this);
        //this.f5578b = (TextView) findViewById(R.id.tvLink);
        //this.f5578b.setOnClickListener(this);
        this.f5579c = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        this.f5580d = this.f5579c.getDhcpInfo();
        this.f5577a.setText(m8758a(this.f5580d.gateway));



    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btPress:
                this.f5579c = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                this.f5580d = this.f5579c.getDhcpInfo();
                this.f5577a.setText(m8758a(this.f5580d.gateway));
                if (this.f5580d.gateway == 0) {
                    Toast.makeText(this, "Please connect to a WiFi first.", Toast.LENGTH_SHORT).show();
                    return;
                }
                return;
            case R.id.bGo:
                if (this.f5580d.gateway != 0) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("http://" + m8758a(this.f5580d.gateway)));
                    startActivity(intent);
                    return;
                }
                Toast.makeText(this, "There's no router page to show.", Toast.LENGTH_SHORT).show();
                return;
            /*case R.id.tvLink:
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.ocapps.routersetuppageadfree"));
                startActivity(intent);
                return;*/
            default:
                return;
        }
    }
}
