package com.bozidar.microdroid.floatingbutton;

import android.app.Activity;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.OnClickListener;

/**
 * Created by bozidar on 27.04.15..
 */
public class FloatingButtonManager {
    private Activity context;
    private List<SubActionButton> subButtons;
    private FloatingActionButton mainButton;

    public FloatingButtonManager(Activity context) {
        this.context = context;
        subButtons = new ArrayList<>();
    }

    public FloatingActionButton addMainButton(int imageRes, int backgroundRes) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(imageRes);
        FloatingActionButton floatingButton = new FloatingActionButton.Builder(context)
                .setContentView(iv)
                .setBackgroundDrawable(backgroundRes)
                .build();
        this.mainButton = floatingButton;
        return floatingButton;
    }

    public FloatingActionButton addMainButton(int imageRes) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(imageRes);
        FloatingActionButton floatingButton = new FloatingActionButton.Builder(context)
                .setContentView(iv)
                .build();
        this.mainButton = floatingButton;
        return floatingButton;
    }

    public SubActionButton addSubButton(int imageRes, int backgroundRes, String tag) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(imageRes);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(context);
        itemBuilder.setBackgroundDrawable(context.getResources().getDrawable(backgroundRes));
        SubActionButton button = itemBuilder.setContentView(iv).build();
        button.setTag(tag);
        if (context instanceof OnClickListener)
            button.setOnClickListener((OnClickListener) context);
        this.subButtons.add(button);
        return button;
    }

    public void build() {
        switch (subButtons.size()) {
            case 1:
                new FloatingActionMenu.Builder(context)
                        .addSubActionView(subButtons.get(0))
                        .attachTo(mainButton)
                        .build();
                break;
            case 2:
                new FloatingActionMenu.Builder(context)
                        .addSubActionView(subButtons.get(0))
                        .addSubActionView(subButtons.get(1))
                        .attachTo(mainButton)
                        .build();
                break;
            case 3:

                new FloatingActionMenu.Builder(context)
                        .addSubActionView(subButtons.get(0))
                        .addSubActionView(subButtons.get(1))
                        .addSubActionView(subButtons.get(2))
                        .attachTo(mainButton)
                        .build();
                break;
        }


    }
}
