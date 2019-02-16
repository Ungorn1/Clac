package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.EventListener;

public class Controller {

    @FXML
    private Button btn_ac;

    @FXML
    private Button btn_pm;

    @FXML
    private Button btn_proc;

    @FXML
    private Button btn_del;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_y;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_m;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_pl;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_tochka;

    @FXML
    private Button btn_r;

    @FXML
    private Label label;

    String str_num = "";
    private float first_num = 0;
    private char operation;

    @FXML
    void inicialize(){
        btn_0.setOnAction(event -> {
            addNumber(0);
        });
        btn_1.setOnAction(event -> {
            addNumber(1);
        });
        btn_2.setOnAction(event -> {
            addNumber(2);
        });
        btn_3.setOnAction(event -> {
            addNumber(3);
        });
        btn_4.setOnAction(event -> {
            addNumber(4);
        });
        btn_5.setOnAction(event -> {
            addNumber(5);
        });
        btn_6.setOnAction(event -> {
            addNumber(6);
        });
        btn_7.setOnAction(event -> {
            addNumber(7);
        });
        btn_8.setOnAction(event -> {
            addNumber(8);
        });
        btn_9.setOnAction(event -> {
            addNumber(9);
        });
        btn_pl.setOnAction(event -> {
            mat_action('+');
        });
        btn_m.setOnAction(event -> {
            mat_action('-');
        });
        btn_y.setOnAction(event -> {
            mat_action('*');
        });
        btn_del.setOnAction(event -> {
            mat_action('/');
        });
        btn_r.setOnAction(event -> {
            if (this.operation == '+' || this.operation == '-' || this.operation
                    == '/' || this.operation == '*')
                eqlsmetod();
        });
        btn_tochka.setOnAction(event -> {
            if(this.str_num.contains(".")){
            }else{
                this.str_num += ".";
                label.setText(str_num);
            }
        });
        btn_proc.setOnAction(event -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                label.setText(str_num);
            }
        });
        btn_pm.setOnAction(event -> {
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                label.setText(str_num);
            }
        });
        btn_ac.setOnAction(event -> {
            label.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 0;
        });

    }

    private void eqlsmetod() {
        float res = 0;
        switch (this.operation){
            case '+':
              res = this.first_num + Float.parseFloat(this.str_num);
              break;
            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;
            case '/':
                res = this.first_num / Float.parseFloat(this.str_num);
                break;
            case '*':
                if(Integer.parseInt(this.str_num) != 0)
                res = this.first_num * Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;
        }
        label.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    void mat_action(char operation) {
        if (this.operation != '+' && this.operation != '-' && this.operation
                != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            label.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    void addNumber(int number){
        this.str_num+= Integer.toString(number);
        label.setText(str_num);
        this.operation = operation;
    }

}

