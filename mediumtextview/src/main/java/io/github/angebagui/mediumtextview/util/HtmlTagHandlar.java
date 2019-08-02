package io.github.angebagui.mediumtextview.util;

import android.support.v4.text.HtmlCompat;
import android.text.Editable;
import android.text.Html;

import org.xml.sax.XMLReader;

public class HtmlTagHandlar implements Html.TagHandler {
    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if(tag.equals("ul") && !opening) output.append("\n");
        if(tag.equals("li") && opening) output.append("\n\t•");    }
}
