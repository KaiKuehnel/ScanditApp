package com.example.scanditapptest;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSettings;
import com.scandit.datacapture.barcode.data.Symbology;
import com.scandit.datacapture.core.capture.DataCaptureContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DataCaptureContext dataCaptureContext = DataCaptureContext.forLicenseKey("ASjufRD6DiSIAOhIOhGVBwYUhh35E9nxfnuypBgN5CkeEQTaWlK5H7FXGWLoU4tk3W3WNvFUo8f6W8FXF3HHMH55NhWjebSEhis5n1suPjo/GUXDzmoH6VQvERqKeaBr0nRFweV/BH+Ld1aPKWqw0Ohv7NWnX4I43luW0V1tTojRcjI3wV/SjZ1x/+5jMsHsMUOmqX9KwOvMS10NXUrxapdWmoklQ1Gd11DQe+Eik38BbX2TjGn4UURqVCW4ZT1klnw40s5oW0PkWlhwUXYjCqhon1KudeEW30QwJdp6nZipcbPzDikzYDBCHq5pZ4m0d1DF1nQg1vEfV9Ofm0pWOY4W2Jz0d2/0+Sixg7V0ouq7W6ucqUone4EskDlrVyBR72u1UHlklSf1XbiLKlb+eXxQqz92Zo+Ygnk0msgW2wQsLxlVRHy+khJuxpdVJggC0BCGDE5y1WNzMEq9vnjIEkVb+R0fbpK/2lJOFN5QJHEIe0W8DmS6+nQVpGjoSU34lQEVTnI5Al5yFRMC+74zWnqBLOxBqtPIhZufEWIElCzzM0QnRUp6og6LKjaxy+g2ZhUSvNl1cQG/sBXs1NeXCJkgvQpELkZ6/yxW6CahuxqQtHv2sEFiq3y1PrEPXXxKw8QTT7Nq0PceOiBX5+uudESMlaiT/jsEn+YWzi5W+LZq22sQLcu75jv6XZGaFQwiBpKuW9ymWtI+gKQy8OTnqkBBZ7m4hAYKN7H8TujKcINIfmUM0GTaAHkW/mmYU8QKVdJeSedyIFrPi/N5qhSYJ3cde3VKkg+uM4AbQ0FaNfPANOarFu2mq3Ou/3v+wjvSmU+CE7uJo4Ula9OBRQng3slYbAmF+DfkLWOHqk5F+YXYge1lJ2DP8DcAS1uqhXlCAwGWwQ+bv7o+ElVi6y5cOXP4XNLSX7CFeM+Ln2i862x6j/GBTw7XdaOvsVFW2ICsyvth+Jn7OMOnknfXDR8jBTqLJ/VudkHIiXkD/uFUO2sIqARrakUQaFNNmKsNJUNcjUEHYIzInfSk0j5cya/lLw+xCAT11hp8fRwLq2QN+qS3ZixQbm+IAUd9ydlrnCpnvtG94qif5+vkf0uwHjgyBNfrKJtzVGTv7gAtacnelRxNsHYuPjWN6Gh31A2CcpNB3Hji2lbiPxhShki80I+IAejidpEye5u5oWn2xtJ1AAsWrfMqXitK0KdUg7E=");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeSettings(){
        BarcodeCaptureSettings settings = new BarcodeCaptureSettings();

        settings.enableSymbology(Symbology.CODE128, true);
        settings.enableSymbology(Symbology.CODE39, true);
        settings.enableSymbology(Symbology.QR, true);
        settings.enableSymbology(Symbology.EAN8, true);
        settings.enableSymbology(Symbology.UPCE, true);
        settings.enableSymbology(Symbology.EAN13_UPCA, true);

        BarcodeCapture barcodeCapture  = BarcodeCapture.forDataCaptureContext(dataCaptureContext, settings);
    }
}
