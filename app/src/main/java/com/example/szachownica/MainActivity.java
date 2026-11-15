package com.example.szachownica;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.Toast;
public class MainActivity extends Activity {
    private Panel panelSzachownicy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        panelSzachownicy = new Panel(this);
        setContentView(panelSzachownicy);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem wybranyElement) {
        int identyfikator = wybranyElement.getItemId();
        if (identyfikator == R.id.menu_tworca) {
            Toast.makeText(
                    this,
                    "Mikołaj Grzegorczyk",
                    Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        if (identyfikator == R.id.menu_wyjscie) {
            finish();
            return true;
        }
        if (identyfikator == R.id.menu_kolor_czarno_bialy) {
            panelSzachownicy.ustawKolory(0xFF000000, 0xFFFFFFFF);
            Toast.makeText(this, "czarno białe", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (identyfikator == R.id.menu_kolor_czerwono_zolty) {
            panelSzachownicy.ustawKolory(0xFFCC2020, 0xFFFFD54F);
            Toast.makeText(this, "czerowno żółte", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(wybranyElement);
    }
}
