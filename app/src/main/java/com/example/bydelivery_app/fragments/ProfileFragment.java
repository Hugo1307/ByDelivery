package com.example.bydelivery_app.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bydelivery_app.LoginActivity;
import com.example.bydelivery_app.R;
import com.example.bydelivery_app.handlers.ContasList;

public class ProfileFragment extends Fragment {

    private String[] metodosPagamento = new String[]{"PayPal", "MBWay", "VISA"};
    private boolean isFirstInstance = true;
    private boolean credentialsChanged = false;
    private boolean acceptChanges = true;
    private static final String TAG = "ProfileFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_profile, container, false);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, metodosPagamento);

        TextView nomeUtilizador = view.findViewById(R.id.profileNameLabel);
        TextView emailUtilizador = view.findViewById(R.id.profileEmailLabel);
        final EditText moradaUtilizador = view.findViewById(R.id.profileInputEndereco);
        final EditText telemovelUtilizador = view.findViewById(R.id.profileInputTelemovel);
        final Button terminarSessaoBtn = view.findViewById(R.id.profileTerminarSessaoBtn);
        final Switch contaProfissionalSwitch = view.findViewById(R.id.profileSwitchConta);
        final Spinner metodosDePagamentoSpinner = view.findViewById(R.id.profileSpinnerMetodoPagamento);

        nomeUtilizador.setText(ContasList.getCurrentAccount().getName());
        emailUtilizador.setText(ContasList.getCurrentAccount().getEmail());
        moradaUtilizador.setText(ContasList.getCurrentAccount().getMorada());
        telemovelUtilizador.setText(ContasList.getCurrentAccount().getNumeroTelemovel());

        metodosDePagamentoSpinner.setAdapter(adapter);
        metodosDePagamentoSpinner.setSelection(ContasList.getCurrentAccount().getMetodoPagamento());

        moradaUtilizador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    credentialsChanged = true;
                    terminarSessaoBtn.setText("Guardar alterações");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        telemovelUtilizador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {

                    int digitCount = 0;

                     for (Character c : telemovelUtilizador.getText().toString().toCharArray()) {
                         if (!Character.isDigit(c)) {
                             if (!Character.isSpaceChar(c)) {
                                 acceptChanges = false;
                             }
                         }else{
                             digitCount++;
                         }
                     }

                     if (digitCount != 9) {
                         acceptChanges = false;
                     }else{
                         acceptChanges = true;
                     }

                    credentialsChanged = true;
                    terminarSessaoBtn.setText("Guardar alterações");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        contaProfissionalSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (ContasList.getCurrentAccount().isContaProfissional()) {
                        Toast.makeText(getContext(), "Bem-vindo de volta, " + ContasList.getCurrentAccount().getName(), Toast.LENGTH_SHORT).show();
                    }else{
                        contaProfissionalSwitch.setChecked(false);
                        Toast.makeText(getContext(), "Lamentamos, mas a sua conta não é profissional", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        terminarSessaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!credentialsChanged) {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{

                    if (acceptChanges) {
                        ContasList.getCurrentAccount().setMorada(moradaUtilizador.getText().toString());
                        ContasList.getCurrentAccount().setNumeroTelemovel(telemovelUtilizador.getText().toString());
                        credentialsChanged = false;
                        terminarSessaoBtn.setText("Terminar Sessão");
                        showPopupWindow(view);
                    }else{
                        Toast.makeText(getContext(), "Dados inválidos. Por favor, tente novamente.", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

        metodosDePagamentoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!isFirstInstance) {
                    Toast.makeText(getContext(), "O seu método de pagamento predefinido foi alterado para " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
                    ContasList.getCurrentAccount().setMetodoPagamento(position);
                    credentialsChanged = true;
                    terminarSessaoBtn.setText("Guardar alterações");
                }else{
                    isFirstInstance = false;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public final void showPopupWindow(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.layout_popup, null);

        // create the popup window
        int width = 540;
        int height = 540;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupView.setAlpha(0);
        popupView.animate().setDuration(500).alpha(1);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                popupView.animate().setDuration(500).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        popupView.setVisibility(View.GONE);
                        popupWindow.dismiss();
                    }
                });
            }
        }, 2000);

    }

    /* nao consegui fazer
    EditText text = (EditText) v.findViewById(R.id.editTextId);
    PhoneNumberUtils.formatNumber(text.getText().toString());
    PhoneNumberUtils.compare(String a, String b);


    Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items_spinner, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);
    */
}


