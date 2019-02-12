package com.example.thebryan.combarbershapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.thebryan.combarbershapp.Models.Order;
import com.example.thebryan.combarbershapp.Models.Service;

public class Reservation extends AppCompatActivity  implements  View.OnClickListener{

    ImageView main_image,btn_go_to_ImagesService,beforepeoples, nextpeople,beforedate, nextdate,beforeHour,nexthour,beforeBarber,nextbarber;

    TextView service_name,service_price,txtpeoples,txtweekday,txtdate, txthour,txttanda,barbername,barberturno;

    Button btnejecutat;

    Service service = null;

    Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        initUI();

        order = new Order();

        Intent intent = getIntent();



        if(intent.hasExtra("service")){
            service  = (Service) intent.getSerializableExtra("service");
            service_name.setText(service.getName());
            service_price.setText("$ "+ service.getPrice());
            barbername.setText(service.getEmployedList().get(0).getName());
            barberturno.setText("-"+service.getEmployedList().size());
            order.setServiceName(service.getName());


        }




    }


    private void initUI() {


        service_name = findViewById(R.id.service_name);
        service_price = findViewById(R.id.service_price);
        main_image = findViewById(R.id.main_image);
        btn_go_to_ImagesService = findViewById(R.id.btn_go_to_ImagesService);
        beforepeoples = findViewById(R.id.beforepeoples );
        nextpeople= findViewById(R.id.nextpeople);
        beforedate = findViewById(R.id.beforedate);
        nextdate= findViewById(R.id.nextdate);
        beforeHour = findViewById(R.id.beforeHour);
        nexthour = findViewById(R.id.nexthour);
        beforeBarber = findViewById(R.id.beforeBarber);
        nextbarber = findViewById(R.id.nextbarber);

        service_name = findViewById(R.id.service_name);
        service_price = findViewById(R.id.service_price);
        txtpeoples= findViewById(R.id.txtpeoples);
        txtweekday= findViewById(R.id.txtweekday);
        txtdate = findViewById(R.id.txtdate);
        txthour = findViewById(R.id.txthour);
        txttanda = findViewById(R.id.txttanda);
        barbername = findViewById(R.id.barbername);
        barberturno = findViewById(R.id.barberturno);

        main_image.setOnClickListener(this);
        btn_go_to_ImagesService.setOnClickListener(this);
        beforepeoples.setOnClickListener(this);
        nextpeople.setOnClickListener(this);
        beforedate.setOnClickListener(this);
        nextdate.setOnClickListener(this);
        beforeHour.setOnClickListener(this);
        nexthour.setOnClickListener(this);
        beforeBarber.setOnClickListener(this);
        nextbarber.setOnClickListener(this);

        service_name.setOnClickListener(this);
        service_price.setOnClickListener(this);
        txtpeoples.setOnClickListener(this);
        txtweekday.setOnClickListener(this);
        txtdate.setOnClickListener(this);
        txthour.setOnClickListener(this);
        txttanda.setOnClickListener(this);
        barbername.setOnClickListener(this);
        barberturno.setOnClickListener(this);


        btnejecutat =  findViewById(R.id.btnejecutat);
        btnejecutat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(Aplicacion.whoLoged == null)){

                    Aplicacion.whoLoged.getServicioActivo().add(order);
                }

                finish();

                //activate Alarm
                //Show Dialog
            }
        });

    }

    @Override
    public void onClick(View view) {
//  CHANGEQUANTITY = 1,CHANGEHOUR =3, CHANGEBARBER=4,CHANGEDATE=2;

        switch (view.getId()){
            case R.id.main_image:
                break;
            case R.id.btn_go_to_ImagesService :
                startActivity(new Intent(this,Portafolio.class));
                break;
            case R.id.beforepeoples:

                order.before(Order.CHANGEQUANTITY);
                txtpeoples.setText(""+order.getQuantity());
                int quanty =  order.getQuantity();
                order.setFinalPrice(quanty*service.getPrice());
                service_price.setText("$"+order.getFinalPrice());

                break;
            case R.id.nextpeople :
                order.next(Order.CHANGEQUANTITY);
                txtpeoples.setText(""+order.getQuantity());

                order.setFinalPrice(order.getQuantity()*service.getPrice());
                service_price.setText("$"+order.getFinalPrice());
                break;
            case R.id.beforedate:
                order.before(Order.CHANGEDATE);
                txtweekday.setText(order.getWeekday());
                txtdate.setText(order.getDate());
                break;
            case R.id.nextdate :
                order.next(Order.CHANGEDATE);
                txtweekday.setText(order.getWeekday());
                txtdate.setText(order.getDate());
                break;
            case R.id.beforeHour:
                order.before(Order.CHANGEHOUR);
                txthour.setText(""+order.getHour());
                txtweekday.setText(order.getWeekday());
                txtdate.setText(order.getDate());
                txttanda.setText(order.getTanda());
                break;
            case R.id.nexthour:
                order.next(Order.CHANGEHOUR);
                txthour.setText(""+order.getHour());
                txtweekday.setText(order.getWeekday());
                txtdate.setText(order.getDate());
                txttanda.setText(order.getTanda());

                break;
            case R.id.beforeBarber:
                if(barberPosition >0){
                    barberPosition--;
                    barbername.setText(service.getEmployedList().get(barberPosition).getName());
                }

                break;
            case R.id.nextbarber :
                if(barberPosition <service.getEmployedList().size()-1){
                    barberPosition++;
                    barbername.setText(service.getEmployedList().get(barberPosition).getName());
                }
                break;
            case R.id.txtpeoples:
                break;
            case R.id.txtweekday :
                break;
            case R.id.txthour:
                break;
            case R.id.barbername:
                 break;
        }



    }

    int  barberPosition = 0;
}
