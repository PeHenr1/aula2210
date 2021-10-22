package peu.example.aula2210;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ToastFragment extends Fragment {

    private TextView txtNome;
    private Button btnOK;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Criando o desenho da interface deste fragment (variável view),
        // inflando o layout XML que criamos para este fragment.
        View view = inflater.inflate( R.layout.fragment_toast, container, false );

        // ligando os atributos aos objetos gráficos
        txtNome = view.findViewById( R.id.txtNome );
        btnOK = view.findViewById( R.id.btnOK );

        // definindo o escutador do botao OK
        btnOK.setOnClickListener( new EscutadorBotao() );
        return view;
    }

    private class EscutadorBotao implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(), txtNome.getText().toString(), Toast.LENGTH_SHORT).show();
            txtNome.setText("");
        }
    }
}
