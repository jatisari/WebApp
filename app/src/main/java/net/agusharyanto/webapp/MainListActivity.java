package net.agusharyanto.webapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainListActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Detik",
                "Kompas",
                "Kemkes",
                "Kemendagri",
                "Kemendes",
                "Basic View 6",
                "Exit"

        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
                openActivity(itemValue);
            }
        });

    }

    private void openActivity(String itemValue) {
        Log.d("TAG","itemValue:"+itemValue);
        Intent intent=null;
        String url="";
        if (itemValue.equals("Detik")){
            url="http://detik.com";
        } else if (itemValue.equals("Kompas")){
            url="http://kompas.com";
        }else if (itemValue.equals("Kemkes")){
            url="http://kemkes.co.id";
        } else if (itemValue.equals("Kemendagri")){
            url="http://www.kemendagri.go.id";
        }else if (itemValue.equals("Kemendesa")){
            url="http://www.kemendesa.go.id";
        }
        intent = new Intent(MainListActivity.this, MainActivity.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }




}
