package io.github.angebagui.mediumtextview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.text.HtmlCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import io.github.angebagui.mediumtextview.util.HtmlTagHandlar;
import io.github.angebagui.mediumtextview.util.Utils;

public class UnoLListView extends ElementView {
    private static final String TAG = UnoLListView.class.getSimpleName();


    public UnoLListView(Context context, Element element) {
        super(context, element);
    }


    @Override
    public void render() {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        /*
            if(getElements()!=null){
                Utils.appendView(getElements());
            }*/
            if(!getElement().text().isEmpty()){

                setText(getElement().toString());
            }


    }

    public void setText(String text){
        Log.d(TAG, "TextUl : "+getElement());
        //Spanned myText = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT);
        Spanned myText=Html.fromHtml(text, null, new HtmlTagHandlar());
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        Log.d(TAG, "setTextD: "+myText);
        textView.setText(myText);
        textView.setPadding(Utils.dpToPx(getContext(),16),0,Utils.dpToPx(getContext(),16),0);

        final Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/"+"freight_text_pro.ttf");

        textView.setTypeface(myTypeface,Typeface.NORMAL);
        textView.setLineSpacing(1.2f,1.1f);
        textView.setTextSize(19f);
        textView.setTextColor(getResources().getColor(android.R.color.black));

        addView(textView);
    }

}
