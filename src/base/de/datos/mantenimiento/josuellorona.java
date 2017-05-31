/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.de.datos.mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Noktuapc
 */
public class josuellorona extends javax.swing.JFrame {
  Conexion con= new Conexion();
  
  //VARIABLE PARA CAPTURAR EL ID DEL CLIENTE y REFACCION
  String idCliente = null, idRefaccion = null,idCliente2 = null, idRefaccion2 = null;

    /**
     * Creates new form josuellorona
     */
    public josuellorona() {
        initComponents();
        this.setLocationRelativeTo(null);
        pedidos();
        automovil();
        clientes();
        refacciones();
        comboClientes();
        comboRefaccion();
        comboAuto();
        ingresos();
        servicios();
    }
    
    //TABLA PEDIDOS
    private void pedidos (){
        con.tabla("Select p.id_pedido, nombre, p.fecha_pedido, p.estado, p.cantidad from pedidos as p, refacciones where p.refaccion = refacciones.id_refaccion",tablapedidos.getModel());
    }
    
    //TABLA AUTOMOVIL
    private void automovil(){
        con.tabla("select a.ID_AUTO,a.VIN,concat(c.nombre, ' ', c.app, ' ', c.apm) as CLIENTE, a.nombre, a.modelo from automovil as a,clientes as c\n" +
        "where a.CLIENTE = c.id_cliente;",tablautomovil.getModel());
    }
    
    //TABLA AUTOMOVIL
    private void clientes(){
        con.tabla("Select * from clientes;",tablaclientes.getModel());
    }
    
    //TABLA REFACCIONES
    private void refacciones(){
        con.tabla("Select * from refacciones;", tablarefacciones.getModel());
    }
    
    //TABLA INGRESOS
    private void ingresos(){
        con.tabla("select * from ingresos;", tablaingresos.getModel());
    }
    
    //TABLA SERVICIOS
    private void servicios(){
        con.tabla("select * from servicio;", tablaservicios.getModel());
    }
    
    //CAPTURAR CLIENTES PARA AGREGARLOS AL COMBOBOX
    private void comboClientes(){
        try {
            ResultSet rs = con.st.executeQuery("select concat(nombre,' ',app,' ',apm) from clientes;");
            while(rs.next()){
                cmbcliente.addItem(rs.getString(1));
                clienteserv.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //CAPTURAR ID DEL CLIENTE
    private void idCliente(){
        try {
            ResultSet rs = con.st.executeQuery("select id_cliente from clientes where concat(nombre,' ',app,' ',apm) = '"+cmbcliente.getSelectedItem()+"'");
            rs.last();
            idCliente = rs.getString(1);
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }
    private void idClienteServ(){
        try {
            ResultSet rs2 = con.st.executeQuery("select id_cliente from clientes where concat(nombre,' ',app,' ',apm) = '"+clienteserv.getSelectedItem()+"'");
            rs2.last();
            idCliente2 = rs2.getString(1);
        }catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
        }
    }
    //CAPTURAR REFACCIONES PARA AGREGARLAS AL COMBOBOX
    private void comboRefaccion(){
      try {
          ResultSet rs = con.st.executeQuery("select nombre from refacciones;");
          while(rs.next()){
              pcmbrefaccion.addItem(rs.getString(1));
              refaccionserv.addItem(rs.getString(1));
          }
      } catch (SQLException e) {
          System.out.println(e.getErrorCode());
      }
    }
    
    //CAPTURAR ID DE LA REFACCION
    private void idRefaccion(){
      try {
          ResultSet rs = con.st.executeQuery("select id_refaccion from refacciones where nombre = '"+pcmbrefaccion.getSelectedItem()+"';");
          rs.last();
          idRefaccion = rs.getString(1);
      } catch (SQLException e) {
          System.out.println(e.getErrorCode());
      }
    }
    private void idRefaccionServ(){
      try {
          ResultSet rs2 = con.st.executeQuery("select id_refaccion from refacciones where nombre = '"+refaccionserv.getSelectedItem()+"';");
          rs2.last();
          idRefaccion2 = rs2.getString(1);
      } catch (SQLException e) {
          System.out.println(e.getErrorCode());
      }
    }
    
    //CAPTURAR ID DEL AUTOMOVIL EN COMBOBOX
    private void comboAuto(){
      try {
          ResultSet rs = con.st.executeQuery("select id_auto from automovil");
          while(rs.next()){
              autoidserv.addItem(rs.getString(1));
          }
      } catch (SQLException e) {
          System.out.println(e.getErrorCode());
      }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab5 = new javax.swing.JTabbedPane();
        clientes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        ctxtidcliente = new javax.swing.JTextField();
        ctxtnombre = new javax.swing.JTextField();
        ctxtapp = new javax.swing.JTextField();
        ctxtapm = new javax.swing.JTextField();
        ctxttelefono = new javax.swing.JTextField();
        ctxtcorreo = new javax.swing.JTextField();
        btnInsertarCliente = new javax.swing.JButton();
        btnModificarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        panelautomovil = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablautomovil = new javax.swing.JTable();
        anumserie = new javax.swing.JTextField();
        anombre = new javax.swing.JTextField();
        amodelo = new javax.swing.JTextField();
        aidvehiculo = new javax.swing.JTextField();
        cmbcliente = new javax.swing.JComboBox<>();
        insertarautomovil = new javax.swing.JButton();
        modificarautomovil = new javax.swing.JButton();
        eliminarautomovil = new javax.swing.JButton();
        panelrefacciones = new javax.swing.JPanel();
        rtxtidrefaccion = new javax.swing.JTextField();
        rtxtcantidad = new javax.swing.JTextField();
        rtxtcosto = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablarefacciones = new javax.swing.JTable();
        rtxtnombre = new javax.swing.JTextField();
        btnInsertarRefaccion = new javax.swing.JButton();
        btnModificarRefaccion = new javax.swing.JButton();
        btnEliminarRefaccion = new javax.swing.JButton();
        panelpedidos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapedidos = new javax.swing.JTable();
        idpedido = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        btnInsertarPedidos = new javax.swing.JButton();
        btnModificarPedidos = new javax.swing.JButton();
        btnEliminarPedidos = new javax.swing.JButton();
        pcmbrefaccion = new javax.swing.JComboBox();
        fechapedido = new javax.swing.JFormattedTextField();
        pcantidad = new javax.swing.JTextField();
        btnre = new javax.swing.JButton();
        panelservicios = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaservicios = new javax.swing.JTable();
        nombreserv = new javax.swing.JTextField();
        fechaserv = new javax.swing.JFormattedTextField();
        costoserv = new javax.swing.JTextField();
        refaccionserv = new javax.swing.JComboBox<>();
        descserv = new javax.swing.JTextField();
        insertarservicios = new javax.swing.JButton();
        btnModificarServicio = new javax.swing.JButton();
        btnEliminarServicio = new javax.swing.JButton();
        btnAgregarRefaccion = new javax.swing.JButton();
        autoidserv = new javax.swing.JComboBox<>();
        idempleadoserv = new javax.swing.JComboBox<>();
        clienteserv = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        listaRefacciones = new javax.swing.JList();
        txtcantidadserv = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        modelo1 = new DefaultListModel();
        listaRefacciones1 = new javax.swing.JList();
        panelingresos = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaingresos = new javax.swing.JTable();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclientesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaclientes);

        ctxtidcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxtidcliente.setForeground(new java.awt.Color(153, 153, 153));
        ctxtidcliente.setText("Id_cliente");

        ctxtnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxtnombre.setForeground(new java.awt.Color(153, 153, 153));
        ctxtnombre.setText("Nombre");

        ctxtapp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxtapp.setForeground(new java.awt.Color(153, 153, 153));
        ctxtapp.setText("App");

        ctxtapm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxtapm.setForeground(new java.awt.Color(153, 153, 153));
        ctxtapm.setText("Apm");

        ctxttelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxttelefono.setForeground(new java.awt.Color(153, 153, 153));
        ctxttelefono.setText("Telefono");

        ctxtcorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ctxtcorreo.setForeground(new java.awt.Color(153, 153, 153));
        ctxtcorreo.setText("Correo");

        btnInsertarCliente.setText("Insertar");
        btnInsertarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarClienteActionPerformed(evt);
            }
        });

        btnModificarCliente.setText("Modificar");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clientesLayout = new javax.swing.GroupLayout(clientes);
        clientes.setLayout(clientesLayout);
        clientesLayout.setHorizontalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1298, Short.MAX_VALUE)
            .addGroup(clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientesLayout.createSequentialGroup()
                        .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ctxtcorreo)
                            .addComponent(ctxtidcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ctxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctxtapp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctxtapm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ctxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clientesLayout.createSequentialGroup()
                        .addComponent(btnInsertarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(535, Short.MAX_VALUE))
        );
        clientesLayout.setVerticalGroup(
            clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ctxtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctxtapp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctxtapm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctxttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctxtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );

        tab5.addTab("Clientes", clientes);

        tablautomovil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablautomovil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablautomovilMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablautomovil);

        anumserie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anumserie.setForeground(new java.awt.Color(153, 153, 153));
        anumserie.setText("Num. Serie");

        anombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anombre.setForeground(new java.awt.Color(153, 153, 153));
        anombre.setText("Nombre");

        amodelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amodelo.setForeground(new java.awt.Color(153, 153, 153));
        amodelo.setText("Modelo");

        aidvehiculo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aidvehiculo.setForeground(new java.awt.Color(153, 153, 153));
        aidvehiculo.setText("Id_Vehiculo");

        cmbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbcliente.setForeground(new java.awt.Color(153, 153, 153));
        cmbcliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente" }));

        insertarautomovil.setText("Insertar");
        insertarautomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarautomovilActionPerformed(evt);
            }
        });

        modificarautomovil.setText("Modificar");
        modificarautomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarautomovilActionPerformed(evt);
            }
        });

        eliminarautomovil.setText("Eliminar");
        eliminarautomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarautomovilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelautomovilLayout = new javax.swing.GroupLayout(panelautomovil);
        panelautomovil.setLayout(panelautomovilLayout);
        panelautomovilLayout.setHorizontalGroup(
            panelautomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(panelautomovilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelautomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelautomovilLayout.createSequentialGroup()
                        .addComponent(insertarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelautomovilLayout.createSequentialGroup()
                        .addComponent(anumserie, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(anombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(amodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(aidvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(555, Short.MAX_VALUE))
        );
        panelautomovilLayout.setVerticalGroup(
            panelautomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelautomovilLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelautomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anumserie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aidvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelautomovilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarautomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab5.addTab("Automovil", panelautomovil);

        rtxtidrefaccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtxtidrefaccion.setForeground(new java.awt.Color(153, 153, 153));
        rtxtidrefaccion.setText("Id_Refaccion");

        rtxtcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtxtcantidad.setForeground(new java.awt.Color(153, 153, 153));
        rtxtcantidad.setText("Cantidad");

        rtxtcosto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtxtcosto.setForeground(new java.awt.Color(153, 153, 153));
        rtxtcosto.setText("Costo");

        tablarefacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablarefacciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablarefaccionesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablarefacciones);

        rtxtnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rtxtnombre.setForeground(new java.awt.Color(153, 153, 153));
        rtxtnombre.setText("Nombre");

        btnInsertarRefaccion.setText("Insertar");
        btnInsertarRefaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarRefaccionActionPerformed(evt);
            }
        });

        btnModificarRefaccion.setText("Modificar");
        btnModificarRefaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRefaccionActionPerformed(evt);
            }
        });

        btnEliminarRefaccion.setText("Eliminar");
        btnEliminarRefaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRefaccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelrefaccionesLayout = new javax.swing.GroupLayout(panelrefacciones);
        panelrefacciones.setLayout(panelrefaccionesLayout);
        panelrefaccionesLayout.setHorizontalGroup(
            panelrefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrefaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelrefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelrefaccionesLayout.createSequentialGroup()
                        .addComponent(rtxtidrefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rtxtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rtxtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rtxtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))
                    .addGroup(panelrefaccionesLayout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addContainerGap())
                    .addGroup(panelrefaccionesLayout.createSequentialGroup()
                        .addComponent(btnInsertarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelrefaccionesLayout.setVerticalGroup(
            panelrefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelrefaccionesLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(panelrefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rtxtcosto, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(rtxtcantidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtxtidrefaccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rtxtnombre))
                .addGap(18, 18, 18)
                .addGroup(panelrefaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab5.addTab("Refacciones y Consumibles", panelrefacciones);

        tablapedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablapedidos.setColumnSelectionAllowed(true);
        tablapedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablapedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablapedidos);

        idpedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idpedido.setForeground(new java.awt.Color(153, 153, 153));
        idpedido.setText("Id Pedido");
        idpedido.setPreferredSize(new java.awt.Dimension(73, 31));

        estado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estado.setForeground(new java.awt.Color(153, 153, 153));
        estado.setText("Estado");

        btnInsertarPedidos.setText("Insertar");
        btnInsertarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarPedidosActionPerformed(evt);
            }
        });

        btnModificarPedidos.setText("Modificar");
        btnModificarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPedidosActionPerformed(evt);
            }
        });

        btnEliminarPedidos.setText("Eliminar");
        btnEliminarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidosActionPerformed(evt);
            }
        });

        pcmbrefaccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pcmbrefaccion.setForeground(new java.awt.Color(153, 153, 153));
        pcmbrefaccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Refaccion" }));

        fechapedido.setForeground(new java.awt.Color(153, 153, 153));
        try {
            fechapedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechapedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        pcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pcantidad.setForeground(new java.awt.Color(153, 153, 153));
        pcantidad.setText("Cantidad");

        btnre.setText("Reporte");
        btnre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelpedidosLayout = new javax.swing.GroupLayout(panelpedidos);
        panelpedidos.setLayout(panelpedidosLayout);
        panelpedidosLayout.setHorizontalGroup(
            panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpedidosLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE))
            .addGroup(panelpedidosLayout.createSequentialGroup()
                .addGroup(panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelpedidosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnInsertarPedidos)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarPedidos)
                        .addGap(18, 18, 18)
                        .addComponent(btnre))
                    .addGroup(panelpedidosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(idpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pcmbrefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechapedido, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(589, Short.MAX_VALUE))
        );
        panelpedidosLayout.setVerticalGroup(
            panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelpedidosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechapedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pcmbrefaccion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idpedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelpedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tab5.addTab("Pedidos", panelpedidos);

        tablaservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaservicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaserviciosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaservicios);

        nombreserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nombreserv.setForeground(new java.awt.Color(153, 153, 153));
        nombreserv.setText("Nombre");

        fechaserv.setForeground(new java.awt.Color(153, 153, 153));
        try {
            fechaserv.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechaserv.setCaretColor(new java.awt.Color(153, 153, 153));
        fechaserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        costoserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        costoserv.setForeground(new java.awt.Color(153, 153, 153));
        costoserv.setText("Costo");

        refaccionserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refaccionserv.setForeground(new java.awt.Color(153, 153, 153));
        refaccionserv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Refaccion" }));

        descserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        descserv.setForeground(new java.awt.Color(153, 153, 153));
        descserv.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        descserv.setText("Descripcion");

        insertarservicios.setText("Insertar");
        insertarservicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarserviciosActionPerformed(evt);
            }
        });

        btnModificarServicio.setText("Modificar");
        btnModificarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarServicioActionPerformed(evt);
            }
        });

        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });

        btnAgregarRefaccion.setText("Agregar");
        btnAgregarRefaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRefaccionActionPerformed(evt);
            }
        });

        autoidserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        autoidserv.setForeground(new java.awt.Color(153, 153, 153));
        autoidserv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto_id" }));

        idempleadoserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idempleadoserv.setForeground(new java.awt.Color(153, 153, 153));
        idempleadoserv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id_empleado", "E001" }));

        clienteserv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clienteserv.setForeground(new java.awt.Color(153, 153, 153));
        clienteserv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente" }));

        jButton6.setText("Quitar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        listaRefacciones.setModel(modelo);
        jScrollPane4.setViewportView(listaRefacciones);

        txtcantidadserv.setText("Cantidad");

        listaRefacciones1.setModel(modelo1);
        jScrollPane9.setViewportView(listaRefacciones1);

        javax.swing.GroupLayout panelserviciosLayout = new javax.swing.GroupLayout(panelservicios);
        panelservicios.setLayout(panelserviciosLayout);
        panelserviciosLayout.setHorizontalGroup(
            panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(panelserviciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelserviciosLayout.createSequentialGroup()
                        .addComponent(nombreserv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechaserv, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clienteserv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(autoidserv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(costoserv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelserviciosLayout.createSequentialGroup()
                        .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelserviciosLayout.createSequentialGroup()
                                .addComponent(insertarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(idempleadoserv, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descserv)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refaccionserv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelserviciosLayout.createSequentialGroup()
                        .addComponent(btnAgregarRefaccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6))
                    .addComponent(txtcantidadserv))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        panelserviciosLayout.setVerticalGroup(
            panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelserviciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelserviciosLayout.createSequentialGroup()
                        .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelserviciosLayout.createSequentialGroup()
                                .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nombreserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fechaserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(costoserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(autoidserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clienteserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(refaccionserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelserviciosLayout.createSequentialGroup()
                                        .addComponent(txtcantidadserv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnAgregarRefaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(descserv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelserviciosLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(idempleadoserv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertarservicios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab5.addTab("Servicios", panelservicios);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Id Ingreso");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("Ingreso");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 153, 153));
        jTextField4.setText("Servicio");

        tablaingresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaingresos);

        jFormattedTextField1.setForeground(new java.awt.Color(153, 153, 153));
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setCaretColor(new java.awt.Color(153, 153, 153));
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelingresosLayout = new javax.swing.GroupLayout(panelingresos);
        panelingresos.setLayout(panelingresosLayout);
        panelingresosLayout.setHorizontalGroup(
            panelingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelingresosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(739, Short.MAX_VALUE))
        );
        panelingresosLayout.setVerticalGroup(
            panelingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelingresosLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panelingresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab5.addTab("Ingresos", panelingresos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab5, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarPedidosActionPerformed
        if(pcmbrefaccion.getSelectedItem().equals("Refaccion")){
            JOptionPane.showMessageDialog(null, "Seleccione la REFACCION a pedir");
        }else{
            idRefaccion();
            con.insertaryact("Insert Into pedidos values('"+idpedido.getText()+"','"+idRefaccion+"','"+fechapedido.getText()+"','"+estado.getText()+"',"+pcantidad.getText()+");");
            pedidos(); 
        }

    }//GEN-LAST:event_btnInsertarPedidosActionPerformed

    private void btnModificarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPedidosActionPerformed
        if(pcmbrefaccion.getSelectedItem().equals("Refaccion")){
            JOptionPane.showMessageDialog(null, "Seleccione la REFACCION a pedir");
        }else{
            idRefaccion();
            con.insertaryact("Update pedidos set refaccion='"+idRefaccion+"',fecha_pedido= '"+fechapedido.getText()+"',estado ='"+estado.getText()+"', cantidad='"+pcantidad.getText()+"' where id_pedido= '"+idpedido.getText()+"';");
            pedidos();
        }
    }//GEN-LAST:event_btnModificarPedidosActionPerformed

    private void btnEliminarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidosActionPerformed
        con.eliminar("Delete From pedidos where id_pedido='"+idpedido.getText()+"';");
        pedidos();
    }//GEN-LAST:event_btnEliminarPedidosActionPerformed

    private void tablapedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablapedidosMouseClicked
        int fila= tablapedidos.getSelectedRow();
        idpedido.setText(tablapedidos.getValueAt(fila, 0).toString());
        pcmbrefaccion.setSelectedItem(tablapedidos.getValueAt(fila, 1).toString());
        fechapedido.setText(tablapedidos.getValueAt(fila,2).toString());
        estado.setText(tablapedidos.getValueAt(fila,3).toString());
        pcantidad.setText(tablapedidos.getValueAt(fila,4).toString());
    }//GEN-LAST:event_tablapedidosMouseClicked

    private void insertarautomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarautomovilActionPerformed
        if(cmbcliente.getSelectedItem().equals("Cliente")){
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }else{
            idCliente();
            con.insertaryact("Insert Into automovil values('"+aidvehiculo.getText()+"','"+anumserie.getText()+"','"+idCliente+"','"+amodelo.getText()+"','"+anombre.getText()+"' );");
            automovil();
        }
    }//GEN-LAST:event_insertarautomovilActionPerformed

    private void modificarautomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarautomovilActionPerformed
        if(cmbcliente.getSelectedItem().equals("Cliente")){
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }else{
            idCliente();
            con.insertaryact("Update automovil set nombre='"+anombre.getText()+"',modelo ='"+amodelo.getText()+"',vin= '"+anumserie.getText()+"',cliente ='"+idCliente+"' where id_auto= '"+aidvehiculo.getText()+"';");
            automovil();    
        }
    }//GEN-LAST:event_modificarautomovilActionPerformed

    private void eliminarautomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarautomovilActionPerformed
        con.eliminar("Delete From automovil where id_auto='"+aidvehiculo.getText()+"';");
        automovil();
    }//GEN-LAST:event_eliminarautomovilActionPerformed

    private void tablautomovilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablautomovilMouseClicked
        int fila= tablautomovil.getSelectedRow();
        aidvehiculo.setText(tablautomovil.getValueAt(fila, 0).toString());
        anumserie.setText(tablautomovil.getValueAt(fila, 1).toString());
        cmbcliente.setSelectedItem(tablautomovil.getValueAt(fila,2).toString());
        anombre.setText(tablautomovil.getValueAt(fila,3).toString());
        amodelo.setText(tablautomovil.getValueAt(fila,4).toString());
    }//GEN-LAST:event_tablautomovilMouseClicked

    private void btnInsertarRefaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarRefaccionActionPerformed
        con.insertaryact("insert into refacciones values('"+rtxtidrefaccion.getText()+"','"+rtxtnombre.getText()+"',"+rtxtcantidad.getText()+","+rtxtcosto.getText()+");");
        refacciones();
        pcmbrefaccion.removeAllItems();
        refaccionserv.removeAllItems();
        comboRefaccion();
    }//GEN-LAST:event_btnInsertarRefaccionActionPerformed

    private void btnModificarRefaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRefaccionActionPerformed
        con.insertaryact("update refacciones set nombre='"+rtxtnombre.getText()+"',cantidad="+rtxtcantidad.getText()+", costo="+rtxtcosto.getText()+" where id_refaccion='"+rtxtidrefaccion.getText()+"'");
        refacciones();
        pcmbrefaccion.removeAllItems();
        refaccionserv.removeAllItems();
        comboRefaccion();
    }//GEN-LAST:event_btnModificarRefaccionActionPerformed

    private void btnEliminarRefaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRefaccionActionPerformed
        con.eliminar("delete from refacciones where id_refaccion='"+rtxtidrefaccion.getText()+"'");
        refacciones();
        pcmbrefaccion.removeAllItems();
        refaccionserv.removeAllItems();
        comboRefaccion();
    }//GEN-LAST:event_btnEliminarRefaccionActionPerformed

    private void tablarefaccionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablarefaccionesMouseClicked
        int fila= tablarefacciones.getSelectedRow();
        rtxtidrefaccion.setText(tablarefacciones.getValueAt(fila, 0).toString());
        rtxtnombre.setText(tablarefacciones.getValueAt(fila, 1).toString());
        rtxtcantidad.setText(tablarefacciones.getValueAt(fila,2).toString());
        rtxtcosto.setText(tablarefacciones.getValueAt(fila,3).toString());
    }//GEN-LAST:event_tablarefaccionesMouseClicked

    private void btnInsertarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarClienteActionPerformed
        con.insertaryact("insert into clientes values('"+ctxtidcliente.getText()+"','"+ctxtnombre.getText()+"','"+ctxtapp.getText()+"','"+ctxtapm.getText()+"','"+ctxttelefono.getText()+"','"+ctxtcorreo.getText()+"');");
        clientes();
        cmbcliente.removeAllItems();
        clienteserv.removeAllItems();
        comboClientes();
    }//GEN-LAST:event_btnInsertarClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
        con.insertaryact("update clientes set nombre='"+ctxtnombre.getText()+"',app='"+ctxtapp.getText()+"',apm='"+ctxtapm.getText()+"',telefono='"+ctxttelefono.getText()+"',correo='"+ctxtcorreo.getText()+"' where id_cliente='"+ctxtidcliente.getText()+"'");
        clientes();
        cmbcliente.removeAllItems();
        clienteserv.removeAllItems();
        comboClientes();
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        con.eliminar("delete from clientes where id_cliente='"+ctxtidcliente.getText()+"';");
        clientes();
        cmbcliente.removeAllItems();
        clienteserv.removeAllItems();
        comboClientes();
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void tablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientesMouseClicked
        int fila= tablaclientes.getSelectedRow();
        ctxtidcliente.setText(tablaclientes.getValueAt(fila, 0).toString());
        ctxtnombre.setText(tablaclientes.getValueAt(fila, 1).toString());
        ctxtapp.setText(tablaclientes.getValueAt(fila,2).toString());
        ctxtapm.setText(tablaclientes.getValueAt(fila,3).toString());
        ctxttelefono.setText(tablaclientes.getValueAt(fila,4).toString());
        ctxtcorreo.setText(tablaclientes.getValueAt(fila,5).toString());
        
    }//GEN-LAST:event_tablaclientesMouseClicked

    private void tablaserviciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaserviciosMouseClicked
        // TODO add your handling code here:
        int fila=tablaservicios.getSelectedRow();
        nombreserv.setText(tablaservicios.getValueAt(fila,1).toString());
        fechaserv.setText(tablaservicios.getValueAt(fila,2).toString());
        idempleadoserv.setSelectedItem(tablaservicios.getValueAt(fila,3).toString());
        clienteserv.setSelectedItem(tablaservicios.getValueAt(fila,4).toString());
        autoidserv.setSelectedItem(tablaservicios.getValueAt(fila,5).toString());
        //refaccionserv.setSelectedItem(tablaservicios.getValueAt(fila,6).toString());
        descserv.setText(tablaservicios.getValueAt(fila,6).toString());
        costoserv.setText(tablaservicios.getValueAt(fila,7).toString());

    }//GEN-LAST:event_tablaserviciosMouseClicked

    private void insertarserviciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarserviciosActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        if(clienteserv.getSelectedItem().equals("Cliente")){
            JOptionPane.showMessageDialog(null, "Eliga un cliente");
        }else if (autoidserv.getSelectedItem().equals("Auto_id")){
            JOptionPane.showMessageDialog(null, "Eliga un Auto");
        }else if (refaccionserv.getSelectedItem().equals("Refaccion")){
            JOptionPane.showMessageDialog(null, "Eliga las refacciones");
        }else if(idempleadoserv.getSelectedItem().equals("Id_empleado")){
            JOptionPane.showMessageDialog(null, "Eliga empleado");
        }else{
            try{
                idClienteServ();
                idRefaccionServ();
                PreparedStatement ppst = con.conn.prepareStatement("Insert into servicio(nombre,fecha,id_empleado,cliente,auto,descripcion,costo_Servicio)"
            + " values('"+nombreserv.getText()+"','"+fechaserv.getText()+"','"+idempleadoserv.getSelectedItem()+"','"+idCliente2+"',"+autoidserv.getSelectedItem()+",'"+descserv.getText()+"',"+costoserv.getText()+");");
                ppst.executeUpdate();
                servicios();
                ingresos();
                ResultSet rs1 = con.st.executeQuery("select id_servicio from servicio");
                rs1.last();
                cont = Integer.parseInt(rs1.getString(1));
                for (int i=0;i<modelo.getSize();i++){
                    try {
                        ResultSet rs = con.st.executeQuery("select id_refaccion from refacciones where nombre='"+modelo.getElementAt(i)+"'");
                        rs.last();
                        con.insertaryact("insert into refaccion_usada(id_servicio,id_refaccion,cantidad) values("+cont+",'"+rs.getString(1)+"',"+modelo1.getElementAt(i)+")");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
       
    }//GEN-LAST:event_insertarserviciosActionPerformed

    private void btnModificarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarServicioActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        int fila = tablaservicios.getSelectedRow();
        String dato = tablaservicios.getValueAt(fila, 0).toString();
        con.eliminar("delete from servicio where id_servicio="+dato+"");
        servicios();
        ingresos();
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void btnAgregarRefaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRefaccionActionPerformed
        String expresion1="\\d+";
        Pattern p1=Pattern.compile(expresion1);
        Matcher m1=p1.matcher(txtcantidadserv.getText());
        
        if(m1.matches()){
            modelo.addElement(refaccionserv.getSelectedItem());
            modelo1.addElement(txtcantidadserv.getText());
        }else{
            JOptionPane.showMessageDialog(null, "Agregue una cantidad valida");
        }

    }//GEN-LAST:event_btnAgregarRefaccionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(modelo.getSize()>0){
            int n=listaRefacciones.getSelectedIndex();
            modelo.removeElementAt(n);
            modelo1.removeElementAt(n);
        }else{
            JOptionPane.showMessageDialog(null, "seleccionar refaccion");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreActionPerformed
        // TODO add your handling code here:
        Reportes re = new Reportes();
        re.generarReporte();
    }//GEN-LAST:event_btnreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(josuellorona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(josuellorona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(josuellorona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(josuellorona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new josuellorona().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aidvehiculo;
    private javax.swing.JTextField amodelo;
    private javax.swing.JTextField anombre;
    private javax.swing.JTextField anumserie;
    private javax.swing.JComboBox<String> autoidserv;
    private javax.swing.JButton btnAgregarRefaccion;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarPedidos;
    private javax.swing.JButton btnEliminarRefaccion;
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnInsertarCliente;
    private javax.swing.JButton btnInsertarPedidos;
    private javax.swing.JButton btnInsertarRefaccion;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JButton btnModificarPedidos;
    private javax.swing.JButton btnModificarRefaccion;
    private javax.swing.JButton btnModificarServicio;
    private javax.swing.JButton btnre;
    private javax.swing.JPanel clientes;
    private javax.swing.JComboBox<String> clienteserv;
    private javax.swing.JComboBox<String> cmbcliente;
    private javax.swing.JTextField costoserv;
    private javax.swing.JTextField ctxtapm;
    private javax.swing.JTextField ctxtapp;
    private javax.swing.JTextField ctxtcorreo;
    private javax.swing.JTextField ctxtidcliente;
    private javax.swing.JTextField ctxtnombre;
    private javax.swing.JTextField ctxttelefono;
    private javax.swing.JTextField descserv;
    private javax.swing.JButton eliminarautomovil;
    private javax.swing.JTextField estado;
    private javax.swing.JFormattedTextField fechapedido;
    private javax.swing.JFormattedTextField fechaserv;
    private javax.swing.JComboBox<String> idempleadoserv;
    private javax.swing.JTextField idpedido;
    private javax.swing.JButton insertarautomovil;
    private javax.swing.JButton insertarservicios;
    private javax.swing.JButton jButton6;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JList listaRefacciones;
    private DefaultListModel modelo;
    private javax.swing.JList listaRefacciones1;
    private DefaultListModel modelo1;
    private javax.swing.JButton modificarautomovil;
    private javax.swing.JTextField nombreserv;
    private javax.swing.JPanel panelautomovil;
    private javax.swing.JPanel panelingresos;
    private javax.swing.JPanel panelpedidos;
    private javax.swing.JPanel panelrefacciones;
    private javax.swing.JPanel panelservicios;
    private javax.swing.JTextField pcantidad;
    private javax.swing.JComboBox pcmbrefaccion;
    private javax.swing.JComboBox<String> refaccionserv;
    private javax.swing.JTextField rtxtcantidad;
    private javax.swing.JTextField rtxtcosto;
    private javax.swing.JTextField rtxtidrefaccion;
    private javax.swing.JTextField rtxtnombre;
    private javax.swing.JTabbedPane tab5;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTable tablaingresos;
    public static javax.swing.JTable tablapedidos;
    private javax.swing.JTable tablarefacciones;
    private javax.swing.JTable tablaservicios;
    private javax.swing.JTable tablautomovil;
    private javax.swing.JTextField txtcantidadserv;
    // End of variables declaration//GEN-END:variables
}
