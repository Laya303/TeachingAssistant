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

public class Cnp extends AppCompatActivity {

    PDFView pdf;
    String url;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnp);

        pdf=findViewById(R.id.pdfViewCnp);
        url="https://firebasestorage.googleapis.com/v0/b/teaching-assistant-72a29.appspot.com/o/novice%2FConjunctions%20and%20Prepositions.pdf?alt=media&token=15f32a70-21fa-4e8a-9fdf-73b57f9ab38f";
        new RetrievePDFbyte()
                .execute(url);
    }

    class RetrievePDFbyte extends AsyncTask<String,Void,byte[]> {
        ProgressDialog progressDialog;
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(Cnp.this);
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
