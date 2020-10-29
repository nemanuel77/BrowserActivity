package temple.edu;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


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
    String theUrl;

    sendURLToFragment parentActivity;

    private Bundle saveState = null;





    public PageViewerElement() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PageViewerElement newInstance() {
        PageViewerElement fragment = new PageViewerElement();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("URL", theUrl);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof sendURLToFragment)
            parentActivity = (sendURLToFragment) context;
        else
            throw new RuntimeException("Activity doesn't implement sendURLToFragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_page_viewer_element, container, false);
        webView = myView.findViewById(R.id.web_PVF);

        if(savedInstanceState != null){
            theUrl = savedInstanceState.getString("URL");
            webView.loadUrl(theUrl);
        }

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                theUrl = request.getUrl().toString();
                Toast.makeText(getActivity(), theUrl, Toast.LENGTH_LONG).show();
                parentActivity.sendURLToTxt(theUrl);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });


//        webView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String theurl = webView.getUrl();
//                Toast.makeText(getActivity(), theurl, Toast.LENGTH_LONG).show();
//                parentActivity.sendURLToTxt(theurl);
//            }
//        });


        return myView;
    }

    public void getURLFromParent(String string) {
        webView.loadUrl(string);

    }

    public void goBack(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            Toast.makeText(getActivity(), "There is no webpage to go back to.", Toast.LENGTH_LONG).show();
        }
    }

    public void goForward(){
        if(webView.canGoForward()){
            webView.goForward();
        }
        else{
            Toast.makeText(getActivity(), "There is no webpage to go forward to.", Toast.LENGTH_LONG).show();
        }
    }

    public interface sendURLToFragment{
         void sendURLToTxt(String string);
    }


}