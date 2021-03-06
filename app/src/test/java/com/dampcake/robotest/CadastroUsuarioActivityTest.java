package com.dampcake.robotest;

import android.view.MenuItem;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.fakes.RoboMenuItem;

import DAO.UsuarioDAO;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class CadastroUsuarioActivityTest {
    // CadastroUsuarioActivity activity;

    @Before
    public void inicializaDAO() {
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().resume().visible().get();
        DAO.DAO.getHelper(activity.getBaseContext());
    }

    @Test
    public void clickNovoUsuarioVazio(){
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().visible().get();
        EditText txt = activity.findViewById(R.id.txtNomeUsuario);
        txt.setText("");
        activity.findViewById(R.id.btnCadastroUsuario).performClick();
        assertFalse(activity.isFinishing());
    }

    @Test
    public void clickNovoUsuarioValido(){
        CadastroUsuarioActivity
        activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().visible().get();

        EditText txt = activity.findViewById(R.id.txtNomeUsuario);
        txt.setText("Carlos");
        DAO.DAO.getHelper(activity.getBaseContext());
        activity.findViewById(R.id.btnCadastroUsuario).performClick();
        assertTrue(activity.isFinishing());
    }

    @Test
    public void testCreate() {
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().get();
        boolean result;
        result = activity != null;
        assertTrue(result);
    }

    @Test
    public void testInicializaBancoCadastroUsuario() {
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().get();
        activity.inicializaBanco();
        assertTrue(activity.getUsuarioDAO() != null);
    }

    @Test
    public void testeInicializaComponentes() {
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().get();
        assertTrue(activity.getButtonCadastroUsuario() != null);
        assertTrue(activity.getTxtNomeUsuario() != null);
    }

    @Test
    public void selecionarItemMenuOpcoes() {
        CadastroUsuarioActivity activity = Robolectric.buildActivity(CadastroUsuarioActivity.class).create().visible().get();
        MenuItem menuItem = new RoboMenuItem(R.id.action_settings);
        assertTrue(activity.onOptionsItemSelected(menuItem));
    }
}
