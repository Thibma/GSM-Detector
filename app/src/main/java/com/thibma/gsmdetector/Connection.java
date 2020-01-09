package com.thibma.gsmdetector;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class Connection {

    // ATTRIBUTS //

    private int icon;
    private String text;

    // METHODES //

    /** icon */

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    /** text */

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
