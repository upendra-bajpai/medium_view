package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import org.jsoup.select.Elements;


public abstract class ElementsView extends LinearLayout {
    private Elements element;

    protected ElementsView(Context context, Elements element) {
        super(context);
        this.element = element;
        render();
    }




    protected ElementsView(Context context, AttributeSet attrs, Elements element) {
        super(context, attrs);
        this.element = element;
        render();
    }

    public Elements getElements() {
        return element;
    }

    public void setElements(Elements element) {
        this.element = element;
    }

    public abstract void render();
}
