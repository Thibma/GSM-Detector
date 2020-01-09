package com.thibma.gsmdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** Connection attributs */

    private Connection mWifi;
    private Connection m3G;
    private Connection m4G;
    private Connection mNoConnection;
    private Connection m2G;

    /** Graphics attributs */

    private Button mNoConnectionButton;
    private Button m3GButton;
    private Button m4GButton;
    private Button mWifiButton;
    private Button mDefaultButton;
    private Button m2GButton;

    private ImageView mStatutsImage;
    private TextView mTextImage;

    private NetworkUtils network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Initialisation */

        mWifi = new Connection();
        mWifi.setIcon(R.drawable.wifi_icon);
        mWifi.setText("Connected : Wi-Fi");

        m3G = new Connection();
        m3G.setIcon(R.drawable.icon_3g);
        m3G.setText("Connected : 3G");

        m4G = new Connection();
        m4G.setIcon(R.drawable.icon_4g);
        m4G.setText("Connected : 4G");

        mNoConnection = new Connection();
        mNoConnection.setIcon(R.drawable.no_network_icon);
        mNoConnection.setText("No connection !");

        m2G = new Connection();
        m2G.setIcon(R.drawable.icon_2g);
        m2G.setText("Connected : 2G/Edge");


        /** Liaison ID */

        mStatutsImage = (ImageView) findViewById(R.id.imageConnection);
        mTextImage = (TextView) findViewById(R.id.textConnection);

        mNoConnectionButton = (Button) findViewById(R.id.buttonNoConnection);
        m2GButton = (Button) findViewById(R.id.button2G);
        m3GButton = (Button) findViewById(R.id.button3G);
        m4GButton = (Button) findViewById(R.id.button4G);
        mWifiButton = (Button) findViewById(R.id.buttonWifi);
        mDefaultButton = (Button) findViewById(R.id.buttonDefault);

        m4GButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatutsImage.setImageResource(m4G.getIcon());
                mTextImage.setText(m4G.getText());
            }
        });

        mNoConnectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatutsImage.setImageResource(mNoConnection.getIcon());
                mTextImage.setText(mNoConnection.getText());
            }
        });

        m3GButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatutsImage.setImageResource(m3G.getIcon());
                mTextImage.setText(m3G.getText());
            }
        });

        mWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatutsImage.setImageResource(mWifi.getIcon());
                mTextImage.setText(mWifi.getText());
            }
        });

        m2GButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatutsImage.setImageResource(m2G.getIcon());
                mTextImage.setText(m2G.getText());
            }
        });

        network = new NetworkUtils();
        String typeOfNet = network.getNetwork(this);

        if (typeOfNet == "2G") {
            mStatutsImage.setImageResource(m2G.getIcon());
            mTextImage.setText(m2G.getText());
        }
        else if (typeOfNet == "3G") {
            mStatutsImage.setImageResource(m3G.getIcon());
            mTextImage.setText(m3G.getText());
        }
        else if (typeOfNet == "4G") {
            mStatutsImage.setImageResource(m4G.getIcon());
            mTextImage.setText(m4G.getText());
        }
        else if (typeOfNet == "Wifi") {
            mStatutsImage.setImageResource(mWifi.getIcon());
            mTextImage.setText(mWifi.getText());
        }
        else {
            mStatutsImage.setImageResource(mNoConnection.getIcon());
            mTextImage.setText(mNoConnection.getText());
        }
    }
}
