package devaguptam.sreelaya.g.teachingassistant;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.common.util.IOUtils;
import com.google.firebase.database.DatabaseReference;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Articles extends AppCompatActivity {

    PDFView pdf;
    String url;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        pdf=findViewById(R.id.pdfViewArticles);
        url="https://firebasestorage.googleapis.com/v0/b/teaching-assistant-72a29.appspot.com/o/begginner%2Farticles.pdf?alt=media&token=968e8fb1-058f-4c6e-8350-225de22974d2";
        new RetrievePDFbyte()
                .execute(url);
    }

    class RetrievePDFbyte extends AsyncTask<String,Void,byte[]> {
        ProgressDialog progressDialog;
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(Articles.this);
            progressDialog.setTitle("getting the content...");
            progressDialog.setMessage("Please wait...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

        }

        @Override
        protected byte [] doInBackground(String... strings) {
            InputStream inputStream = null;
            try{
                URL url=new URL(strings[0]);
                HttpsURLConnection httpsURLConnection=(HttpsURLConnection)url.openConnection();
                if (httpsURLConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(httpsURLConnection.getInputStream());
                }
            }catch (IOException e){
                return null;
            }
            try {
                return IOUtils.toByteArray(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  null;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            pdf.fromBytes(bytes).load();
            progressDialog.dismiss();
        }

    }
}
