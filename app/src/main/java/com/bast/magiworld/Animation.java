package com.bast.magiworld;

import android.widget.ImageSwitcher;

import android.os.Handler;

public interface Animation {
    void running(final ImageSwitcher imageSwitcher, boolean isFighting);
    void runningReverse(final ImageSwitcher imageSwitcher, boolean isFighting);
    void death();
    void win();
    void attBase();
    void attSpe();

}
