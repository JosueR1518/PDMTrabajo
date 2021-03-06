package sv.fia.ues.controltesisw;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EtapaInsertarActivity extends Activity {

	EditText editidEtapa;
	EditText editfechaDeInicioEtapa;
	EditText editfechaDeFinalizacionEtapa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etapa_insertar);
		//helper = new ControlBDCarnet(this);
		editidEtapa = (EditText) findViewById(R.id.editIDEtapa);
		editfechaDeInicioEtapa = (EditText) findViewById(R.id.editFechaDeInicioEtapa);
		editfechaDeFinalizacionEtapa = (EditText) findViewById(R.id.editFechaDeFinalizacionEtapa);
		
	}

	
	
	public void insertarEtapa(View v)
	{
	String idE = editidEtapa.getText().toString();
	String fi = editfechaDeInicioEtapa.getText().toString();
	String ff = editfechaDeFinalizacionEtapa.getText().toString();
	String regInsertados;
	Etapa e = new Etapa();
	e.setIdEtapa(idE);
	e.setFechaDeInicioEtapa(fi);
	e.setFechaDeFinalizacionEtapa(ff);
	
	if(verificarDatos(e))
	{
	
	TextView mensaje=new TextView(this);
	//mensaje.setText(regInsertados);
	Dialog d=new Dialog(this);
	d.setTitle("Resultado de la Operacion");
	d.setContentView(mensaje);
	d.show();
	}else
		Toast.makeText(this,"Error al ingresar los datos, todos los campos deben estar completados",Toast.LENGTH_LONG).show();

		
	}
	public void limpiarTexto(View v){
		editidEtapa.setText("");
		editfechaDeInicioEtapa.setText("");
		editfechaDeFinalizacionEtapa.setText("");
	}
	@SuppressLint("NewApi")
	public boolean verificarDatos(Etapa et){
		if(et.getIdEtapa().isEmpty()||et.getFechaDeInicioEtapa().isEmpty()|| et.getFechaDeFinalizacionEtapa().isEmpty()){
			return false;
		}else
			return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.etapa_insertar, menu);
		return true;
	}

}
