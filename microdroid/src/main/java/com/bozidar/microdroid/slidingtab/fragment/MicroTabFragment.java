package com.bozidar.microdroid.slidingtab.fragment;

import com.bozidar.microdroid.base.MicroFragment;

/**
 * Created by bozidar on 24.04.15..
 */

/**
 * Base class for fragments which will represents view inside tabs
 */
public abstract class MicroTabFragment extends MicroFragment {
    /**
     * Abstract method for setup title of tab
     *
     * @return Title of tab
     */
    public abstract String setTabTitle();
}
