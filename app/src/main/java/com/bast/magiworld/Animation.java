package com.bast.magiworld;

import android.widget.ImageSwitcher;

import android.os.Handler;

public interface Animation {
    void running(final ImageSwitcher imageSwitcher);
    void runningReverse(final ImageSwitcher imageSwitcher);
    void death(final ImageSwitcher imageSwitcher);
    void win(final ImageSwitcher imageSwitcher);
    void attBase(final ImageSwitcher imageSwitcher);
    void attSpe(final ImageSwitcher imageSwitcher);

}
