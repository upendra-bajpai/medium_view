package io.github.angebagui.mediumtextview.util;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by angebagui on 06/08/2016.
 */

public class JsoupUtils {


    public static boolean isParagraph(Element element){
        if (element.tagName().equals("p")){
            Log.d(TAG, "isParagraph: ");
        }
        return element.tagName().equals("p");

    }

    public static boolean isUl(Element element){
        if (element.tagName().equals("ul")){
            Log.d(TAG, "isisUl: ");
        }
        return element.tagName().equals("ul");

    }
    public static boolean isIFrame(Element element){
        return element.tagName().equals("iframe");
    }

    public static boolean isImage(Element element){
        return element.tagName().equals("img");
    }

    public static boolean isHeader(Element element){
        return element.tagName().equals("h");
    }

    public static boolean isBlockquote(Element element){
        return element.tagName().equals("blockquote");
    }

    public static boolean isDiv(Element element){
        if (element.tagName().equals("p")){
            Log.d(TAG, "isDiv: "+element.html());
        }
        return element.tagName().equals("div");
    }

    public static boolean hasChildren(Element element){
        return element.children().size()>0;
    }


    public static List<String> findAllVideoLinks(String content){
        final List<String> links = new ArrayList<>();
        final Document document = Jsoup.parse(content);
        Elements medias = document.select("[src]");
        for (Element element: medias){
            if(element.tagName().equals("iframe")){
                links.add(element.attr("abs:src"));
            }else{

            }
        }
        return links;
    }
    public static List<String> findAllImagesLinks(String content){
        final List<String> links = new ArrayList<>();
        final Document document = Jsoup.parse(content);
        Elements medias = document.select("[src]");
        for (Element element: medias){
            if(element.tagName().equals("img")){
                links.add(element.attr("abs:src"));
            }else{

            }
        }
        return links;
    }
}
