package com.example.trejee.pos020218;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    double whippedCream= .25;
    double coco= .50;
    double cost= 2.75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBackground();
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {

        CheckBox whippedCreamBox = (CheckBox) findViewById(R.id.whippedCreamBox);
        boolean hasWhippedCream = whippedCreamBox.isChecked();
        CheckBox cocoBox= (CheckBox) findViewById(R.id.cocoBox) ;
        boolean hascoco= cocoBox.isChecked();

        EditText nameTextBox =  (EditText)findViewById(R.id.nameTextBox);

        double Total=0;
        if( hasWhippedCream && hascoco){
            Total = (cost*quantity) + (quantity*whippedCream)+(quantity*coco);
        } else if (hascoco) {
            Total = (cost*quantity) + (quantity*coco) ;
        } else if ( hasWhippedCream){
            Total = (cost*quantity) + (quantity*whippedCream);
        } else
            Total = cost*quantity;

        String content = nameTextBox.getText().toString();
        String toppingsMessage = content + "\n add whipped cream?" + "\n"+ hasWhippedCream;
        String quantityMessage = " \n Quantity: " + quantity;
        String tyMessage = " \n Thank You";
        String priceMessage = " \n Total: $"+ Total;
        String finalMessage = quantityMessage+priceMessage+tyMessage;

        displayMessage( finalMessage);


    }

    public void playBackground(){

        MediaPlayer mp= MediaPlayer.create(this,R.raw.boogieboogie);

    }
    /**
     * This method displays the given quantity value on the screen.
     */

    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantitynumber);
        quantityTextView.setText("" + number);
    }


    public void displayMessage(String message){
        TextView quantityTextView = (TextView) findViewById(R.id.order_summary_text_view);
        quantityTextView.setText(message);

    }

    public void increment(View view){
        quantity++;
        display(quantity);
    }

    public void decrement(View view){

        if(quantity>0){
            quantity--;
            display(quantity);
        }
    }
}

