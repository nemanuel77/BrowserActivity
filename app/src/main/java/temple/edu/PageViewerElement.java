package temple.edu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageViewerElement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageViewerElement extends Fragment {

    TextView textView;
    View myView;
    WebView webView;

    Handler responseHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg){

            webView.loadUrl(msg.toString());
            return false;
        }
    });



    public PageViewerElement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageViewerElement.
     */
    // TODO: Rename and change types and number of parameters
    public static PageViewerElement newInstance(String param1, String param2) {
        PageViewerElement fragment = new PageViewerElement();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_page_viewer_element, container, false);
        webView = myView.findViewById(R.id.web_PVF);
        webView.setWebViewClient(new WebViewClient());


        return myView;
    }

    public void getURLFromParent(String string) {
        webView.loadUrl(string);

    }

}