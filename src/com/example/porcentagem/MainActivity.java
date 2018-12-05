package com.example.porcentagem;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText edtxValor, edtxTaxa;
	
	TextView txtValor, txtTaxa, txtResultado;
	RadioGroup rgRes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edtxTaxa = (EditText) findViewById(R.id.edtxTaxa);
		edtxValor = (EditText) findViewById(R.id.edtxtValor);
		txtValor = (TextView) findViewById(R.id.txtValor);
		txtTaxa = (TextView) findViewById(R.id.txtTaxa);
		txtResultado = (TextView) findViewById(R.id.txtResultado);
		rgRes = (RadioGroup) findViewById(R.id.rgRes);
	}
	public void resultado (View v){
		double valor,taxa;
		String res;
		
		valor = Double.parseDouble(edtxValor.getText().toString());
		taxa = Double.parseDouble(edtxTaxa.getText().toString());
		
		res=calculo(valor, taxa);
		
		txtResultado.setText(res);
		
	}
	public String calculo(double x, double y) {
		double total = (x * y) / 100;
		double valor = x;


		switch (rgRes.getCheckedRadioButtonId()) {
		case R.id.rbdLucro:
			valor = x + total;
			break;
		case R.id.rbdDesconto:
			valor = x - total;
			break;
		default:
			break;
		}
		
		String res;
		res = String.valueOf(valor);
		return res;
	}
}
