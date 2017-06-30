package com.calculator.kavitha.calcluator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorMainActivity extends AppCompatActivity implements View.OnClickListener {


    Button percentageButton,clearButton,divideButton,
            sevenButton,eightButton,nineButton,multiplyButton,
            fourButton,fiveButton,sixButton,subtractButton,
            oneButton,twoButton,threeButton,addButton,
            dotButton,zeroButton,deleteButton,equalButton;
    EditText inputEditText;
    TextView outputTextView;

    String textToEnterInEditText;
    int  valueOfoutputTextView,numberTemp;

    private String TAG = CalculatorMainActivity.class.getSimpleName();

    private final String ADDITION = "+";
    private final String SUBTRACTION = "-";
    private final String MULTIPLICATION = "x";
    private final String DIVISION = "/";
    private final String PERCENTAGE = "%";
    private final String EQUAL = "=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);
findViewByIds();
    }


    @Override
    public void onClick(View v) {
        int selectedId = v.getId();
        switch (selectedId){
            case R.id.percentageButton:
                textToEnterInEditText = "%";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;
            case R.id.clearButton:
                clearFullTextFromEditText();
                break;
            case R.id.divideButton:
                textToEnterInEditText = "/";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;
            case R.id.sevenButton:
                textToEnterInEditText = "7";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.eightButton:
                textToEnterInEditText = "8";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.nineButton:
                textToEnterInEditText = "9";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.multiplyButton:
                textToEnterInEditText = "x";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;
            case R.id.fourButton:
                textToEnterInEditText = "4";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.fiveButton:
                textToEnterInEditText = "5";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.sixButton:
                textToEnterInEditText = "6";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.subtractButton:
                textToEnterInEditText = "-";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;
            case R.id.oneButton:
                textToEnterInEditText = "1";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.twoButton:
                textToEnterInEditText = "2";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.addButton:
                textToEnterInEditText = "+";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;
            case R.id.dotButton:
                textToEnterInEditText = ".";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.zeroButton:
                textToEnterInEditText = "0";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.threeButton:
                textToEnterInEditText = "3";
                showOperandInEditTest(textToEnterInEditText);
                break;
            case R.id.deleteButton:
                  deleteTextFromEditText();
                break;
            case R.id.equalButton:
                textToEnterInEditText = "=";
                showInEditTestAndPerformOperation(textToEnterInEditText);
                break;

        }
    }


    private  void showInEditTestAndPerformOperation(String  textToEnterInEditText){
        if (outputTextView.getText().toString() != null && outputTextView.getText().toString().length() > 0){
            valueOfoutputTextView = Integer.parseInt(outputTextView.getText().toString());
        }

        switch (textToEnterInEditText){
            case ADDITION:
                showOperatorInEditTest(ADDITION);
                break;
            case SUBTRACTION:
                showOperatorInEditTest(SUBTRACTION);
                break;
            case MULTIPLICATION:
                showOperatorInEditTest(MULTIPLICATION);
                break;
            case DIVISION:
                showOperatorInEditTest(DIVISION);
                break;
            case EQUAL:
                showOperatorInEditTest(EQUAL);
                break;
            case PERCENTAGE:
                showOperatorInEditTest(PERCENTAGE);
                break;
        }
    }


    private void showOperatorInEditTest(String textToEnterInEditText){
        if (inputEditText.getText().toString() != null && inputEditText.getText().toString().length() > 0){
            String inputEditTex = inputEditText.getText().toString();

            Log.d(TAG,"inputEditTex "+inputEditTex);

            //Convert inputEditTex to int.

            numberTemp = Integer.parseInt(inputEditTex);


            //get Last Charcter
            String lastCharacter = inputEditTex.substring(inputEditTex.length()-1,inputEditTex.length());

            Log.d(TAG,"lastCharacter "+lastCharacter);
            Log.d(TAG,"textToEnterInEditText "+textToEnterInEditText);

            if (lastCharacter.equals(textToEnterInEditText) || lastCharacter.equals(ADDITION) ||
                    lastCharacter.equals(SUBTRACTION) || lastCharacter.equals(MULTIPLICATION) ||
                    lastCharacter.equals(DIVISION) || lastCharacter.equals(PERCENTAGE)){
                Log.d(TAG,"Both Equal no need to show");
            }else {
                inputEditText.append(textToEnterInEditText);
            }
        }else
        {
            boolean validatedResult = validateFirstCharacter(textToEnterInEditText);
            Log.d(TAG,"validatedResult ? "+validatedResult);
            if (validatedResult)
                inputEditText.setText(textToEnterInEditText);
        }

        inputEditText.setSelection(inputEditText.getText().length());

    }

    public void deleteTextFromEditText(){
        if (inputEditText.getText().toString() != null && inputEditText.getText().toString().length() > 0){
            int inputEditTextLength = inputEditText.getText().length();
            inputEditText.getText().delete(inputEditTextLength-1,inputEditTextLength);
        }
    }

    public void clearFullTextFromEditText(){
        if (inputEditText.getText().toString() != null && inputEditText.getText().toString().length() > 0){
            int inputEditTextLength = inputEditText.getText().length();
            inputEditText.setText("");
        }
    }


    private void showOperandInEditTest(String textToEnterInEditText){
        if (inputEditText.getText().toString() != null && inputEditText.getText().toString().length() > 0){
            inputEditText.append(textToEnterInEditText);
        }else
        {
            boolean validatedResult = validateFirstCharacter(textToEnterInEditText);
            Log.d(TAG,"validatedResult ? "+validatedResult);
            if (validatedResult)
            inputEditText.setText(textToEnterInEditText);
        }

        inputEditText.setSelection(inputEditText.getText().length());

    }

    private  boolean validateFirstCharacter(String textToEnterInEditText){
        if (textToEnterInEditText.equals("%") ||
                textToEnterInEditText.equals("(") ||
                textToEnterInEditText.equals(")") ||
                textToEnterInEditText.equals("/") ||
                textToEnterInEditText.equals("x") ||
                textToEnterInEditText.equals("+") ||
                textToEnterInEditText.equals("=")){
            Log.d(TAG,"False");
            return false;
        }
        Log.i(TAG,"True");
        return true;
    }

    private  void findViewByIds(){
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        outputTextView = (TextView) findViewById(R.id.outputTextView);

        percentageButton = (Button) findViewById(R.id.percentageButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        divideButton = (Button) findViewById(R.id.divideButton);

        sevenButton = (Button) findViewById(R.id.sevenButton);
        eightButton = (Button) findViewById(R.id.eightButton);
        nineButton = (Button) findViewById(R.id.nineButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);

        fourButton = (Button) findViewById(R.id.fourButton);
        fiveButton = (Button) findViewById(R.id.fiveButton);
        sixButton = (Button) findViewById(R.id.sixButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);

        oneButton = (Button) findViewById(R.id.oneButton);
        twoButton = (Button) findViewById(R.id.twoButton);
        threeButton = (Button) findViewById(R.id.threeButton);
        addButton = (Button) findViewById(R.id.addButton);

        dotButton = (Button) findViewById(R.id.dotButton);
        zeroButton = (Button) findViewById(R.id.zeroButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        equalButton = (Button) findViewById(R.id.equalButton);


        percentageButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);

        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);

        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        addButton.setOnClickListener(this);

        dotButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);

    }


}
