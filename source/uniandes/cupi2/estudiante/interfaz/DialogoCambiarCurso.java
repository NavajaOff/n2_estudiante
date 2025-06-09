/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.estudiante.mundo.Curso;
import uniandes.cupi2.estudiante.mundo.Curso.Departamento;

/**
 * Di�logo para el ingreso de un Curso.
 */
@SuppressWarnings("serial")
public class DialogoCambiarCurso extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el comando para aceptar.
     */
    public final static String ACEPTAR = "Aceptar";

    /**
     * Representa el comando para cancelar.
     */
    public final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta c�digo actual.
     */
    private JLabel lblCodigoActual;

    /**
     * Etiqueta c�digo nuevo.
     */
    private JLabel lblCodigoNuevo;

    /**
     * Etiqueta nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta departamento.
     */
    private JLabel lblDepartamento;

    /**
     * Etiqueta cr�ditos.
     */
    private JLabel lblCreditos;

    /**
     * Campo de texto del c�digo actual.
     */
    private JTextField txtCodigoActual;

    /**
     * Campo de texto del c�digo nuevo.
     */
    private JTextField txtCodigoNuevo;

    /**
     * Campor de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Combo box de los departamentos.
     */
    private JComboBox cbDepartamentos;

    /**
     * Campo de texto de los cr�ditos.
     */
    private JTextField txtCreditos;

    /**
     * Bot�n para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Bot�n para cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazEstudiante principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el di�logo que permite cambiar la informaci�n de un curso.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     * @param pCodigoCurso C�digo actual del curso. pCodigoCurso != null && pcodigoCurso != "".
     */
    public DialogoCambiarCurso( InterfazEstudiante pPrincipal, String pCodigoCurso )
    {
        principal = pPrincipal;

        setTitle( "Cambiar curso" );
        setSize( 250, 250 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        setLayout( new BorderLayout( ) );
        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new GridLayout( 6, 2 ) );
        panelInfo.setBorder( new TitledBorder( "Información curso" ) );

        lblCodigoActual = new JLabel( "Código actual:" );
        panelInfo.add( lblCodigoActual );

        txtCodigoActual = new JTextField( pCodigoCurso );
        txtCodigoActual.setEditable( false );
        panelInfo.add( txtCodigoActual );

        lblCodigoNuevo = new JLabel( "Código nuevo:" );
        panelInfo.add( lblCodigoNuevo );

        txtCodigoNuevo = new JTextField( );
        panelInfo.add( txtCodigoNuevo );

        lblNombre = new JLabel( "Nombre:" );
        panelInfo.add( lblNombre );

        txtNombre = new JTextField( );
        panelInfo.add( txtNombre );

        lblDepartamento = new JLabel( "Departamento:" );
        panelInfo.add( lblDepartamento );

        cbDepartamentos = new JComboBox( );
        cbDepartamentos.addItem( "Ing. Sistemas" );
        cbDepartamentos.addItem( "Matemáticas" );
        cbDepartamentos.addItem( "Física" );
        cbDepartamentos.addItem( "Biología" );
        panelInfo.add( cbDepartamentos );

        lblCreditos = new JLabel( "Créditos:" );
        panelInfo.add( lblCreditos );

        txtCreditos = new JTextField( );
        panelInfo.add( txtCreditos );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelInfo.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelInfo.add( btnCancelar );

        add( panelInfo, BorderLayout.CENTER );

        setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ACEPTAR ) )
        {
            String codigoActual = txtCodigoActual.getText( );
            String codigoNuevo = txtCodigoNuevo.getText( );
            String nombre = txtNombre.getText( );
            String creditosStr = txtCreditos.getText( );
            if( codigoActual.equals( "" ) || codigoNuevo.equals( "" ) || nombre.equals( "" ) || creditosStr.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                Departamento depto = Departamento.SISTEMAS;
                String depSelec = ( String )cbDepartamentos.getSelectedItem( );
                if( depSelec.equals( "Matemáticas" ) )
                {
                    depto = Departamento.MATEMATICAS;
                }
                else if( depSelec.equals( "Física" ) )
                {
                    depto = Departamento.FISICA;
                }
                else if( depSelec.equals( "Biología" ) )
                {
                    depto = Departamento.BIOLOGIA;
                }
                try
                {
                    int creditos = Integer.parseInt( creditosStr );
                    if( creditos <= 0 )
                    {
                        JOptionPane.showMessageDialog( this, "El número de créditos debería ser mayor a 0.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        principal.cambiarCurso( codigoActual, codigoNuevo, nombre, depto, creditos );
                        dispose( );
                    }
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "La cantidad de creditos debe ser un valor numérico.", "Cambiar curso", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}
