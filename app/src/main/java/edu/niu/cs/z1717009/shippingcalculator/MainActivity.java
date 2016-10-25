package edu.niu.cs.z1717009.shippingcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private ShipItem itemShipped;
    private EditText weightET;
    double weight ;
    private TextView baseCostTV, addedCostTV, shippingCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemShipped = new ShipItem();

        weightET  = (EditText) findViewById(R.id.weightET);
        baseCostTV = (TextView) findViewById(R.id.baseCostTV);
        addedCostTV = (TextView) findViewById(R.id.addedCostTV);
        shippingCostTV= (TextView) findViewById(R.id.shippingCostTV);

        //weight = Double.parseDouble(weightET.toString());

        // set up listener

        weightET.addTextChangedListener(weightTextWatcher);

        }

    private TextWatcher weightTextWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                itemShipped.setWeight(Integer.parseInt(s.toString()));
            }
            catch(NumberFormatException e){
                itemShipped.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        baseCostTV.setText("$ "+ df.format(itemShipped.getBaseCost()));
        addedCostTV.setText("$ "+ df.format(itemShipped.getAddedCost()));
        shippingCostTV.setText("$ "+ df.format(itemShipped.getShippingCost()));
    }
}

