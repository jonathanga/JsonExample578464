package co.edu.sena.jonathan.jsonexample578464;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadJSON(View view) {
        tareaCargar objEjecutar = new tareaCargar();
        objEjecutar.execute();
    }

    private class tareaCargar extends AsyncTask<String,Integer,Boolean>{

        private String datos;
        private List<Producto> productos = new ArrayList<Producto>();
        @Override
        protected Boolean doInBackground(String... strings) {
            HttpClient cliente = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://www.submarino.com.br/productinfo?itens=113067295,113918310,113067252,113285305,114980465,113437196,113918272");
            httpGet.setHeader("content-type","application/json");
            try {
                HttpResponse respuesta = cliente.execute(httpGet);
                datos = EntityUtils.toString(respuesta.getEntity());

                JSONObject jsonObject = new JSONObject(datos);
                JSONArray jsonArray = jsonObject.getJSONArray("products");

                for(int i=0; i < jsonArray.length();i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    Producto temp = new Producto();
                    temp.setCodigo(obj.getString("id"));
                    temp.setNombre(obj.getString("name"));
                    temp.setPrecio(obj.getString("sales_price"));
                    temp.setImagen(obj.getString("image"));
                    productos.add(temp);
                }


                return true;

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            TextView myText = (TextView)findViewById(R.id.texto);
            myText.setText(datos);
        }
    }
}
