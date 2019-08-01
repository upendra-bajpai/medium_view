package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.text.HtmlCompat;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.github.angebagui.mediumtextview.util.Utils;

/**
 * Created by angebagui on 06/08/2016.
 */

public class ParagraphView extends ElementView{


    private static final String TAG = ParagraphView.class.getSimpleName();

    public ParagraphView(Context context, Element element) {
        super(context, element);
    }

    public ParagraphView(Context context, Elements element) {
        super(context, element);
    }


    protected ParagraphView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        if (getElement() != null){

            if(getElement().children().size()>0){
                Utils.appendView(this,getElement().children());
            }
            if(!getElement().text().isEmpty()){
                Log.d(TAG, "Text : "+getElement());
                setText(getElement().text());
            }
        }

    }

    public void setText(String text){
        Spanned myText = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        Log.d(TAG, "setText: "+myText);
        textView.setText(myText);
        textView.setPadding(Utils.dpToPx(getContext(),16),0,Utils.dpToPx(getContext(),16),0);

        final Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/"+"freight_text_pro.ttf");

        textView.setTypeface(myTypeface,Typeface.NORMAL);
        textView.setLineSpacing(1.2f,1.5f);
        textView.setTextSize(19f);
        textView.setTextColor(getResources().getColor(android.R.color.black));

        addView(textView);
    }

}
