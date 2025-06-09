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
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.estudiante.mundo.Estudiante;

/**
 * Panel con la informaci�n del estudiante.
 */
@SuppressWarnings("serial")
public class PanelInfoEstudiante extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Promedio.
     */
    private JLabel lblPromedio;

    /**
     * Etiqueta c�digo.
     */
    private JLabel lblCodigo;

    /**
     * Etiqueta Nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta Apellido.
     */
    private JLabel lblApellido;

    /**
     * Etiqueta para la imagen.
     */
    private JLabel lblImagen;

    /**
     * Campo de texto donde se muestra el promedio.
     */
    private JTextField txtPromedio;

    /**
     * Campo de texto donde se muestra el c�digo.
     */
    private JTextField txtCodigo;

    /**
     * Campo de texto donde se muestra el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto donde se muestra el apellido.
     */
    private JTextField txtApellido;

    private JLabel lblSemestre;

    private JTextField txtSemestre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el panel con la informaci�n del estudiante.
     */
    public PanelInfoEstudiante( )
    {
        setBorder( new TitledBorder( "Informacion del estudiante" ) );
        setLayout( new BorderLayout( ) );

        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 5, 2 ) );
        txtCodigo = new JTextField( );
        txtCodigo.setEditable( false );
        txtPromedio = new JTextField( );
        txtPromedio.setEditable( false );
        txtApellido = new JTextField( );
        txtApellido.setEditable( false );
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        txtSemestre = new JTextField( );
        txtSemestre.setEditable( false );
        lblPromedio = new JLabel( );
        lblCodigo = new JLabel( );
        lblNombre = new JLabel( );
        lblApellido = new JLabel( );
        lblSemestre = new JLabel( "Semestre:" );

        lblPromedio.setText( "Promedio:" );
        lblCodigo.setText( "Codigo:" );
        lblNombre.setText( "Nombre:" );
        lblApellido.setText( "Apellido:" );
        panelAux.add( lblCodigo );
        panelAux.add( txtCodigo );
        panelAux.add( lblNombre );
        panelAux.add( txtNombre );
        panelAux.add( lblApellido );
        panelAux.add( txtApellido );
        panelAux.add( lblSemestre );
        panelAux.add( txtSemestre );
        panelAux.add( lblPromedio );
        panelAux.add( txtPromedio );

        lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./data/estudiante.png" );
        lblImagen.setIcon( icono );

        add( lblImagen, BorderLayout.WEST );
        add( panelAux, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza al informaci�n del panel con la informaci�n del estudiante dado.
     * @param pEstudiante Estudiante de los cursos. pEstudiante != null && pEstudiante != "".
     */
    public void actualizar( Estudiante pEstudiante )
    {
        if( pEstudiante.calcularPromedioEstudiante( ) != -1 )
        {
            txtPromedio.setText( pEstudiante.calcularPromedioEstudiante( ) + "" );
        }
        else
        {
            txtPromedio.setText( "0" );
        }
        txtCodigo.setText( pEstudiante.darCodigo( ) + "" );
        txtNombre.setText( pEstudiante.darNombre( ) );
        txtApellido.setText( pEstudiante.darApellido( ) );
        txtSemestre.setText( pEstudiante.darSemestre( ) + "" );
    }

}
