package com.troopes.android.utils;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.troopes.android.R;

public class ToolbarUtils {

    private static boolean isBackButtonVisible = false;

    public static void show(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .setVisibility(View.VISIBLE);
            showToolbar(activity);
            showSearchBar(activity);
        }
    }

    public static void hideToolbar(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .setVisibility(View.GONE);
        }
    }

    public static void showToolbar(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .setVisibility(View.VISIBLE);
            // not set title for
            showBackButton(activity);
            showFavourite(activity);
            showShare(activity);
        }
    }

    public static void hide(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .setVisibility(View.GONE);
        }
    }

    public static void showFavourite(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.favourite_button)
                    .setVisibility(View.VISIBLE);
        }
    }

    public static void hideFavourite(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.favourite_button)
                    .setVisibility(View.GONE);
        }
    }

    public static void showShare(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.share_button)
                    .setVisibility(View.VISIBLE);
        }
    }

    public static void hideShare(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.share_button)
                    .setVisibility(View.GONE);
        }
    }

    public static void showBackButton(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.back_button)
                    .setVisibility(View.VISIBLE);
            isBackButtonVisible = true;
        }
    }

    // method to change back button color

    public static void hideBackButton(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.back_button)
                    .setVisibility(View.GONE);
            isBackButtonVisible = false;
        }
    }

    public static void changeBackButtonIcon(Activity activity, Drawable buttonDrawable) {
        if ((activity) != null) {
            ImageButton button = activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.back_button);

            button.setVisibility(View.VISIBLE);
            button.setImageDrawable(buttonDrawable);
            isBackButtonVisible = false;
        }
    }

    public static void setToolbarTitle(Activity activity, String title) {
        if ((activity) != null) {
            TextView textview = activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.toolbar_title);
            textview.setVisibility(View.VISIBLE);
            textview.setText(title);
        }
    }

    public static void setToolbarTitleColor(Activity activity, @ColorRes int color) {
        if ((activity) != null) {
            TextView textview = activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.toolbar_title);
            textview.setTextColor(ContextCompat.getColor(activity, color));
        }
    }

    public static void hideToolbarTitle(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.toolbar)
                    .findViewById(R.id.toolbar_container)
                    .findViewById(R.id.toolbar_title)
                    .setVisibility(View.GONE);
        }
    }

    public static void showSearchBar(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.search_container)
                    .setVisibility(View.VISIBLE);
        }
    }

    public static void hideSearchBar(Activity activity) {
        if ((activity) != null) {
            activity.findViewById(R.id.search_container)
                    .setVisibility(View.GONE);
        }
    }

    public static void setupSimpleToolbar(Activity activity, String title, @ColorRes int color) {
        show(activity);
        hideSearchBar(activity);
        showToolbar(activity);
        hideShare(activity);
        hideFavourite(activity);
        setToolbarTitleColor(activity, color);
        setToolbarTitle(activity, title);
    }

    public static boolean isIsBackButtonVisible() {
        return isBackButtonVisible;
    }
}