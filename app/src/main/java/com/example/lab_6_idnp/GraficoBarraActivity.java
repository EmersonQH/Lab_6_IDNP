package com.example.lab_6_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class GraficoBarraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico_barra);

        double[] y ={20.7,46.6,28.6,14.5,23.4,27.4,32.9,28.3,29,34.8,32.9,16.7,18,27.5};
        String[] x ={"Argentina","Bolivia","Brazil","Canada","Chile","Colombia","Ecuador",
                    "Guyana","Mexico","Paraguay","Peru","USA","Uruguay","Venezuela"};
        Barras vista = new Barras(this,x,y);
        setContentView(vista);
    }
}
class Barras extends View{
    private int alto, ancho;
    private int temp1, temp2;
    private double[] valor;
    private String[] pais;
    private int cant;
    private int colorBar = Color.RED;
    public Barras(Context context, String[] paises, double[] valores) {
        super(context);
        setAtributos(paises, valores);
    }

    private void setAtributos(String[] paises, double[] valores) {
        pais = paises;
        valor = valores;
    }
    private void drawBars(Canvas canvas){
        DibujarBase(canvas);
        setCant(pais.length);
        for(int i =0; i< pais.length;i++){
            DibujarBarra(canvas, valor[i], pais[i]);
        }
    }
    protected void onDraw(Canvas canvas){drawBars(canvas);}
    public void DibujarBase(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        ancho = canvas.getWidth();
        alto = canvas.getHeight();
        canvas.drawRect(10,alto/4,ancho-10,alto-alto/4,paint);
        int lineaB = alto/3*2;
        paint.setStrokeWidth(5);
        canvas.drawLine(25,lineaB,ancho-25,lineaB,paint);
        canvas.drawLine(50,lineaB+25,50,(alto/4)/+30,paint);
        paint.setTextSize(30-cant);
        for(int i=0; i<7;i++){
            canvas.drawText((i*10)+"",20,lineaB-(i*100),paint);
        }

    }
    public void DibujarBarra(Canvas canvas, double peso, String str){
        Paint paint = new Paint();
        paint.setStrokeWidth(60);
        paint.setColor(Color.RED);
        int lineB = alto/3*2;
        canvas.drawLine((float) temp1,(float) lineB,(float) temp1,(float) (lineB-(peso*10)),paint);
        paint.setColor(Color.BLACK);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(40-cant);
        canvas.drawText(str,temp1,lineB+50,paint);
        temp1 += temp2;
    }
    public void setCant(int x){
        temp1 = ancho / (x+1)+10;
        temp2 = ancho / (x+1);
        cant = x;
    }
}









