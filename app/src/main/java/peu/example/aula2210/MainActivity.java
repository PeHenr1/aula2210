package peu.example.aula2210;
// DESENVOLVIDO POR BEATRIZ CALDEIRA E PEDRO AISSA
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout placeHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeHolder = findViewById( R.id.placeHolder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // recuperar um objeto "inflador" de menus
        MenuInflater inflater = getMenuInflater();

        // Vamos inflar o menu que criamos em res/menu.
        // Lembre-se que demos nome ao arquivo de "meumenu".
        inflater.inflate(R.menu.fragments_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Precisamos identificar qual item do menu foi clicado.
        // Fazemos isso recuperando o ID do item.
        switch (item.getItemId()) {
            case R.id.menToast:
                // apagando a figura que está no placeHolder
                placeHolder.removeAllViews();
                // colocando o fragment no placeHolder
                // recuperando o objeto gerenciador de fragments
                FragmentManager fm1 = getSupportFragmentManager();
                // criando o objeto fragment
                ToastFragment tf = new ToastFragment();
                // iniciando uma transação
                FragmentTransaction ft1 = fm1.beginTransaction();
                // trocando o que esta no placeHolder
                // pelo nosso objeto fragment, que criamos
                // logo acima
                ft1.replace(R.id.constraint, tf );
                // executando a transação
                ft1.commit();
                return true;
            // não precisa break porque já estamos retornando daqui.
            case R.id.menSoma:
                // apagando a figura que está no placeHolder
                placeHolder.removeAllViews();
                // colocando o fragment no placeHolder
                FragmentManager fm2 = getSupportFragmentManager();
                SomaFragment sf = new SomaFragment();
                FragmentTransaction ft2 = fm2.beginTransaction();
                ft2.replace(R.id.constraint, sf );
                ft2.commit();
                return true;
            // não precisa break porque já estamos retornando daqui.
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}