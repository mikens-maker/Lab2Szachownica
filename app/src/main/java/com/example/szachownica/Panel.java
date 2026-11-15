package com.example.szachownica;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import static java.lang.Math.min;
public class Panel extends View {
    private final Paint farbaPierwsza = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint farbaDruga = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint farbaObramowania = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int kolorPierwszy = 0xFF000000;
    private int kolorDrugi = 0xFFFFFFFF;
    public Panel(Context kontekst) {
        super(kontekst);
        farbaObramowania.setColor(0xFF333333);
        farbaObramowania.setStyle(Paint.Style.STROKE);
        farbaObramowania.setStrokeWidth(2f);
        setBackgroundColor(0xFFF2F2F2);
    }
    public void ustawKolory(int nowyPierwszy, int nowyDrugi) {
        kolorPierwszy = nowyPierwszy;
        kolorDrugi = nowyDrugi;
        invalidate();
    }
    @Override
    protected void onDraw(Canvas plansza) {
        super.onDraw(plansza);
        float margines = getResources().getDisplayMetrics().density * 16f;
        float bokPlanszy = min(getWidth(), getHeight()) - 2f * margines;

        if (bokPlanszy <= 0f) {
            return;
        }

        float lewy = (getWidth() - bokPlanszy) / 2f;
        float gora = (getHeight() - bokPlanszy) / 2f;
        float bokPola = bokPlanszy / 8f;
        farbaPierwsza.setColor(kolorPierwszy);
        farbaDruga.setColor(kolorDrugi);
        for (int wiersz = 0; wiersz < 8; wiersz++) {
            for (int kolumna = 0; kolumna < 8; kolumna++) {
                float lewaKrawedz = lewy + kolumna * bokPola;
                float gornaKrawedz = gora + wiersz * bokPola;
                RectF pole = new RectF(
                        lewaKrawedz,
                        gornaKrawedz,
                        lewaKrawedz + bokPola,
                        gornaKrawedz + bokPola
                );
                Paint wybranaFarba =
                        ((wiersz + kolumna) % 2 == 0) ? farbaPierwsza : farbaDruga;
                plansza.drawRect(pole, wybranaFarba);
            }
        }
        plansza.drawRect(
                lewy, gora,
                lewy + bokPlanszy, gora + bokPlanszy,
                farbaObramowania
        );
    }
}
