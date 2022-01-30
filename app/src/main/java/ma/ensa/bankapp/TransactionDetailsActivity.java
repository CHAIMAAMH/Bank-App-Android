package ma.ensa.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransactionDetailsActivity extends AppCompatActivity {

    // Travail a faire
    // 1. Rajouter deux boutons en bas de l'ecran
    // 1.1 premier bouton permet de passer un appel pour l'agence
    // 1.2 dexuieme bouton qui permet d'affciher une nouvelle activite Maps avec un ensemble d'agence sous forme de Marker
    // Creer une nouvelle activite Maps
    // Generer la cle Maps en utilisant le lien dans le fichier settings
    // Rajoter des MArkers dans Maps avec les bonnes positions
    TextView compte;
    TextView desc;
    TextView montant;
    TextView date;
    TextView solde;
    TextView ref;
    Button displaybtn;
    Button callbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);
    }

    @Override
    protected void onResume() {
        super.onResume();

        compte = findViewById(R.id.compte);
        desc = findViewById(R.id.description);
        montant = findViewById(R.id.montant);
        date = findViewById(R.id.date);
        solde = findViewById(R.id.solde);
        ref = findViewById(R.id.reference);
        displaybtn =  findViewById(R.id.displaybtn);
        callbtn = findViewById(R.id.callbtn);

        Bundle b = getIntent().getExtras();
        Transaction tr = (Transaction) b.get("transactionObject");

        compte.setText(tr.getNumCompte());
        desc.setText(tr.getLabel());
        montant.setText(tr.getPrice());
        date.setText(tr.getDate());
        solde.setText(""+tr.getSolde());
        ref.setText(tr.getNumRef());


        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });


        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phone = Uri.parse("tel:+212500000000");
                Intent call = new Intent(Intent.ACTION_DIAL, phone);
                startActivity(call);
            }
        });
    }
}